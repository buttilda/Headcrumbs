package ganymedes01.headcrumbs.renderers;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelHuman extends ModelBiped {

	@Override
	public void render(Entity entity, float f0, float f1, float f2, float f3, float f4, float f5) {
		setRotationAngles(f0, f1, f2, f3, f4, f5, entity);

		if (isChild) {
			float f6 = 2.0F;
			OpenGLHelper.pushMatrix();
			OpenGLHelper.scale(1.5F / f6, 1.5F / f6, 1.5F / f6);
			OpenGLHelper.translate(0.0F, 16.0F * f5, 0.0F);
			bipedHead.render(f5);
			bipedHeadwear.render(f5);
			OpenGLHelper.popMatrix();

			OpenGLHelper.pushMatrix();
			OpenGLHelper.scale(1.0F / f6, 1.0F / f6, 1.0F / f6);
			OpenGLHelper.translate(0.0F, 24.0F * f5, 0.0F);
			bipedBody.render(f5);
			bipedRightArm.render(f5);
			bipedLeftArm.render(f5);
			bipedRightLeg.render(f5);
			bipedLeftLeg.render(f5);
			OpenGLHelper.popMatrix();
		} else {
			bipedHead.render(f5);
			bipedBody.render(f5);
			bipedRightArm.render(f5);
			bipedLeftArm.render(f5);
			bipedRightLeg.render(f5);
			bipedLeftLeg.render(f5);
			bipedHeadwear.render(f5);
		}
	}
}