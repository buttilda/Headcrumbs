package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class BafometyrHead extends ModelHead {
	
	public static final BafometyrHead INSTANCE = new BafometyrHead();
	
	protected BafometyrHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;


		head = new ModelRenderer(this, 0, 1);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		ModelRenderer beard = new ModelRenderer(this, 0, 56);
		beard.setRotationPoint(0.0F, 0.3F, -2.2F);
		beard.addBox(-1.5F, 0.0F, -1.0F, 3, 4, 4, 0.0F);
		setRotateAngle(beard, 0.03490658503988659F, 0.0F, 0.0F);

		ModelRenderer jawLower = new ModelRenderer(this, 37, 0);
		jawLower.setRotationPoint(0.0F, -0.8F, -3.5F);
		jawLower.addBox(-2.0F, -0.5F, -4.0F, 4, 1, 4, 0.0F);
		setRotateAngle(jawLower, -0.03490658503988659F, 0.0F, 0.0F);

		ModelRenderer lEar = new ModelRenderer(this, 50, 0);
		lEar.setRotationPoint(3.4F, -6.0F, 0.8F);
		lEar.addBox(-0.3F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		setRotateAngle(lEar, -0.5235987755982988F, 0.0F, -0.5235987755982988F);

		ModelRenderer lHorn01 = new ModelRenderer(this, 24, 0);
		lHorn01.setRotationPoint(2.4F, -8.0F, 1.5F);
		lHorn01.addBox(-1.0F, -1.0F, -1.8F, 2, 2, 4, 0.0F);
		setRotateAngle(lHorn01, 0.593411945678072F, 0.13962634015954636F, 0.0F);

		ModelRenderer lHorn02a = new ModelRenderer(this, 33, 7);
		lHorn02a.setRotationPoint(0.0F, 0.0F, 2.1F);
		lHorn02a.addBox(-0.2F, -0.8F, -0.5F, 1, 1, 3, 0.0F);
		setRotateAngle(lHorn02a, -0.3141592653589793F, 0.12217304763960307F, 0.0F);

		ModelRenderer lHorn02b = new ModelRenderer(this, 33, 7);
		lHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02b.addBox(-0.8F, -0.8F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer lHorn02c = new ModelRenderer(this, 33, 7);
		lHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02c.addBox(-0.2F, -0.2F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer lHorn02d = new ModelRenderer(this, 33, 7);
		lHorn02d.setRotationPoint(0.0F, 0.0F, 0.0F);
		lHorn02d.addBox(-0.8F, -0.2F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer lHorn03 = new ModelRenderer(this, 42, 7);
		lHorn03.setRotationPoint(0.0F, 0.0F, 2.4F);
		lHorn03.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 3, 0.0F);
		setRotateAngle(lHorn03, -0.17453292519943295F, 0.13962634015954636F, 0.0F);

		ModelRenderer lHorn04 = new ModelRenderer(this, 39, 12);
		lHorn04.setRotationPoint(0.0F, 0.0F, 2.4F);
		lHorn04.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
		setRotateAngle(lHorn04, 0.06981317007977318F, -0.22689280275926282F, 0.0F);

		ModelRenderer rEar = new ModelRenderer(this, 50, 0);
		rEar.mirror = true;
		rEar.setRotationPoint(-3.4F, -6.2F, 0.8F);
		rEar.addBox(-3.7F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
		setRotateAngle(rEar, -0.5235987755982988F, 0.0F, 0.5235987755982988F);

		ModelRenderer rHorn01 = new ModelRenderer(this, 24, 0);
		rHorn01.mirror = true;
		rHorn01.setRotationPoint(-2.4F, -8.0F, 1.5F);
		rHorn01.addBox(-1.0F, -1.0F, -1.8F, 2, 2, 4, 0.0F);
		setRotateAngle(rHorn01, 0.593411945678072F, -0.13962634015954636F, 0.0F);

		ModelRenderer rHorn02a = new ModelRenderer(this, 33, 7);
		rHorn02a.mirror = true;
		rHorn02a.setRotationPoint(0.0F, 0.0F, 2.1F);
		rHorn02a.addBox(-0.2F, -0.8F, -0.5F, 1, 1, 3, 0.0F);
		setRotateAngle(rHorn02a, -0.3141592653589793F, -0.12217304763960307F, 0.0F);

		ModelRenderer rHorn02b = new ModelRenderer(this, 33, 7);
		rHorn02b.mirror = true;
		rHorn02b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02b.addBox(-0.8F, -0.8F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer rHorn02c = new ModelRenderer(this, 33, 7);
		rHorn02c.mirror = true;
		rHorn02c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02c.addBox(-0.2F, -0.2F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer rHorn02d = new ModelRenderer(this, 33, 7);
		rHorn02d.mirror = true;
		rHorn02d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rHorn02d.addBox(-0.8F, -0.2F, -0.5F, 1, 1, 3, 0.0F);

		ModelRenderer rHorn03 = new ModelRenderer(this, 42, 7);
		rHorn03.mirror = true;
		rHorn03.setRotationPoint(0.0F, 0.0F, 2.4F);
		rHorn03.addBox(-0.5F, -0.5F, -0.4F, 1, 1, 3, 0.0F);
		setRotateAngle(rHorn03, -0.17453292519943295F, -0.13962634015954636F, 0.0F);

		ModelRenderer rHorn04 = new ModelRenderer(this, 39, 12);
		rHorn04.mirror = true;
		rHorn04.setRotationPoint(0.0F, 0.0F, 2.4F);
		rHorn04.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 2, 0.0F);
		setRotateAngle(rHorn04, 0.06981317007977318F, 0.22689280275926282F, 0.0F);

		ModelRenderer snout = new ModelRenderer(this, 44, 55);
		snout.setRotationPoint(0.0F, -1.8F, -0.6F);
		snout.addBox(-2.5F, -1.5F, -7.1F, 5, 2, 4, 0.0F);

		ModelRenderer snout_1 = new ModelRenderer(this, 29, 56);
		snout_1.setRotationPoint(0.0F, -4.9F, -2.9F);
		snout_1.addBox(-2.0F, -1.9F, -5.1F, 4, 3, 5, 0.0F);
		setRotateAngle(snout_1, 0.5235987755982988F, 0.0F, 0.0F);

		jawLower.addChild(beard);
		head.addChild(lHorn01);
		head.addChild(rHorn01);
		head.addChild(rEar);
		head.addChild(snout_1);
		head.addChild(lEar);
		head.addChild(snout);
		head.addChild(jawLower);
		lHorn01.addChild(lHorn02a);
		lHorn02a.addChild(lHorn03);
		lHorn02a.addChild(lHorn02c);
		lHorn02a.addChild(lHorn02b);
		lHorn02a.addChild(lHorn02d);
		lHorn03.addChild(lHorn04);
		rHorn01.addChild(rHorn02a);
		rHorn02a.addChild(rHorn02d);
		rHorn02a.addChild(rHorn02b);
		rHorn02a.addChild(rHorn02c);
		rHorn02a.addChild(rHorn03);
		rHorn03.addChild(rHorn04);
	}
	
	@Override
	public void preRender(GameProfile profile) {
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
