package ganymedes01.headcrumbs.renderers.heads.primitivemobs;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class LilyLurkerHead extends ModelHead {

	public static final LilyLurkerHead INSTANCE = new LilyLurkerHead();

	protected LilyLurkerHead() {
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 28, 0);
		head.addBox(-4.0F, -4.0F, -6.0F, 8, 4, 10);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		hideOverlay();
	}
}