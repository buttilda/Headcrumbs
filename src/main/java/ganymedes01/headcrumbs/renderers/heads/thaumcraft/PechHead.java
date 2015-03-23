package ganymedes01.headcrumbs.renderers.heads.thaumcraft;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class PechHead extends ModelHead {

	public static final PechHead INSTANCE = new PechHead();

	protected PechHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f1 = -2.0F;
		float f2 = 4.0F;
		head = new ModelRenderer(this, 2, 11);
		head.addBox(-3.5F, -5.0F + f1, -5.0F + f2, 7, 5, 5);
		overlay = new ModelRenderer(this, 1, 21);
		overlay.addBox(-4.0F, -1.0F + f1, -6.0F + f2, 8, 3, 5);
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}
}