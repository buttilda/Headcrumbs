package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class YetiHead extends ModelHead {

	public static final YetiHead INSTANCE = new YetiHead();

	protected YetiHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = -4;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -4.0F + f0, -4.0F, 8, 8, 8);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 0, 28);
		overlay.addBox(-6.0F, -6.0F + f0, 0.0F, 12, 8, 6);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		setRotation(overlay, -0.261799F, 0.0F, 0.0F);
		ModelRenderer headjaw = new ModelRenderer(this, 0, 16);
		headjaw.addBox(-6.0F, 0.0F + f0, -2.0F, 12, 6, 6);
		headjaw.setTextureSize(128, 64);
		headjaw.mirror = true;
		setRotation(headjaw, 0.0F, 0.0F, 0.0F);

		head.addChild(headjaw);
	}
}