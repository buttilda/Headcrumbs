package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelEnderman;
import net.minecraft.client.renderer.OpenGlHelper;

import org.lwjgl.opengl.GL11;

public class EndermanHead extends ModelHead {

	public static final EndermanHead INSTANCE = new EndermanHead();

	protected EndermanHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.MC_PREFIX + "enderman/enderman_eyes.png"));

		ModelEnderman model = new ModelEnderman();
		head = model.bipedHead;
		overlay = model.bipedHeadwear;
		head.setRotationPoint(0F, 0F, 0F);
		overlay.setRotationPoint(0F, 0F, 0F);
	}

	@Override
	public void renderSpecial(float skullRotation) {
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glDepthMask(true);
		char c0 = 61680;
		int j = c0 % 65536;
		int k = c0 / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
		render(skullRotation);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glEnable(GL11.GL_ALPHA_TEST);
	}
}