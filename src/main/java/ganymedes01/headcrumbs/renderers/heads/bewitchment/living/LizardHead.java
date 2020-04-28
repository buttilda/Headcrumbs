package ganymedes01.headcrumbs.renderers.heads.bewitchment.living;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class LizardHead extends ModelHead {
	
	public static final LizardHead INSTANCE = new LizardHead();
	
	protected LizardHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;

		float fy = -6.0f;

		head = new ModelRenderer(this, 25, 13);
		head.setRotationPoint(0, 0, 0);
		head.addBox(-2.5f, -2, -2.5f, 5, 3, 5, 0);
		setRotateAngle(head, 0.14f, 0, 0);

		ModelRenderer leftEye = new ModelRenderer(this, 37, 38);
		leftEye.setRotationPoint(1.5f, -0.2f, 0);
		leftEye.addBox(-0.5f, -2, -1, 2, 2, 2, 0);
		setRotateAngle(leftEye, 0, 0.12f, -0.19f);

		ModelRenderer lowerJaw = new ModelRenderer(this, 34, 29);
		lowerJaw.setRotationPoint(0, 1.3f, 1.1f);
		lowerJaw.addBox(-2, -0.5f, -5.6f, 4, 1, 6, 0);
		setRotateAngle(lowerJaw, -0.16f, 0, 0);

		ModelRenderer rightEye = new ModelRenderer(this, 37, 38);
		rightEye.mirror = true;
		rightEye.setRotationPoint(-1.5f, -0.2f, 0);
		rightEye.addBox(-1.5f, -2, -1, 2, 2, 2, 0);
		setRotateAngle(rightEye, 0, -0.12f, 0.19f);

		ModelRenderer snout = new ModelRenderer(this, 31, 22);
		snout.setRotationPoint(0, -0.8f, -1.9f);
		snout.addBox(-2.3f, -1, -2.8f, 4, 2, 3, 0);
		setRotateAngle(snout, 0.09f, 0, 0);

		ModelRenderer snoutb = new ModelRenderer(this, 31, 28);
		snoutb.setRotationPoint(0, -0.8f, -1.9f);
		snoutb.addBox(1.2f, -1, -2.8f, 1, 2, 3, 0);
		setRotateAngle(snoutb, 0.09f, 0, 0);

		head.addChild(lowerJaw);
		head.addChild(rightEye);
		head.addChild(snoutb);
		head.addChild(snout);
		head.addChild(leftEye);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = -1.7f * 0.0625f;
		float fz = 1.5f * 0.0625f;
		setTranslation(fx, fy, fz);
	}
	
	@Override
	public void render(float rotationX, float rotationY) {
		rotationY += 10f;
		super.render(rotationX, rotationY);
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
