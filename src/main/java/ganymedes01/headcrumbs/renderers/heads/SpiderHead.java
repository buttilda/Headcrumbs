package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

import com.mojang.authlib.GameProfile;

public class SpiderHead extends ModelHead {

	public static final SpiderHead INSTANCE = new SpiderHead();

	protected SpiderHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.MC_PREFIX + "spider_eyes.png"));

		head = new ModelRenderer(this, 32, 4);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		hideOverlay();
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}