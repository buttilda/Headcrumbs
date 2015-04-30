package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SphinxHead extends ModelHead {

	public static final SphinxHead INSTANCE = new SphinxHead();

	protected SphinxHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.5F, -3.0F, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -7.0F, -3.5F, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 14);
		rightear.addBox(-4.5F, -10.0F, -1.5F, 3, 4, 3);
		rightear.setTextureSize(64, 32);
		rightear.mirror = true;
		setRotation(rightear, 0.0F, 0.0F, 0.0F);
		ModelRenderer leftear = new ModelRenderer(this, 48, 14);
		leftear.addBox(1.5F, -10.0F, -1.5F, 3, 4, 3);
		leftear.setTextureSize(64, 32);
		leftear.mirror = true;
		setRotation(leftear, 0.0F, 0.0F, 0.0F);
		ModelRenderer hair01 = new ModelRenderer(this, 36, 21);
		hair01.addBox(-4.0F, -4.5F, -2.0F, 8, 3, 6);
		hair01.setTextureSize(64, 32);
		hair01.mirror = true;
		setRotation(hair01, 0.0F, 0.0F, 0.0F);
		ModelRenderer hair02 = new ModelRenderer(this, 36, 30);
		hair02.addBox(-4.5F, -1.5F, -1.5F, 9, 6, 6);
		hair02.setTextureSize(64, 32);
		hair02.mirror = true;
		setRotation(hair02, 0.0F, 0.0F, 0.0F);
		ModelRenderer crown = new ModelRenderer(this, 36, 42);
		crown.addBox(-1.0F, -8.0F, -4.6F, 2, 3, 1);
		crown.setTextureSize(64, 32);
		crown.mirror = true;
		setRotation(crown, 0.0F, 0.0F, 0.0F);

		head.addChild(rightear);
		head.addChild(leftear);
		head.addChild(hair01);
		head.addChild(hair02);
		head.addChild(crown);
	}
}