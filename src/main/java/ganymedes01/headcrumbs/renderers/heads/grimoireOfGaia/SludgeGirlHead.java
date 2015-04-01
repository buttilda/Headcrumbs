package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;

import com.mojang.authlib.GameProfile;

public class SludgeGirlHead extends ModelHead {

	public static final SludgeGirlHead INSTANCE = new SludgeGirlHead();

	protected SludgeGirlHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		init();
	}

	@Override
	public void init() {
	}
}