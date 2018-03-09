package ganymedes01.headcrumbs.eventHandlers;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandlerEvents {

	public static final HandlerEvents INSTANCE = new HandlerEvents();

	private static List<String> hardcodedBlacklist = Arrays.asList("Twilight Forest", "Erebus", "The Outer Lands");
	private static Item cleaver;

	@SubscribeEvent
	public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
		if(event.getEntityLiving() instanceof EntityHuman){
			World world = event.getWorld();
			DimensionType dimType = world.provider.getDimensionType();
			if(hardcodedBlacklist.contains(dimType.getName()) || isDimensionBlackListed(dimType.getId()))
				event.setResult(Result.DENY);
		}
	}

	private static boolean isDimensionBlackListed(int dimensionId) {
		for(int id : Headcrumbs.blacklistedDimensions)
			if(dimensionId == id)
				return true;
		return false;
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void playerDrop(LivingDeathEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		if(entity.world.getGameRules().getBoolean("keepInventory") && entity instanceof EntityPlayerMP){
			ArrayList<ItemStack> drops = new ArrayList<ItemStack>();

			ItemStack weapon = getWeapon(event.getSource());
			int looting = EnchantmentHelper.getEnchantmentLevel(Enchantment.getEnchantmentByLocation("looting"), weapon);
			drop(event.getEntityLiving(), event.getSource(), looting, drops);

			if(!drops.isEmpty())
				for(ItemStack item : drops)
					((EntityPlayerMP) entity).dropItem(item, true);
		}
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void dropEvent(LivingDropsEvent event) {
		List<ItemStack> drops = new ArrayList<ItemStack>();

		drop(event.getEntityLiving(), event.getSource(), event.getLootingLevel(), drops);

		if(!drops.isEmpty()){
			Entity ent = event.getEntity();
			for(ItemStack item : drops)
				event.getDrops().add(new EntityItem(ent.world, ent.posX, ent.posY, ent.posZ, item));
		}
	}

	private void drop(EntityLivingBase entity, DamageSource source, int looting, List<ItemStack> drops) {
		if(entity.world.isRemote)
			return;
		if(entity.getHealth() > 0.0F)
			return;

		boolean isPoweredCreeper = isPoweredCreeper(source);
		int beheading = getBeaheadingLevel(getWeapon(source));

		if(isPoweredCreeper || shouldDoRandomDrop(entity.world.rand, beheading, looting)){
			ItemStack stack = HeadUtils.getHeadfromEntity(entity);
			if(stack == null)
				return;

			if(beheading > 0 && stack.getItem() == Items.SKULL)
				return; // Vanilla head drops will be handled by
					// TiCon

			NBTTagCompound nbt = stack.writeToNBT(new NBTTagCompound());
			System.out.println(nbt.toString());
			if(stack.getItem() != Items.SKULL || Headcrumbs.enableVanillaHeadsDrop)
				if(isPlayerHead(stack) || Headcrumbs.enableMobsAndAnimalHeads)
					drops.add(stack);
		}
	}

	private boolean isPoweredCreeper(DamageSource source) {
		if(source.isExplosion() && source instanceof EntityDamageSource){
			Entity entity = ((EntityDamageSource) source).getEntity();
			if(entity != null && entity instanceof EntityCreeper)
				return ((EntityCreeper) entity).getPowered();
		}

		return false;
	}

	private boolean isPlayerHead(ItemStack stack) {
		return stack.getItem() == Items.SKULL && stack.getMetadata() == 3;
	}

	private boolean shouldDoRandomDrop(Random rand, int beheading, int looting) {
		if(beheading > 0)
			return rand.nextInt(100) < beheading * 10;

		int chance = Math.max(1, Headcrumbs.headDropChance / Math.max(looting + 1, 1));
		return Headcrumbs.enableRandomHeadDrop && rand.nextInt(chance) == 0;
	}

	private int getBeaheadingLevel(ItemStack weapon) {
		if(Headcrumbs.isTinkersConstructLoaded){
			if(cleaver == null)
				try{
					Class<?> TinkerTools = Class.forName("tconstruct.tools.TinkerTools");
					Field field = TinkerTools.getDeclaredField("cleaver");
					field.setAccessible(true);
					cleaver = (Item) field.get(null);
				} catch(Exception e){
				}

			if(weapon == null || !weapon.hasTagCompound())
				return 0;

			if(weapon.getTagCompound().hasKey("InfiTool", Constants.NBT.TAG_COMPOUND)){
				NBTTagCompound infiTool = weapon.getTagCompound().getCompoundTag("InfiTool");
				if(infiTool.hasKey("Beheading", Constants.NBT.TAG_INT)){
					int beheading = infiTool.getInteger("Beheading");
					if(cleaver == weapon.getItem())
						beheading += 2;
					return beheading;
				}
			}
		}

		return 0;
	}

	private ItemStack getWeapon(DamageSource source) {
		if(source instanceof EntityDamageSource){
			Entity entity = ((EntityDamageSource) source).getEntity();
			if(entity instanceof EntityPlayer)
				return ((EntityPlayer) entity).getActiveItemStack();
		}
		return null;
	}

	private BlockPattern statuePattern;

	@SubscribeEvent
	public void onSkullPlacedEvent(PlaceEvent event) {
		if(event.getState().getBlock() != Blocks.SKULL){
			return;
		}

		World world = event.getWorld();
		BlockPos pos = event.getPos();
		TileEntity tileEntity = world.getTileEntity(pos);
		if(tileEntity instanceof TileEntitySkull){
			TileEntitySkull tileSkull = (TileEntitySkull) tileEntity;
			if(tileSkull.getSkullType() == 3 && pos.getY() >= 2 && world.getDifficulty() != EnumDifficulty.PEACEFUL && !world.isRemote){
				if(statuePattern == null)
					statuePattern = FactoryBlockPattern.start().aisle(new String[] { "^", "#", "#" }).where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.CLAY))).where('^', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.SKULL))).build();
				BlockPattern.PatternHelper patternHelper = statuePattern.match(world, pos);
				if(patternHelper != null){
					GameProfile profile = tileSkull.getPlayerProfile();
					for(int i = 0; i < 3; i++){
						BlockWorldState blockWorldState = patternHelper.translateOffset(0, -i, 0);
						world.setBlockState(blockWorldState.getPos(), Blocks.AIR.getDefaultState(), 2);
					}
					world.setBlockState(pos.add(0, -1, 0), ModBlocks.player.getDefaultState());
					Utils.doBreakParticles(world, pos.add(0, -1, 0), Blocks.SOUL_SAND, 0);
					world.setBlockState(pos.add(0, -2, 0), ModBlocks.empty.getDefaultState());
					Utils.doBreakParticles(world, pos.add(0, -2, 0), Blocks.SOUL_SAND, 0);

					TileEntityBlockPlayer tile = Utils.getTileEntity(world, pos.add(0, -1, 0), TileEntityBlockPlayer.class);
					if(tile != null){
						tile.setPlayerProfile(profile);
						tile.setSkullRotation(MathHelper.floor(event.getPlayer().rotationYaw * 16.0F / 360.0F + 0.5D) & 15);
						world.notifyNeighborsOfStateChange(pos, ModBlocks.player, true);
					}
				}
			}
		}
	}
}