package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class EndermiteHead extends ModelHead {

	public static final EndermiteHead INSTANCE = new EndermiteHead();

	protected EndermiteHead() {
	}

	@Override
	public void init() {
		float f0 = -4;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.0F, 1.0F + f0, -3.0F, 4, 3, 2);

		overlay = new ModelRenderer(this, 0, 5);
		overlay.addBox(-3.0F, 0.0F + f0, -1.0F, 6, 4, 5);
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}
}