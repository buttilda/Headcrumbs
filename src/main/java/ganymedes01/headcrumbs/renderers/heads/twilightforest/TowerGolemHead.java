package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class TowerGolemHead extends ModelHead {

	public static final TowerGolemHead INSTANCE = new TowerGolemHead();

	protected TowerGolemHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		hideOverlay();
		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		float f = 2;
		head.setTextureOffset(0, 0).addBox(-3.5f, -10.0f + f, -3.0f + f, 7, 8, 6);
		head.setTextureOffset(0, 14).addBox(-4.0f, -6.0f + f, -3.5f + f, 8, 4, 6);
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}
}