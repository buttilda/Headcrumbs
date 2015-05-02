package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class GoGWitchHead extends ModelHead {

	public static final GoGWitchHead INSTANCE = new GoGWitchHead();

	protected GoGWitchHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 1;

		ModelRenderer hat1 = new ModelRenderer(this, 36, 14);
		hat1.addBox(-7.0F, -7.0F, -7.0F + f0, 14, 2, 14);
		hat1.setTextureSize(64, 32);
		hat1.mirror = true;
		setRotation(hat1, 0.0F, 0.6108652F, 0.0F);
		ModelRenderer hat2 = new ModelRenderer(this, 36, 30);
		hat2.addBox(-4.0F, -9.0F, -4.0F + f0, 8, 2, 8);
		hat2.setTextureSize(64, 32);
		hat2.mirror = true;
		setRotation(hat2, 0.0F, 0.7853982F, 0.0F);
		ModelRenderer hat3 = new ModelRenderer(this, 36, 40);
		hat3.addBox(-3.0F, -10.0F, -3.0F + f0, 6, 1, 6);
		hat3.setTextureSize(64, 32);
		hat3.mirror = true;
		setRotation(hat3, 0.0F, 0.9599311F, 0.0F);
		ModelRenderer hat4 = new ModelRenderer(this, 36, 47);
		hat4.addBox(-2.0F, -11.0F, -2.0F + f0, 4, 1, 4);
		hat4.setTextureSize(64, 32);
		hat4.mirror = true;
		setRotation(hat4, 0.0F, 1.134464F, 0.0F);
		ModelRenderer hat5 = new ModelRenderer(this, 36, 52);
		hat5.addBox(-1.5F, -12.0F, -1.5F + f0, 3, 1, 3);
		hat5.setTextureSize(64, 32);
		hat5.mirror = true;
		setRotation(hat5, 0.0F, 1.308997F, 0.0F);
		ModelRenderer hat6 = new ModelRenderer(this, 36, 56);
		hat6.addBox(-1.0F, -14.0F, -1.0F + f0, 2, 2, 2);
		hat6.setTextureSize(64, 32);
		hat6.mirror = true;
		setRotation(hat6, 0.0F, 1.48353F, 0.0F);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F + f0, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -7.0F, -3.5F + f0, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);

		head.addChild(hat1);
		head.addChild(hat2);
		head.addChild(hat3);
		head.addChild(hat4);
		head.addChild(hat5);
		head.addChild(hat6);
	}
}