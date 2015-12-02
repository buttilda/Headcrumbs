package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class FleshLichHead extends ModelHead {

	public static final FleshLichHead INSTANCE = new FleshLichHead();

	protected FleshLichHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 6, 8);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 56, 0);
		overlay.addBox(-4.0F, -2.0F, -4.0F, 8, 4, 8);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
	}
}