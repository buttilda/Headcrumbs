package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class WitherCowHead extends ModelHead {

	public static final WitherCowHead INSTANCE = new WitherCowHead();

	protected WitherCowHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 4;
		float f1 = -4;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -4.0F + f1, -6.0F + f0, 8, 8, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		ModelRenderer horn1 = new ModelRenderer(this, 22, 0);
		horn1.addBox(-4.0F, -6.0F + f1, -4.0F + f0, 1, 3, 1);
		horn1.setTextureSize(128, 64);
		horn1.mirror = true;
		ModelRenderer horn2 = new ModelRenderer(this, 22, 0);
		horn2.addBox(3.0F, -6.0F + f1, -4.0F + f0, 1, 3, 1);
		horn2.setTextureSize(128, 64);
		horn2.mirror = true;

		head.addChild(horn1);
		head.addChild(horn2);
		hideOverlay();
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}
}