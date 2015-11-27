package ganymedes01.headcrumbs.renderers;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelHuman extends ModelBiped {

	@Override
	public void render(Entity entity, float f0, float f1, float f2, float f3, float f4, float scale) {
		setRotationAngles(f0, f1, f2, f3, f4, scale, entity);

		if (isChild) {
			float f6 = 2.0F;
			OpenGLHelper.pushMatrix();
			OpenGLHelper.scale(1.5F / f6, 1.5F / f6, 1.5F / f6);
			OpenGLHelper.translate(0.0F, 16.0F * scale, 0.0F);
			bipedHead.render(scale);
			OpenGLHelper.enableBlend();
			OpenGLHelper.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			bipedHeadwear.render(scale);
			OpenGLHelper.disableBlend();
			OpenGLHelper.popMatrix();

			OpenGLHelper.pushMatrix();
			OpenGLHelper.scale(1.0F / f6, 1.0F / f6, 1.0F / f6);
			OpenGLHelper.translate(0.0F, 24.0F * scale, 0.0F);
			bipedBody.render(scale);
			bipedRightArm.render(scale);
			bipedLeftArm.render(scale);
			bipedRightLeg.render(scale);
			bipedLeftLeg.render(scale);
			OpenGLHelper.popMatrix();
		} else {
			bipedHead.render(scale);
			bipedBody.render(scale);
			bipedRightArm.render(scale);
			bipedLeftArm.render(scale);
			bipedRightLeg.render(scale);
			bipedLeftLeg.render(scale);
			OpenGLHelper.enableBlend();
			OpenGLHelper.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			bipedHeadwear.render(scale);
			OpenGLHelper.disableBlend();
		}
	}
}