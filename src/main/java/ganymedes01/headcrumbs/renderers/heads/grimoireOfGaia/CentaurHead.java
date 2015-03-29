package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class CentaurHead extends ModelHead {

	public static final CentaurHead INSTANCE = new CentaurHead();

	protected CentaurHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = 0;
		float f1 = 1.5F;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
		head.setRotationPoint(0.0F, f0, f1);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		overlay.setRotationPoint(0.0F, f0, f1);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 26);
		rightear.addBox(-4.0F, -5.0F, -1.0F, 0, 4, 4);
		rightear.setTextureSize(64, 32);
		rightear.mirror = true;
		setRotation(rightear, 0.0F, -0.5235988F, 0.0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 26);
		leftear.addBox(4.0F, -5.0F, -1.0F, 0, 4, 4);
		leftear.setTextureSize(64, 32);
		leftear.mirror = true;
		setRotation(leftear, 0.0F, 0.5235988F, 0.0F);

		head.addChild(rightear);
		head.addChild(leftear);
	}

	@Override
	public float playerRenderOffset() {
		return -2;
	}
}