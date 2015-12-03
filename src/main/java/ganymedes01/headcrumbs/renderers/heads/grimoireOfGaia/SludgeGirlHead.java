package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

public class SludgeGirlHead extends ModelHead {

	public static final SludgeGirlHead INSTANCE = new SludgeGirlHead();

	protected SludgeGirlHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.GOG_PREFIX + "Sludge_Girl_Hair.png"));

		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		overlay.setTextureSize(128, 64);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer righteye = new ModelRenderer(this, 72, 0);
		righteye.addBox(-3.0F, -7.0F, -4.0F, 2, 2, 2);
		righteye.setTextureSize(128, 64);
		righteye.mirror = true;
		setRotation(righteye, 0.0F, 0.0F, 0.0F);
		ModelRenderer lefteye = new ModelRenderer(this, 80, 0);
		lefteye.addBox(1.0F, -7.0F, -4.0F, 2, 2, 2);
		lefteye.setTextureSize(128, 64);
		lefteye.mirror = true;
		setRotation(lefteye, 0.0F, 0.0F, 0.0F);
		ModelRenderer headslime = new ModelRenderer(this, 36, 14);
		headslime.addBox(-4.5F, -7.5F, -4.5F, 9, 9, 9);
		headslime.setTextureSize(128, 64);
		headslime.mirror = true;
		setRotation(headslime, 0.0F, 0.0F, 0.0F);
		ModelRenderer headslime1 = new ModelRenderer(this, 36, 32);
		headslime1.addBox(-5.0F, -6.5F, 1.0F, 10, 10, 4);
		headslime1.setTextureSize(128, 64);
		headslime1.mirror = true;
		setRotation(headslime1, 0.0F, 0.0F, 0.0F);

		head.addChild(righteye);
		head.addChild(lefteye);
		overlay.addChild(headslime);
		overlay.addChild(headslime1);
		hideOverlay();
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		OpenGLHelper.enableBlend();
		OpenGLHelper.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		renderOverlay(skullRotation);
		OpenGLHelper.disableBlend();
	}
}