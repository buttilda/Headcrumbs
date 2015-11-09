package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

public class DhampirHead extends ModelHead {

	public static final DhampirHead INSTANCE = new DhampirHead();

	protected DhampirHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.GOG_PREFIX + "eyes/Eyes_Dhampir.png"));

		textureWidth = 128;
		textureHeight = 64;
		float f0 = 1;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F + f0, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F + f0, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer hat01 = new ModelRenderer(this, 36, 33);
		hat01.addBox(-6.0F, -7.0F, -6.0F + f0, 12, 2, 12);
		hat01.setTextureSize(64, 32);
		hat01.mirror = true;
		setRotation(hat01, 0.034907F, 0.9599311F, 0.034907F);
		ModelRenderer hat02 = new ModelRenderer(this, 36, 47);
		hat02.addBox(-3.0F, -10.0F, -3.0F + f0, 6, 3, 6);
		hat02.setTextureSize(64, 32);
		hat02.mirror = true;
		setRotation(hat02, 0.034907F, 0.7853982F, 0.034907F);
		ModelRenderer hat03 = new ModelRenderer(this, 36, 56);
		hat03.addBox(-4.0F, -11.0F, 0.0F + f0, 4, 3, 4);
		hat03.setTextureSize(64, 32);
		hat03.mirror = true;
		setRotation(hat03, 0.034907F, 0.9599311F, 0.034907F);
		ModelRenderer hatflower = new ModelRenderer(this, 84, 0);
		hatflower.addBox(-3.5F, -11.0F, -3.5F + f0, 7, 4, 7);
		hatflower.setTextureSize(64, 32);
		hatflower.mirror = true;
		setRotation(hatflower, 0.034907F, 0.7853982F, 0.034907F);
		ModelRenderer hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-1.0F, -2.5F, 2.5F + f0, 2, 12, 2);
		hair.setTextureSize(64, 32);
		hair.mirror = true;
		setRotation(hair, 0.349066F, 0.0F, 0.0F);
		ModelRenderer righthair = new ModelRenderer(this, 36, 28);
		righthair.addBox(-5.0F, -5.0F, -4.0F + f0, 4, 4, 1);
		righthair.setTextureSize(64, 32);
		righthair.mirror = true;
		setRotation(righthair, 0.0F, 0.7853982F, 0.0F);
		ModelRenderer lefthair = new ModelRenderer(this, 46, 28);
		lefthair.addBox(1.0F, -5.0F, -4.0F + f0, 4, 4, 1);
		lefthair.setTextureSize(64, 32);
		lefthair.mirror = true;
		setRotation(lefthair, 0.0F, -0.7853982F, 0.0F);

		head.addChild(hat01);
		head.addChild(hat02);
		head.addChild(hat03);
		head.addChild(hatflower);
		head.addChild(hair);
		head.addChild(righthair);
		head.addChild(lefthair);
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}