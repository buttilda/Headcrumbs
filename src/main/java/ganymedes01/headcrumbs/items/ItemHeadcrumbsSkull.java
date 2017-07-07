package ganymedes01.headcrumbs.items;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHeadcrumbsSkull extends FixedItemBlock {

	public ItemHeadcrumbsSkull(Block block) {
		super(block);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems) {
		for (SkullTypes skull : SkullTypes.values())
			if (skull.canShow())
				subItems.add(skull.getStack());
	}

	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState) {
		if (side == EnumFacing.DOWN)
			return false;
		else {
			BlockPos clickedPos = pos.offset(side.getOpposite());
			IBlockState clickedState = world.getBlockState(clickedPos);
			if (!clickedState.getMaterial().isSolid() || !world.isSideSolid(clickedPos, side, true))
				return false;

			if (!player.canPlayerEdit(pos, side, stack))
				return false;
			else if (!block.canPlaceBlockAt(world, pos))
				return false;
			else {
				if (!world.isRemote) {
					if (!block.canPlaceBlockOnSide(world, pos, side))
						return false;
					world.setBlockState(pos, block.getDefaultState().withProperty(BlockSkull.FACING, side), 3);

					TileEntity tile = world.getTileEntity(pos);
					populateTile(stack, side, player, tile);
				}

				return true;
			}
		}
	}

	protected void populateTile(ItemStack stack, EnumFacing side, EntityPlayer player, TileEntity tile) {
		if (tile instanceof TileEntityBlockSkull) {
			TileEntityBlockSkull tileSkull = (TileEntityBlockSkull) tile;
			SkullTypes model = HeadUtils.getModel(stack);
			tileSkull.setType(stack.getMetadata());
			tileSkull.setSkullModel(model);

			int rotation = 0;
			if (side == EnumFacing.UP)
				rotation = MathHelper.floor(player.rotationYaw * 16.0F / 360.0F + 0.5D) & 15;
			tileSkull.setSkullRotation(rotation);
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		SkullTypes type = HeadUtils.getModel(stack);
		return "item." + Utils.getUnlocalisedName(type.name());
	}

	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		return armorType == EntityEquipmentSlot.HEAD;
	}
}