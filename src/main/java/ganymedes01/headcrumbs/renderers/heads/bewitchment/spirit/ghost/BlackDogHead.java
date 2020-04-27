package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.ghost;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class BlackDogHead extends ModelHead {
	
	public static final BlackDogHead INSTANCE = new BlackDogHead();
	
	protected BlackDogHead() {
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

		ModelRenderer leftEar00 = new ModelRenderer(this, 16, 14);
		leftEar00.setRotationPoint(2, -2, -2);
		leftEar00.addBox(0, -1, -1, 2, 1, 2, 0);
		setRotateAngle(leftEar00, 0, 0, -0.55f);

		ModelRenderer leftEar01 = new ModelRenderer(this, 39, 14);
		leftEar01.setRotationPoint(1.9f, -0.9f, 0);
		leftEar01.addBox(-0.5f, -0.1f, -1, 1, 3, 2, 0);
		setRotateAngle(leftEar01, 0, 0, 0.23f);

		ModelRenderer lowerJaw = new ModelRenderer(this, 0, 43);
		lowerJaw.setRotationPoint(0, 2, -3.8f);
		lowerJaw.addBox(-1.5f, -0.4f, -3, 3, 1, 3, 0);

		ModelRenderer muzzle = new ModelRenderer(this, 0, 10);
		muzzle.setRotationPoint(0, 0.7f, -3.9f);
		muzzle.addBox(-1.5f, -1, -3, 3, 2, 3, 0);

		ModelRenderer rightEar00 = new ModelRenderer(this, 16, 14);
		rightEar00.mirror = true;
		rightEar00.setRotationPoint(-2, -2, -2);
		rightEar00.addBox(-2, -1, -1, 2, 1, 2, 0);
		setRotateAngle(rightEar00, 0, 0, 0.55f);

		ModelRenderer rightEar01 = new ModelRenderer(this, 39, 14);
		rightEar01.mirror = true;
		rightEar01.setRotationPoint(-1.9f, -0.9f, 0);
		rightEar01.addBox(-0.5f, -0.1f, -1, 1, 3, 2, 0);
		setRotateAngle(rightEar01, 0, 0, -0.23f);

		head.addChild(muzzle);
		head.addChild(leftEar00);
		head.addChild(rightEar00);
		head.addChild(lowerJaw);
		leftEar00.addChild(leftEar01);
		rightEar00.addChild(rightEar01);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = -3f * 0.0625f;
		float fz = 2.2f * 0.0625f;
		setTranslation(fx, fy, fz);
		GlStateManager.scale(1.8, 1.8, 1.8);
	}
	
	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(0, 0.05f, 0.05f);
		GlStateManager.scale(0.9f, 0.9f, 0.9f);
	}
	
	public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
