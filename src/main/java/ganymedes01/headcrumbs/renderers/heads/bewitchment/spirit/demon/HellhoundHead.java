package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class HellhoundHead extends ModelHead {
	
	public static final HellhoundHead INSTANCE = new HellhoundHead();
	
	protected HellhoundHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;

		float fy = -5.0f;
		float fz = 2.0f;

		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0, 0, 0);
		head.addBox(-3, -3, -4, 6, 6, 4, 0);

		ModelRenderer leftEar = new ModelRenderer(this, 16, 14);
		leftEar.setRotationPoint(2, -3, -2);
		leftEar.addBox(-1, -2, -0.5f, 2, 2, 1, 0);

		ModelRenderer leftHorn00 = new ModelRenderer(this, 46, 0);
		leftHorn00.setRotationPoint(1.3f, -2.1f, -1.4f);
		leftHorn00.addBox(-1, -3, -1, 2, 3, 2, 0);
		setRotateAngle(leftHorn00, -1, 0.45f, 0);

		ModelRenderer leftHorn01 = new ModelRenderer(this, 55, 0);
		leftHorn01.setRotationPoint(0, -2.5f, -0.1f);
		leftHorn01.addBox(-1, -2, -1, 2, 2, 2, 0);
		setRotateAngle(leftHorn01, -0.52f, 0.17f, 0);

		ModelRenderer leftHorn02a = new ModelRenderer(this, 52, 7);
		leftHorn02a.setRotationPoint(0, -1.5f, -0.1f);
		leftHorn02a.addBox(-0.2f, -2, -0.8f, 1, 2, 1, 0);
		setRotateAngle(leftHorn02a, -0.7f, 0.21f, 0);

		ModelRenderer leftHorn02c = new ModelRenderer(this, 52, 7);
		leftHorn02c.setRotationPoint(0, 0, 0);
		leftHorn02c.addBox(-0.2f, -2, -0.2f, 1, 2, 1, 0);

		ModelRenderer leftHorn03a = new ModelRenderer(this, 57, 6);
		leftHorn03a.setRotationPoint(0, -1.5f, -0.1f);
		leftHorn03a.addBox(-0.3f, -3, -0.7f, 1, 3, 1, 0);
		setRotateAngle(leftHorn03a, -0.7f, 0, 0);

		ModelRenderer leftHorn03c = new ModelRenderer(this, 57, 6);
		leftHorn03c.setRotationPoint(0, 0, 0);
		leftHorn03c.addBox(-0.3f, -3, -0.3f, 1, 3, 1, 0);

		ModelRenderer leftHorn04a = new ModelRenderer(this, 52, 12);
		leftHorn04a.setRotationPoint(0, -2.5f, -0.1f);
		leftHorn04a.addBox(-0.5f, -3, -0.7f, 1, 3, 1, 0);
		setRotateAngle(leftHorn04a, -0.7f, 0.35f, 0);

		ModelRenderer leftHorn04b = new ModelRenderer(this, 52, 12);
		leftHorn04b.setRotationPoint(0, 0, 0);
		leftHorn04b.addBox(-0.5f, -3, -0.3f, 1, 3, 1, 0);

		ModelRenderer leftHorn05 = new ModelRenderer(this, 58, 13);
		leftHorn05.setRotationPoint(0, -2.7f, 0);
		leftHorn05.addBox(-0.5f, -3, -0.5f, 1, 3, 1, 0);
		setRotateAngle(leftHorn05, -0.63f, 0, 0);

		ModelRenderer lowerJaw = new ModelRenderer(this, 0, 43);
		lowerJaw.setRotationPoint(0, 2, -3.8f);
		lowerJaw.addBox(-1.5f, -0.4f, -3, 3, 1, 3, 0);

		ModelRenderer muzzle = new ModelRenderer(this, 0, 10);
		muzzle.setRotationPoint(0, 0.7f, -3.9f);
		muzzle.addBox(-1.5f, -1, -3, 3, 2, 3, 0);

		ModelRenderer rightEar = new ModelRenderer(this, 16, 14);
		rightEar.mirror = true;
		rightEar.setRotationPoint(-2, -3, -2);
		rightEar.addBox(-1, -2, -0.5f, 2, 2, 1, 0);

		ModelRenderer rightHorn00 = new ModelRenderer(this, 46, 0);
		rightHorn00.mirror = true;
		rightHorn00.setRotationPoint(-1.3f, -2.1f, -1.4f);
		rightHorn00.addBox(-1, -3, -1, 2, 3, 2, 0);
		setRotateAngle(rightHorn00, -1, -0.45f, 0);

		ModelRenderer rightHorn01 = new ModelRenderer(this, 55, 0);
		rightHorn01.mirror = true;
		rightHorn01.setRotationPoint(0, -2.5f, -0.1f);
		rightHorn01.addBox(-1, -2, -1, 2, 2, 2, 0);
		setRotateAngle(rightHorn01, -0.52f, -0.17f, 0);

		ModelRenderer rightHorn02a = new ModelRenderer(this, 52, 7);
		rightHorn02a.mirror = true;
		rightHorn02a.setRotationPoint(0, -1.5f, -0.1f);
		rightHorn02a.addBox(-0.8f, -2, -0.8f, 1, 2, 1, 0);
		setRotateAngle(rightHorn02a, -0.7f, -0.21f, 0);

		ModelRenderer rightHorn02c = new ModelRenderer(this, 52, 7);
		rightHorn02c.mirror = true;
		rightHorn02c.setRotationPoint(0, 0, 0);
		rightHorn02c.addBox(-0.8f, -2, -0.2f, 1, 2, 1, 0);

		ModelRenderer rightHorn03a = new ModelRenderer(this, 57, 6);
		rightHorn03a.mirror = true;
		rightHorn03a.setRotationPoint(0, -1.5f, -0.1f);
		rightHorn03a.addBox(-0.7f, -3, -0.7f, 1, 3, 1, 0);
		setRotateAngle(rightHorn03a, -0.7f, 0, 0);

		ModelRenderer rightHorn03c = new ModelRenderer(this, 57, 6);
		rightHorn03c.mirror = true;
		rightHorn03c.setRotationPoint(0, 0, 0);
		rightHorn03c.addBox(-0.7f, -3, -0.3f, 1, 3, 1, 0);

		ModelRenderer rightHorn04a = new ModelRenderer(this, 52, 12);
		rightHorn04a.mirror = true;
		rightHorn04a.setRotationPoint(0, -2.5f, -0.1f);
		rightHorn04a.addBox(-0.5f, -3, -0.7f, 1, 3, 1, 0);
		setRotateAngle(rightHorn04a, -0.7f, -0.35f, 0);

		ModelRenderer rightHorn04b = new ModelRenderer(this, 52, 12);
		rightHorn04b.mirror = true;
		rightHorn04b.setRotationPoint(0, 0, 0);
		rightHorn04b.addBox(-0.5f, -3, -0.3f, 1, 3, 1, 0);

		ModelRenderer rightHorn05 = new ModelRenderer(this, 58, 13);
		rightHorn05.mirror = true;
		rightHorn05.setRotationPoint(0, -2.7f, 0);
		rightHorn05.addBox(-0.5f, -3, -0.5f, 1, 3, 1, 0);
		setRotateAngle(rightHorn05, -0.63f, 0, 0);

		head.addChild(lowerJaw);
		head.addChild(leftEar);
		head.addChild(rightEar);
		head.addChild(rightHorn00);
		head.addChild(leftHorn00);
		head.addChild(muzzle);
		leftHorn00.addChild(leftHorn01);
		leftHorn01.addChild(leftHorn02a);
		leftHorn02a.addChild(leftHorn03a);
		leftHorn02a.addChild(leftHorn02c);
		leftHorn03a.addChild(leftHorn03c);
		leftHorn03a.addChild(leftHorn04a);
		leftHorn04a.addChild(leftHorn04b);
		leftHorn04a.addChild(leftHorn05);
		rightHorn00.addChild(rightHorn01);
		rightHorn01.addChild(rightHorn02a);
		rightHorn02a.addChild(rightHorn03a);
		rightHorn02a.addChild(rightHorn02c);
		rightHorn03a.addChild(rightHorn03c);
		rightHorn03a.addChild(rightHorn04a);
		rightHorn04a.addChild(rightHorn05);
		rightHorn04a.addChild(rightHorn04b);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = -3.0f * 0.0625f;
		float fz = 4.0f * 0.0625f;
		setTranslation(fx, fy, fz);
	}
	
	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
	}
	
	public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
