package ganymedes01.headcrumbs.tileentities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.renderers.TileEntityBlockPlayerRenderer.PlayerForRendering;
import ganymedes01.headcrumbs.utils.helpers.EtFuturumHelper;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.AxisAlignedBB;

public class TileEntityBlockPlayer extends TileEntityBlockSkull {

	@SideOnly(Side.CLIENT)
	private AbstractClientPlayer player;

	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord - 1, yCoord - 1, zCoord - 1, xCoord + 2, yCoord + 3, zCoord + 2);
	}

	@SideOnly(Side.CLIENT)
	public AbstractClientPlayer getPlayer() {
		if (profile == null) {
			player = null;
			return null;
		}

		if (player == null)
			player = Headcrumbs.use18PlayerModel ? EtFuturumHelper.getPlayer(worldObj, profile) : new PlayerForRendering(worldObj, profile);
		return player;
	}
}