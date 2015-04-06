package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class MinotaurusHead extends ModelHead {

	public static final MinotaurusHead INSTANCE = new MinotaurusHead();

	protected MinotaurusHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F + f0, 6, 6, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F + f0, 7, 7, 7);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer horn = new ModelRenderer(this, 36, 14);
		horn.addBox(-4.5F, -7.5F, -0.5F + f0, 9, 3, 2);
		horn.setTextureSize(128, 64);
		horn.mirror = true;
		setRotation(horn, 0.349066F, 0.0F, 0.0F);
		ModelRenderer righthorn = new ModelRenderer(this, 36, 19);
		righthorn.addBox(-3.5F, -9.5F, -0.5F + f0, 2, 2, 2);
		righthorn.setTextureSize(128, 64);
		righthorn.mirror = true;
		setRotation(righthorn, 0.349066F, 0.0F, 0.0F);
		ModelRenderer lefthorn = new ModelRenderer(this, 44, 19);
		lefthorn.addBox(1.5F, -9.5F, -0.5F + f0, 2, 2, 2);
		lefthorn.setTextureSize(128, 64);
		lefthorn.mirror = true;
		setRotation(lefthorn, 0.349066F, 0.0F, 0.0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 23);
		rightear.addBox(-3.5F, -5.0F, 0.5F + f0, 0, 4, 4);
		rightear.setTextureSize(128, 64);
		rightear.mirror = true;
		setRotation(rightear, 0.0F, -0.7853982F, 0.0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 23);
		leftear.addBox(3.5F, -5.0F, 0.5F + f0, 0, 4, 4);
		leftear.setTextureSize(128, 64);
		leftear.mirror = true;
		setRotation(leftear, 0.0F, 0.7853982F, 0.0F);

		head.addChild(horn);
		head.addChild(righthorn);
		head.addChild(lefthorn);
		head.addChild(rightear);
		head.addChild(leftear);
	}
}