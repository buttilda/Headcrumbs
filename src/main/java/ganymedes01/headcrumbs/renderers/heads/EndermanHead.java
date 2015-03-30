package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelEnderman;

import com.mojang.authlib.GameProfile;

public class EndermanHead extends ModelHead {

	public static final EndermanHead INSTANCE = new EndermanHead();

	protected EndermanHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.MC_PREFIX + "enderman/enderman_eyes.png"));

		ModelEnderman model = new ModelEnderman();
		head = model.bipedHead;
		overlay = model.bipedHeadwear;
		head.setRotationPoint(0F, 0F, 0F);
		overlay.setRotationPoint(0F, 0F, 0F);
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}