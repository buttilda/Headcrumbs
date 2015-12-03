package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class YetiHead extends ModelHead {

	public static final YetiHead INSTANCE = new YetiHead();

	protected YetiHead() {
	}

	@Override
	public void init() {
		textureWidth = 256;
		textureHeight = 128;
		float f0 = -4, f1 = 5;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -4.0F + f0, -9.0F + f1, 8, 8, 8);
		head.setTextureSize(256, 128);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 0, 40);
		overlay.addBox(-6.0F, -5.0F + f0, -3.0F + f1, 12, 8, 6);
		overlay.setTextureSize(256, 128);
		overlay.mirror = true;
		setRotation(overlay, -0.261799F, 0.0F, 0.0F);
		ModelRenderer horns = new ModelRenderer(this, 0, 16);
		horns.addBox(-4.5F, -6.0F + f0, -9.5F + f1, 9, 3, 9);
		horns.setTextureSize(256, 128);
		horns.mirror = true;
		setRotation(horns, 0.0F, 0.0F, 0.0F);
		ModelRenderer headjaw = new ModelRenderer(this, 0, 28);
		headjaw.addBox(-6.0F, 0.0F + f0, -3.0F + f1, 12, 6, 6);
		headjaw.setTextureSize(256, 128);
		headjaw.mirror = true;
		setRotation(headjaw, 0.0F, 0.0F, 0.0F);

		head.addChild(horns);
		head.addChild(headjaw);
	}
}