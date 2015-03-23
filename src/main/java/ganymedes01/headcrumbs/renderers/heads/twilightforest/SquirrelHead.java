package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.heads.PigmanHead;
import net.minecraft.client.model.ModelRenderer;

public class SquirrelHead extends PigmanHead {

	public static final SquirrelHead INSTANCE = new SquirrelHead();

	protected SquirrelHead() {
		textureWidth = 32;
		textureHeight = 32;
		hideOverlay();
		setTextureOffset("head.head", 0, 0);
		setTextureOffset("head.ear2", 16, 0);
		setTextureOffset("head.ear1", 16, 0);

		head = new ModelRenderer(this, "head");
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		setRotation(head, 0.0f, 0.0f, 0.0f);
		float f = 3;
		float f2 = 1;
		head.addBox("head", -2.0f, -5.0f + f2, -3.0f + f, 4, 4, 4);
		head.addBox("ear2", -2.0f, -6.0f + f2, -0.5f + f, 1, 1, 1);
		head.addBox("ear1", 1.0f, -6.0f + f2, -0.5f + f, 1, 1, 1);
	}

	@Override
	public float playerRenderOffset() {
		return 3;
	}
}