package ganymedes01.headcrumbs.tileentities;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityBlockSkull extends TileEntitySkull {

	private SkullTypes type;

	public SkullTypes getModel() {
		if (type == null)
			type = SkullTypes.blaze;
		return type;
	}

	public void setSkullModel(SkullTypes type) {
		this.type = type;
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString(HeadUtils.OWNER_TAG, type.name());
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		type = HeadUtils.getModel(nbt.getString(HeadUtils.OWNER_TAG));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos().add(-1, -1, -1), getPos().add(2, 2, 2));
	}
}