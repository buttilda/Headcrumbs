package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

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

		RenderManager.renderPosX = player.posX = player.prevPosX = player.field_71091_bM = player.field_71094_bP = x;
		RenderManager.renderPosY = player.posY = player.prevPosY = player.field_71096_bN = player.field_71095_bQ = y;
		RenderManager.renderPosZ = player.posZ = player.prevPosZ = player.field_71097_bO = player.field_71085_bR = z;

		GL11.glPushMatrix();
		GL11.glTranslated(x + 0.5, y + 0.63, z + 0.5);
		GL11.glScalef(1.0F, -1.0F, -1.0F);
		GL11.glRotatef(180.0F, 0.0F, 0.0F, 1.0F);
		GL11.glRotatef(adjustRotation(tilePlayer.getBlockMetadata() & 7, -tilePlayer.func_145906_b() * 360 / 16.0F), 0, 1, 0);

		RenderManager.instance.renderEntitySimple(player, 0);

		GL11.glPopMatrix();
	}

	public static class PlayerForRendering extends AbstractClientPlayer {

		private ResourceLocation skin, cape;

		public PlayerForRendering(World world, GameProfile profile) {
			super(world, profile);
			skin = SkullTypes.player.getTexture(getGameProfile());
			cape = TextureUtils.getPlayerCape(getGameProfile());
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
		public int getBrightnessForRender(float partialTicks) {
			return 15728880;
		}

		@Override
		public ResourceLocation getLocationSkin() {
			return skin;
		}

		@Override
		public ResourceLocation getLocationCape() {
			return cape;
		}

		@Override
		public boolean func_152122_n() {
			return cape != null;
		}

		@Override
		public boolean func_152123_o() {
			return skin != null;
		}

		@Override
		public void func_152121_a(Type type, ResourceLocation resource) {
			switch (type) {
				case CAPE:
					cape = resource;
					break;
				case SKIN:
					skin = resource;
					break;
			}
		}
	}
}