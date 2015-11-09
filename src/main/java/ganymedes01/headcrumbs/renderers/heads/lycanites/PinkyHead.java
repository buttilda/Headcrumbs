package ganymedes01.headcrumbs.renderers.heads.lycanites;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;

public class PinkyHead extends ModelHead {

	public static final PinkyHead INSTANCE = new PinkyHead();

	protected PinkyHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		float f1 = 11;
		float f2 = -3;
		float f3 = 6;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-5F, -4F, -9F + f3, 10, 11, 9);
		head.setRotationPoint(0F, -4F + f2, -11F + f1);
		setRotation(head, 0.7853982F, 0F, 0F);

		ModelRenderer topjaw = new ModelRenderer(this, 38, 0);
		head.addChild(topjaw);
		topjaw.addBox(-6F, 0F, -12F, 12, 6, 6);
		topjaw.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(topjaw, -0.7853982F + 0.2094395F, 0F, 0F);

		ModelRenderer topteeth = new ModelRenderer(this, 38, 12);
		head.addChild(topteeth);
		topteeth.addBox(-5F, 5F, -11F, 10, 3, 0);
		topteeth.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(topteeth, -0.7853982F + 0.2094395F, 0F, 0F);

		ModelRenderer leftmouth = new ModelRenderer(this, 120, 0);
		head.addChild(leftmouth);
		leftmouth.addBox(4.9F, -2F, -11F, 1, 8, 3);
		leftmouth.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(leftmouth, -0.7853982F + 0.7853982F, 0F, 0F);

		ModelRenderer rightmouth = new ModelRenderer(this, 120, 0);
		head.addChild(rightmouth);
		rightmouth.mirror = true;
		rightmouth.addBox(-5.9F, -2F, -11F, 1, 8, 3);
		rightmouth.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(rightmouth, -0.7853982F + 0.7853982F, 0F, 0F);
		rightmouth.mirror = false;

		ModelRenderer bottomjaw = new ModelRenderer(this, 74, 0);
		head.addChild(bottomjaw);
		bottomjaw.addBox(-6F, 8F, -13F, 12, 4, 12);
		bottomjaw.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(bottomjaw, -0.7853982F + 0.4537856F, 0F, 0F);

		ModelRenderer bottomteeth = new ModelRenderer(this, 38, 15);
		bottomjaw.addChild(bottomteeth);
		bottomteeth.addBox(-5F, 5F, -12F, 10, 4, 0);
		bottomteeth.setRotationPoint(0F, 0F, 0F);
		setRotation(bottomteeth, -0.4537856F + 0.4537856F, 0F, 0F);

		ModelRenderer lefthorn01 = new ModelRenderer(this, 110, 17);
		head.addChild(lefthorn01);
		lefthorn01.addBox(5F, -2F, -7F, 4, 4, 3);
		lefthorn01.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(lefthorn01, -0.7853982F + 0.4537856F, 0F, 0F);

		ModelRenderer lefthorn02 = new ModelRenderer(this, 110, 17);
		head.addChild(lefthorn02);
		lefthorn02.addBox(-1F, -2F, -15F, 3, 2, 6);
		lefthorn02.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(lefthorn02, (float) Math.toRadians(-8), (float) Math.toRadians(-49), (float) Math.toRadians(3));

		ModelRenderer lefthorn03 = new ModelRenderer(this, 110, 17);
		head.addChild(lefthorn03);
		lefthorn03.addBox(13F, -3F, -9F, 2, 2, 7);
		lefthorn03.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(lefthorn03, (float) Math.toRadians(-4), (float) Math.toRadians(30), (float) Math.toRadians(-3));

		ModelRenderer righthorn01 = new ModelRenderer(this, 110, 17);
		head.addChild(righthorn01);
		righthorn01.mirror = true;
		righthorn01.addBox(-9F, -2F, -7F, 4, 4, 3);
		righthorn01.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(righthorn01, -0.7853982F + 0.4537856F, 0F, 0F);
		righthorn01.mirror = false;

		ModelRenderer righthorn02 = new ModelRenderer(this, 110, 17);
		head.addChild(righthorn02);
		righthorn02.mirror = true;
		righthorn02.addBox(-2F, -2F, -15F, 3, 2, 6);
		righthorn02.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(righthorn02, (float) Math.toRadians(-8), (float) Math.toRadians(49), (float) Math.toRadians(-3));
		righthorn02.mirror = false;

		ModelRenderer righthorn03 = new ModelRenderer(this, 110, 17);
		head.addChild(righthorn03);
		righthorn03.mirror = true;
		righthorn03.addBox(-15F, -3F, -9F, 2, 2, 7);
		righthorn03.setRotationPoint(0F, 0F, 0F + f3);
		setRotation(righthorn03, (float) Math.toRadians(-4), (float) Math.toRadians(-30), (float) Math.toRadians(3));
		righthorn03.mirror = false;

		hideOverlay();
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.scale(2F / 3F, 2F / 3F, 2F / 3F);
	}
}