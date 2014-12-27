package ganymedes01.headcrumbs.blocks;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.utils.Utils;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockEmpty extends Block {

	public BlockEmpty() {
		super(Material.clay);
		setHardness(1.0F);
		setStepSound(soundTypeStone);
		setBlockName(Utils.getUnlocalizedName("empty"));
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
		float f = 4F / 16F;
		setBlockBounds(f, 0.0F, f, 1.0F - f, 1.0F, 1.0F - f);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block neighbour) {
		if (world.getBlock(x, y + 1, z) != ModBlocks.blockPlayer)
			Utils.breakBlockWithParticles(world, x, y, z, 0);
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
	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World world, int x, int y, int z) {
		return world.getBlock(x, y + 1, z).getItem(world, x, y + 1, z);
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return world.getBlock(x, y + 1, z).getPickBlock(target, world, x, y + 1, z);
	}

	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		return world.getBlock(x, y + 1, z).getDamageValue(world, x, y + 1, z);
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		world.getBlock(x, y + 1, z).onBlockHarvested(world, x, y + 1, z, meta, player);
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int meta, int fortune) {
		return world.getBlock(x, y + 1, z).getDrops(world, x, y + 1, z, meta, fortune);
	}

	@Override
	public int quantityDropped(Random rand) {
		return 0;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		return world.getBlock(x, y + 1, z).onBlockActivated(world, x, y + 1, z, player, side, hitX, hitY - 1.0F, hitZ);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return Blocks.soul_sand.getBlockTextureFromSide(side);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getItemIconName() {
		return Blocks.skull.getItemIconName();
	}
}