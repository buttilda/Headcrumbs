package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class FeuerwurmHead extends ModelHead {
	
	public static final FeuerwurmHead INSTANCE = new FeuerwurmHead();
	
	protected FeuerwurmHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;

		float fy = -6.0f;
		float fz = 2.0f;

		head = new ModelRenderer(this, 0, 22);
		head.setRotationPoint(0.0F, -0.3F, 0F);
		head.addBox(-2.5F, -2.0F, -4.0F, 5, 4, 4, 0.0F);

		ModelRenderer leftFang = new ModelRenderer(this, 0, 0);
		leftFang.setRotationPoint(1.4F, 0.5F, -3.6F);
		leftFang.addBox(0.0F, -0.8F, -0.5F, 0, 2, 1, 0.0F);

		ModelRenderer leftHorn00a = new ModelRenderer(this, 42, 6);
		leftHorn00a.mirror = true;
		leftHorn00a.setRotationPoint(1.9F, -0.8F, -1.0F);
		leftHorn00a.addBox(-0.4F, -2.0F, -0.7F, 1, 2, 1, 0.0F);
		setRotateAngle(leftHorn00a, -1.2217304763960306F, 0.6108652381980153F, 0.0F);

		ModelRenderer leftHorn00b = new ModelRenderer(this, 42, 6);
		leftHorn00b.mirror = true;
		leftHorn00b.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftHorn00b.addBox(-0.4F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer leftHorn01 = new ModelRenderer(this, 47, 6);
		leftHorn01.mirror = true;
		leftHorn01.setRotationPoint(0.0F, -1.7F, 0.0F);
		leftHorn01.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(leftHorn01, -0.3490658503988659F, 0.0F, -0.3490658503988659F);

		ModelRenderer leftHorn02 = new ModelRenderer(this, 47, 6);
		leftHorn02.mirror = true;
		leftHorn02.setRotationPoint(0.0F, -1.8F, 0.0F);
		leftHorn02.addBox(-0.49F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(leftHorn02, -0.3490658503988659F, 0.0F, 0.0F);

		ModelRenderer leftHornTop00a = new ModelRenderer(this, 42, 0);
		leftHornTop00a.setRotationPoint(1.3F, -1.5F, -1.2F);
		leftHornTop00a.addBox(-0.3F, -2.0F, -0.7F, 1, 2, 1, 0.0F);
		setRotateAngle(leftHornTop00a, -0.8726646259971648F, 0.17453292519943295F, 0.0F);

		ModelRenderer leftHornTop00b = new ModelRenderer(this, 42, 0);
		leftHornTop00b.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftHornTop00b.addBox(-0.7F, -2.0F, -0.7F, 1, 2, 1, 0.0F);

		ModelRenderer leftHornTop01 = new ModelRenderer(this, 47, 0);
		leftHornTop01.setRotationPoint(0.0F, -2.0F, 0.0F);
		leftHornTop01.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(leftHornTop01, -0.2617993877991494F, 0.0F, 0.0F);

		ModelRenderer leftHornTop02 = new ModelRenderer(this, 52, 0);
		leftHornTop02.setRotationPoint(0.0F, -1.8F, 0.0F);
		leftHornTop02.addBox(-0.49F, -2.7F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(leftHornTop02, -0.2617993877991494F, 0.0F, 0.0F);

		ModelRenderer leftUpperJaw = new ModelRenderer(this, 17, 0);
		leftUpperJaw.setRotationPoint(0.9F, 0.1F, 0.0F);
		leftUpperJaw.addBox(-0.5F, -1.0F, -3.5F, 2, 2, 3, 0.0F);
		setRotateAngle(leftUpperJaw, 0.0F, 0.19198621771937624F, 0.0F);

		ModelRenderer lowerJaw = new ModelRenderer(this, 0, 8);
		lowerJaw.setRotationPoint(0.0F, 1.9F, -2.0F);
		lowerJaw.addBox(-1.5F, -0.5F, -5.0F, 3, 1, 5, 0.0F);

		ModelRenderer rightFang = new ModelRenderer(this, 0, 0);
		rightFang.setRotationPoint(-1.4F, 0.5F, -3.6F);
		rightFang.addBox(0.0F, -0.8F, -0.5F, 0, 2, 1, 0.0F);

		ModelRenderer rightHorn00a = new ModelRenderer(this, 42, 6);
		rightHorn00a.setRotationPoint(-1.9F, -0.8F, -1.0F);
		rightHorn00a.addBox(-0.6F, -2.0F, -0.7F, 1, 2, 1, 0.0F);
		setRotateAngle(rightHorn00a, -1.2217304763960306F, -0.6108652381980153F, 0.0F);

		ModelRenderer rightHorn00b = new ModelRenderer(this, 42, 6);
		rightHorn00b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightHorn00b.addBox(-0.6F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer rightHorn01 = new ModelRenderer(this, 47, 6);
		rightHorn01.setRotationPoint(0.0F, -1.7F, 0.0F);
		rightHorn01.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rightHorn01, -0.3490658503988659F, 0.0F, 0.3490658503988659F);

		ModelRenderer rightHorn02 = new ModelRenderer(this, 47, 6);
		rightHorn02.setRotationPoint(0.0F, -1.8F, 0.0F);
		rightHorn02.addBox(-0.51F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rightHorn02, -0.3490658503988659F, 0.0F, 0.0F);

		ModelRenderer rightHornTop00a = new ModelRenderer(this, 42, 0);
		rightHornTop00a.mirror = true;
		rightHornTop00a.setRotationPoint(-1.3F, -1.5F, -1.2F);
		rightHornTop00a.addBox(-0.3F, -2.0F, -0.7F, 1, 2, 1, 0.0F);
		setRotateAngle(rightHornTop00a, -0.8726646259971648F, -0.17453292519943295F, 0.0F);

		ModelRenderer rightHornTop00b = new ModelRenderer(this, 42, 0);
		rightHornTop00b.mirror = true;
		rightHornTop00b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightHornTop00b.addBox(-0.7F, -2.0F, -0.7F, 1, 2, 1, 0.0F);

		ModelRenderer rightHornTop01 = new ModelRenderer(this, 47, 0);
		rightHornTop01.mirror = true;
		rightHornTop01.setRotationPoint(0.0F, -2.0F, 0.0F);
		rightHornTop01.addBox(-0.5F, -1.8F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rightHornTop01, -0.2617993877991494F, 0.0F, 0.0F);

		ModelRenderer rightHornTop02 = new ModelRenderer(this, 52, 0);
		rightHornTop02.mirror = true;
		rightHornTop02.setRotationPoint(0.0F, -1.8F, 0.0F);
		rightHornTop02.addBox(-0.51F, -2.8F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rightHornTop02, -0.2617993877991494F, 0.0F, 0.0F);

		ModelRenderer rightUpperJaw = new ModelRenderer(this, 17, 0);
		rightUpperJaw.mirror = true;
		rightUpperJaw.setRotationPoint(-1.9F, 0.1F, 0.0F);
		rightUpperJaw.addBox(-0.5F, -1.0F, -3.87F, 2, 2, 3, 0.0F);
		setRotateAngle(rightUpperJaw, 0.0F, -0.19198621771937624F, 0.0F);

		ModelRenderer tongue = new ModelRenderer(this, 25, 0);
		tongue.setRotationPoint(0.0F, 1.4F, -1.9F);
		tongue.addBox(-1.5F, 0.0F, -5.0F, 3, 0, 7, 0.0F);

		ModelRenderer upperJaw = new ModelRenderer(this, 0, 0);
		upperJaw.setRotationPoint(0.0F, 0.3F, -2.8F);
		upperJaw.addBox(-1.5F, -1.1F, -4.4F, 3, 2, 5, 0.0F);
		setRotateAngle(upperJaw, 0.08726646259971647F, 0.0F, 0.0F);

		head.addChild(lowerJaw);
		head.addChild(leftHorn00a);
		head.addChild(upperJaw);
		head.addChild(rightHornTop00a);
		head.addChild(tongue);
		head.addChild(leftHornTop00a);
		head.addChild(rightHorn00a);
		upperJaw.addChild(leftFang);
		leftHorn00a.addChild(leftHorn01);
		leftHorn00a.addChild(leftHorn00b);
		leftHorn01.addChild(leftHorn02);
		leftHornTop00a.addChild(leftHornTop00b);
		leftHornTop00a.addChild(leftHornTop01);
		leftHornTop01.addChild(leftHornTop02);
		upperJaw.addChild(leftUpperJaw);
		upperJaw.addChild(rightFang);
		rightHorn00a.addChild(rightHorn01);
		rightHorn00a.addChild(rightHorn00b);
		rightHorn01.addChild(rightHorn02);
		rightHornTop00a.addChild(rightHornTop01);
		rightHornTop00a.addChild(rightHornTop00b);
		rightHornTop01.addChild(rightHornTop02);
		upperJaw.addChild(rightUpperJaw);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = -2.0f * 0.0625f;
		float fz = 4.0f * 0.0625f;
		setTranslation(fx, fy, fz);
	}
	
	@Override
	public void applyTranslation() {
		super.applyTranslation();
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
