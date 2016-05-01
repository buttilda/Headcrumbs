package ganymedes01.headcrumbs.blocks;

import java.util.ArrayList;
import java.util.List;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.items.ItemStatue;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockPlayer extends BlockHeadcrumbsSkull {

	private static final AxisAlignedBB BOUNDS = new AxisAlignedBB(0.125, 0, 0.125, 0.875, 1, 0.875);

	public BlockPlayer() {
		setUnlocalizedName(Utils.getUnlocalisedName("player"));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
	}

	@Override
	public void onBlockHarvested(World world, BlockPos pos, IBlockState state, EntityPlayer player) {
		if (player.capabilities.isCreativeMode) {
			state = state.withProperty(NODROP, true);
			world.setBlockState(pos, state, 4);
		}

		super.onBlockHarvested(world, pos, state, player);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> drops = new ArrayList<ItemStack>();

		if (state.getValue(NODROP).booleanValue())
			return drops;

		TileEntityBlockPlayer tile = Utils.getTileEntity(world, pos, TileEntityBlockPlayer.class);
		if (tile != null) {
			ItemStack stack = new ItemStack(this);
			stack.setTagCompound(new NBTTagCompound());
			GameProfile profile = tile.getPlayerProfile();
			if (profile == null)
				return drops;
			NBTTagCompound nbt = NBTUtil.writeGameProfile(new NBTTagCompound(), profile);
			stack.getTagCompound().setTag(HeadUtils.OWNER_TAG, nbt);
			drops.add(stack);
		}
		return drops;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		TileEntityBlockPlayer tile = Utils.getTileEntity(world, pos, TileEntityBlockPlayer.class);
		if (tile != null) {
			ItemStack stack = new ItemStack(this);
			stack.setTagCompound(new NBTTagCompound());
			GameProfile profile = tile.getPlayerProfile();
			if (profile != null) {
				NBTTagCompound nbt = NBTUtil.writeGameProfile(new NBTTagCompound(), profile);
				stack.getTagCompound().setTag(HeadUtils.OWNER_TAG, nbt);
			}
			return stack;
		}
		return null;
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
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDS;
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemStatue.class;
	}
}