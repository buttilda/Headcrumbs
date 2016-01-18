package ganymedes01.headcrumbs.blocks;

import java.util.Random;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEmpty extends Block {

	public BlockEmpty() {
		super(Material.clay);
		setHardness(1.0F);
		setStepSound(soundTypeStone);
		setUnlocalizedName(Utils.getUnlocalisedName("empty"));
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos) {
		float f = 4F / 16F;
		setBlockBounds(f, 0.0F, f, 1.0F - f, 1.0F, 1.0F - f);
	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighbour) {
		if (world.getBlockState(pos.add(0, 1, 0)).getBlock() != ModBlocks.player)
			Utils.breakBlockWithParticles(world, pos, 0);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
		pos = pos.add(0, 1, 0);
		return world.getBlockState(pos).getBlock().getPickBlock(target, world, pos, player);
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		pos = pos.add(0, 1, 0);
		state = world.getBlockState(pos);
		state.getBlock().onBlockHarvested(world, pos, state, player);
	}

	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
		pos = pos.add(0, 1, 0);
		state = world.getBlockState(pos);
		return state.getBlock().onBlockActivated(world, pos, state, player, side, hitX, hitY - 1.0F, hitZ);
	}
}