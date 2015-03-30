package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class GryphonHead extends ModelHead {

	public static final GryphonHead INSTANCE = new GryphonHead();

	protected GryphonHead() {
	}

	@Override
	public void preRender() {
		// init();
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 4.5F;
		float f1 = 6.5F;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.5F, -9.5F + f0, -7.5F + f1, 5, 5, 5);
		head.setTextureSize(64, 32);
		head.mirror = true;
		ModelRenderer eyes = new ModelRenderer(this, 0, 10);
		eyes.addBox(-2.0F, -10F + f0, -9F + f1, 4, 3, 4);
		eyes.setTextureSize(64, 32);
		eyes.mirror = true;
		setRotation(eyes, 0.6108652F, 0.0F, 0.0F);
		ModelRenderer beak = new ModelRenderer(this, 0, 17);
		beak.addBox(-1.5F, -7.5F + f0, -11.5F + f1, 3, 3, 4);
		beak.setTextureSize(64, 32);
		beak.mirror = true;
		hideOverlay();

		head.addChild(eyes);
		head.addChild(beak);
	}
}