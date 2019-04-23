package ganymedes01.headcrumbs.tileentities;

import ganymedes01.headcrumbs.libs.HeadDrop;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityBlockSkull extends TileEntitySkull
{
	private String entName;

	public HeadDrop getModel()
	{
		if(entName == null)
			return HeadDrop.DEFAULT;
		return HeadUtils.getModel(entName);
	}

	public String getSkullModel()
	{
		return entName;
	}

	public void setSkullModel(String entName)
	{
		this.entName = entName;
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound nbt)
	{
		nbt = super.writeToNBT(nbt);
		nbt.setString(HeadUtils.OWNER_TAG, entName);
		return nbt;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt)
	{
		super.readFromNBT(nbt);
		entName = nbt.getString(HeadUtils.OWNER_TAG);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox()
	{
		return new AxisAlignedBB(getPos().add(-1, -1, -1), getPos().add(2, 2, 2));
	}
}