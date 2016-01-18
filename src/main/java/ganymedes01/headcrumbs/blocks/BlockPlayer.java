package ganymedes01.headcrumbs.blocks;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.items.ItemStatue;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlayer extends BlockHeadcrumbsSkull {

	public BlockPlayer() {
		setUnlocalizedName(Utils.getUnlocalisedName("player"));
	}

	@Override
	public void onNeighborBlockChange(World world, BlockPos pos, IBlockState state, Block neighbour) {
		if (world.getBlockState(pos.add(0, -1, 0)).getBlock() != ModBlocks.empty)
			Utils.breakBlockWithParticles(world, pos, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBlockPlayer();
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos) {
		float f = 2F / 16F;
		setBlockBounds(f, 0.0F, f, 1.0F - f, 1.0F, 1.0F - f);
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemStatue.class;
	}
}