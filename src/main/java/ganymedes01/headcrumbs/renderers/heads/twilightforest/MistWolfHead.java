package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.heads.WolfHead;
import net.minecraft.client.renderer.GlStateManager;

public class MistWolfHead extends WolfHead {

	public static final MistWolfHead INSTANCE = new MistWolfHead();

	protected MistWolfHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		GlStateManager.scale(1.5, 1.5, 1.5);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(0, -0.25, 0);
	}
}