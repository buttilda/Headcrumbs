package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import com.mojang.authlib.GameProfile;

public class WitchHead extends ModelHead {

	public static final WitchHead INSTANCE = new WitchHead();

	protected WitchHead() {
	}

	@Override
	public void init() {
		head = new ModelRenderer(this).setTextureSize(64, 128);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.setTextureOffset(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);

		overlay = new ModelRenderer(this).setTextureSize(64, 128);
		overlay.setRotationPoint(0.0F, -2.0F, 0.0F);
		overlay.setTextureOffset(24, 0).addBox(-1.0F, -1.0F, -6.0F, 2, 4, 2, 0.0F);

		ModelRenderer wart = new ModelRenderer(this).setTextureSize(64, 128);
		wart.setRotationPoint(0.0F, -2.0F, 0.0F);
		wart.setTextureOffset(0, 0).addBox(0.0F, 3.0F, -6.75F, 1, 1, 1, -0.25F);
		overlay.addChild(wart);

		ModelRenderer hatBase = new ModelRenderer(this).setTextureSize(64, 128);
		hatBase.setRotationPoint(-5.0F, -10.03125F, -5.0F);
		hatBase.setTextureOffset(0, 64).addBox(0.0F, 0.0F, 0.0F, 10, 2, 10);
		hatBase.rotateAngleX = head.rotateAngleX;
		hatBase.rotateAngleY = head.rotateAngleY;
		head.addChild(hatBase);

		ModelRenderer hat1 = new ModelRenderer(this).setTextureSize(64, 128);
		hat1.setRotationPoint(1.75F, -4.0F, 2.0F);
		hat1.setTextureOffset(0, 76).addBox(0.0F, 0.0F, 0.0F, 7, 4, 7);
		hat1.rotateAngleX = -0.05235988F;
		hat1.rotateAngleZ = 0.02617994F;
		hatBase.addChild(hat1);

		ModelRenderer hat2 = new ModelRenderer(this).setTextureSize(64, 128);
		hat2.setRotationPoint(1.75F, -4.0F, 2.0F);
		hat2.setTextureOffset(0, 87).addBox(0.0F, 0.0F, 0.0F, 4, 4, 4);
		hat2.rotateAngleX = -0.10471976F;
		hat2.rotateAngleZ = 0.05235988F;
		hat1.addChild(hat2);

		ModelRenderer hat3 = new ModelRenderer(this).setTextureSize(64, 128);
		hat3.setRotationPoint(1.75F, -2.0F, 2.0F);
		hat3.setTextureOffset(0, 95).addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.25F);
		hat3.rotateAngleX = -0.20943952F;
		hat3.rotateAngleZ = 0.10471976F;
		hat2.addChild(hat3);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		OpenGLHelper.scale(0.75, 0.75, 0.75);
		OpenGLHelper.translate(0, -0.45, 0);
	}
}