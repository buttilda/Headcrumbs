package ganymedes01.headcrumbs.renderers.heads.mysticalwildlife;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

public class YagaHogHead extends ModelHead {

	public static final YagaHogHead INSTANCE = new YagaHogHead();

	protected YagaHogHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.MWL_PREFIX + "yaga_hog_dirt_eyes.png"));
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
		head.setTextureOffset(16, 16).addBox(-2.0F, -4.0F, -5.0F, 4, 3, 1, 0.0F);
		hideOverlay();
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}