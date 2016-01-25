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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockPlayer extends BlockHeadcrumbsSkull {

	public BlockPlayer() {
		setUnlocalizedName(Utils.getUnlocalisedName("player"));
		float f = 2F / 16F;
		setBlockBounds(f, 0.0F, f, 1.0F - f, 1.0F, 1.0F - f);
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
	public ItemStack getPickBlock(MovingObjectPosition target, World world, BlockPos pos, EntityPlayer player) {
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
	public void setBlockBoundsBasedOnState(IBlockAccess access, BlockPos pos) {
	}

	@Override
	public Class<? extends ItemBlock> getItemBlockClass() {
		return ItemStatue.class;
	}
}