package ganymedes01.headcrumbs.renderers.heads.enderzoo;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import ganymedes01.headcrumbs.renderers.heads.EndermanHead;
import ganymedes01.headcrumbs.utils.Utils;

public class EnderminyHead extends EndermanHead {

	public static final EnderminyHead INSTANCE = new EnderminyHead();

	protected EnderminyHead() {
	}

	@Override
	public void init() {
		super.init();
		setSecondTexture(Utils.getResource(Strings.EZ_PREFIX + "enderminy_eyes.png"));
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.scale(1, 0.5F, 1);
	}
}