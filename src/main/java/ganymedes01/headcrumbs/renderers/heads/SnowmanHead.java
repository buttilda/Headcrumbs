package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SnowmanHead extends ModelHead {

	public static final SnowmanHead INSTANCE = new SnowmanHead();

	protected SnowmanHead() {
		textureWidth = 64;
		textureHeight = 64;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		hideOverlay();
	}
}