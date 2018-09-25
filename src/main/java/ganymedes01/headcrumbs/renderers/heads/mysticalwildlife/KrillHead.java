package ganymedes01.headcrumbs.renderers.heads.mysticalwildlife;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class KrillHead extends ModelHead {

	public static final KrillHead INSTANCE = new KrillHead();

	protected KrillHead() {
		textureWidth = 32;
		textureHeight = 32;
	}

	@Override
	public void init() {
		//Offsets to copy paste positions from the original model
		float y = -1.5F, z = 3;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-1.5F, -1.5F + y, -5 + z, 3, 3, 6, 0.0F);

		ModelRenderer tentacleUL = new ModelRenderer(this, 0, 9);
		tentacleUL.setRotationPoint(-0.75F, -0.75F + y, -4.5F + z);
		tentacleUL.addBox(-0.5F, -0.5F, -3, 1, 1, 3, 0);
		tentacleUL.rotateAngleX = 0.6981317007977318F;
		ModelRenderer tentacleUR = new ModelRenderer(this, 0, 9);
		tentacleUR.setRotationPoint(0.75F, -0.75F + y, -4.5F + z);
		tentacleUR.addBox(-0.5F, -0.5F, -3, 1, 1, 3, 0);
		tentacleUR.rotateAngleX = 0.6981317007977318F;
		ModelRenderer tentacleLL = new ModelRenderer(this, 0, 9);
		tentacleLL.setRotationPoint(-0.75F, 0.75F + y, -4.5F + z);
		tentacleLL.addBox(-0.5F, -0.5F, -3, 1, 1, 3, 0);
		tentacleLL.rotateAngleX = 0.8726646259971648F;
		ModelRenderer tentacleLR = new ModelRenderer(this, 0, 9);
		tentacleLR.setRotationPoint(0.75F, 0.75F + y, -4.5F + z);
		tentacleLR.addBox(-0.5F, -0.5F, -3, 1, 1, 3, 0);
		tentacleLR.rotateAngleX = 0.8726646259971648F;
		ModelRenderer tentacleM = new ModelRenderer(this, 0, 9);
		tentacleM.setRotationPoint(0.0F, 0.0F + y, -4.5F + z);
		tentacleM.addBox(-0.5F, -0.5F, -3, 1, 1, 3, 0);
		tentacleM.rotateAngleX = 0.7853981633974483F;

		head.addChild(tentacleUL);
		head.addChild(tentacleUR);
		head.addChild(tentacleLL);
		head.addChild(tentacleLR);
		head.addChild(tentacleM);

		hideOverlay();
	}
}