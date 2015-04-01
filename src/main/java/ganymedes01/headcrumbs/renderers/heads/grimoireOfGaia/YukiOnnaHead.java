package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;

import com.mojang.authlib.GameProfile;

public class YukiOnnaHead extends ModelHead {

	public static final YukiOnnaHead INSTANCE = new YukiOnnaHead();

	protected YukiOnnaHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		init();
	}

	@Override
	public void init() {
	}
}