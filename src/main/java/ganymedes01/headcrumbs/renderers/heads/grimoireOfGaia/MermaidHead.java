package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class MermaidHead extends ModelHead {

	public static final MermaidHead INSTANCE = new MermaidHead();

	protected MermaidHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = -1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -5.0F + f0, -2.0F, 6, 6, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -5.5F + f0, -2.5F, 7, 7, 7);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer headhelmet = new ModelRenderer(this, 36, 37);
		headhelmet.addBox(-4.0F, -7.5F + f0, -5.5F, 8, 8, 8);
		headhelmet.setTextureSize(128, 64);
		headhelmet.mirror = true;
		setRotation(headhelmet, -0.5235988F, 0.0F, 0.0F);
		ModelRenderer finright = new ModelRenderer(this, 36, 29);
		finright.addBox(-4.0F, -5.0F + f0, 0.0F, 0, 5, 3);
		finright.setTextureSize(128, 64);
		finright.mirror = true;
		setRotation(finright, 0.0F, -0.5235988F, 0.0F);
		ModelRenderer finleft = new ModelRenderer(this, 36, 29);
		finleft.addBox(4.0F, -5.0F + f0, 0.0F, 0, 5, 3);
		finleft.setTextureSize(128, 64);
		finleft.mirror = true;
		setRotation(finleft, 0.0F, 0.5235988F, 0.0F);

		head.addChild(headhelmet);
		head.addChild(finright);
		head.addChild(finleft);
	}
}