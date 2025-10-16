package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class CambionSlimHead extends ModelHead {
	
	public static final CambionSlimHead INSTANCE = new CambionSlimHead();
	
	protected CambionSlimHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;


		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		ModelRenderer hair00 = new ModelRenderer(this, 38, 46);
		hair00.setRotationPoint(0.0F, -5.5F, 3.2F);
		hair00.addBox(-3.99F, 0.0F, -1.0F, 8, 11, 2, 0.0F);
		setRotateAngle(hair00, 0.13962634015954636F, 0.0F, 0.0F);

		ModelRenderer hair01 = new ModelRenderer(this, 40, 36);
		hair01.mirror = true;
		hair01.setRotationPoint(0.0F, -7.2F, 3.2F);
		hair01.addBox(-4.01F, 0.0F, -0.1F, 8, 8, 1, 0.0F);
		setRotateAngle(hair01, 0.3490658503988659F, 0.0F, 0.0F);

		ModelRenderer lHorn01 = new ModelRenderer(this, 0, 0);
		lHorn01.setRotationPoint(2.9F, -7.3F, 0.6F);
		lHorn01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(lHorn01, -0.6108652381980153F, 0.0F, 1.3089969389957472F);

		ModelRenderer lHorn02a = new ModelRenderer(this, 0, 4);
		lHorn02a.setRotationPoint(-0.1F, -1.5F, -0.1F);
		lHorn02a.addBox(-0.8F, -2.0F, -0.8F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn02a, -0.2617993877991494F, 0.0F, 0.40142572795869574F);

		ModelRenderer lHorn02b = new ModelRenderer(this, 0, 4);
		lHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02b.addBox(-0.2F, -2.0F, -0.8F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn02c = new ModelRenderer(this, 0, 4);
		lHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02c.addBox(-0.8F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03a = new ModelRenderer(this, 0, 4);
		lHorn03a.setRotationPoint(0.0F, -1.6F, 0.0F);
		lHorn03a.addBox(-0.7F, -2.0F, -0.7F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn03a, -0.17453292519943295F, 0.0F, 0.4363323129985824F);

		ModelRenderer lHorn03b = new ModelRenderer(this, 0, 4);
		lHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03b.addBox(-0.3F, -2.0F, -0.7F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03c = new ModelRenderer(this, 0, 4);
		lHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03c.addBox(-0.7F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03d = new ModelRenderer(this, 0, 4);
		lHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03d.addBox(-0.2F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn03d_1 = new ModelRenderer(this, 0, 4);
		lHorn03d_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn03d_1.addBox(-0.3F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer lHorn04 = new ModelRenderer(this, 49, 0);
		lHorn04.setRotationPoint(0.0F, -1.7F, 0.0F);
		lHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(lHorn04, 0.05235987755982988F, 0.0F, 0.13962634015954636F);

		ModelRenderer lHorn05 = new ModelRenderer(this, 43, 0);
		lHorn05.setRotationPoint(0.0F, -2.7F, 0.0F);
		lHorn05.addBox(-0.5F, -2.1F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(lHorn05, 0.05235987755982988F, 0.0F, -0.3141592653589793F);

		ModelRenderer lUpperHorn01 = new ModelRenderer(this, 24, 0);
		lUpperHorn01.setRotationPoint(2.0F, -8.7F, -0.5F);
		lUpperHorn01.addBox(-1.0F, -1.0F, -1.8F, 2, 2, 3, 0.0F);
		setRotateAngle(lUpperHorn01, 0.8726646259971648F, 0.17453292519943295F, 0.0F);

		ModelRenderer lUpperHorn02a = new ModelRenderer(this, 33, 7);
		lUpperHorn02a.setRotationPoint(0.0F, 0.0F, 0.9F);
		lUpperHorn02a.addBox(-0.2F, -0.8F, -0.5F, 1, 1, 3, 0.0F);
		setRotateAngle(lUpperHorn02a, -0.3141592653589793F, 0.2617993877991494F, 0.0F);

		ModelRenderer lUpperHorn02b = new ModelRenderer(this, 33, 7);
		lUpperHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lUpperHorn02b.addBox(-0.8F, -0.8F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer lUpperHorn02c = new ModelRenderer(this, 33, 7);
		lUpperHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lUpperHorn02c.addBox(-0.2F, -0.2F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer lUpperHorn02d = new ModelRenderer(this, 33, 7);
		lUpperHorn02d.setRotationPoint(0.0F, 0.0F, 0.0F);
		lUpperHorn02d.addBox(-0.8F, -0.2F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer lUpperHorn03 = new ModelRenderer(this, 42, 7);
		lUpperHorn03.setRotationPoint(0.0F, 0.0F, 2.4F);
		lUpperHorn03.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 3, 0.0F);
		setRotateAngle(lUpperHorn03, -0.17453292519943295F, 0.17453292519943295F, 0.0F);

		ModelRenderer lowerJaw = new ModelRenderer(this, 23, 46);
		lowerJaw.setRotationPoint(0.0F, -0.4F, -3.8F);
		lowerJaw.addBox(-1.5F, -0.5F, -1.6F, 3, 1, 2, 0.0F);

		ModelRenderer rHorn01 = new ModelRenderer(this, 0, 0);
		rHorn01.mirror = true;
		rHorn01.setRotationPoint(-2.9F, -7.3F, 0.6F);
		rHorn01.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(rHorn01, -0.6108652381980153F, 0.0F, -1.3089969389957472F);

		ModelRenderer rHorn02a = new ModelRenderer(this, 0, 4);
		rHorn02a.mirror = true;
		rHorn02a.setRotationPoint(0.1F, -1.5F, -0.1F);
		rHorn02a.addBox(-0.8F, -2.0F, -0.8F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn02a, -0.2617993877991494F, 0.0F, -0.40142572795869574F);

		ModelRenderer rHorn02b = new ModelRenderer(this, 0, 4);
		rHorn02b.mirror = true;
		rHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02b.addBox(-0.2F, -2.0F, -0.8F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn02c = new ModelRenderer(this, 0, 4);
		rHorn02c.mirror = true;
		rHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02c.addBox(-0.8F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03a = new ModelRenderer(this, 0, 4);
		rHorn03a.mirror = true;
		rHorn03a.setRotationPoint(0.0F, -1.6F, 0.0F);
		rHorn03a.addBox(-0.7F, -2.0F, -0.7F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn03a, -0.17453292519943295F, 0.0F, -0.4363323129985824F);

		ModelRenderer rHorn03b = new ModelRenderer(this, 0, 4);
		rHorn03b.mirror = true;
		rHorn03b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03b.addBox(-0.3F, -2.0F, -0.7F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03c = new ModelRenderer(this, 0, 4);
		rHorn03c.mirror = true;
		rHorn03c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03c.addBox(-0.7F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03d = new ModelRenderer(this, 0, 4);
		rHorn03d.mirror = true;
		rHorn03d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03d.addBox(-0.2F, -2.0F, -0.2F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn03d_1 = new ModelRenderer(this, 0, 4);
		rHorn03d_1.mirror = true;
		rHorn03d_1.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn03d_1.addBox(-0.3F, -2.0F, -0.3F, 1, 2, 1, 0.0F);

		ModelRenderer rHorn04 = new ModelRenderer(this, 49, 0);
		rHorn04.mirror = true;
		rHorn04.setRotationPoint(0.0F, -1.7F, 0.0F);
		rHorn04.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rHorn04, 0.05235987755982988F, 0.0F, -0.13962634015954636F);

		ModelRenderer rHorn05 = new ModelRenderer(this, 43, 0);
		rHorn05.mirror = true;
		rHorn05.setRotationPoint(0.0F, -2.7F, 0.0F);
		rHorn05.addBox(-0.5F, -2.1F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rHorn05, 0.05235987755982988F, 0.0F, 0.3141592653589793F);

		ModelRenderer rUpperHorn01 = new ModelRenderer(this, 24, 0);
		rUpperHorn01.mirror = true;
		rUpperHorn01.setRotationPoint(-2.0F, -8.7F, -0.5F);
		rUpperHorn01.addBox(-1.0F, -1.0F, -1.8F, 2, 2, 3, 0.0F);
		setRotateAngle(rUpperHorn01, 0.8726646259971648F, -0.17453292519943295F, 0.0F);

		ModelRenderer rUpperHorn02a = new ModelRenderer(this, 33, 7);
		rUpperHorn02a.mirror = true;
		rUpperHorn02a.setRotationPoint(0.0F, 0.0F, 0.9F);
		rUpperHorn02a.addBox(-0.2F, -0.8F, -0.5F, 1, 1, 3, 0.0F);
		setRotateAngle(rUpperHorn02a, -0.3141592653589793F, -0.2617993877991494F, 0.0F);

		ModelRenderer rUpperHorn02b = new ModelRenderer(this, 33, 7);
		rUpperHorn02b.mirror = true;
		rUpperHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rUpperHorn02b.addBox(-0.8F, -0.8F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer rUpperHorn02c = new ModelRenderer(this, 33, 7);
		rUpperHorn02c.mirror = true;
		rUpperHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rUpperHorn02c.addBox(-0.2F, -0.2F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer rUpperHorn02d = new ModelRenderer(this, 33, 7);
		rUpperHorn02d.mirror = true;
		rUpperHorn02d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rUpperHorn02d.addBox(-0.8F, -0.2F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer rUpperHorn03 = new ModelRenderer(this, 42, 7);
		rUpperHorn03.mirror = true;
		rUpperHorn03.setRotationPoint(0.0F, 0.0F, 2.4F);
		rUpperHorn03.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 3, 0.0F);
		setRotateAngle(rUpperHorn03, -0.17453292519943295F, -0.17453292519943295F, 0.0F);

		ModelRenderer snout = new ModelRenderer(this, 21, 35);
		snout.setRotationPoint(0.0F, -2.5F, -3.7F);
		snout.addBox(-1.5F, -1.0F, -2.0F, 3, 2, 3, 0.0F);
		setRotateAngle(snout, 0.41887902047863906F, 0.0F, 0.0F);

		ModelRenderer upperJaw = new ModelRenderer(this, 23, 41);
		upperJaw.setRotationPoint(0.0F, -1.4F, -3.8F);
		upperJaw.addBox(-2.0F, -1.0F, -1.7F, 4, 2, 2, 0.0F);

		head.addChild(hair00);
		head.addChild(hair01);
		head.addChild(upperJaw);
		head.addChild(rHorn01);
		head.addChild(lowerJaw);
		head.addChild(rUpperHorn01);
		head.addChild(snout);
		head.addChild(lHorn01);
		head.addChild(lUpperHorn01);
		lHorn01.addChild(lHorn02a);
		lHorn02a.addChild(lHorn03a);
		lHorn02a.addChild(lHorn03d);
		lHorn02a.addChild(lHorn02c);
		lHorn02a.addChild(lHorn02b);
		lHorn03a.addChild(lHorn03b);
		lHorn03a.addChild(lHorn03d_1);
		lHorn03a.addChild(lHorn03c);
		lHorn03a.addChild(lHorn04);
		lHorn04.addChild(lHorn05);
		lUpperHorn01.addChild(lUpperHorn02a);
		lUpperHorn02a.addChild(lUpperHorn02c);
		lUpperHorn02a.addChild(lUpperHorn03);
		lUpperHorn02a.addChild(lUpperHorn02d);
		lUpperHorn02a.addChild(lUpperHorn02b);
		rHorn01.addChild(rHorn02a);
		rHorn02a.addChild(rHorn02c);
		rHorn02a.addChild(rHorn03a);
		rHorn02a.addChild(rHorn02b);
		rHorn02a.addChild(rHorn03d);
		rHorn03a.addChild(rHorn03c);
		rHorn03a.addChild(rHorn04);
		rHorn03a.addChild(rHorn03b);
		rHorn03a.addChild(rHorn03d_1);
		rHorn04.addChild(rHorn05);
		rUpperHorn01.addChild(rUpperHorn02a);
		rUpperHorn02a.addChild(rUpperHorn03);
		rUpperHorn02a.addChild(rUpperHorn02c);
		rUpperHorn02a.addChild(rUpperHorn02d);
		rUpperHorn02a.addChild(rUpperHorn02b);
	}
	
	@Override
	public void preRender(GameProfile profile) {
	}
	
	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(0, 0.2f, 0.1f);
		GlStateManager.scale(0.8f, 0.8f, 0.8f);
	}
	
	public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
