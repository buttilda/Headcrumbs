package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class HarpyHead extends ModelHead {

	public static final HarpyHead INSTANCE = new HarpyHead();

	protected HarpyHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 0;
		float f1 = 1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F + f0, -3.0F + f1, 6, 6, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -7.0F + f0, -3.5F + f1, 7, 7, 7);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		ModelRenderer hair = new ModelRenderer(this, 64, 0);
		hair.addBox(-2.5F, -8.0F + f0, 2.0F + f1, 5, 5, 5);
		hair.setTextureSize(128, 64);
		hair.mirror = true;
		ModelRenderer rightfeather = new ModelRenderer(this, 36, 14);
		rightfeather.addBox(-4.5F, -5.0F + f0, 0.0F + f1, 1, 6, 8);
		rightfeather.setTextureSize(128, 64);
		rightfeather.mirror = true;
		setRotation(rightfeather, 0.349066F, -0.261799F, 0.0F);
		ModelRenderer leftfeather = new ModelRenderer(this, 54, 14);
		leftfeather.addBox(3.5F, -5.0F + f0, 0.0F + f1, 1, 6, 8);
		leftfeather.setTextureSize(128, 64);
		leftfeather.mirror = true;
		setRotation(leftfeather, 0.349066F, 0.261799F, 0.0F);

		head.addChild(hair);
		head.addChild(rightfeather);
		head.addChild(leftfeather);
	}
}