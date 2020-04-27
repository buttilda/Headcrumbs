package ganymedes01.headcrumbs.renderers.heads.bewitchment.living;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class WerewolfHead extends ModelHead {
	
	public static final WerewolfHead INSTANCE = new WerewolfHead();
	
	protected WerewolfHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		textureWidth = 128;
		textureHeight = 64;

		float fy = -3.0f;
		float fz = -0.1f;

		head = new ModelRenderer(this, 44, 0);
		head.setRotationPoint(0, -0.5F, 0);
		head.addBox(-4, -5, -3.4F, 8, 6, 7, 0);
		setRotateAngle(head, 2.1816615649929116F, 0, 0);

		ModelRenderer jawLower = new ModelRenderer(this, 39, 37);
		jawLower.setRotationPoint(0, -4.1F, -3);
		jawLower.addBox(-2, -4.9F, -0.5F, 4, 5, 1, 0);

		ModelRenderer jawUpper01 = new ModelRenderer(this, 20, 36);
		jawUpper01.setRotationPoint(1.2F, -5.1F, -1.5F);
		jawUpper01.addBox(-0.8F, -4, -1, 2, 5, 2, 0);
		setRotateAngle(jawUpper01, 0, 0, -0.13962634015954636F);

		ModelRenderer jawUpper02 = new ModelRenderer(this, 20, 36);
		jawUpper02.mirror = true;
		jawUpper02.setRotationPoint(0, 0.35F, 0);
		jawUpper02.addBox(-3.6F, -4, -1, 2, 5, 2, 0);
		setRotateAngle(jawUpper02, 0, 0, 0.2792526803190927F);

		ModelRenderer lEar01 = new ModelRenderer(this, 70, 0);
		lEar01.setRotationPoint(2.8F, -2.1F, 2.8F);
		lEar01.addBox(0, 0, -1, 1, 3, 2, 0);
		setRotateAngle(lEar01, 0.6981317007977318F, 0.12217304763960307F, -0.6981317007977318F);

		ModelRenderer lEar02 = new ModelRenderer(this, 78, 0);
		lEar02.setRotationPoint(-0.3F, 0, -0.5F);
		lEar02.addBox(-0.8F, 0, -0.5F, 1, 5, 1, 0);
		setRotateAngle(lEar02, 0.22689280275926282F, 0, -0.2617993877991494F);

		ModelRenderer lowerTeeth01 = new ModelRenderer(this, 63, 41);
		lowerTeeth01.setRotationPoint(0, -3.7F, 0.1F);
		lowerTeeth01.addBox(0.6F, -0.7F, 0.4F, 1, 3, 1, 0);

		ModelRenderer lowerTeeth02 = new ModelRenderer(this, 63, 41);
		lowerTeeth02.mirror = true;
		lowerTeeth02.setRotationPoint(0, 0, 0);
		lowerTeeth02.addBox(-1.6F, -0.7F, 0.3F, 1, 3, 1, 0);

		ModelRenderer rEar01 = new ModelRenderer(this, 70, 0);
		rEar01.mirror = true;
		rEar01.setRotationPoint(-2.8F, -2.1F, 2.8F);
		rEar01.addBox(-1, 0, -1, 1, 3, 2, 0);
		setRotateAngle(rEar01, 0.6981317007977318F, -0.12217304763960307F, 0.6981317007977318F);

		ModelRenderer rEar02 = new ModelRenderer(this, 78, 0);
		rEar02.mirror = true;
		rEar02.setRotationPoint(0.3F, 0, -0.5F);
		rEar02.addBox(-0.2F, 0, -0.5F, 1, 5, 1, 0);
		setRotateAngle(rEar02, 0.22689280275926282F, 0, 0.2617993877991494F);

		ModelRenderer snout = new ModelRenderer(this, 29, 35);
		snout.setRotationPoint(0, -4.2F, -0.1F);
		snout.addBox(-1.5F, -5.05F, -1, 3, 5, 2, 0);
		setRotateAngle(snout, 0.18203784098300857F, 0, 0);

		ModelRenderer upperTeeth01 = new ModelRenderer(this, 56, 37);
		upperTeeth01.setRotationPoint(0.4F, -2.8F, -1);
		upperTeeth01.addBox(-0.5F, -1, -0.8F, 1, 4, 2, 0);

		ModelRenderer upperTeeth02 = new ModelRenderer(this, 50, 37);
		upperTeeth02.setRotationPoint(-2.8F, -2.8F, -1);
		upperTeeth02.addBox(-0.5F, -1, -0.8F, 1, 4, 2, 0);

		ModelRenderer upperTeeth03 = new ModelRenderer(this, 63, 38);
		upperTeeth03.setRotationPoint(0, -3.2F, -1);
		upperTeeth03.addBox(-2.27F, -0.7F, -0.4F, 3, 0, 1, 0);
		setRotateAngle(upperTeeth03, 0, 0, 0.136659280431156F);

		head.addChild(jawUpper01);
		head.addChild(lEar01);
		head.addChild(rEar01);
		head.addChild(jawLower);
		head.addChild(snout);
		jawLower.addChild(lowerTeeth01);
		jawUpper01.addChild(upperTeeth03);
		jawUpper01.addChild(jawUpper02);
		jawUpper01.addChild(upperTeeth01);
		jawUpper02.addChild(upperTeeth02);
		lEar01.addChild(lEar02);
		lowerTeeth01.addChild(lowerTeeth02);
		rEar01.addChild(rEar02);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = -2.9f * 0.0625f;
		float fz = 2.5f * 0.0625f;
		setTranslation(fx, fy, fz);
		GlStateManager.scale(1.2f, 1.2f, 1.2f);
		
	}
	
	@Override
	public void render(float rotationX, float rotationY) {
		head.rotateAngleY = rotationX / (180F / (float) Math.PI);
		head.rotateAngleX = (float) Math.toRadians(90) + rotationY / (180F / (float) Math.PI);
		applyTranslation();
		head.render(0.0625F);
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
