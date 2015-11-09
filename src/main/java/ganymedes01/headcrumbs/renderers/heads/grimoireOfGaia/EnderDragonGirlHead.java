package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

public class EnderDragonGirlHead extends ModelHead {

	public static final EnderDragonGirlHead INSTANCE = new EnderDragonGirlHead();

	protected EnderDragonGirlHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.GOG_PREFIX + "eyes/Eyes_Ender_Dragon_Girl.png"));

		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -2.0F, 6, 6, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.1745329F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -7.0F, -2.5F, 7, 7, 9);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		setRotation(overlay, 0.1745329F, 0.0F, 0.0F);
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}