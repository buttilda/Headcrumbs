package ganymedes01.headcrumbs.renderers;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityBlockPlayerRenderer extends TileEntitySpecialRenderer<TileEntityBlockPlayer> {

	@Override
	public void renderTileEntityAt(TileEntityBlockPlayer tile, double x, double y, double z, float partialTicks, int destroyStage) {
		GameProfile profile = tile.getPlayerProfile();

		if (profile == null)
			return;

		EntityHuman human = tile.getHuman();
		if (human == null)
			return;

		human.posX = human.lastTickPosX = human.prevPosX = tile.getPos().getX();
		human.posY = human.lastTickPosY = human.prevPosY = tile.getPos().getY();
		human.posZ = human.lastTickPosZ = human.prevPosZ = tile.getPos().getZ();

		RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
		renderManager.setRenderPosition(human.posX, human.posY, human.posZ);

		GlStateManager.pushMatrix();
		GlStateManager.translate(x + 0.5, y - 1, z + 0.5);
		GlStateManager.scale(1.0F, -1.0F, -1.0F);
		GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		GlStateManager.rotate(adjustRotation(tile.getBlockMetadata() & 7, -tile.getSkullRotation() * 360 / 16.0F), 0, 1, 0);

		renderManager.renderEntityStatic(human, 0, false);

		GlStateManager.popMatrix();
	}

	private float adjustRotation(int meta, float rotation) {
		switch (meta) {
			case 1:
			case 2:
				return rotation;
			case 3:
				return 180.0F;
			case 4:
				return 270.0F;
			default:
				return 90.0F;
		}
	}
}