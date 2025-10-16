package ganymedes01.headcrumbs.renderers.heads.bewitchment.living;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class SnakeHead extends ModelHead {
	
	public static final SnakeHead INSTANCE = new SnakeHead();
	
	protected SnakeHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;

		float fy = -5.6f;
		float fz = 1.5f;

		head = new ModelRenderer(this, 0, 22);
		head.setRotationPoint(0, 0.8f, 0f);
		head.addBox(-2.5f, -2.4f, -3, 5, 3, 3, 0);

		ModelRenderer eyes = new ModelRenderer(this, 40, 0);
		eyes.setRotationPoint(0, -2, -3.9f);
		eyes.addBox(-2, -0.5f, -0.5f, 4, 1, 1, 0);

		ModelRenderer leftUpperJaw = new ModelRenderer(this, 17, 0);
		leftUpperJaw.setRotationPoint(0.9f, -0.9f, -3);
		leftUpperJaw.addBox(-0.5f, -1, -3.7f, 2, 2, 5, 0);
		setRotateAngle(leftUpperJaw, 0, 0.19f, 0);

		ModelRenderer leftfang = new ModelRenderer(this, 0, 0);
		leftfang.setRotationPoint(1.4f, -0.5f, -3.6f);
		leftfang.addBox(0, 0, -0.5f, 0, 2, 1, 0);

		ModelRenderer lowerJaw = new ModelRenderer(this, 0, 8);
		lowerJaw.setRotationPoint(0, 0.1f, -2);
		lowerJaw.addBox(-1.5f, -0.5f, -5, 3, 1, 5, 0);

		ModelRenderer rightUpperJaw = new ModelRenderer(this, 17, 0);
		rightUpperJaw.mirror = true;
		rightUpperJaw.setRotationPoint(-1.9f, -0.9f, -3);
		rightUpperJaw.addBox(-0.5f, -1, -4.07f, 2, 2, 5, 0);
		setRotateAngle(rightUpperJaw, 0, -0.19f, 0);

		ModelRenderer rightfang = new ModelRenderer(this, 0, 0);
		rightfang.setRotationPoint(-1.4f, -0.5f, -3.6f);
		rightfang.addBox(0, 0, -0.5f, 0, 2, 1, 0);

		ModelRenderer tongue = new ModelRenderer(this, 25, 0);
		tongue.setRotationPoint(0, 0.4f, -2);
		tongue.addBox(-1.5f, 0, -5, 3, 0, 7, 0);

		ModelRenderer upperJaw = new ModelRenderer(this, 0, 0);
		upperJaw.setRotationPoint(0, -1.3f, -2.8f);
		upperJaw.addBox(-1.5f, -1.1f, -4.4f, 3, 2, 5, 0);
		setRotateAngle(upperJaw, 0.09f, 0, 0);

		head.addChild(eyes);
		head.addChild(upperJaw);
		head.addChild(leftUpperJaw);
		head.addChild(rightUpperJaw);
		head.addChild(tongue);
		head.addChild(lowerJaw);
		upperJaw.addChild(leftfang);
		upperJaw.addChild(rightfang);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = -1.4f * 0.0625f;
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
