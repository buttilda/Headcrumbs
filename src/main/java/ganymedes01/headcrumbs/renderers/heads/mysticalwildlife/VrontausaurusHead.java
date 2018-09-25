package ganymedes01.headcrumbs.renderers.heads.mysticalwildlife;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class VrontausaurusHead extends ModelHead {

	public static final VrontausaurusHead INSTANCE = new VrontausaurusHead();

	protected VrontausaurusHead() {
		textureWidth = 128;
		textureHeight = 64;
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-6, -10, -4, 12, 10, 8, 0.0F);

		ModelRenderer snout = new ModelRenderer(this, 0, 18);
		snout.addBox(-4, -7, -12, 8, 6, 8);
		head.addChild(snout);
		
		hideOverlay();
	}
}