package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class DullahanHead extends ModelHead {

	public static final DullahanHead INSTANCE = new DullahanHead();

	protected DullahanHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = -3;
		float f1 = 1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -3.0F + f0, -3.0F + f1, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -3.5F + f0, -3.5F + f1, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
	}
}