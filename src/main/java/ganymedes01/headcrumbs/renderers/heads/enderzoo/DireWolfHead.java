package ganymedes01.headcrumbs.renderers.heads.enderzoo;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class DireWolfHead extends ModelHead {

	public static final DireWolfHead INSTANCE = new DireWolfHead();

	protected DireWolfHead() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -3.0F, -4.0F, 6, 6, 6, 0);
		head.setRotationPoint(2, -3F, 0);
		head.setTextureOffset(16, 18).addBox(-2.5F, -5.0F, -1.5F, 1, 2, 2, 0);
		head.setTextureOffset(16, 18).addBox(1.5F, -5.0F, -1.5F, 1, 2, 2, 0);
		head.setTextureOffset(0, 14).addBox(-1.5F, 0.0F, -7.0F, 3, 3, 4, 0);
		hideOverlay();
	}
}