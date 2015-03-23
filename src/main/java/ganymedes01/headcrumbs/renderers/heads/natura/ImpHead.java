package ganymedes01.headcrumbs.renderers.heads.natura;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class ImpHead extends ModelHead {

	public static final ImpHead INSTANCE = new ImpHead();

	protected ImpHead() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-5F, -8F, -4F, 10, 8, 8, 0.0F);
		hideOverlay();
	}
}