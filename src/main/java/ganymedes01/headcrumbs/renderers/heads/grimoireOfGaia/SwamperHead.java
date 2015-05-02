package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SwamperHead extends ModelHead {

	public static final SwamperHead INSTANCE = new SwamperHead();

	protected SwamperHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 1.5F;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -7.0F, -4.0F + f0, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.1745329F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 32, 0);
		overlay.addBox(-3.5F, -7.5F, -4.5F + f0, 7, 9, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.1745329F, 0.0F, 0.0F);
	}
}