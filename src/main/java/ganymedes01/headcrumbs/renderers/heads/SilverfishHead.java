package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SilverfishHead extends ModelHead {

	public static final SilverfishHead INSTANCE = new SilverfishHead();

	protected SilverfishHead() {
		float f = -1.9F;
		float f1 = -24;
		head = new ModelRenderer(this, 0, 0);

		ModelRenderer[] silverfishBodyParts = new ModelRenderer[7];
		ModelRenderer[] silverfishWings;
		int[][] silverfishBoxLength = new int[][] { { 3, 2, 2 }, { 4, 3, 2 }, { 6, 4, 3 }, { 3, 3, 3 }, { 2, 2, 3 }, { 2, 1, 2 }, { 1, 1, 2 } };
		int[][] silverfishTexturePositions = new int[][] { { 0, 0 }, { 0, 4 }, { 0, 9 }, { 0, 16 }, { 0, 22 }, { 11, 0 }, { 13, 4 } };

		float[] field_78170_c = new float[7];

		for (int i = 0; i < silverfishBodyParts.length; ++i) {
			silverfishBodyParts[i] = new ModelRenderer(this, silverfishTexturePositions[i][0], silverfishTexturePositions[i][1]);
			silverfishBodyParts[i].addBox(silverfishBoxLength[i][0] * -0.5F, 0.0F + f1, silverfishBoxLength[i][2] * -0.5F, silverfishBoxLength[i][0], silverfishBoxLength[i][1], silverfishBoxLength[i][2]);
			silverfishBodyParts[i].setRotationPoint(0.0F, 24 - silverfishBoxLength[i][1], f);
			field_78170_c[i] = f;

			if (i < silverfishBodyParts.length - 1)
				f += (silverfishBoxLength[i][2] + silverfishBoxLength[i + 1][2]) * 0.5F;

			if (i < 3)
				head.addChild(silverfishBodyParts[i]);
		}

		silverfishWings = new ModelRenderer[2];
		silverfishWings[0] = new ModelRenderer(this, 20, 0);
		silverfishWings[0].addBox(-5.0F, 0.0F + f1, silverfishBoxLength[2][2] * -0.5F, 10, 8, silverfishBoxLength[2][2]);
		silverfishWings[0].setRotationPoint(0.0F, 16.0F, field_78170_c[2]);
		silverfishWings[1] = new ModelRenderer(this, 20, 18);
		silverfishWings[1].addBox(-3.0F, 0.0F + f1, silverfishBoxLength[4][2] * -0.5F, 6, 5, silverfishBoxLength[1][2]);
		silverfishWings[1].setRotationPoint(0.0F, 19.0F, field_78170_c[1]);

		head.addChild(silverfishWings[0]);
		head.addChild(silverfishWings[1]);
		hideOverlay();
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}