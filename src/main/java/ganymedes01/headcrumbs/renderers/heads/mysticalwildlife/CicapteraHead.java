package ganymedes01.headcrumbs.renderers.heads.mysticalwildlife;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class CicapteraHead extends ModelHead {

	public static final CicapteraHead INSTANCE = new CicapteraHead();

	protected CicapteraHead() {
		textureWidth = 32;
		textureHeight = 32;
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3, -4, 0, 6, 4, 4, 0.0F);
		head.addBox(2.5F, -3, 1, 1, 1, 1, 0.0F);
		head.addBox(-3.5F, -3, 1, 1, 1, 1, 0.0F);
		hideOverlay();
	}
}