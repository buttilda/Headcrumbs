package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class BaphometHead extends ModelHead {
	
	public static final BaphometHead INSTANCE = new BaphometHead();
	
	protected BaphometHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 128;
		this.textureHeight = 64;

		float fy = -1.0f;

		head = new ModelRenderer(this, 1, 2);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-3.5F, -7.0F, -3.5F, 7, 7, 7, 0.0F);

		ModelRenderer beard = new ModelRenderer(this, 18, 59);
		beard.setRotationPoint(0.0F, 0.3F, -2.4F);
		beard.addBox(-1.5F, 0.0F, -1.0F, 3, 3, 2, 0.0F);
		setRotateAngle(beard, -0.03490658503988659F, 0.0F, 0.0F);

		ModelRenderer jawLower = new ModelRenderer(this, 48, 5);
		jawLower.setRotationPoint(0.0F, -1.0F, -3.0F);
		jawLower.addBox(-2.0F, -0.5F, -4.0F, 4, 1, 4, 0.0F);
		setRotateAngle(jawLower, -0.03490658503988659F, 0.0F, 0.0F);

		ModelRenderer jawUpper00 = new ModelRenderer(this, 43, 11);
		jawUpper00.setRotationPoint(0.0F, -2.5F, -2.2F);
		jawUpper00.addBox(-1.6F, -1.0F, -5.0F, 4, 2, 5, 0.0F);
		setRotateAngle(jawUpper00, 0.06981317007977318F, 0.0F, 0.0F);

		ModelRenderer jawUpper01 = new ModelRenderer(this, 30, 11);
		jawUpper01.setRotationPoint(0.0F, 0.0F, 0.0F);
		jawUpper01.addBox(-2.3F, -1.0F, -5.0F, 1, 2, 5, 0.0F);

		ModelRenderer lHorn01 = new ModelRenderer(this, 23, 0);
		lHorn01.setRotationPoint(2.9F, -7.2F, -0.2F);
		lHorn01.addBox(-1.0F, -2.7F, -1.0F, 2, 4, 2, 0.0F);
		setRotateAngle(lHorn01, -0.17453292519943295F, 0.13962634015954636F, 0.40142572795869574F);

		ModelRenderer lHorn02a = new ModelRenderer(this, 0, 0);
		lHorn02a.setRotationPoint(0.0F, -2.2F, 0.0F);
		lHorn02a.addBox(-0.8F, -3.0F, -0.8F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn02a, -0.17453292519943295F, 0.0F, 0.2617993877991494F);

		ModelRenderer lHorn02b = new ModelRenderer(this, 0, 0);
		lHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02b.addBox(-0.2F, -3.0F, -0.8F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn02c = new ModelRenderer(this, 0, 0);
		lHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02c.addBox(-0.8F, -3.0F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn03a = new ModelRenderer(this, 0, 4);
		lHorn03a.setRotationPoint(0.0F, -2.7F, 0.0F);
		lHorn03a.addBox(-0.7F, -3.0F, -0.7F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn03a, -0.10471975511965977F, 0.0F, 0.17453292519943295F);

		ModelRenderer lHorn03b = new ModelRenderer(this, 0, 4);
		lHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03b.addBox(-0.3F, -3.0F, -0.7F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn03c = new ModelRenderer(this, 0, 4);
		lHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03c.addBox(-0.7F, -3.0F, -0.3F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn03d = new ModelRenderer(this, 0, 0);
		lHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03d.addBox(-0.2F, -3.0F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn03d_1 = new ModelRenderer(this, 0, 4);
		lHorn03d_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03d_1.addBox(-0.3F, -3.0F, -0.3F, 1, 3, 1, 0.0F);

		ModelRenderer lHorn04 = new ModelRenderer(this, 4, 0);
		lHorn04.setRotationPoint(0.0F, -2.8F, 0.0F);
		lHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn04, 0.05235987755982988F, 0.0F, 0.13962634015954636F);

		ModelRenderer lHorn05 = new ModelRenderer(this, 4, 4);
		lHorn05.setRotationPoint(0.0F, -2.7F, 0.0F);
		lHorn05.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn05, 0.05235987755982988F, 0.0F, -0.13962634015954636F);

		ModelRenderer leftEar = new ModelRenderer(this, 48, 0);
		leftEar.setRotationPoint(2.6F, -5.4F, 0.1F);
		leftEar.addBox(0.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		setRotateAngle(leftEar, -0.3490658503988659F, 0.0F, 0.3141592653589793F);

		ModelRenderer rHorn01 = new ModelRenderer(this, 23, 0);
		rHorn01.mirror = true;
		rHorn01.setRotationPoint(-2.9F, -7.2F, -0.2F);
		rHorn01.addBox(-1.0F, -2.7F, -1.0F, 2, 4, 2, 0.0F);
		setRotateAngle(rHorn01, -0.17453292519943295F, -0.13962634015954636F, -0.40142572795869574F);

		ModelRenderer rHorn02a = new ModelRenderer(this, 0, 0);
		rHorn02a.mirror = true;
		rHorn02a.setRotationPoint(0.0F, -2.2F, 0.0F);
		rHorn02a.addBox(-0.8F, -3.0F, -0.8F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn02a, -0.17453292519943295F, 0.0F, -0.2617993877991494F);

		ModelRenderer rHorn02b = new ModelRenderer(this, 0, 0);
		rHorn02b.mirror = true;
		rHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02b.addBox(-0.2F, -3.0F, -0.8F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn02c = new ModelRenderer(this, 0, 0);
		rHorn02c.mirror = true;
		rHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02c.addBox(-0.8F, -3.0F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn03a = new ModelRenderer(this, 0, 4);
		rHorn03a.mirror = true;
		rHorn03a.setRotationPoint(0.0F, -2.7F, 0.0F);
		rHorn03a.addBox(-0.7F, -3.0F, -0.7F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn03a, -0.10471975511965977F, 0.0F, -0.17453292519943295F);

		ModelRenderer rHorn03b = new ModelRenderer(this, 0, 4);
		rHorn03b.mirror = true;
		rHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03b.addBox(-0.3F, -3.0F, -0.7F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn03c = new ModelRenderer(this, 0, 4);
		rHorn03c.mirror = true;
		rHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03c.addBox(-0.7F, -3.0F, -0.3F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn03d = new ModelRenderer(this, 0, 0);
		rHorn03d.mirror = true;
		rHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03d.addBox(-0.2F, -3.0F, -0.2F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn03d_1 = new ModelRenderer(this, 0, 4);
		rHorn03d_1.mirror = true;
		rHorn03d_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03d_1.addBox(-0.3F, -3.0F, -0.3F, 1, 3, 1, 0.0F);

		ModelRenderer rHorn04 = new ModelRenderer(this, 4, 0);
		rHorn04.mirror = true;
		rHorn04.setRotationPoint(0.0F, -2.8F, 0.0F);
		rHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn04, 0.05235987755982988F, 0.0F, -0.13962634015954636F);

		ModelRenderer rHorn05 = new ModelRenderer(this, 4, 4);
		rHorn05.mirror = true;
		rHorn05.setRotationPoint(0.0F, -2.7F, 0.0F);
		rHorn05.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn05, 0.05235987755982988F, 0.0F, 0.13962634015954636F);

		ModelRenderer rightEar = new ModelRenderer(this, 48, 0);
		rightEar.mirror = true;
		rightEar.setRotationPoint(-2.6F, -5.4F, 0.1F);
		rightEar.addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		setRotateAngle(rightEar, -0.3490658503988659F, 0.0F, -0.3141592653589793F);

		ModelRenderer snout = new ModelRenderer(this, 29, 2);
		snout.setRotationPoint(0.0F, -4.6F, -2.5F);
		snout.addBox(-2.0F, -1.9F, -5.1F, 4, 3, 5, 0.0F);
		setRotateAngle(snout, 0.5235987755982988F, 0.0F, 0.0F);

		jawLower.addChild(beard);
		head.addChild(rightEar);
		head.addChild(snout);
		head.addChild(jawUpper00);
		head.addChild(rHorn01);
		head.addChild(leftEar);
		head.addChild(lHorn01);
		head.addChild(jawLower);
		jawUpper00.addChild(jawUpper01);
		lHorn01.addChild(lHorn02a);
		lHorn02a.addChild(lHorn03a);
		lHorn02a.addChild(lHorn03d);
		lHorn02a.addChild(lHorn02b);
		lHorn02a.addChild(lHorn02c);
		lHorn03a.addChild(lHorn03d_1);
		lHorn03a.addChild(lHorn03c);
		lHorn03a.addChild(lHorn03b);
		lHorn03a.addChild(lHorn04);
		lHorn04.addChild(lHorn05);
		rHorn01.addChild(rHorn02a);
		rHorn02a.addChild(rHorn02c);
		rHorn02a.addChild(rHorn03a);
		rHorn02a.addChild(rHorn02b);
		rHorn02a.addChild(rHorn03d);
		rHorn03a.addChild(rHorn04);
		rHorn03a.addChild(rHorn03b);
		rHorn03a.addChild(rHorn03c);
		rHorn03a.addChild(rHorn03d_1);
		rHorn04.addChild(rHorn05);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		setTranslation(0, 0, -0.25f * 0.0625f);
		GlStateManager.scale(1.25, 1.25, 1.25);
	}
	
	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(0, 0.1f, 0.15f);
		GlStateManager.scale(0.65f, 0.65f, 0.65f);
	}
	
	public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
