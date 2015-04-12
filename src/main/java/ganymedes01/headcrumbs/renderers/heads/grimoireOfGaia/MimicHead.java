package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;

import com.mojang.authlib.GameProfile;

public class MimicHead extends ModelHead {

	public static final MimicHead INSTANCE = new MimicHead();

	protected MimicHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.scale(0.54F, 0.54F, 0.54F);
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;
		float f0 = -10;
		float f1 = 7;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-7.0F, -5.0F + f0, -14.0F + f1, 14, 5, 14);
		head.setTextureSize(128, 64);
		head.mirror = true;
		overlay = new ModelRenderer(this, 0, 19);
		overlay.addBox(-7.0F, 0.0F + f0, -14.0F + f1, 14, 10, 14);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		ModelRenderer lock = new ModelRenderer(this, 0, 0);
		lock.addBox(-1.0F, -2.0F + f0, -15.0F + f1, 2, 4, 1);
		lock.setTextureSize(128, 64);
		lock.mirror = true;

		head.addChild(lock);
	}
}