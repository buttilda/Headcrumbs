package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class NineTailsHead extends ModelHead {

	public static final NineTailsHead INSTANCE = new NineTailsHead();

	protected NineTailsHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F + f0, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F + f0, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer ears = new ModelRenderer(this, 36, 29);
		ears.addBox(-5.5F, -8.5F, 0.5F + f0, 11, 4, 1);
		ears.setTextureSize(64, 32);
		ears.mirror = true;
		setRotation(ears, 0.0F, 0.0F, 0.0F);

		head.addChild(ears);
	}
}