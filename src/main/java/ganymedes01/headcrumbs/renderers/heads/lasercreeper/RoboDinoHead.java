package ganymedes01.headcrumbs.renderers.heads.lasercreeper;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;

public class RoboDinoHead extends ModelHead {

	public static final RoboDinoHead INSTANCE = new RoboDinoHead();

	protected RoboDinoHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 256;
		float f0 = 18;
		float f1 = -2.5F;

		head = new ModelRenderer(this, 54, 0);
		head.addBox(-4F, -2F + f1, -29F + f0, 8, 4, 2);
		setRotation(head, 0F, 0F, 0F);
		overlay = new ModelRenderer(this, 48, 7);
		overlay.addBox(-4.5F, -3F + f1, -27F + f0, 9, 5, 7);
		setRotation(overlay, 0F, 0F, 0F);

		ModelRenderer headTopBack = new ModelRenderer(this, 48, 20);
		headTopBack.addBox(-5F, -4F + f1, -20F + f0, 10, 6, 6);
		setRotation(headTopBack, 0F, 0F, 0F);
		ModelRenderer jawBack = new ModelRenderer(this, 13, 23);
		jawBack.addBox(-5F, -2.5F, -19.5F, 10, 3, 6);
		jawBack.setRotationPoint(0, f1, f0);
		setRotation(jawBack, 0.2617994F, 0F, 0F);
		ModelRenderer jawFront = new ModelRenderer(this, 7, 11);
		jawFront.addBox(-5F, -2.5F, -28F, 10, 2, 9);
		jawFront.setRotationPoint(0, f1, f0);
		setRotation(jawFront, 0.2617994F, 0F, 0F);

		head.addChild(headTopBack);
		head.addChild(jawFront);
		head.addChild(jawBack);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		OpenGLHelper.translate(0, 0.25, 0);
		OpenGLHelper.scale(0.75, 0.75, 0.75);
	}
}