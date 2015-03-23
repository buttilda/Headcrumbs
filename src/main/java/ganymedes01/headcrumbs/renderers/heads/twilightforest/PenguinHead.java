package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class PenguinHead extends ModelHead {

	public static final PenguinHead INSTANCE = new PenguinHead();

	protected PenguinHead() {
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 0, 0).setTextureSize(64, 32);
		head.addBox(-3.5F, -5.0F, -3.5F, 7, 5, 7);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		overlay = new ModelRenderer(this, 0, 13);
		overlay.addBox(-1.0F, -2.0F, -5.0F, 2, 1, 2);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
	}
}