package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class CleaverHead extends ModelHead {
	
	public static final CleaverHead INSTANCE = new CleaverHead();
	
	protected CleaverHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;


		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		ModelRenderer lEar00 = new ModelRenderer(this, 47, 0);
		lEar00.setRotationPoint(3.4F, -5.5F, 0.0F);
		lEar00.addBox(0.0F, -0.5F, -1.5F, 5, 1, 3, 0.0F);
		setRotateAngle(lEar00, -0.6981317007977318F, 0.08726646259971647F, 0.3490658503988659F);

		ModelRenderer lEar01 = new ModelRenderer(this, 48, 5);
		lEar01.setRotationPoint(0.0F, -0.9F, 0.0F);
		lEar01.addBox(0.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		setRotateAngle(lEar01, 0.0F, 0.0F, 0.22759093446006054F);

		ModelRenderer lHorn01 = new ModelRenderer(this, 37, 38);
		lHorn01.setRotationPoint(2.8F, -6.8F, 2.0F);
		lHorn01.addBox(-1.0F, -2.5F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(lHorn01, 0.08726646259971647F, 0.0F, 0.7853981633974483F);

		ModelRenderer lHorn02a = new ModelRenderer(this, 39, 38);
		lHorn02a.setRotationPoint(0.1F, -1.9F, 0.2F);
		lHorn02a.addBox(-0.8F, -3.0F, -0.8F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn02a, 0.2792526803190927F, 0.0F, -0.2617993877991494F);

		ModelRenderer lHorn02b = new ModelRenderer(this, 39, 38);
		lHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02b.addBox(-0.2F, -3.0F, -0.8F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn02c = new ModelRenderer(this, 39, 38);
		lHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02c.addBox(-0.8F, -3.0F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn02d = new ModelRenderer(this, 39, 38);
		lHorn02d.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02d.addBox(-0.2F, -3.0F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn03 = new ModelRenderer(this, 38, 43);
		lHorn03.setRotationPoint(0.0F, -2.7F, 0.0F);
		lHorn03.addBox(-0.5F, -2.5F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn03, 0.13962634015954636F, 0.0F, -0.3490658503988659F);

		ModelRenderer lHorn04 = new ModelRenderer(this, 43, 43);
		lHorn04.setRotationPoint(0.0F, -2.3F, 0.0F);
		lHorn04.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn04, 0.13962634015954636F, 0.0F, -0.3490658503988659F);

		ModelRenderer lowerJaw = new ModelRenderer(this, 0, 55);
		lowerJaw.setRotationPoint(0.0F, -0.9F, -3.5F);
		lowerJaw.addBox(-2.5F, -0.5F, -5.0F, 5, 1, 6, 0.0F);
		setRotateAngle(lowerJaw, -0.03490658503988659F, 0.0F, 0.0F);

		ModelRenderer lowerTeethL = new ModelRenderer(this, 24, 58);
		lowerTeethL.setRotationPoint(2.2F, -0.4F, -3.5F);
		lowerTeethL.addBox(-0.8F, -2.0F, -1.4F, 1, 2, 4, 0.0F);

		ModelRenderer lowerTeethM = new ModelRenderer(this, 35, 61);
		lowerTeethM.setRotationPoint(0.0F, -0.4F, -3.5F);
		lowerTeethM.addBox(-1.5F, -1.1F, -1.4F, 3, 1, 0, 0.0F);

		ModelRenderer lowerTeethR = new ModelRenderer(this, 24, 58);
		lowerTeethR.mirror = true;
		lowerTeethR.setRotationPoint(-2.2F, -0.4F, -3.5F);
		lowerTeethR.addBox(-0.2F, -2.0F, -1.4F, 1, 2, 4, 0.0F);

		ModelRenderer rEar00 = new ModelRenderer(this, 47, 0);
		rEar00.mirror = true;
		rEar00.setRotationPoint(-3.4F, -5.5F, 0.0F);
		rEar00.addBox(-5.0F, -0.5F, -1.5F, 5, 1, 3, 0.0F);
		setRotateAngle(rEar00, -0.6981317007977318F, 0.08726646259971647F, -0.3490658503988659F);

		ModelRenderer rEar01 = new ModelRenderer(this, 48, 5);
		rEar01.mirror = true;
		rEar01.setRotationPoint(0.0F, -0.9F, 0.0F);
		rEar01.addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		setRotateAngle(rEar01, 0.0F, 0.0F, -0.22759093446006054F);

		ModelRenderer rHorn01 = new ModelRenderer(this, 37, 38);
		rHorn01.mirror = true;
		rHorn01.setRotationPoint(-2.8F, -6.8F, 2.0F);
		rHorn01.addBox(-1.0F, -2.5F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(rHorn01, 0.08726646259971647F, 0.0F, -0.7853981633974483F);

		ModelRenderer rHorn02a = new ModelRenderer(this, 39, 38);
		rHorn02a.mirror = true;
		rHorn02a.setRotationPoint(-0.1F, -1.9F, 0.2F);
		rHorn02a.addBox(-0.8F, -3.0F, -0.8F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn02a, 0.2792526803190927F, 0.0F, 0.2617993877991494F);

		ModelRenderer rHorn02b = new ModelRenderer(this, 39, 38);
		rHorn02b.mirror = true;
		rHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02b.addBox(-0.2F, -3.0F, -0.8F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn02c = new ModelRenderer(this, 39, 38);
		rHorn02c.mirror = true;
		rHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02c.addBox(-0.8F, -3.0F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn02d = new ModelRenderer(this, 39, 38);
		rHorn02d.mirror = true;
		rHorn02d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02d.addBox(-0.2F, -3.0F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn03 = new ModelRenderer(this, 38, 43);
		rHorn03.mirror = true;
		rHorn03.setRotationPoint(0.0F, -2.7F, 0.0F);
		rHorn03.addBox(-0.5F, -2.5F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn03, 0.13962634015954636F, 0.0F, 0.3490658503988659F);

		ModelRenderer rHorn04 = new ModelRenderer(this, 43, 43);
		rHorn04.mirror = true;
		rHorn04.setRotationPoint(0.0F, -2.3F, 0.0F);
		rHorn04.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn04, 0.13962634015954636F, 0.0F, 0.3490658503988659F);

		ModelRenderer snout = new ModelRenderer(this, 0, 35);
		snout.setRotationPoint(0.0F, -5.0F, -2.3F);
		snout.addBox(-2.5F, -2.05F, -6.4F, 5, 3, 6, 0.0F);
		setRotateAngle(snout, 0.3490658503988659F, 0.0F, 0.0F);

		ModelRenderer upperJaw = new ModelRenderer(this, 0, 46);
		upperJaw.mirror = true;
		upperJaw.setRotationPoint(0.0F, -3.8F, -4.1F);
		upperJaw.addBox(-3.0F, -0.65F, -4.7F, 6, 3, 5, 0.0F);

		ModelRenderer upperTeethL = new ModelRenderer(this, 52, 58);
		upperTeethL.setRotationPoint(2.0F, 2.2F, -2.8F);
		upperTeethL.addBox(-1.2F, 0.0F, -1.7F, 2, 2, 4, 0.0F);

		ModelRenderer upperTeethR = new ModelRenderer(this, 52, 58);
		upperTeethR.mirror = true;
		upperTeethR.setRotationPoint(-2.0F, 2.2F, -2.8F);
		upperTeethR.addBox(-0.8F, 0.0F, -1.7F, 2, 2, 4, 0.0F);

		head.addChild(rEar00);
		head.addChild(upperJaw);
		head.addChild(rHorn01);
		head.addChild(snout);
		head.addChild(lHorn01);
		head.addChild(lEar00);
		head.addChild(lowerJaw);
		lEar00.addChild(lEar01);
		lHorn01.addChild(lHorn02a);
		lHorn02a.addChild(lHorn03);
		lHorn02a.addChild(lHorn02c);
		lHorn02a.addChild(lHorn02d);
		lHorn02a.addChild(lHorn02b);
		lHorn03.addChild(lHorn04);
		lowerJaw.addChild(lowerTeethR);
		lowerJaw.addChild(lowerTeethM);
		lowerJaw.addChild(lowerTeethL);
		rEar00.addChild(rEar01);
		rHorn01.addChild(rHorn02a);
		rHorn02a.addChild(rHorn02d);
		rHorn02a.addChild(rHorn02b);
		rHorn02a.addChild(rHorn02c);
		rHorn02a.addChild(rHorn03);
		rHorn03.addChild(rHorn04);
		upperJaw.addChild(upperTeethL);
		upperJaw.addChild(upperTeethR);
	}
	
	@Override
	public void preRender(GameProfile profile) {
	}
	
	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(0, 0.05f, 0.1f);
		GlStateManager.scale(0.8f, 0.8f, 0.8f);
	}
	
	public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
