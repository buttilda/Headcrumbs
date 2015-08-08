package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;

import com.mojang.authlib.GameProfile;

public class NagaTFHead extends ModelHead {

	public static final NagaTFHead INSTANCE = new NagaTFHead();

	protected NagaTFHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.scale(0.5, 0.5, 0.5);
	}

	@Override
	public void init() {
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-8.0F, -16.0F, -8.0F, 16, 16, 16, 0);
		hideOverlay();
	}
}