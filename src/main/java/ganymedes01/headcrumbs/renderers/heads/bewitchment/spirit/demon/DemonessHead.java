package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class DemonessHead extends ModelHead {
	
	public static final DemonessHead INSTANCE = new DemonessHead();
	
	protected DemonessHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;


		head = new ModelRenderer(this, 0, 1);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		ModelRenderer hair01 = new ModelRenderer(this, 25, 0);
		hair01.setRotationPoint(0.0F, -4.4F, 3.2F);
		hair01.addBox(-4.0F, 0.0F, -0.1F, 8, 8, 1, 0.0F);
		setRotateAngle(hair01, 0.20943951023931953F, 0.0F, 0.0F);

		ModelRenderer hair02 = new ModelRenderer(this, 25, 0);
		hair02.mirror = true;
		hair02.setRotationPoint(0.0F, -6.9F, 3.2F);
		hair02.addBox(-4.0F, 0.0F, -0.1F, 8, 8, 1, 0.0F);
		setRotateAngle(hair02, 0.3490658503988659F, 0.0F, 0.0F);

		ModelRenderer lHorn01 = new ModelRenderer(this, 0, 0);
		lHorn01.setRotationPoint(2.9F, -7.4F, -0.5F);
		lHorn01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(lHorn01, -0.17453292519943295F, 0.13962634015954636F, 0.13962634015954636F);

		ModelRenderer lHorn02a = new ModelRenderer(this, 0, 4);
		lHorn02a.setRotationPoint(0.0F, -1.7F, 0.0F);
		lHorn02a.addBox(-0.8F, -2.0F, -0.8F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn02a, -0.17453292519943295F, 0.0F, 0.05235987755982988F);

		ModelRenderer lHorn02b = new ModelRenderer(this, 0, 4);
		lHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02b.addBox(-0.2F, -2.0F, -0.8F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn02c = new ModelRenderer(this, 0, 4);
		lHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02c.addBox(-0.8F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03a = new ModelRenderer(this, 0, 4);
		lHorn03a.setRotationPoint(0.0F, -1.6F, 0.0F);
		lHorn03a.addBox(-0.7F, -2.0F, -0.7F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn03a, -0.10471975511965977F, 0.0F, 0.10471975511965977F);

		ModelRenderer lHorn03b = new ModelRenderer(this, 0, 4);
		lHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03b.addBox(-0.3F, -2.0F, -0.7F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03c = new ModelRenderer(this, 0, 4);
		lHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03c.addBox(-0.7F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03d = new ModelRenderer(this, 0, 4);
		lHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03d.addBox(-0.2F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03d_1 = new ModelRenderer(this, 0, 4);
		lHorn03d_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03d_1.addBox(-0.3F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn04 = new ModelRenderer(this, 4, 4);
		lHorn04.setRotationPoint(0.0F, -1.7F, 0.0F);
		lHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn04, 0.05235987755982988F, 0.0F, 0.13962634015954636F);

		ModelRenderer lHorn05 = new ModelRenderer(this, 43, 0);
		lHorn05.setRotationPoint(0.0F, -2.7F, 0.0F);
		lHorn05.addBox(-0.5F, -2.1F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn05, 0.05235987755982988F, 0.0F, -0.13962634015954636F);

		ModelRenderer rHorn01 = new ModelRenderer(this, 0, 0);
		rHorn01.mirror = true;
		rHorn01.setRotationPoint(-2.9F, -7.4F, -0.5F);
		rHorn01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(rHorn01, -0.17453292519943295F, -0.13962634015954636F, -0.13962634015954636F);

		ModelRenderer rHorn02a = new ModelRenderer(this, 0, 4);
		rHorn02a.mirror = true;
		rHorn02a.setRotationPoint(0.0F, -1.7F, 0.0F);
		rHorn02a.addBox(-0.8F, -2.0F, -0.8F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn02a, -0.17453292519943295F, 0.0F, -0.05235987755982988F);

		ModelRenderer rHorn02b = new ModelRenderer(this, 0, 4);
		rHorn02b.mirror = true;
		rHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02b.addBox(-0.2F, -2.0F, -0.8F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn02c = new ModelRenderer(this, 0, 4);
		rHorn02c.mirror = true;
		rHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02c.addBox(-0.8F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03a = new ModelRenderer(this, 0, 4);
		rHorn03a.mirror = true;
		rHorn03a.setRotationPoint(0.0F, -1.6F, 0.0F);
		rHorn03a.addBox(-0.7F, -2.0F, -0.7F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn03a, -0.10471975511965977F, 0.0F, -0.10471975511965977F);

		ModelRenderer rHorn03b = new ModelRenderer(this, 0, 4);
		rHorn03b.mirror = true;
		rHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03b.addBox(-0.3F, -2.0F, -0.7F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03c = new ModelRenderer(this, 0, 4);
		rHorn03c.mirror = true;
		rHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03c.addBox(-0.7F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03d = new ModelRenderer(this, 0, 4);
		rHorn03d.mirror = true;
		rHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03d.addBox(-0.2F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03d_1 = new ModelRenderer(this, 0, 4);
		rHorn03d_1.mirror = true;
		rHorn03d_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03d_1.addBox(-0.3F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn04 = new ModelRenderer(this, 4, 4);
		rHorn04.mirror = true;
		rHorn04.setRotationPoint(0.0F, -1.7F, 0.0F);
		rHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn04, 0.05235987755982988F, 0.0F, -0.13962634015954636F);

		ModelRenderer rHorn05 = new ModelRenderer(this, 43, 0);
		rHorn05.mirror = true;
		rHorn05.setRotationPoint(0.0F, -2.7F, 0.0F);
		rHorn05.addBox(-0.5F, -2.1F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn05, 0.05235987755982988F, 0.0F, 0.13962634015954636F);

		head.addChild(hair01);
		head.addChild(hair02);
		head.addChild(lHorn01);
		head.addChild(rHorn01);
		lHorn01.addChild(lHorn02a);
		lHorn02a.addChild(lHorn02b);
		lHorn02a.addChild(lHorn03d);
		lHorn02a.addChild(lHorn02c);
		lHorn02a.addChild(lHorn03a);
		lHorn03a.addChild(lHorn03b);
		lHorn03a.addChild(lHorn03d_1);
		lHorn03a.addChild(lHorn04);
		lHorn03a.addChild(lHorn03c);
		lHorn04.addChild(lHorn05);
		rHorn01.addChild(rHorn02a);
		rHorn02a.addChild(rHorn03a);
		rHorn02a.addChild(rHorn02b);
		rHorn02a.addChild(rHorn03d);
		rHorn02a.addChild(rHorn02c);
		rHorn03a.addChild(rHorn03c);
		rHorn03a.addChild(rHorn04);
		rHorn03a.addChild(rHorn03d_1);
		rHorn03a.addChild(rHorn03b);
		rHorn04.addChild(rHorn05);
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
