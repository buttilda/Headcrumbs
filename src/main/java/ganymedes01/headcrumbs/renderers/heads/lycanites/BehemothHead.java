package ganymedes01.headcrumbs.renderers.heads.lycanites;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class BehemothHead extends ModelHead {

	public static final BehemothHead INSTANCE = new BehemothHead();

	protected BehemothHead() {
		textureWidth = 128;
		textureHeight = 128;

		float f1 = 22;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4F, -10F + f1, -4F, 8, 10, 8);
		head.setRotationPoint(0F, -21F, 0F);
		head.setTextureSize(128, 128);
		setRotation(head, 0F, 0F, 0F);

		ModelRenderer mouth = new ModelRenderer(this, 32, 0);
		head.addChild(mouth);
		mouth.addBox(-2F, -2F, -4.5F, 4, 3, 2);
		mouth.setRotationPoint(0F, 0F + f1, 0F);
		mouth.setTextureSize(128, 128);
		setRotation(mouth, 0.2094395F, 0F, 0F);

		ModelRenderer lefthorn01 = new ModelRenderer(this, 32, 5);
		head.addChild(lefthorn01);
		lefthorn01.addBox(3F, -5F, -0.5F, 5, 5, 6);
		lefthorn01.setRotationPoint(0F, 0F + f1, 0F);
		lefthorn01.setTextureSize(128, 128);
		setRotation(lefthorn01, 0.1745329F, 0.3141593F, -0.4363323F);

		ModelRenderer lefthorn02 = new ModelRenderer(this, 50, 0);
		head.addChild(lefthorn02);
		lefthorn02.addBox(-3F, -10F, 6F, 3, 7, 4);
		lefthorn02.setRotationPoint(0F, 0F + f1, 0F);
		lefthorn02.setTextureSize(128, 128);
		setRotation(lefthorn02, 1.204277F, -0.1396263F, 1.012291F);

		ModelRenderer lefthorn03 = new ModelRenderer(this, 53, 0);
		head.addChild(lefthorn03);
		lefthorn03.addBox(3.5F, -7.5F, 11F, 2, 7, 2);
		lefthorn03.setRotationPoint(0F, 0F + f1, 0F);
		lefthorn03.setTextureSize(128, 128);
		setRotation(lefthorn03, 1.989675F, 0F, 0.5235988F);

		ModelRenderer righthorn01 = new ModelRenderer(this, 32, 5);
		head.addChild(righthorn01);
		righthorn01.mirror = true;
		righthorn01.addBox(-8F, -5F, -0.5F, 5, 5, 6);
		righthorn01.setRotationPoint(0F, 0F + f1, 0F);
		righthorn01.setTextureSize(128, 128);
		setRotation(righthorn01, 0.1745329F, -0.3141593F, 0.4363323F);
		righthorn01.mirror = false;

		ModelRenderer righthorn02 = new ModelRenderer(this, 50, 0);
		head.addChild(righthorn02);
		righthorn02.mirror = true;
		righthorn02.addBox(0F, -10F, 6F, 3, 7, 4);
		righthorn02.setRotationPoint(0F, 0F + f1, 0F);
		righthorn02.setTextureSize(128, 128);
		setRotation(righthorn02, 1.204277F, 0.1396263F, -1.012291F);
		righthorn02.mirror = false;

		ModelRenderer righthorn03 = new ModelRenderer(this, 53, 0);
		head.addChild(righthorn03);
		righthorn03.mirror = true;
		righthorn03.addBox(-5.5F, -7.5F, 11F, 2, 7, 2);
		righthorn03.setRotationPoint(0F, 0F + f1, 0F);
		righthorn03.setTextureSize(128, 128);
		setRotation(righthorn03, 1.989675F, 0F, -0.5235988F);
		righthorn03.mirror = false;

		hideOverlay();
	}
}