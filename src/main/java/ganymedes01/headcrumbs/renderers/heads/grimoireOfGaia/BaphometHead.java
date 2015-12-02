package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class BaphometHead extends ModelHead {

	public static final BaphometHead INSTANCE = new BaphometHead();

	protected BaphometHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer righthorn = new ModelRenderer(this, 36, 34);
		righthorn.addBox(-3.0F, -9.0F, 0.0F, 2, 6, 6);
		righthorn.setTextureSize(64, 32);
		righthorn.mirror = true;
		setRotation(righthorn, 0.0F, 0.0F, 0.0F);
		ModelRenderer leftthorn = new ModelRenderer(this, 36, 34);
		leftthorn.addBox(1.0F, -9.0F, 0.0F, 2, 6, 6);
		leftthorn.setTextureSize(64, 32);
		leftthorn.mirror = true;
		setRotation(leftthorn, 0.0F, 0.0F, 0.0F);
		ModelRenderer righthair = new ModelRenderer(this, 36, 22);
		righthair.addBox(-5.0F, -4.5F, 3.0F, 2, 10, 2);
		righthair.setTextureSize(64, 32);
		righthair.mirror = true;
		setRotation(righthair, 0.1745329F, 0.0F, 0.1745329F);
		ModelRenderer lefthair = new ModelRenderer(this, 36, 22);
		lefthair.addBox(3.0F, -4.5F, 3.0F, 2, 10, 2);
		lefthair.setTextureSize(64, 32);
		lefthair.mirror = true;
		setRotation(lefthair, 0.1745329F, 0.0F, -0.1745329F);
		ModelRenderer righthairclip = new ModelRenderer(this, 36, 14);
		righthairclip.addBox(-5.5F, -5.0F, 2.533333F, 3, 5, 3);
		righthairclip.setTextureSize(64, 32);
		righthairclip.mirror = true;
		setRotation(righthairclip, 0.1745329F, 0.0F, 0.1745329F);
		ModelRenderer lefthairclip = new ModelRenderer(this, 48, 14);
		lefthairclip.addBox(2.5F, -5.0F, 2.5F, 3, 5, 3);
		lefthairclip.setTextureSize(64, 32);
		lefthairclip.mirror = true;
		setRotation(lefthairclip, 0.1745329F, 0.0F, -0.1745329F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 42);
		rightear.addBox(-4.0F, -5.0F, -1.0F, 0, 4, 4);
		rightear.setTextureSize(64, 32);
		rightear.mirror = true;
		setRotation(rightear, 0.0F, -0.5235988F, 0.0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 42);
		leftear.addBox(4.0F, -5.0F, -1.0F, 0, 4, 4);
		leftear.setTextureSize(64, 32);
		leftear.mirror = true;
		setRotation(leftear, 0.0F, 0.5235988F, 0.0F);

		head.addChild(righthorn);
		head.addChild(leftthorn);
		head.addChild(righthair);
		head.addChild(lefthair);
		head.addChild(righthairclip);
		head.addChild(lefthairclip);
		head.addChild(rightear);
		head.addChild(leftear);
	}
}