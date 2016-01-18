package ganymedes01.headcrumbs.renderers.heads.elementalCreepers;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.renderer.GlStateManager;

public class GhostCreeperHead extends ModelHead {

	public static final GhostCreeperHead INSTANCE = new GhostCreeperHead();

	@Override
	public void init() {
		hideOverlay();
	}

	@Override
	public void preRender(GameProfile profile) {
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.color(1, 1, 1, 0.3F);
	}
}