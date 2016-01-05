package ganymedes01.headcrumbs.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDispenser;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class HumanEgg extends Item {

	public HumanEgg() {
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(Utils.getUnlocalisedName("egg"));
		BlockDispenser.dispenseBehaviorRegistry.putObject(this, new DispenserBehaviourHumanEgg());
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		String s = ("" + StatCollector.translateToLocal(Items.spawn_egg.getUnlocalizedName() + ".name")).trim();
		String s1 = "headcrumbs.Human";

		if (s1 != null)
			s = s + " " + StatCollector.translateToLocal("entity." + s1 + ".name");

		return s;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int pass) {
		return pass == 0 ? 0xFFF144 : 0x69DFDA;
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
		if (world.isRemote)
			return true;
		else {
			Block block = world.getBlock(x, y, z);
			x += Facing.offsetsXForSide[side];
			y += Facing.offsetsYForSide[side];
			z += Facing.offsetsZForSide[side];
			double d0 = 0.0D;

			if (side == 1 && block.getRenderType() == 11)
				d0 = 0.5D;

			EntityHuman human = spawnHuman(world, x + 0.5D, y + d0, z + 0.5D);
			if (stack.hasDisplayName())
				human.setUsername(stack.getDisplayName());
			if (!player.capabilities.isCreativeMode)
				stack.stackSize--;
		}

		return true;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (world.isRemote)
			return stack;
		else {
			MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, player, true);

			if (movingobjectposition == null)
				return stack;
			else {
				if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
					int i = movingobjectposition.blockX;
					int j = movingobjectposition.blockY;
					int k = movingobjectposition.blockZ;

					if (!world.canMineBlock(player, i, j, k))
						return stack;

					if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack))
						return stack;

					if (world.getBlock(i, j, k) instanceof BlockLiquid) {
						EntityHuman human = spawnHuman(world, i, j, k);
						if (stack.hasDisplayName())
							human.setUsername(stack.getDisplayName());
						if (!player.capabilities.isCreativeMode)
							stack.stackSize--;
					}
				}

				return stack;
			}
		}
	}

	public static EntityHuman spawnHuman(World world, double x, double y, double z) {
		EntityHuman human = new EntityHuman(world);
		human.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
		human.rotationYawHead = human.rotationYaw;
		human.renderYawOffset = human.rotationYaw;
		human.onSpawnWithEgg(null);
		world.spawnEntityInWorld(human);
		human.playLivingSound();
		return human;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int meta, int pass) {
		return Items.spawn_egg.getIconFromDamageForRenderPass(meta, pass);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) {
	}
}