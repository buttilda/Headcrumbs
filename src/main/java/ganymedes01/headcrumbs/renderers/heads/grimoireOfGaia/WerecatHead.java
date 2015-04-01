package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.renderers.ModelHead;

import com.mojang.authlib.GameProfile;

public class WerecatHead extends ModelHead {

	public static final WerecatHead INSTANCE = new WerecatHead();

	protected WerecatHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		init();
	}

	@Override
	public void init() {
	}
}