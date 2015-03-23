package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class WolfHead extends ModelHead {

	public static final WolfHead INSTANCE = new WolfHead();

	protected WolfHead() {
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, 0.0F, 6, 6, 4, 0.0F);

		head.setTextureOffset(16, 14).addBox(-3.0F, -8.0F, 2.0F, 2, 2, 1, 0.0F);
		head.setTextureOffset(16, 14).addBox(1.0F, -8.0F, 2.0F, 2, 2, 1, 0.0F);
		head.setTextureOffset(0, 10).addBox(-1.5F, -3.0F, -3.0F, 3, 3, 4, 0.0F);
		hideOverlay();
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}