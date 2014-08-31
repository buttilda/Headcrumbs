package ganymedes01.headcrumbs.tileentities;

import ganymedes01.headcrumbs.renderers.TileEntityBlockPlayerRenderer.PlayerForRendering;
import net.minecraft.util.AxisAlignedBB;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TileEntityBlockPlayer extends TileEntityBlockSkull {

	@SideOnly(Side.CLIENT)
	private PlayerForRendering player;

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord - 1, zCoord - 1, xCoord + 2, yCoord + 3, zCoord + 2);
	}

	@SideOnly(Side.CLIENT)
	public PlayerForRendering getPlayer() {
		if (profile == null) {
			player = null;
			return null;
		}

		if (player == null)
			player = new PlayerForRendering(worldObj, profile, xCoord, yCoord, zCoord);
		return player;
	}
}