package ganymedes01.headcrumbs.items;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class FixedItemBlock extends ItemBlock {

	public FixedItemBlock(Block block) {
		super(block);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
		IBlockState state = world.getBlockState(pos);
		Block block = state.getBlock();

		if (!block.isReplaceable(world, pos))
			pos = pos.offset(side);

		if (stack.stackSize == 0)
			return false;
		else if (!player.canPlayerEdit(pos, side, stack))
			return false;
		else if (canBlockBePlaced(world, this.block, pos, false, side, null, stack)) {
			int meta = getMetadata(stack.getMetadata());
			IBlockState newState = this.block.onBlockPlaced(world, pos, side, hitX, hitY, hitZ, meta, player);

			if (placeBlockAt(stack, player, world, pos, side, hitX, hitY, hitZ, newState)) {
				world.playSoundEffect(pos.getX() + 0.5F, pos.getY() + 0.5F, pos.getZ() + 0.5F, this.block.stepSound.getPlaceSound(), (this.block.stepSound.getVolume() + 1.0F) / 2.0F, this.block.stepSound.getFrequency() * 0.8F);
				stack.stackSize--;
			}

			return true;
		} else
			return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean canPlaceBlockOnSide(World world, BlockPos pos, EnumFacing side, EntityPlayer player, ItemStack stack) {
		Block block = world.getBlockState(pos).getBlock();

		if (block == Blocks.snow_layer && block.isReplaceable(world, pos))
			side = EnumFacing.UP;
		else if (!block.isReplaceable(world, pos))
			pos = pos.offset(side);

		return canBlockBePlaced(world, block, pos, false, side, null, stack);
	}

	public boolean canBlockBePlaced(World world, Block blockToPlace, BlockPos pos, boolean useBounds, EnumFacing side, Entity entity, ItemStack stack) {
		Block block = world.getBlockState(pos).getBlock();
		AxisAlignedBB bb = useBounds ? null : block.getCollisionBoundingBox(world, pos, blockToPlace.getDefaultState());
		if (bb != null && !world.checkNoEntityCollision(bb, entity))
			return false;
		return block.isReplaceable(world, pos) && blockToPlace.canReplace(world, pos, side, stack);
	}
}