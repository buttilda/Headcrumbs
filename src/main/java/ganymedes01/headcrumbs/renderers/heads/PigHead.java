package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class PigHead extends ModelHead {

	public static final PigHead INSTANCE = new PigHead();

	protected PigHead() {
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		head.setTextureOffset(16, 16).addBox(-2.0F, -4.0F, -5.0F, 4, 3, 1, 0.0F);
		hideOverlay();
	}
}