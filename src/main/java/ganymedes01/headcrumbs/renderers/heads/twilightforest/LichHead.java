package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class LichHead extends ModelHead {

	public static final LichHead INSTANCE = new LichHead();

	protected LichHead() {
	}

	@Override
	public void init() {
		textureWidth = 64;
		textureHeight = 64;
		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, -4.0F, 0.0F);
		head.addBox(-4.0F, -4.0F, -4.0F, 8, 8, 8, 0.0F);
		overlay = new ModelRenderer(this, 32, 0);
		overlay.setRotationPoint(0.0F, -4.0F, 0.0F);
		overlay.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
	}
}