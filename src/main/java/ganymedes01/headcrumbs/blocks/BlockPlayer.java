package ganymedes01.headcrumbs.blocks;

import cpw.mods.fml.common.Optional;
import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlayer extends BlockSkull {

	public BlockPlayer() {
		super(Material.clay);
		setBlockName(Utils.getUnlocalisedName("player"));
	}

	@Override
	@Optional.Method(modid = "Thaumcraft")
	public boolean canStabaliseInfusion(World world, int x, int y, int z) {
		return false;
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour) {
		if (world.getBlock(x, y - 1, z) != ModBlocks.blockEmpty)
			Utils.breakBlockWithParticles(world, x, y, z, 0);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityBlockPlayer();
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
		float f = 2F / 16F;
		setBlockBounds(f, 0.0F, f, 1.0F - f, 1.0F, 1.0F - f);
	}
}