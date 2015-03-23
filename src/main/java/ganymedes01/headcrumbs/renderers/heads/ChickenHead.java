package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class ChickenHead extends ModelHead {

	public static final ChickenHead INSTANCE = new ChickenHead();

	protected ChickenHead() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.0F, -6.0F, 1.0F, 4, 6, 3, 0.0F);
		overlay = new ModelRenderer(this, 14, 0);
		overlay.addBox(-2.0F, -4.0F, -1.0F, 4, 2, 2, 0.0F);
		ModelRenderer overlay2 = new ModelRenderer(this, 14, 4);
		overlay2.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 2, 0.0F);
		overlay.addChild(overlay2);
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}