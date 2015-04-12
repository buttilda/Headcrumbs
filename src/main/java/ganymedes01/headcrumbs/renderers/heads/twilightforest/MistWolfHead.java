package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import ganymedes01.headcrumbs.renderers.heads.WolfHead;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import com.mojang.authlib.GameProfile;

public class MistWolfHead extends WolfHead {

	public static final MistWolfHead INSTANCE = new MistWolfHead();

	protected MistWolfHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.scale(1.5, 1.5, 1.5);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		OpenGLHelper.translate(0, -0.25, 0);
	}
}