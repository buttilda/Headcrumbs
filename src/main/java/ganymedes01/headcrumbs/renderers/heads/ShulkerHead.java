package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class ShulkerHead extends ModelHead {

	public static final ShulkerHead INSTANCE = new ShulkerHead();

	protected ShulkerHead() {
	}

	@Override
	public void init() {
		textureWidth = 64;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 52);
		head.addBox(-3.0F, -6.0F, -2.0F, 6, 6, 6);
		hideOverlay();
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}
}