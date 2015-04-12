package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityBlockPlayerRenderer extends TileEntityBlockSkullRenderer {

	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float partialTicks) {
		TileEntityBlockPlayer tilePlayer = (TileEntityBlockPlayer) tile;
		GameProfile profile = tilePlayer.func_152108_a();

		if (profile == null)
			return;

		AbstractClientPlayer player = tilePlayer.getPlayer();
		if (player == null)
			return;

		player.func_152121_a(MinecraftProfileTexture.Type.CAPE, TextureUtils.getPlayerCape(profile));
		player.func_152121_a(MinecraftProfileTexture.Type.SKIN, TextureUtils.getPlayerSkin(profile));

		RenderManager.renderPosX = player.posX = player.lastTickPosX = player.prevPosX = player.field_71091_bM = player.field_71094_bP = x;
		RenderManager.renderPosY = player.posY = player.lastTickPosY = player.prevPosY = player.field_71096_bN = player.field_71095_bQ = y;
		RenderManager.renderPosZ = player.posZ = player.lastTickPosZ = player.prevPosZ = player.field_71097_bO = player.field_71085_bR = z;

		OpenGLHelper.pushMatrix();
		OpenGLHelper.translate(x + 0.5, y + 0.63, z + 0.5);
		OpenGLHelper.scale(1.0F, -1.0F, -1.0F);
		OpenGLHelper.rotate(180.0F, 0.0F, 0.0F, 1.0F);
		OpenGLHelper.rotate(adjustRotation(tilePlayer.getBlockMetadata() & 7, -tilePlayer.func_145906_b() * 360 / 16.0F), 0, 1, 0);

		RenderManager.instance.renderEntitySimple(player, 0);

		OpenGLHelper.popMatrix();
	}

	public static class PlayerForRendering extends AbstractClientPlayer {

		private final int x, y, z;

		public PlayerForRendering(World world, GameProfile profile, int x, int y, int z) {
			super(world, profile);
			this.x = x;
			this.y = y;
			this.z = z;
		}

		@Override
		public void addChatMessage(IChatComponent chat) {
		}

		@Override
		public boolean canCommandSenderUseCommand(int p_70003_1_, String command) {
			return false;
		}

		@Override
		public ChunkCoordinates getPlayerCoordinates() {
			return null;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public boolean isInvisibleToPlayer(EntityPlayer p_98034_1_) {
			return true;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int getBrightnessForRender(float partialTicks) {
			int i = MathHelper.floor_double(x);
			int j = MathHelper.floor_double(z);

			if (worldObj.blockExists(i, 0, j)) {
				double d0 = (boundingBox.maxY - boundingBox.minY) * 0.66D;
				int k = MathHelper.floor_double(y - (double) yOffset + d0);
				return worldObj.getLightBrightnessForSkyBlocks(i, k, j, 0);
			} else
				return 0;
		}
	}
}