package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class NagaHead extends ModelHead {

	public static final NagaHead INSTANCE = new NagaHead();

	protected NagaHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = -1;
		float f1 = 1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-2.5F, -4.0F + f0, -3.0F + f1, 5, 4, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 76, 0);
		overlay.addBox(-1.0F, -3.5F + f0, -5.0F + f1, 2, 1, 2);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer headnose1 = new ModelRenderer(this, 72, 3);
		headnose1.addBox(-1.5F, -2.5F + f0, -6.0F + f1, 3, 2, 3);
		headnose1.setTextureSize(128, 64);
		headnose1.mirror = true;
		setRotation(headnose1, 0.0F, 0.0F, 0.0F);
		ModelRenderer headchin = new ModelRenderer(this, 64, 8);
		headchin.addBox(-2.0F, -1.5F + f0, -6.5F + f1, 4, 2, 6);
		headchin.setTextureSize(128, 64);
		headchin.mirror = true;
		setRotation(headchin, 0.0F, 0.0F, 0.0F);
		ModelRenderer rightfin = new ModelRenderer(this, 22, 0);
		rightfin.addBox(-3.0F, -5.0F + f0, 0.0F + f1, 0, 5, 3);
		rightfin.setTextureSize(128, 64);
		rightfin.mirror = true;
		setRotation(rightfin, 0.0F, -0.5235988F, 0.0F);
		ModelRenderer leftfin = new ModelRenderer(this, 28, 0);
		leftfin.addBox(3.0F, -5.0F + f0, 0.0F + f1, 0, 5, 3);
		leftfin.setTextureSize(128, 64);
		leftfin.mirror = true;
		setRotation(leftfin, 0.0F, 0.5235988F, 0.0F);
		ModelRenderer fin2 = new ModelRenderer(this, 34, 40);
		fin2.addBox(0.0F, -9.0F + f0, -3.0F + f1, 0, 5, 6);
		fin2.setTextureSize(128, 64);
		fin2.mirror = true;
		setRotation(fin2, 0.0F, 0.0F, 0.0F);

		head.addChild(headnose1);
		head.addChild(headchin);
		head.addChild(rightfin);
		head.addChild(leftfin);
		head.addChild(fin2);
	}
}