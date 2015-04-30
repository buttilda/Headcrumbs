package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SprigganHead extends ModelHead {

	public static final SprigganHead INSTANCE = new SprigganHead();

	protected SprigganHead() {
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
		ModelRenderer headhorns = new ModelRenderer(this, 36, 14);
		headhorns.addBox(-4.0F, -7.0F, -4.0F + f0, 8, 8, 8);
		headhorns.setTextureSize(64, 32);
		headhorns.mirror = true;
		setRotation(headhorns, 0.0F, 0.0F, 0.0F);
		ModelRenderer headhornslong01 = new ModelRenderer(this, 36, 30);
		headhornslong01.addBox(-6.0F, -10.0F, -3.0F + f0, 12, 5, 5);
		headhornslong01.setTextureSize(64, 32);
		headhornslong01.mirror = true;
		setRotation(headhornslong01, 0.0F, 0.0F, 0.0F);
		ModelRenderer headhornslong02 = new ModelRenderer(this, 36, 40);
		headhornslong02.addBox(-9.0F, -7.0F, -1.0F + f0, 18, 5, 5);
		headhornslong02.setTextureSize(64, 32);
		headhornslong02.mirror = true;
		setRotation(headhornslong02, 0.0F, 0.0F, 0.0F);

		head.addChild(headhorns);
		head.addChild(headhornslong01);
		head.addChild(headhornslong02);
	}
}