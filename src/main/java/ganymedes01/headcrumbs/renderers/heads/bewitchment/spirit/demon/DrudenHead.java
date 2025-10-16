package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class DrudenHead extends ModelHead {
	
	public static final DrudenHead INSTANCE = new DrudenHead();
	
	protected DrudenHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 128;
		this.textureHeight = 64;


		head = new ModelRenderer(this, 0, 1);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		ModelRenderer hair00 = new ModelRenderer(this, 44, 0);
		hair00.setRotationPoint(0.0F, -5.1F, 3.2F);
		hair00.addBox(-4.0F, 0.0F, -1.0F, 8, 11, 2, 0.0F);
		setRotateAngle(hair00, 0.6981317007977318F, 0.0F, 0.0F);

		ModelRenderer hair01 = new ModelRenderer(this, 25, 0);
		hair01.mirror = true;
		hair01.setRotationPoint(0.0F, -6.9F, 3.2F);
		hair01.addBox(-4.0F, 0.0F, -0.1F, 8, 8, 1, 0.0F);
		setRotateAngle(hair01, 0.8726646259971648F, 0.0F, 0.0F);
		
		ModelRenderer hood = new ModelRenderer(this, 69, 0);
		hood.setRotationPoint(0.0F, 0.0F, 0.0F);
		hood.addBox(-4.5F, -8.5F, -4.5F, 9, 11, 9, 0.0F);

		ModelRenderer leftAntler00 = new ModelRenderer(this, 49, 34);
		leftAntler00.setRotationPoint(1.9F, -7.1F, 0.0F);
		leftAntler00.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(leftAntler00, -0.20943951023931953F, 0.0F, 0.3490658503988659F);

		ModelRenderer leftAntler01a = new ModelRenderer(this, 49, 34);
		leftAntler01a.setRotationPoint(0.0F, -1.6F, 0.0F);
		leftAntler01a.addBox(-0.2F, -3.5F, -0.8F, 1, 4, 1, 0.0F);
		setRotateAngle(leftAntler01a, -0.20943951023931953F, 0.0F, 0.6108652381980153F);

		ModelRenderer leftAntler01b = new ModelRenderer(this, 49, 34);
		leftAntler01b.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftAntler01b.addBox(-0.8F, -3.5F, -0.8F, 1, 4, 1, 0.0F);

		ModelRenderer leftAntler01c = new ModelRenderer(this, 49, 34);
		leftAntler01c.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftAntler01c.addBox(-0.2F, -3.5F, -0.2F, 1, 4, 1, 0.0F);

		ModelRenderer leftAntler01d = new ModelRenderer(this, 49, 34);
		leftAntler01d.setRotationPoint(0.0F, 0.0F, 0.0F);
		leftAntler01d.addBox(-0.8F, -3.5F, -0.2F, 1, 4, 1, 0.0F);

		ModelRenderer leftAntler02 = new ModelRenderer(this, 49, 34);
		leftAntler02.setRotationPoint(0.0F, -3.1F, 0.0F);
		leftAntler02.addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
		setRotateAngle(leftAntler02, 0.0F, 0.0F, -0.3141592653589793F);

		ModelRenderer leftAntler03a = new ModelRenderer(this, 49, 34);
		leftAntler03a.setRotationPoint(0.0F, -3.7F, 0.0F);
		leftAntler03a.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(leftAntler03a, 0.0F, 0.0F, -0.3490658503988659F);

		ModelRenderer leftAntler03b = new ModelRenderer(this, 49, 34);
		leftAntler03b.setRotationPoint(-0.0F, -2.8F, 0.0F);
		leftAntler03b.addBox(-0.5F, -3.9F, -0.5F, 1, 4, 1, 0.0F);
		setRotateAngle(leftAntler03b, -0.10471975511965977F, 0.0F, -0.2792526803190927F);

		ModelRenderer leftAntler03c = new ModelRenderer(this, 49, 34);
		leftAntler03c.setRotationPoint(-0.0F, -3.7F, 0.0F);
		leftAntler03c.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(leftAntler03c, 0.0F, 0.0F, -0.4363323129985824F);

		ModelRenderer leftAntler04a = new ModelRenderer(this, 49, 34);
		leftAntler04a.setRotationPoint(-0.9F, -5.9F, 0.0F);
		leftAntler04a.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(leftAntler04a, 0.45378560551852565F, 0.0F, -0.8028514559173915F);

		ModelRenderer leftAntler04b = new ModelRenderer(this, 49, 34);
		leftAntler04b.setRotationPoint(-0.0F, -2.7F, 0.0F);
		leftAntler04b.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(leftAntler04b, -0.3141592653589793F, 0.0F, 0.0F);

		ModelRenderer leftAntler05a = new ModelRenderer(this, 49, 34);
		leftAntler05a.setRotationPoint(-1.2F, -6.7F, 0.0F);
		leftAntler05a.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(leftAntler05a, -0.5235987755982988F, 0.0F, -1.3089969389957472F);

		ModelRenderer leftAntler05b = new ModelRenderer(this, 49, 34);
		leftAntler05b.setRotationPoint(-0.0F, -2.7F, 0.0F);
		leftAntler05b.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(leftAntler05b, 0.3141592653589793F, 0.0F, 0.3141592653589793F);

		ModelRenderer leftAntler06a = new ModelRenderer(this, 49, 34);
		leftAntler06a.setRotationPoint(0.0F, -2.5F, -0.4F);
		leftAntler06a.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, 0.0F);
		setRotateAngle(leftAntler06a, -0.6283185307179586F, 0.6981317007977318F, 0.0F);

		ModelRenderer leftAntler06b = new ModelRenderer(this, 49, 34);
		leftAntler06b.setRotationPoint(0.1F, 0.0F, -3.4F);
		leftAntler06b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		setRotateAngle(leftAntler06b, 0.0F, 0.5759586531581287F, 0.0F);

		ModelRenderer leftAntler07a = new ModelRenderer(this, 49, 34);
		leftAntler07a.setRotationPoint(0.0F, -2.0F, -0.4F);
		leftAntler07a.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, 0.0F);
		setRotateAngle(leftAntler07a, -0.9075712110370513F, 0.5235987755982988F, 0.0F);

		ModelRenderer leftAntler07b = new ModelRenderer(this, 49, 34);
		leftAntler07b.setRotationPoint(0.1F, 0.0F, -3.4F);
		leftAntler07b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		setRotateAngle(leftAntler07b, 0.0F, 0.5759586531581287F, 0.0F);

		ModelRenderer rightAntler00 = new ModelRenderer(this, 49, 34);
		rightAntler00.mirror = true;
		rightAntler00.setRotationPoint(-1.9F, -7.1F, 0.0F);
		rightAntler00.addBox(-1.0F, -2.0F, -1.0F, 2, 2, 2, 0.0F);
		setRotateAngle(rightAntler00, -0.20943951023931953F, 0.0F, -0.3490658503988659F);

		ModelRenderer rightAntler01a = new ModelRenderer(this, 49, 34);
		rightAntler01a.mirror = true;
		rightAntler01a.setRotationPoint(0.0F, -1.6F, 0.0F);
		rightAntler01a.addBox(-0.2F, -3.5F, -0.8F, 1, 4, 1, 0.0F);
		setRotateAngle(rightAntler01a, -0.20943951023931953F, 0.0F, -0.6108652381980153F);

		ModelRenderer rightAntler01b = new ModelRenderer(this, 49, 34);
		rightAntler01b.mirror = true;
		rightAntler01b.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightAntler01b.addBox(-0.8F, -3.5F, -0.8F, 1, 4, 1, 0.0F);

		ModelRenderer rightAntler01c = new ModelRenderer(this, 49, 34);
		rightAntler01c.mirror = true;
		rightAntler01c.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightAntler01c.addBox(-0.2F, -3.5F, -0.2F, 1, 4, 1, 0.0F);

		ModelRenderer rightAntler01d = new ModelRenderer(this, 49, 34);
		rightAntler01d.mirror = true;
		rightAntler01d.setRotationPoint(0.0F, 0.0F, 0.0F);
		rightAntler01d.addBox(-0.8F, -3.5F, -0.2F, 1, 4, 1, 0.0F);

		ModelRenderer rightAntler02 = new ModelRenderer(this, 49, 34);
		rightAntler02.mirror = true;
		rightAntler02.setRotationPoint(0.0F, -3.1F, 0.0F);
		rightAntler02.addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1, 0.0F);
		setRotateAngle(rightAntler02, 0.0F, 0.0F, 0.3141592653589793F);

		ModelRenderer rightAntler03a = new ModelRenderer(this, 49, 34);
		rightAntler03a.mirror = true;
		rightAntler03a.setRotationPoint(0.0F, -3.7F, 0.0F);
		rightAntler03a.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rightAntler03a, 0.0F, 0.0F, 0.3490658503988659F);

		ModelRenderer rightAntler03b = new ModelRenderer(this, 49, 34);
		rightAntler03b.mirror = true;
		rightAntler03b.setRotationPoint(-0.0F, -2.8F, 0.0F);
		rightAntler03b.addBox(-0.5F, -3.9F, -0.5F, 1, 4, 1, 0.0F);
		setRotateAngle(rightAntler03b, -0.10471975511965977F, 0.0F, 0.2792526803190927F);

		ModelRenderer rightAntler03c = new ModelRenderer(this, 49, 34);
		rightAntler03c.mirror = true;
		rightAntler03c.setRotationPoint(-0.0F, -3.7F, 0.0F);
		rightAntler03c.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rightAntler03c, 0.0F, 0.0F, 0.4363323129985824F);

		ModelRenderer rightAntler04a = new ModelRenderer(this, 49, 34);
		rightAntler04a.mirror = true;
		rightAntler04a.setRotationPoint(0.9F, -5.9F, 0.0F);
		rightAntler04a.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rightAntler04a, 0.45378560551852565F, 0.0F, 0.8028514559173915F);

		ModelRenderer rightAntler04b = new ModelRenderer(this, 49, 34);
		rightAntler04b.mirror = true;
		rightAntler04b.setRotationPoint(-0.0F, -2.7F, 0.0F);
		rightAntler04b.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rightAntler04b, -0.3141592653589793F, 0.0F, 0.0F);

		ModelRenderer rightAntler05a = new ModelRenderer(this, 49, 34);
		rightAntler05a.mirror = true;
		rightAntler05a.setRotationPoint(1.2F, -6.7F, 0.0F);
		rightAntler05a.addBox(-0.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F);
		setRotateAngle(rightAntler05a, -0.5235987755982988F, 0.0F, 1.3089969389957472F);

		ModelRenderer rightAntler05b = new ModelRenderer(this, 49, 34);
		rightAntler05b.mirror = true;
		rightAntler05b.setRotationPoint(-0.0F, -2.7F, 0.0F);
		rightAntler05b.addBox(-0.5F, -2.0F, -0.5F, 1, 2, 1, 0.0F);
		setRotateAngle(rightAntler05b, 0.3141592653589793F, 0.0F, -0.3141592653589793F);

		ModelRenderer rightAntler06a = new ModelRenderer(this, 49, 34);
		rightAntler06a.mirror = true;
		rightAntler06a.setRotationPoint(0.0F, -2.5F, -0.4F);
		rightAntler06a.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, 0.0F);
		setRotateAngle(rightAntler06a, -0.6283185307179586F, -0.6981317007977318F, 0.0F);

		ModelRenderer rightAntler06b = new ModelRenderer(this, 49, 34);
		rightAntler06b.mirror = true;
		rightAntler06b.setRotationPoint(-0.1F, 0.0F, -3.4F);
		rightAntler06b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		setRotateAngle(rightAntler06b, 0.0F, -0.5759586531581287F, 0.0F);

		ModelRenderer rightAntler07a = new ModelRenderer(this, 49, 34);
		rightAntler07a.mirror = true;
		rightAntler07a.setRotationPoint(0.0F, -2.0F, -0.4F);
		rightAntler07a.addBox(-0.5F, -0.5F, -3.8F, 1, 1, 4, 0.0F);
		setRotateAngle(rightAntler07a, -0.9075712110370513F, -0.5235987755982988F, 0.0F);

		ModelRenderer rightAntler07b = new ModelRenderer(this, 49, 34);
		rightAntler07b.mirror = true;
		rightAntler07b.setRotationPoint(-0.1F, 0.0F, -3.4F);
		rightAntler07b.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
		setRotateAngle(rightAntler07b, 0.0F, -0.5759586531581287F, 0.0F);

		head.addChild(hair00);
		head.addChild(hair01);
		head.addChild(hood);
		head.addChild(leftAntler00);
		head.addChild(rightAntler00);
		leftAntler00.addChild(leftAntler07a);
		leftAntler00.addChild(leftAntler01a);
		leftAntler01a.addChild(leftAntler02);
		leftAntler01a.addChild(leftAntler06a);
		leftAntler01a.addChild(leftAntler01b);
		leftAntler01a.addChild(leftAntler01d);
		leftAntler01a.addChild(leftAntler01c);
		leftAntler02.addChild(leftAntler04a);
		leftAntler02.addChild(leftAntler03a);
		leftAntler02.addChild(leftAntler05a);
		leftAntler03a.addChild(leftAntler03b);
		leftAntler03b.addChild(leftAntler03c);
		leftAntler04a.addChild(leftAntler04b);
		leftAntler05a.addChild(leftAntler05b);
		leftAntler06a.addChild(leftAntler06b);
		leftAntler07a.addChild(leftAntler07b);
		rightAntler00.addChild(rightAntler01a);
		rightAntler00.addChild(rightAntler07a);
		rightAntler01a.addChild(rightAntler01b);
		rightAntler01a.addChild(rightAntler02);
		rightAntler01a.addChild(rightAntler01c);
		rightAntler01a.addChild(rightAntler06a);
		rightAntler01a.addChild(rightAntler01d);
		rightAntler02.addChild(rightAntler03a);
		rightAntler02.addChild(rightAntler05a);
		rightAntler02.addChild(rightAntler04a);
		rightAntler03a.addChild(rightAntler03b);
		rightAntler03b.addChild(rightAntler03c);
		rightAntler04a.addChild(rightAntler04b);
		rightAntler05a.addChild(rightAntler05b);
		rightAntler06a.addChild(rightAntler06b);
		rightAntler07a.addChild(rightAntler07b);
	}
	
	@Override
	public void preRender(GameProfile profile) {
	}
	
	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GlStateManager.translate(0, 0.15f, 0.25f);
		GlStateManager.scale(0.5f, 0.5f, 0.5f);
	}
	
	public void setRotateAngle(ModelRenderer renderer, float x, float y, float z) {
		renderer.rotateAngleX = x;
		renderer.rotateAngleY = y;
		renderer.rotateAngleZ = z;
	}

}
