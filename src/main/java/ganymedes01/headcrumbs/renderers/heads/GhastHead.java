package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class GhastHead extends ModelHead {

	public static final GhastHead INSTANCE = new GhastHead();

	protected GhastHead() {
		hideOverlay();
		textureWidth = 32;
		textureHeight = 16;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
	}
}