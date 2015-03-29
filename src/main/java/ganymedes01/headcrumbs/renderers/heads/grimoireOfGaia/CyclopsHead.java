package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class CyclopsHead extends ModelHead {

	public static final CyclopsHead INSTANCE = new CyclopsHead();

	protected CyclopsHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.034907F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.034907F, 0.0F, 0.0F);
		ModelRenderer hair = new ModelRenderer(this, 36, 18);
		hair.addBox(-1.5F, -5.0F, 2.5F, 3, 12, 3);
		hair.setTextureSize(64, 32);
		hair.mirror = true;
		setRotation(hair, 0.034907F, 0.0F, 0.0F);
		ModelRenderer righthorn = new ModelRenderer(this, 36, 14);
		righthorn.addBox(-2.5F, -2.5F, -7.5F, 1, 1, 3);
		righthorn.setTextureSize(64, 32);
		righthorn.mirror = true;
		setRotation(righthorn, -0.7504916F, 0.0F, 0.0F);
		ModelRenderer lefthorn = new ModelRenderer(this, 36, 14);
		lefthorn.addBox(1.5F, -2.5F, -7.5F, 1, 1, 3);
		lefthorn.setTextureSize(64, 32);
		lefthorn.mirror = true;
		setRotation(lefthorn, -0.7504916F, 0.0F, 0.0F);

		head.addChild(hair);
		head.addChild(righthorn);
		head.addChild(lefthorn);
	}
}