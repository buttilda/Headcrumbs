package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;

import com.mojang.authlib.GameProfile;

public class JorogumoHead extends ModelHead {

	public static final JorogumoHead INSTANCE = new JorogumoHead();

	protected JorogumoHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.GOG_PREFIX + "eyes/Eyes_Jorogumo.png"));

		textureWidth = 128;
		textureHeight = 64;
		float f0 = -5;
		float f1 = 10;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -1.0F + f0, -13.0F + f1, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -1.5F + f0, -13.5F + f1, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-2.0F, -3.0F + f0, -14.5F + f1, 4, 4, 4);
		hair1.setTextureSize(64, 32);
		hair1.mirror = true;
		setRotation(hair1, -0.0872665F, 0.0F, 0.0F);
		ModelRenderer hair2 = new ModelRenderer(this, 36, 14);
		hair2.addBox(-2.0F, -3.0F + f0, -9.5F + f1, 4, 4, 4);
		hair2.setTextureSize(64, 32);
		hair2.mirror = true;
		setRotation(hair2, 0.0872665F, 0.0F, 0.0F);
		ModelRenderer hair3 = new ModelRenderer(this, 36, 55);
		hair3.addBox(-4.5F, -1.5F + f0, -11.5F + f1, 9, 6, 4);
		hair3.setTextureSize(64, 32);
		hair3.mirror = true;
		setRotation(hair3, -0.261799F, 0.0F, 0.0F);
		ModelRenderer hairpin1 = new ModelRenderer(this, 36, 22);
		hairpin1.addBox(-3.0F, -4.0F + f0, -10.5F + f1, 6, 4, 1);
		hairpin1.setTextureSize(64, 32);
		hairpin1.mirror = true;
		setRotation(hairpin1, 0.0F, 0.0F, 0.0F);
		ModelRenderer hairpin2 = new ModelRenderer(this, 36, 27);
		hairpin2.addBox(-4.0F, -3.0F + f0, -15.0F + f1, 8, 4, 1);
		hairpin2.setTextureSize(64, 32);
		hairpin2.mirror = true;
		setRotation(hairpin2, 0.0F, 0.0F, 0.0F);

		head.addChild(hair1);
		head.addChild(hair2);
		head.addChild(hair3);
		head.addChild(hairpin1);
		head.addChild(hairpin2);
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}
}