package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class ValkyrieHead extends ModelHead {

	public static final ValkyrieHead INSTANCE = new ValkyrieHead();

	protected ValkyrieHead() {
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
		ModelRenderer hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-3.5F, -4.0F, 2.5F + f0, 7, 10, 3);
		hair.setTextureSize(64, 32);
		hair.mirror = true;
		setRotation(hair, 0.349066F, 0.0F, 0.0F);
		ModelRenderer rightfeather = new ModelRenderer(this, 36, 27);
		rightfeather.addBox(-4.5F, -7.0F, 0.0F + f0, 1, 6, 8);
		rightfeather.setTextureSize(64, 32);
		rightfeather.mirror = true;
		setRotation(rightfeather, 0.349066F, -0.261799F, 0.0F);
		ModelRenderer leftfeather = new ModelRenderer(this, 36, 27);
		leftfeather.addBox(3.5F, -7.0F, 0.0F + f0, 1, 6, 8);
		leftfeather.setTextureSize(64, 32);
		leftfeather.mirror = true;
		setRotation(leftfeather, 0.349066F, 0.261799F, 0.0F);
		ModelRenderer headhelmet = new ModelRenderer(this, 36, 41);
		headhelmet.addBox(-3.0F, -7.0F, -4.0F + f0, 6, 3, 4);
		headhelmet.setTextureSize(64, 32);
		headhelmet.mirror = true;
		setRotation(headhelmet, 0.0F, 0.0F, 0.0F);

		head.addChild(hair);
		head.addChild(rightfeather);
		head.addChild(leftfeather);
		head.addChild(headhelmet);
	}
}