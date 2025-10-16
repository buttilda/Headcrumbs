package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class ImpHead extends ModelHead {
	
	public static final ImpHead INSTANCE = new ImpHead();
	
	protected ImpHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;

		float fy = -2.0f;
		float fz = 0.5f;

		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0, 0, 0);
		head.addBox(-3, -6, -3.5f, 6, 6, 6, 0);

		ModelRenderer lEar03 = new ModelRenderer(this, 49, 0);
		lEar03.setRotationPoint(-0.1f, -0.2f, 0.1f);
		lEar03.addBox(-0.5f, -2.9f, -0.5f, 1, 3, 1, 0);
		setRotateAngle(lEar03, 0, 0, 0.17f);

		ModelRenderer leftEar00 = new ModelRenderer(this, 42, 0);
		leftEar00.setRotationPoint(2.1f, -4, 0.2f);
		leftEar00.addBox(0, -3, -0.9f, 1, 3, 2, 0);
		setRotateAngle(leftEar00, -0.44f, 0.4f, 0.44f);

		ModelRenderer leftEar01 = new ModelRenderer(this, 49, 0);
		leftEar01.setRotationPoint(0.4f, -2.6f, 0.1f);
		leftEar01.addBox(-0.5f, -1.9f, -0.5f, 1, 2, 1, 0);
		setRotateAngle(leftEar01, 0.14f, 0, 0);

		ModelRenderer leftHorn00a = new ModelRenderer(this, 35, 5);
		leftHorn00a.setRotationPoint(2.1f, -5.7f, -1.8f);
		leftHorn00a.addBox(-0.8f, -2.5f, -0.8f, 1, 3, 1, 0);
		setRotateAngle(leftHorn00a, 0, 0, 0.23f);

		ModelRenderer leftHorn00b = new ModelRenderer(this, 35, 5);
		leftHorn00b.setRotationPoint(0, 0, 0);
		leftHorn00b.addBox(-0.2f, -2.5f, -0.8f, 1, 3, 1, 0);

		ModelRenderer leftHorn00c = new ModelRenderer(this, 35, 5);
		leftHorn00c.setRotationPoint(0, 0, 0);
		leftHorn00c.addBox(-0.8f, -2.5f, -0.2f, 1, 3, 1, 0);

		ModelRenderer leftHorn00d = new ModelRenderer(this, 35, 5);
		leftHorn00d.setRotationPoint(0, 0, 0);
		leftHorn00d.addBox(-0.2f, -2.5f, -0.2f, 1, 3, 1, 0);

		ModelRenderer leftHorn01 = new ModelRenderer(this, 35, 10);
		leftHorn01.setRotationPoint(0, -1.7f, 0);
		leftHorn01.addBox(-0.5f, -3, -0.5f, 1, 3, 1, 0);
		setRotateAngle(leftHorn01, -0.14f, 0, -0.1f);

		ModelRenderer lowerJaw = new ModelRenderer(this, 41, 11);
		lowerJaw.setRotationPoint(0, -0.7f, -3.3f);
		lowerJaw.addBox(-1.5f, -0.5f, -1.6f, 3, 1, 2, 0);

		ModelRenderer rEar03 = new ModelRenderer(this, 49, 0);
		rEar03.mirror = true;
		rEar03.setRotationPoint(0.1f, -0.2f, 0.1f);
		rEar03.addBox(-0.5f, -2.9f, -0.5f, 1, 3, 1, 0);
		setRotateAngle(rEar03, 0, 0, -0.17f);

		ModelRenderer rightEar00 = new ModelRenderer(this, 42, 0);
		rightEar00.mirror = true;
		rightEar00.setRotationPoint(-2.1f, -4, 0.2f);
		rightEar00.addBox(-1, -3, -0.9f, 1, 3, 2, 0);
		setRotateAngle(rightEar00, -0.44f, -0.4f, -0.44f);

		ModelRenderer rightEar01 = new ModelRenderer(this, 49, 0);
		rightEar01.mirror = true;
		rightEar01.setRotationPoint(-0.4f, -2.6f, 0.1f);
		rightEar01.addBox(-0.5f, -1.9f, -0.5f, 1, 2, 1, 0);
		setRotateAngle(rightEar01, 0.14f, 0, 0);

		ModelRenderer rightHorn00a = new ModelRenderer(this, 35, 5);
		rightHorn00a.mirror = true;
		rightHorn00a.setRotationPoint(-2.1f, -5.7f, -1.8f);
		rightHorn00a.addBox(-0.8f, -2.5f, -0.8f, 1, 3, 1, 0);
		setRotateAngle(rightHorn00a, 0, 0, -0.23f);

		ModelRenderer rightHorn00b = new ModelRenderer(this, 35, 5);
		rightHorn00b.mirror = true;
		rightHorn00b.setRotationPoint(0, 0, 0);
		rightHorn00b.addBox(-0.2f, -2.5f, -0.8f, 1, 3, 1, 0);

		ModelRenderer rightHorn00c = new ModelRenderer(this, 35, 5);
		rightHorn00c.mirror = true;
		rightHorn00c.setRotationPoint(0, 0, 0);
		rightHorn00c.addBox(-0.8f, -2.5f, -0.2f, 1, 3, 1, 0);

		ModelRenderer rightHorn00d = new ModelRenderer(this, 35, 5);
		rightHorn00d.mirror = true;
		rightHorn00d.setRotationPoint(0, 0, 0);
		rightHorn00d.addBox(-0.2f, -2.5f, -0.2f, 1, 3, 1, 0);

		ModelRenderer rightHorn01 = new ModelRenderer(this, 35, 10);
		rightHorn01.mirror = true;
		rightHorn01.setRotationPoint(0, -1.7f, 0);
		rightHorn01.addBox(-0.5f, -3, -0.5f, 1, 3, 1, 0);
		setRotateAngle(rightHorn01, -0.14f, 0, 0.1f);

		ModelRenderer snout = new ModelRenderer(this, 22, 0);
		snout.setRotationPoint(0, -3.1f, -3.5f);
		snout.addBox(-1.5f, -1, -1.9f, 3, 2, 3, 0);
		setRotateAngle(snout, 0.42f, 0, 0);

		ModelRenderer upperJaw00 = new ModelRenderer(this, 41, 6);
		upperJaw00.setRotationPoint(0, -2, -3.3f);
		upperJaw00.addBox(-1.3f, -1, -1.7f, 3, 2, 2, 0);

		ModelRenderer upperJaw01 = new ModelRenderer(this, 53, 6);
		upperJaw01.setRotationPoint(0, -2, -3.3f);
		upperJaw01.addBox(-1.7f, -1, -1.7f, 1, 2, 2, 0);

		head.addChild(upperJaw01);
		head.addChild(lowerJaw);
		head.addChild(snout);
		head.addChild(leftHorn00a);
		head.addChild(rightHorn00a);
		head.addChild(upperJaw00);
		head.addChild(rightEar00);
		head.addChild(leftEar00);
		leftEar00.addChild(lEar03);
		leftEar00.addChild(leftEar01);
		leftHorn00a.addChild(leftHorn00c);
		leftHorn00a.addChild(leftHorn00d);
		leftHorn00a.addChild(leftHorn01);
		leftHorn00a.addChild(leftHorn00b);
		rightEar00.addChild(rEar03);
		rightEar00.addChild(rightEar01);
		rightHorn00a.addChild(rightHorn00b);
		rightHorn00a.addChild(rightHorn00d);
		rightHorn00a.addChild(rightHorn01);
		rightHorn00a.addChild(rightHorn00c);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = 0;
		float fz = 1.5f * 0.0625f;
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
