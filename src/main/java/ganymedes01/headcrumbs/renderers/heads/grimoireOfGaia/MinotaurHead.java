package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class MinotaurHead extends ModelHead {

	public static final MinotaurHead INSTANCE = new MinotaurHead();

	protected MinotaurHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.GOG_PREFIX + "eyes/Eyes_Minotaur.png"));

		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.5F, -7.0F, -4.0F, 7, 7, 8);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		ModelRenderer horn = new ModelRenderer(this, 50, 0);
		horn.addBox(-7.5F, -6.0F, -3.0F, 15, 2, 2);
		horn.setTextureSize(128, 64);
		horn.mirror = true;
		setRotation(horn, 0.0F, 0.0F, 0.0F);
		ModelRenderer hornright = new ModelRenderer(this, 76, 4);
		hornright.addBox(-7.5F, -10.0F, 1.0F, 2, 5, 2);
		hornright.setTextureSize(128, 64);
		hornright.mirror = true;
		setRotation(hornright, 0.7853982F, 0.0F, 0.0F);
		ModelRenderer hornleft = new ModelRenderer(this, 76, 4);
		hornleft.addBox(5.5F, -10.0F, 1.0F, 2, 5, 2);
		hornleft.setTextureSize(128, 64);
		hornleft.mirror = true;
		setRotation(hornleft, 0.802852F, 0.0F, 0.0F);
		ModelRenderer brow = new ModelRenderer(this, 30, 0);
		brow.addBox(-3.0F, -6.0F, -6.0F, 6, 2, 2);
		brow.setTextureSize(128, 64);
		brow.mirror = true;
		setRotation(brow, 0.0F, 0.0F, 0.0F);
		ModelRenderer nose = new ModelRenderer(this, 30, 4);
		nose.addBox(-2.5F, -4.0F, -9.0F, 5, 4, 5);
		nose.setTextureSize(128, 64);
		nose.mirror = true;
		setRotation(nose, 0.0F, 0.0F, 0.0F);
		ModelRenderer nosering = new ModelRenderer(this, 30, 13);
		nosering.addBox(-2.0F, -1.0F, -10.0F, 4, 4, 1);
		nosering.setTextureSize(128, 64);
		nosering.mirror = true;
		setRotation(nosering, 0.0F, 0.0F, 0.0F);

		head.addChild(horn);
		head.addChild(hornright);
		head.addChild(hornleft);
		head.addChild(brow);
		head.addChild(nose);
		head.addChild(nosering);
		hideOverlay();
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(-0.35F, 0.125F, 0);
	}
}