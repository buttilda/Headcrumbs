package ganymedes01.headcrumbs.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityBlockSkull extends TileEntitySkull {

	protected int skullType, skullRotation;
	protected GameProfile profile = null;

	@Override
	public boolean canUpdate() {
		return false;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("skullType", skullType);
		nbt.setInteger("skullRotation", skullRotation);

		if (profile != null) {
			NBTTagCompound profileData = new NBTTagCompound();
			NBTUtil.func_152460_a(profileData, profile);
			nbt.setTag("Owner", profileData);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		skullType = nbt.getInteger("skullType");
		skullRotation = nbt.getInteger("skullRotation");

		if (nbt.hasKey("Owner", Constants.NBT.TAG_COMPOUND))
			profile = NBTUtil.func_152459_a(nbt.getCompoundTag("Owner"));
	}

	public void setType(int type, GameProfile profile) {
		skullType = type;
		this.profile = profile;
	}

	@Override
	public int func_145904_a() {
		return skullType;
	}

	@Override
	public void func_145903_a(int rotation) {
		skullRotation = rotation;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int func_145906_b() {
		return skullRotation;
	}

	@Override
	public GameProfile func_152108_a() {
		return profile;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord - 1, zCoord - 1, xCoord + 2, yCoord + 2, zCoord + 2);
	}
}