package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SelkieHead extends ModelHead {

	public static final SelkieHead INSTANCE = new SelkieHead();

	protected SelkieHead() {
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
		ModelRenderer hat1 = new ModelRenderer(this, 36, 36);
		hat1.addBox(-4.0F, -7.5F, -5.0F + f0, 8, 3, 8);
		hat1.setTextureSize(64, 32);
		hat1.mirror = true;
		setRotation(hat1, -0.1745329F, 0.0F, 0.0F);
		ModelRenderer hat2 = new ModelRenderer(this, 36, 47);
		hat2.addBox(-3.0F, -8.5F, -4.0F + f0, 6, 1, 6);
		hat2.setTextureSize(64, 32);
		hat2.mirror = true;
		setRotation(hat2, -0.1745329F, 0.0F, 0.0F);

		head.addChild(hat1);
		head.addChild(hat2);
	}
}