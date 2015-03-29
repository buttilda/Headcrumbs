package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class CobbleGolemHead extends ModelHead {

	public static final CobbleGolemHead INSTANCE = new CobbleGolemHead();

	protected CobbleGolemHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -4.0F, 0.0F, 6, 4, 4);
		head.setTextureSize(64, 32);
		head.mirror = true;
		hideOverlay();
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}