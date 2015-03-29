package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class AnubisHead extends ModelHead {

	public static final AnubisHead INSTANCE = new AnubisHead();

	protected AnubisHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
		head.setRotationPoint(0.0F, 0.0F, f0);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F, 7, 9, 7);
		overlay.setRotationPoint(0.0F, 0.0F, f0);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer earright = new ModelRenderer(this, 36, 31);
		earright.addBox(-3.5F, -10.0F, -1.5F, 2, 4, 3);
		earright.setTextureSize(64, 32);
		earright.mirror = true;
		setRotation(earright, 0.0F, 0.0F, 0.0F);
		ModelRenderer earleft = new ModelRenderer(this, 46, 31);
		earleft.addBox(1.5F, -10.0F, -1.5F, 2, 4, 3);
		earleft.setTextureSize(64, 32);
		earleft.mirror = true;
		setRotation(earleft, 0.0F, 0.0F, 0.0F);
		ModelRenderer hair = new ModelRenderer(this, 36, 16);
		hair.addBox(-3.5F, -3.0F, 0.5F, 7, 12, 3);
		hair.setTextureSize(64, 32);
		hair.mirror = true;
		setRotation(hair, 0.0F, 0.0F, 0.0F);
		head.addChild(earleft);
		head.addChild(earright);
	}
}