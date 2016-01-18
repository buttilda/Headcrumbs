package ganymedes01.headcrumbs.items;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

public class ItemStatue extends FixedItemBlock {

	public ItemStatue(Block block) {
		super(block);
	}

	@Override
	public boolean placeBlockAt(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, IBlockState newState) {
		if (world.getBlockState(pos).getBlock().isReplaceable(world, pos) && side != EnumFacing.DOWN) {
			side = EnumFacing.UP;
			pos = pos.down();
		}
		if (side == EnumFacing.DOWN)
			return false;
		else {
			IBlockState state = world.getBlockState(pos);
			Block block = state.getBlock();

			if (!block.isReplaceable(world, pos)) {
				if (!world.getBlockState(pos).getBlock().getMaterial().isSolid() && !world.isSideSolid(pos, side, true))
					return false;

				pos = pos.offset(side);
			}

			BlockPos topPos = pos.add(0, 1, 0);
			if (!world.getBlockState(topPos).getBlock().isReplaceable(world, topPos))
				return false;

			if (!player.canPlayerEdit(pos, side, stack) || !player.canPlayerEdit(topPos, side, stack))
				return false;
			else if (!this.block.canPlaceBlockAt(world, pos))
				return false;
			else {
				if (!world.isRemote) {
					if (!this.block.canPlaceBlockOnSide(world, pos, side))
						return false;
					world.setBlockState(topPos, this.block.getDefaultState().withProperty(BlockSkull.FACING, side), 3);
					world.setBlockState(pos, ModBlocks.empty.getDefaultState());

					TileEntity tile = world.getTileEntity(topPos);
					populateTile(stack, side, player, tile);
				}

				return true;
			}
		}
	}

	protected void populateTile(ItemStack stack, EnumFacing side, EntityPlayer player, TileEntity tile) {
		if (tile instanceof TileEntityBlockPlayer) {
			TileEntityBlockPlayer tilePlayer = (TileEntityBlockPlayer) tile;

			GameProfile profile = null;
			if (stack.hasTagCompound()) {
				NBTTagCompound nbt = stack.getTagCompound();
				if (nbt.hasKey(HeadUtils.OWNER_TAG, Constants.NBT.TAG_COMPOUND))
					profile = NBTUtil.readGameProfileFromNBT(nbt.getCompoundTag(HeadUtils.OWNER_TAG));
				else if (nbt.hasKey(HeadUtils.OWNER_TAG, Constants.NBT.TAG_STRING) && nbt.getString(HeadUtils.OWNER_TAG).length() > 0)
					profile = new GameProfile(null, nbt.getString(HeadUtils.OWNER_TAG));
			}

			tilePlayer.setPlayerProfile(profile);

			int rotation = 0;
			if (side == EnumFacing.UP)
				rotation = MathHelper.floor_double(player.rotationYaw * 16.0F / 360.0F + 0.5D) & 15;
			tilePlayer.setSkullRotation(rotation);
		}
	}

	@Override
	public String getItemStackDisplayName(ItemStack stack) {
		return HeadUtils.getName(stack);
	}
}