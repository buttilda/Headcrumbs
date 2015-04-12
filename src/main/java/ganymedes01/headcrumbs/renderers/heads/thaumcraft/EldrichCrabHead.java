package ganymedes01.headcrumbs.renderers.heads.thaumcraft;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class EldrichCrabHead extends ModelHead {

	public static final EldrichCrabHead INSTANCE = new EldrichCrabHead();

	protected EldrichCrabHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = -3;
		float f1 = 10;

		head = new ModelRenderer(this, 0, 38);
		head.addBox(-2.0F, -1.5F + f0, -9.0F + f1, 4, 4, 1);
		overlay = new ModelRenderer(this, 0, 31);
		overlay.addBox(-2.5F, -2.0F + f0, -8.0F + f1, 5, 5, 2);
	}

	@Override
	public float playerRenderOffset() {
		return 3;
	}
}