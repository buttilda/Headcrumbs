package ganymedes01.headcrumbs.renderers.heads.bewitchment.living;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class OwlHead extends ModelHead {
	
	public static final OwlHead INSTANCE = new OwlHead();
	
	protected OwlHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;

		float fy = -4.0f;

		head = new ModelRenderer(this, 28, 0);
		head.setRotationPoint(0, -12, 0);
		head.addBox(-5, -4, -4, 10, 8, 8, 0);
		setRotateAngle(head, -0.07f, 0, 0);

		ModelRenderer beak = new ModelRenderer(this, 19, 1);
		beak.setRotationPoint(-1, 0, -5);
		beak.addBox(0, 0, 0.4f, 2, 4, 1, 0);
		setRotateAngle(beak, -0.09f, 0, 0);

		ModelRenderer leftEar = new ModelRenderer(this, 27, 1);
		leftEar.setRotationPoint(4, -3.4f, 0);
		leftEar.addBox(-1, -4, -1, 2, 4, 2, 0);
		setRotateAngle(leftEar, -0.35f, 0, 0.26f);

		ModelRenderer rightEar = new ModelRenderer(this, 27, 1);
		rightEar.mirror = true;
		rightEar.setRotationPoint(-4, -3.4f, 0);
		rightEar.addBox(-1, -4, -1, 2, 4, 2, 0);
		setRotateAngle(rightEar, -0.35f, 0, -0.26f);

		head.addChild(beak);
		head.addChild(leftEar);
		head.addChild(rightEar);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = 8.0f * 0.0625f;
		float fz = 0;
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
