package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class CowHead extends ModelHead {

	public static final CowHead INSTANCE = new CowHead();

	protected CowHead() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -2.0F, 8, 8, 6, 0.0F);
		head.setTextureOffset(22, 0).addBox(-5.0F, -9.0F, 0.0F, 1, 3, 1, 0.0F);
		head.setTextureOffset(22, 0).addBox(4.0F, -9.0F, 0.0F, 1, 3, 1, 0.0F);
		hideOverlay();
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}
}