package ganymedes01.headcrumbs.items;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraftforge.common.util.Constants;

public class ItemStatue extends ItemHeadcrumbsSkull {

	public ItemStatue(Block block) {
		super(block);
	}

	@Override
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
}
