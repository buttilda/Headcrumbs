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
		float f0 = -10;
		float f1 = -2;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0F, -5.0F, -2.0F, 8, 8, 6);
		head.setRotationPoint(0, f1, 0);
		head.setTextureSize(128, 64);
		head.mirror = true;
		setRotation(head, 0.1745329F, 0.0F, 0.0F);
		ModelRenderer eyeLid1 = new ModelRenderer(this, 0, 16);
		eyeLid1.addBox(-4.5F, -4.5F, -9.0F, 9, 5, 9);
		eyeLid1.setRotationPoint(0.0F, 8.0F + f0, 4.5F);
		eyeLid1.setTextureSize(128, 64);
		eyeLid1.mirror = true;
		setRotation(eyeLid1, 0.1745329F, 0.0F, 0.0F);
		ModelRenderer eyeLid2 = new ModelRenderer(this, 0, 30);
		eyeLid2.addBox(-4.5F, 0.5F, -9.0F, 9, 4, 9);
		eyeLid2.setRotationPoint(0.0F, 8.0F + f0, 4.5F);
		eyeLid2.setTextureSize(128, 64);
		eyeLid2.mirror = true;
		setRotation(eyeLid2, 0.349066F, 0.0F, 0.0F);

		head.addChild(eyeLid1);
		head.addChild(eyeLid2);
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}