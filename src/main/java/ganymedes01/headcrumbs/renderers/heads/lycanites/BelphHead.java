package ganymedes01.headcrumbs.renderers.heads.lycanites;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class BelphHead extends ModelHead {

	public static final BelphHead INSTANCE = new BelphHead();

	protected BelphHead() {
	}

	@Override
	public void init() {
		textureWidth = 64;
		textureHeight = 32;

		float f1 = -4;
		float f2 = 3;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F + f1, -5F + f2, 6, 10, 6);
		head.setRotationPoint(0F, 0F, 0F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);

		hideOverlay();
	}
}