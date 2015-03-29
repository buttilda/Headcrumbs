package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class CockatriceHead extends ModelHead {

	public static final CockatriceHead INSTANCE = new CockatriceHead();

	protected CockatriceHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 8;
		float f1 = 5.5F;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.0F, -12.0F + f0, -5.5F + f1, 4, 4, 4);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		ModelRenderer beak = new ModelRenderer(this, 0, 8);
		beak.addBox(-2.0F, -10.0F + f0, -7.5F + f1, 4, 2, 2);
		beak.setTextureSize(128, 64);
		beak.mirror = true;
		setRotation(beak, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 0, 12);
		overlay.addBox(-2.5F, -9.0F + f0, -5.5F + f1, 5, 3, 3);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer crown = new ModelRenderer(this, 16, -5);
		crown.addBox(0.0F, -15.0F + f0, -3.5F + f1, 0, 5, 5);
		crown.setTextureSize(128, 64);
		crown.mirror = true;
		setRotation(crown, 0.0F, 0.0F, 0.0F);

		head.addChild(beak);
		head.addChild(crown);
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}