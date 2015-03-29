package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class CobblestoneGolemHead extends ModelHead {

	public static final CobblestoneGolemHead INSTANCE = new CobblestoneGolemHead();

	protected CobblestoneGolemHead() {
	}

	@Override
	public void init() {
		textureWidth = 256;
		textureHeight = 128;

		overlay = new ModelRenderer(this, 32, 0);
		overlay.addBox(-2.0F, -10.0F, -5.0F, 4, 4, 1);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8);
		head.setTextureSize(64, 32);
		head.mirror = true;
		ModelRenderer nose = new ModelRenderer(this, 32, 5);
		nose.addBox(-1.0F, -5.0F, -5.0F, 2, 3, 1);
		nose.setTextureSize(64, 32);
		nose.mirror = true;
		ModelRenderer mouth = new ModelRenderer(this, 32, 9);
		mouth.addBox(-2.0F, -1.0F, -5.0F, 4, 2, 2);
		mouth.setTextureSize(64, 32);
		mouth.mirror = true;

		head.addChild(nose);
		head.addChild(mouth);
	}
}