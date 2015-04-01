package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;

import com.mojang.authlib.GameProfile;

public class ShamanHead extends ModelHead {

	public static final ShamanHead INSTANCE = new ShamanHead();

	protected ShamanHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		init();
	}

	@Override
	public void init() {
	}
}