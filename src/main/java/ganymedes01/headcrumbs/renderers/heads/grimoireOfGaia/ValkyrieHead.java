package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;

import com.mojang.authlib.GameProfile;

public class ValkyrieHead extends ModelHead {

	public static final ValkyrieHead INSTANCE = new ValkyrieHead();

	protected ValkyrieHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		init();
	}

	@Override
	public void init() {
	}
}