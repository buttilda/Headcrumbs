package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SahuaginHead extends ModelHead {

	public static final SahuaginHead INSTANCE = new SahuaginHead();

	protected SahuaginHead() {
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
		ModelRenderer rightear = new ModelRenderer(this, 36, 24);
		rightear.addBox(-4.0F, -5.0F, -1.0F + f0, 0, 4, 5);
		rightear.setTextureSize(64, 32);
		rightear.mirror = true;
		setRotation(rightear, 0.0F, -0.5235988F, 0.0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 24);
		leftear.addBox(4.0F, -5.0F, -1.0F + f0, 0, 4, 5);
		leftear.setTextureSize(64, 32);
		leftear.mirror = true;
		setRotation(leftear, 0.0F, 0.5235988F, 0.0F);
		head.addChild(leftear);
		head.addChild(rightear);
	}
}