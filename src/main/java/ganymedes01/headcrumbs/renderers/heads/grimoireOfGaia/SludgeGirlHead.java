package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SludgeGirlHead extends ModelHead {

	public static final SludgeGirlHead INSTANCE = new SludgeGirlHead();

	protected SludgeGirlHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer headslime = new ModelRenderer(this, 64, 0);
		headslime.addBox(-4.0F, -7.0F, -4.0F, 8, 12, 8);
		headslime.setTextureSize(128, 64);
		headslime.mirror = true;
		setRotation(headslime, 0.0F, 0.0F, 0.0F);

		head.addChild(headslime);
	}
}