package ganymedes01.headcrumbs.renderers.heads.elementalCreepers;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

public class GhostCreeperHead extends ModelHead {

	public static final GhostCreeperHead INSTANCE = new GhostCreeperHead();

	@Override
	public void init() {
		hideOverlay();
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.enableBlend();
		OpenGLHelper.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		OpenGLHelper.colour(1, 1, 1, 0.3F);
	}
}