package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class DemonHead extends ModelHead {
	
	public static final DemonHead INSTANCE = new DemonHead();
	
	protected DemonHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;


		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		ModelRenderer lHorn01 = new ModelRenderer(this, 32, 0);
		lHorn01.setRotationPoint(2.9F, -7.4F, -1.3F);
		lHorn01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(lHorn01, 0.10471975511965977F, 0.0F, 0.41887902047863906F);

		ModelRenderer lHorn02 = new ModelRenderer(this, 32, 0);
		lHorn02.setRotationPoint(0.0F, -1.7F, 0.0F);
		lHorn02.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(lHorn02, -0.10471975511965977F, 0.0F, -0.19198621771937624F);

		ModelRenderer lHorn03a = new ModelRenderer(this, 35, 5);
		lHorn03a.setRotationPoint(0.0F, -1.6F, 0.0F);
		lHorn03a.addBox(-0.8F, -2.0F, -0.8F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn03a, -0.13962634015954636F, 0.0F, -0.06981317007977318F);

		ModelRenderer lHorn03b = new ModelRenderer(this, 35, 5);
		lHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03b.addBox(-0.2F, -2.0F, -0.8F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03c = new ModelRenderer(this, 35, 5);
		lHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03c.addBox(-0.8F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03d = new ModelRenderer(this, 35, 5);
		lHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03d.addBox(-0.2F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn04 = new ModelRenderer(this, 35, 10);
		lHorn04.setRotationPoint(0.0F, -1.7F, 0.0F);
		lHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn04, -0.13962634015954636F, 0.0F, -0.10471975511965977F);

		ModelRenderer rHorn01 = new ModelRenderer(this, 32, 0);
		rHorn01.mirror = true;
		rHorn01.setRotationPoint(-2.9F, -7.4F, -1.3F);
		rHorn01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(rHorn01, 0.10471975511965977F, 0.0F, -0.41887902047863906F);

		ModelRenderer rHorn02 = new ModelRenderer(this, 32, 0);
		rHorn02.mirror = true;
		rHorn02.setRotationPoint(0.0F, -1.7F, 0.0F);
		rHorn02.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(rHorn02, -0.10471975511965977F, 0.0F, 0.19198621771937624F);

		ModelRenderer rHorn03a = new ModelRenderer(this, 35, 5);
		rHorn03a.mirror = true;
		rHorn03a.setRotationPoint(0.0F, -1.6F, 0.0F);
		rHorn03a.addBox(-0.8F, -2.0F, -0.8F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn03a, -0.13962634015954636F, 0.0F, 0.06981317007977318F);

		ModelRenderer rHorn03b = new ModelRenderer(this, 35, 5);
		rHorn03b.mirror = true;
		rHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03b.addBox(-0.2F, -2.0F, -0.8F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03c = new ModelRenderer(this, 35, 5);
		rHorn03c.mirror = true;
		rHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03c.addBox(-0.8F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03d = new ModelRenderer(this, 35, 5);
		rHorn03d.mirror = true;
		rHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03d.addBox(-0.2F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn04 = new ModelRenderer(this, 35, 10);
		rHorn04.mirror = true;
		rHorn04.setRotationPoint(0.0F, -1.7F, 0.0F);
		rHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn04, -0.13962634015954636F, 0.0F, 0.10471975511965977F);

		head.addChild(rHorn01);
		head.addChild(lHorn01);
		lHorn01.addChild(lHorn02);
		lHorn02.addChild(lHorn03a);
		lHorn03a.addChild(lHorn03d);
		lHorn03a.addChild(lHorn04);
		lHorn03a.addChild(lHorn03b);
		lHorn03a.addChild(lHorn03c);
		rHorn01.addChild(rHorn02);
		rHorn02.addChild(rHorn03a);
		rHorn03a.addChild(rHorn03d);
		rHorn03a.addChild(rHorn03b);
		rHorn03a.addChild(rHorn04);
		rHorn03a.addChild(rHorn03c);
	}
	
	@Override
	public void preRender(GameProfile profile) {
		float fx = 0;
		float fy = 0;
		float fz = -1.0f * 0.0625f;
		setTranslation(fx, fy, fz);
		GlStateManager.scale(1.4, 1.4, 1.4);
	}
	
	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(0, 0.15f, 0.25f);
		GlStateManager.scale(0.5f, 0.5f, 0.5f);
	}
	
	public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
