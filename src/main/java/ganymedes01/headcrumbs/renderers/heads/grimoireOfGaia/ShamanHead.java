package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class ShamanHead extends ModelHead {

	public static final ShamanHead INSTANCE = new ShamanHead();

	protected ShamanHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F + f0, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F + f0, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-4.5F, -7.5F, 0.5F + f0, 9, 9, 6);
		hair.setTextureSize(64, 32);
		hair.mirror = true;
		setRotation(hair, 0.0F, 0.0F, 0.0F);
		ModelRenderer hat01 = new ModelRenderer(this, 36, 39);
		hat01.addBox(-2.5F, -6.5F, 0.0F + f0, 5, 4, 4);
		hat01.setTextureSize(64, 32);
		hat01.mirror = true;
		setRotation(hat01, 1.047198F, 0.0F, 0.0F);
		ModelRenderer hat02 = new ModelRenderer(this, 36, 47);
		hat02.addBox(-2.0F, -6.0F, -4.0F + f0, 4, 4, 4);
		hat02.setTextureSize(64, 32);
		hat02.mirror = true;
		setRotation(hat02, 1.047198F, 0.0F, 0.0F);
		ModelRenderer horns = new ModelRenderer(this, 36, 29);
		horns.addBox(-4.0F, -6.5F, 2.0F + f0, 8, 4, 6);
		horns.setTextureSize(64, 32);
		horns.mirror = true;
		setRotation(horns, 1.047198F, 0.0F, 0.0F);

		head.addChild(hair);
		head.addChild(hat01);
		head.addChild(hat02);
		head.addChild(horns);
	}
}