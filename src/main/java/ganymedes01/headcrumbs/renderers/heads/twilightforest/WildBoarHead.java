package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class WildBoarHead extends ModelHead {

	public static final WildBoarHead INSTANCE = new WildBoarHead();

	protected WildBoarHead() {
		hideOverlay();

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -2.0F, -2.0F, 8, 7, 6, 0.0F);
		head.setRotationPoint(0.0F, -5.0F, 0.0F);

		head.setTextureOffset(28, 0).addBox(-3.0F, 1.0F, -5.0F, 6, 4, 3, 0.0F);

		head.setTextureOffset(17, 17).addBox(3.0F, 2.0F, -5.0F, 1, 2, 1, 0.0F);
		head.setTextureOffset(17, 17).addBox(-4.0F, 2.0F, -5.0F, 1, 2, 1, 0.0F);
	}
}