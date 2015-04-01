package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;

import com.mojang.authlib.GameProfile;

public class SuccubusHead extends ModelHead {

	public static final SuccubusHead INSTANCE = new SuccubusHead();

	protected SuccubusHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		init();
	}

	@Override
	public void init() {
	}
}