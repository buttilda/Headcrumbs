package ganymedes01.headcrumbs.renderers.heads.lasercreeper;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class LaserCreeperHead extends ModelHead {

	public static final LaserCreeperHead INSTANCE = new LaserCreeperHead();

	protected LaserCreeperHead() {
	}

	@Override
	public void init() {
		textureWidth = 64;
		textureHeight = 32;

		head = new ModelRenderer(this, 0, 2);
		head.addBox(-4F, -8F, -4F, 8, 8, 8);
		setRotation(head, 0F, 0F, 0F);
		overlay = new ModelRenderer(this, 0, 18);
		overlay.addBox(-3.5F, -7.5F, -3.5F, 7, 7, 7);
		setRotation(overlay, 0F, 0F, 0F);
		ModelRenderer eye = new ModelRenderer(this, 52, 17);
		eye.addBox(1F, -5F, -5F, 1, 1, 1);
		setRotation(eye, 0F, 0F, 0F);
		ModelRenderer eyePiece = new ModelRenderer(this, 28, 18);
		eyePiece.addBox(1.5F, -5.5F, -4.5F, 3, 2, 2);
		setRotation(eyePiece, 0F, 0F, 0F);

		head.addChild(eye);
		head.addChild(eyePiece);
	}
}