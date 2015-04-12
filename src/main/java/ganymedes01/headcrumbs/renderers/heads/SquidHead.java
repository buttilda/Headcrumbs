package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;

import com.mojang.authlib.GameProfile;

public class SquidHead extends ModelHead {

	public static final SquidHead INSTANCE = new SquidHead();

	protected SquidHead() {
	}

	@Override
	public void init() {
		head = new ModelRenderer(this).setTextureSize(64, 32);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-6.0F, -16F, -6.0F + 0.25F, 12, 16, 12);
		hideOverlay();
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.scale(2F / 3F, 2F / 3F, 2F / 3F);
	}
}