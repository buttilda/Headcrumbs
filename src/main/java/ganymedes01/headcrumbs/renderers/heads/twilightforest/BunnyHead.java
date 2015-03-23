package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.heads.PigmanHead;
import net.minecraft.client.model.ModelRenderer;

public class BunnyHead extends PigmanHead {

	public static final BunnyHead INSTANCE = new BunnyHead();

	protected BunnyHead() {
		hideOverlay();

		setTextureOffset("head.head", 0, 0);
		setTextureOffset("head.ear2", 16, 0);
		setTextureOffset("head.ear1", 16, 0);

		head = new ModelRenderer(this, "head").setTextureSize(32, 32);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.rotateAngleX = 0.0F;
		head.rotateAngleY = 0.0F;
		head.rotateAngleZ = 0.0F;
		head.mirror = true;
		head.addBox("head", -2.0F, -4.0F, 0.0F, 4, 4, 4);
		head.addBox("ear2", -2.5F, -8.0F, 2.5F, 2, 4, 1);
		head.addBox("ear1", 0.5F, -8.0F, 2.5F, 2, 4, 1);
	}

	@Override
	public float playerRenderOffset() {
		return 3;
	}
}