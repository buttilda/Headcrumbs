package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class KoboldHead extends ModelHead {

	public static final KoboldHead INSTANCE = new KoboldHead();

	protected KoboldHead() {
	}

	@Override
	public void init() {
		float f = 1.0F;
		hideOverlay();
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.5f, -7.0f + f, -3.0f + f, 7, 6, 6);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		ModelRenderer rightear = new ModelRenderer(this, 48, 20);
		rightear.addBox(0.0f, -4.0f, 0.0f, 4, 4, 1);
		rightear.setRotationPoint(3.5f, -3.0f + f, -1.0f + f);
		rightear.rotateAngleY = 0.2617994f;
		rightear.rotateAngleZ = -0.3490659f;
		head.addChild(rightear);
		ModelRenderer leftear = new ModelRenderer(this, 48, 25);
		leftear.addBox(-4.0f, -4.0f, 0.0f, 4, 4, 1);
		leftear.setRotationPoint(-3.5f, -3.0f + f, -1.0f + f);
		leftear.rotateAngleY = -0.2617994f;
		leftear.rotateAngleZ = 0.3490659f;
		head.addChild(leftear);
		ModelRenderer snout = new ModelRenderer(this, 28, 0);
		snout.addBox(-1.5f, -2.0f, -2.0f, 3, 2, 3);
		snout.setRotationPoint(0.0f, -2.0f + f, -3.0f + f);
		head.addChild(snout);
		ModelRenderer jaw = new ModelRenderer(this, 28, 5);
		jaw.addBox(-1.5f, 0.0f, -2.0f, 3, 1, 3);
		jaw.setRotationPoint(0.0f, -2.0f + f, -3.0f + f);
		jaw.rotateAngleX = 0.20944f;
		head.addChild(jaw);
	}
}