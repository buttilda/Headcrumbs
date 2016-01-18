package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class RabbitHead extends ModelHead {

	public static final RabbitHead INSTANCE = new RabbitHead();

	protected RabbitHead() {
	}

	@Override
	public void init() {
		float f0 = 4;
		setTextureOffset("head.main", 0, 0);
		setTextureOffset("head.nose", 0, 24);
		setTextureOffset("head.ear1", 0, 10);
		setTextureOffset("head.ear2", 6, 10);

		head = new ModelRenderer(this, 32, 0);
		head.addBox(-2.5F, -4.0F, -5.0F + f0, 5, 4, 5);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);

		ModelRenderer rabbitRightEar = new ModelRenderer(this, 52, 0);
		rabbitRightEar.addBox(-1.5F, -9.0F, -1.0F + f0, 2, 5, 1);
		rabbitRightEar.mirror = true;
		rabbitRightEar.setRotationPoint(0.0F, 0.0F, -1.0F);
		setRotation(rabbitRightEar, 0.0F, -0.2617994F, 0.0F);

		ModelRenderer rabbitLeftEar = new ModelRenderer(this, 58, 0);
		rabbitLeftEar.addBox(-0.5F, -9.0F, -1.0F + f0, 2, 5, 1);
		rabbitLeftEar.mirror = true;
		rabbitLeftEar.setRotationPoint(0.0F, 0.0F, -1.0F);
		setRotation(rabbitLeftEar, 0.0F, 0.2617994F, 0.0F);

		overlay = new ModelRenderer(this, 32, 9);
		overlay.addBox(-0.5F, -2.5F, -5.5F + f0, 1, 1, 1);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);

		head.addChild(rabbitLeftEar);
		head.addChild(rabbitRightEar);
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}