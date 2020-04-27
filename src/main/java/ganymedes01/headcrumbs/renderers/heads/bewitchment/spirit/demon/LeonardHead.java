package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class LeonardHead extends ModelHead {
	
	public static final LeonardHead INSTANCE = new LeonardHead();
	
	protected LeonardHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;

		float fy = -2.0f;
		float fz = 0.4f;

		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-3.0F, -6.0F, -3.4F, 6, 6, 6, 0.0F);

		ModelRenderer beard = new ModelRenderer(this, 53, 0);
		beard.setRotationPoint(0.0F, 0.3F, -2.0F);
		beard.addBox(-1.5F, 0.0F, -1.0F, 3, 3, 2, 0.0F);
		setRotateAngle(beard, -0.10471975511965977F, 0.0F, 0.0F);

		ModelRenderer lEar = new ModelRenderer(this, 40, 0);
		lEar.setRotationPoint(2.6F, -4.3F, 0.0F);
		lEar.addBox(0.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		setRotateAngle(lEar, -0.5235987755982988F, 0.0F, 0.3141592653589793F);

		ModelRenderer lHorn01 = new ModelRenderer(this, 25, 0);
		lHorn01.setRotationPoint(1.8F, -5.0F, -1.5F);
		lHorn01.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
		setRotateAngle(lHorn01, -0.5235987755982988F, 0.0F, 0.5235987755982988F);

		ModelRenderer lHorn02 = new ModelRenderer(this, 25, 0);
		lHorn02.setRotationPoint(0.0F, -2.7F, 0.0F);
		lHorn02.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(lHorn02, -0.13962634015954636F, 0.0F, 0.20943951023931953F);

		ModelRenderer lHorn03a = new ModelRenderer(this, 25, 6);
		lHorn03a.setRotationPoint(0.0F, -1.9F, 0.0F);
		lHorn03a.addBox(-0.8F, -2.8F, -0.8F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn03a, -0.3141592653589793F, 0.0F, 0.0F);

		ModelRenderer lHorn03b = new ModelRenderer(this, 25, 6);
		lHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03b.addBox(-0.2F, -2.8F, -0.8F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn03c = new ModelRenderer(this, 25, 6);
		lHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03c.addBox(-0.8F, -2.8F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn03d = new ModelRenderer(this, 25, 6);
		lHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03d.addBox(-0.2F, -2.8F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn04 = new ModelRenderer(this, 31, 6);
		lHorn04.setRotationPoint(0.0F, -2.7F, 0.0F);
		lHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn04, 0.2617993877991494F, 0.0F, 0.0F);

		ModelRenderer mHorn01 = new ModelRenderer(this, 41, 5);
		mHorn01.setRotationPoint(0.0F, -5.2F, -0.2F);
		mHorn01.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
		setRotateAngle(mHorn01, -0.9599310885968813F, 0.0F, 0.0F);

		ModelRenderer mHorn02 = new ModelRenderer(this, 40, 11);
		mHorn02.setRotationPoint(0.0F, -2.7F, 0.0F);
		mHorn02.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
		setRotateAngle(mHorn02, -0.13962634015954636F, 0.0F, 0.0F);

		ModelRenderer mHorn03a = new ModelRenderer(this, 25, 6);
		mHorn03a.setRotationPoint(0.0F, -2.8F, 0.0F);
		mHorn03a.addBox(-0.8F, -2.8F, -0.8F, 1, 3, 1, 0.0F);
		setRotateAngle(mHorn03a, -0.3141592653589793F, 0.0F, 0.0F);

		ModelRenderer mHorn03b = new ModelRenderer(this, 25, 6);
		mHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		mHorn03b.addBox(-0.2F, -2.8F, -0.8F, 1, 3, 1, 0.0F);

		ModelRenderer mHorn03c = new ModelRenderer(this, 25, 6);
		mHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		mHorn03c.addBox(-0.8F, -2.8F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer mHorn03d = new ModelRenderer(this, 25, 6);
		mHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		mHorn03d.addBox(-0.2F, -2.8F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer mHorn04 = new ModelRenderer(this, 50, 7);
		mHorn04.setRotationPoint(0.0F, -2.7F, 0.0F);
		mHorn04.addBox(-0.5F, -3.7F, -0.5F, 1, 4, 1, 0.0F);
		setRotateAngle(mHorn04, 0.2617993877991494F, 0.0F, 0.0F);

		ModelRenderer muzzleLower = new ModelRenderer(this, 23, 54);
		muzzleLower.setRotationPoint(0.0F, -0.8F, -3.6F);
		muzzleLower.addBox(-2.0F, -0.5F, -3.5F, 4, 1, 4, 0.0F);
		setRotateAngle(muzzleLower, 0.06981317007977318F, 0.0F, 0.0F);

		ModelRenderer muzzleUpper = new ModelRenderer(this, 24, 45);
		muzzleUpper.setRotationPoint(0.0F, -1.4F, -3.8F);
		muzzleUpper.addBox(-1.6F, -1.8F, -3.5F, 4, 2, 4, 0.0F);
		setRotateAngle(muzzleUpper, 0.06981317007977318F, 0.0F, 0.0F);

		ModelRenderer muzzleUpper02 = new ModelRenderer(this, 12, 45);
		muzzleUpper02.setRotationPoint(0.0F, -1.4F, -3.8F);
		muzzleUpper02.addBox(-2.3F, -1.8F, -3.5F, 1, 2, 4, 0.0F);
		setRotateAngle(muzzleUpper02, 0.06981317007977318F, 0.0F, 0.0F);

		ModelRenderer rEar = new ModelRenderer(this, 40, 0);
		rEar.mirror = true;
		rEar.setRotationPoint(-2.6F, -4.3F, 0.0F);
		rEar.addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		setRotateAngle(rEar, -0.5235987755982988F, 0.0F, -0.3141592653589793F);

		ModelRenderer rHorn01 = new ModelRenderer(this, 25, 0);
		rHorn01.mirror = true;
		rHorn01.setRotationPoint(-1.8F, -5.0F, -1.5F);
		rHorn01.addBox(-1.0F, -3.0F, -1.0F, 2, 3, 2, 0.0F);
		setRotateAngle(rHorn01, -0.5235987755982988F, 0.0F, -0.5235987755982988F);

		ModelRenderer rHorn02 = new ModelRenderer(this, 25, 0);
		rHorn02.mirror = true;
		rHorn02.setRotationPoint(0.0F, -2.7F, 0.0F);
		rHorn02.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(rHorn02, -0.13962634015954636F, 0.0F, -0.20943951023931953F);

		ModelRenderer rHorn03a = new ModelRenderer(this, 25, 6);
		rHorn03a.mirror = true;
		rHorn03a.setRotationPoint(0.0F, -1.9F, 0.0F);
		rHorn03a.addBox(-0.8F, -2.8F, -0.8F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn03a, -0.3141592653589793F, 0.0F, 0.0F);

		ModelRenderer rHorn03b = new ModelRenderer(this, 25, 6);
		rHorn03b.mirror = true;
		rHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03b.addBox(-0.2F, -2.8F, -0.8F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn03c = new ModelRenderer(this, 25, 6);
		rHorn03c.mirror = true;
		rHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03c.addBox(-0.8F, -2.8F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn03d = new ModelRenderer(this, 25, 6);
		rHorn03d.mirror = true;
		rHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03d.addBox(-0.2F, -2.8F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn04 = new ModelRenderer(this, 31, 6);
		rHorn04.mirror = true;
		rHorn04.setRotationPoint(0.0F, -2.7F, 0.0F);
		rHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn04, 0.2617993877991494F, 0.0F, 0.0F);

		ModelRenderer snout = new ModelRenderer(this, 24, 36);
		snout.setRotationPoint(0.0F, -4.1F, -3.3F);
		snout.addBox(-2.0F, -1.0F, -4.4F, 4, 2, 5, 0.0F);
		setRotateAngle(snout, 0.41887902047863906F, 0.0F, 0.0F);

		muzzleLower.addChild(beard);
		head.addChild(muzzleUpper);
		head.addChild(lEar);
		head.addChild(muzzleLower);
		head.addChild(snout);
		head.addChild(rHorn01);
		head.addChild(muzzleUpper02);
		head.addChild(lHorn01);
		head.addChild(rEar);
		head.addChild(mHorn01);
		lHorn01.addChild(lHorn02);
		lHorn02.addChild(lHorn03a);
		lHorn03a.addChild(lHorn03b);
		lHorn03a.addChild(lHorn03c);
		lHorn03a.addChild(lHorn03d);
		lHorn03a.addChild(lHorn04);
		mHorn01.addChild(mHorn02);
		mHorn02.addChild(mHorn03a);
		mHorn03a.addChild(mHorn03b);
		mHorn03a.addChild(mHorn03d);
		mHorn03a.addChild(mHorn04);
		mHorn03a.addChild(mHorn03c);
		rHorn01.addChild(rHorn02);
		rHorn02.addChild(rHorn03a);
		rHorn03a.addChild(rHorn03d);
		rHorn03a.addChild(rHorn04);
		rHorn03a.addChild(rHorn03b);
		rHorn03a.addChild(rHorn03c);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		GlStateManager.scale(1.5, 1.5, 1.5);
		
	}
	
	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(0, 0.1f, 0.20f);
		GlStateManager.scale(0.6f, 0.6f, 0.6f);		
	}
	
	public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
