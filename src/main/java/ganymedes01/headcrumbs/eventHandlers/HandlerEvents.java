package ganymedes01.headcrumbs.eventHandlers;

import java.util.Arrays;
import java.util.List;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.vip.direwolf20;
import ganymedes01.headcrumbs.libs.CelebrityMap;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.StringUtils;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DimensionType;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandlerEvents {

	public static final HandlerEvents INSTANCE = new HandlerEvents();

	private static List<String> hardcodedBlacklist = Arrays.asList("Twilight Forest", "Erebus", "The Outer Lands");

	private HandlerEvents() {
	}

	@SubscribeEvent
	public void onRegisterLootTable(LootTableLoadEvent event) {
		HeadUtils.onRegisterLootTable(event);
	}

	@SubscribeEvent
	public void onAttack(LivingAttackEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		DamageSource dmgSrc = event.getSource();
		if (dmgSrc != null && entity instanceof EntityHuman) {
			Entity attacker = dmgSrc.getEntity();
			if (attacker instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) attacker;
				ItemStack stack = player.getHeldItem(EnumHand.MAIN_HAND);
				if (stack != null && stack.getItem() == Items.STICK)
					if (stack.hasTagCompound() && stack.getTagCompound().getBoolean("IsDirestick"))
						direwolf20.takeItEasy(player);
					else
						direwolf20.makeDirestick((EntityHuman) entity, player, stack);
			}
		}
	}

	@SubscribeEvent
	public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
		if (event.getEntityLiving() instanceof EntityHuman) {
			World world = event.getWorld();
			DimensionType dimType = world.provider.getDimensionType();
			if (hardcodedBlacklist.contains(dimType.getName()) || isDimensionBlackListed(dimType.getId()))
				event.setResult(Result.DENY);
		}
	}

	private static boolean isDimensionBlackListed(int dimensionId) {
		for (int id : Headcrumbs.blacklistedDimensions)
			if (dimensionId == id)
				return true;
		return false;
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void dropEvent(LivingDropsEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		DamageSource source = event.getSource();
		List<EntityItem> drops = event.getDrops();

		if (entity.worldObj.isRemote)
			return;
		if (entity.getHealth() > 0.0F)
			return;

		if (isPoweredCreeper(source)) {
			ItemStack stack = HeadUtils.getHeadfromEntity(entity);
			if (stack == null)
				return;

			EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
			entityItem.setDefaultPickupDelay();
			drops.add(entityItem);
		}
	}

	private boolean isPoweredCreeper(DamageSource source) {
		if (source.isExplosion() && source instanceof EntityDamageSource) {
			Entity entity = ((EntityDamageSource) source).getEntity();
			if (entity != null && entity instanceof EntityCreeper)
				return ((EntityCreeper) entity).getPowered();
		}
		return false;
	}

	@SubscribeEvent
	public void onTooltip(ItemTooltipEvent event) {
		if (!Headcrumbs.enableTooltips)
			return;
		ItemStack stack = event.getItemStack();
		if (stack != null && stack.getItem() == Items.SKULL && stack.getMetadata() == 3) {
			String name = HeadUtils.getName(stack);
			if (name != null) {
				String tip = CelebrityMap.getTooltip(name);
				if (!StringUtils.isNullOrEmpty(tip))
					event.getToolTip().add(tip);
			}
		}
	}

	private BlockPattern statuePattern;

	@SubscribeEvent
	public void onSkullPlacedEvent(PlaceEvent event) {
		if (event.getState().getBlock() != Blocks.SKULL) {
			return;
		}

		World world = event.getWorld();
		BlockPos pos = event.getPos();
		TileEntity tileEntity = world.getTileEntity(pos);
		if (tileEntity instanceof TileEntitySkull) {
			TileEntitySkull tileSkull = (TileEntitySkull) tileEntity;
			if (tileSkull.getSkullType() == 3 && pos.getY() >= 2 && world.getDifficulty() != EnumDifficulty.PEACEFUL && !world.isRemote) {
				if (statuePattern == null)
					statuePattern = FactoryBlockPattern.start().aisle(new String[] { "^", "#", "#" }).where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.CLAY))).where('^', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.SKULL))).build();
				BlockPattern.PatternHelper patternHelper = statuePattern.match(world, pos);
				if (patternHelper != null) {
					GameProfile profile = tileSkull.getPlayerProfile();
					for (int i = 0; i < 3; i++) {
						BlockWorldState blockWorldState = patternHelper.translateOffset(0, -i, 0);
						world.setBlockState(blockWorldState.getPos(), Blocks.AIR.getDefaultState(), 2);
					}
					world.setBlockState(pos.add(0, -1, 0), ModBlocks.player.getDefaultState());
					Utils.doBreakParticles(world, pos.add(0, -1, 0), Blocks.SOUL_SAND, 0);
					world.setBlockState(pos.add(0, -2, 0), ModBlocks.empty.getDefaultState());
					Utils.doBreakParticles(world, pos.add(0, -2, 0), Blocks.SOUL_SAND, 0);

					TileEntityBlockPlayer tile = Utils.getTileEntity(world, pos.add(0, -1, 0), TileEntityBlockPlayer.class);
					if (tile != null) {
						tile.setPlayerProfile(profile);
						tile.setSkullRotation(MathHelper.floor_double(event.getPlayer().rotationYaw * 16.0F / 360.0F + 0.5D) & 15);
						world.notifyBlockOfStateChange(pos.add(0, -1, 0), ModBlocks.player);
					}
				}
			}
		}
	}
}