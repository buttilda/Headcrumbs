package ganymedes01.headcrumbs.renderers.heads.mysticalwildlife;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

public class DuskLurkerHead extends ModelHead {

	public static final DuskLurkerHead INSTANCE = new DuskLurkerHead();

	protected DuskLurkerHead() {
		textureWidth = 64;
		textureHeight = 48;
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.MWL_PREFIX + "dusk_lurker_eyes.png"));
		
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4, -8, -4, 8, 8, 8, 0.0F);
		head.setTextureOffset(0, 16).addBox(-3, -5, -10, 6, 4, 6, 0.0F);
		hideOverlay();
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}