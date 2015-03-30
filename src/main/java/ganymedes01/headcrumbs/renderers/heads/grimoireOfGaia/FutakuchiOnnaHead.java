package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class FutakuchiOnnaHead extends ModelHead {

	public static final FutakuchiOnnaHead INSTANCE = new FutakuchiOnnaHead();

	protected FutakuchiOnnaHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 0;
		float f1 = -1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F + f0, -3.0F + f1, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, -0.261799F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F + f0, -3.5F + f1, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, -0.261799F, 0.0F, 0.0F);
		ModelRenderer hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-5.0F, -8.0F + f0, -5.5F + f1, 10, 10, 4);
		hair1.setTextureSize(64, 32);
		hair1.mirror = true;
		setRotation(hair1, -0.0872665F, 0.0F, 0.0F);
		ModelRenderer hair2 = new ModelRenderer(this, 36, 28);
		hair2.addBox(-4.0F, -7.0F + f0, -7.5F + f1, 8, 8, 4);
		hair2.setTextureSize(64, 32);
		hair2.mirror = true;
		setRotation(hair2, -0.0872665F, 0.0F, 0.0F);
		ModelRenderer hair3 = new ModelRenderer(this, 36, 40);
		hair3.addBox(-4.0F, -6.0F + f0, -1.0F + f1, 8, 10, 6);
		hair3.setTextureSize(64, 32);
		hair3.mirror = true;
		setRotation(hair3, 0.0F, 0.0F, 0.0F);
		ModelRenderer mouth1 = new ModelRenderer(this, 64, 0);
		mouth1.addBox(-3.0F, -5.5F + f0, -5.5F + f1, 6, 3, 6);
		mouth1.setTextureSize(64, 32);
		mouth1.mirror = true;
		setRotation(mouth1, 0.0F, 0.0F, 0.0F);
		ModelRenderer mouth2 = new ModelRenderer(this, 64, 9);
		mouth2.addBox(-3.0F, -2.5F + f0, -5.5F + f1, 6, 3, 6);
		mouth2.setTextureSize(64, 32);
		mouth2.mirror = true;
		setRotation(mouth2, 0.0F, 0.0F, 0.0F);

		head.addChild(hair1);
		head.addChild(hair2);
		head.addChild(hair3);
		head.addChild(mouth1);
		head.addChild(mouth2);
	}
}