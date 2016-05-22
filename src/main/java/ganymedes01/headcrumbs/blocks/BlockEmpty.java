package ganymedes01.headcrumbs.blocks;

import java.util.Random;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockEmpty extends Block {

	private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.25, 0, 0.25, 0.75, 1, 0.75);

	public BlockEmpty() {
		super(Material.CLAY);
		setHardness(1.0F);
		setSoundType(SoundType.STONE);
		setDefaultState(blockState.getBaseState().withProperty(BlockSkull.NODROP, false));
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(BlockSkull.NODROP, meta == 1);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(BlockSkull.NODROP).booleanValue() ? 1 : 0;
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { BlockSkull.NODROP });
	}

	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighbour) {
		if (world.getBlockState(pos.up()).getBlock() != ModBlocks.player)
			Utils.breakBlockWithParticles(world, pos, 0);
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		pos = pos.up();
		return world.getBlockState(pos).getBlock().getPickBlock(state, target, world, pos, player);
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		pos = pos.up();
		state = world.getBlockState(pos);
		state.getBlock().onBlockHarvested(world, pos, state, player);
	}

	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		pos = pos.up();
		state = world.getBlockState(pos);
		return state.getBlock().onBlockActivated(world, pos, state, player, hand, heldItem, side, hitX, hitY - 1.0F, hitZ);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDS;
	}
}