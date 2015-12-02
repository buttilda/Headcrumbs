package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

public class EnderEyeHead extends ModelHead {

	public static final EnderEyeHead INSTANCE = new EnderEyeHead();

	protected EnderEyeHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.GOG_PREFIX + "eyes/Eyes_Ender_Eye.png"));

		textureWidth = 128;
		textureHeight = 64;
		float f0 = -3;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -5.0F + f0, -2.0F, 8, 8, 6);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.1745329F, 0.0F, 0.0F);
		ModelRenderer eyelid1 = new ModelRenderer(this, 0, 14);
		eyelid1.addBox(-5.0F, -5.0F, -9.0F, 10, 5, 10);
		eyelid1.setRotationPoint(0.0F, -2.0F + f0, 4.5F);
		eyelid1.setTextureSize(128, 64);
		eyelid1.mirror = true;
		setRotation(eyelid1, 0.034907F, 0.0F, 0.0F);
		ModelRenderer eyelid2 = new ModelRenderer(this, 0, 29);
		eyelid2.addBox(-5.0F, 0.0F, -9.0F, 10, 5, 10);
		eyelid2.setRotationPoint(0.0F, -2.0F + f0, 4.5F);
		eyelid2.setTextureSize(128, 64);
		eyelid2.mirror = true;
		setRotation(eyelid2, 0.349066F, 0.0F, 0.0F);

		head.addChild(eyelid1);
		head.addChild(eyelid2);
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}