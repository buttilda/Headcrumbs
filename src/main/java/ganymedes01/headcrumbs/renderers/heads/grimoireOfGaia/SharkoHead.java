package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SharkoHead extends ModelHead {

	public static final SharkoHead INSTANCE = new SharkoHead();

	protected SharkoHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -7.0F, -4.0F, 8, 7, 8);
		head.setTextureSize(64, 32);
		head.mirror = true;
		ModelRenderer headsnout = new ModelRenderer(this, 0, 33);
		headsnout.addBox(-3.5F, -7.5F, -5.0F, 7, 4, 6);
		headsnout.setTextureSize(64, 32);
		headsnout.mirror = true;
		setRotation(headsnout, 0.6981317F, 0.0F, 0.0F);
		ModelRenderer headjaw = new ModelRenderer(this, 0, 43);
		headjaw.addBox(-3.0F, -3.0F, -5.0F, 6, 4, 5);
		headjaw.setTextureSize(64, 32);
		headjaw.mirror = true;
		setRotation(headjaw, 0.1745329F, 0.0F, 0.0F);

		head.addChild(headsnout);
		head.addChild(headjaw);
		hideOverlay();
	}
}