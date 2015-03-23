package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class RedcapHead extends ModelHead {

	public static final RedcapHead INSTANCE = new RedcapHead();

	protected RedcapHead() {
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 0, 0);
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.4F, -7.0F, -4.0F, 7, 7, 7, 0.0F);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		overlay = new ModelRenderer(this, 32, 0);
		overlay.addBox(-2.0F, -8.0F, -3.0F, 4, 5, 7, 0.0F);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);

		ModelRenderer goblinRightEar = new ModelRenderer(this, 48, 20);
		goblinRightEar.addBox(3.0F, -7.0F, -1.0F, 2, 3, 1, 0.0F);
		goblinRightEar.setRotationPoint(0.0F, 0.0F, 0.0F);

		ModelRenderer goblinLeftEar = new ModelRenderer(this, 48, 24);
		goblinLeftEar.addBox(-5.0F, -7.0F, -1.0F, 2, 3, 1, 0.0F);
		goblinLeftEar.setRotationPoint(0.0F, 0.0F, 0.0F);

		head.addChild(goblinLeftEar);
		head.addChild(goblinRightEar);
	}
}