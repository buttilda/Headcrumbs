package ganymedes01.headcrumbs.renderers.heads;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.MathHelper;

public class GuardianHead extends ModelHead {

	public static final GuardianHead INSTANCE = new GuardianHead();

	protected GuardianHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		GlStateManager.scale(0.5F, 0.5F, 0.5F);
	}

	@Override
	public void init() {
		float f0 = -24;

		ModelRenderer[] guardianSpines;

		textureWidth = 64;
		textureHeight = 64;
		guardianSpines = new ModelRenderer[12];
		head = new ModelRenderer(this);
		head.setTextureOffset(0, 0).addBox(-6.0F, 10.0F + f0, -8.0F, 12, 12, 16);
		head.setTextureOffset(0, 28).addBox(-8.0F, 10.0F + f0, -6.0F, 2, 12, 12);
		head.mirror = true;
		head.setTextureOffset(0, 28).addBox(6.0F, 10.0F + f0, -6.0F, 2, 12, 12);
		head.mirror = false;
		head.setTextureOffset(16, 40).addBox(-6.0F, 8.0F + f0, -6.0F, 12, 2, 12);
		head.setTextureOffset(16, 40).addBox(-6.0F, 22.0F + f0, -6.0F, 12, 2, 12);

		for (int i = 0; i < guardianSpines.length; i++) {
			guardianSpines[i] = new ModelRenderer(this, 0, 0);
			guardianSpines[i].addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2);
			head.addChild(guardianSpines[i]);
		}

		overlay = new ModelRenderer(this, 8, 0);
		overlay.addBox(-1.0F, 15.0F + f0, -8.25F, 2, 2, 1);

		float[] afloat = new float[] { 1.75F, 0.25F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 1.25F, 0.75F, 0.0F, 0.0F };
		float[] afloat1 = new float[] { 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 1.75F, 1.25F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F };
		float[] afloat2 = new float[] { 0.0F, 0.0F, 0.25F, 1.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, 1.25F };
		float[] afloat3 = new float[] { 0.0F, 0.0F, 8.0F, -8.0F, -8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F, 8.0F, -8.0F };
		float[] afloat4 = new float[] { -8.0F, -8.0F, -8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, 8.0F };
		float[] afloat5 = new float[] { 8.0F, -8.0F, 0.0F, 0.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F };

		for (int i = 0; i < 12; i++) {
			guardianSpines[i].rotateAngleX = (float) Math.PI * afloat[i];
			guardianSpines[i].rotateAngleY = (float) Math.PI * afloat1[i];
			guardianSpines[i].rotateAngleZ = (float) Math.PI * afloat2[i];
			guardianSpines[i].rotationPointX = afloat3[i] * (1.0F + MathHelper.cos(i) * 0.01F - 0.275F);
			guardianSpines[i].rotationPointY = 16.0F + afloat4[i] * (1.0F + MathHelper.cos(i) * 0.01F - 0.275F) + f0;
			guardianSpines[i].rotationPointZ = afloat5[i] * (1.0F + MathHelper.cos(i) * 0.01F - 0.275F);
		}
	}
}