package ganymedes01.headcrumbs.renderers.heads.bewitchment.living;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class ToadHead extends ModelHead {
	
	public static final ToadHead INSTANCE = new ToadHead();
	
	protected ToadHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 32;

		float fy = -6.5f;
		float fz = 2.7f;

		head = new ModelRenderer(this, 37, 0);
		head.setRotationPoint(0, -0.2f, 0);
		head.addBox(-3, -1.5f, -5.7f, 6, 2, 6, 0);
		setRotateAngle(head, 0.87f, 0, 0);

		ModelRenderer jaw = new ModelRenderer(this, 37, 10);
		jaw.setRotationPoint(0, 0.4f, -0.6f);
		jaw.addBox(-3, 0, -5, 6, 2, 6, 0);

		ModelRenderer leftEye = new ModelRenderer(this, 27, 0);
		leftEye.setRotationPoint(1.3f, -0.5f, -2.3f);
		leftEye.addBox(0, -2.1f, -1.5f, 2, 2, 3, 0);
		setRotateAngle(leftEye, 0, 0.18f, 0.14f);

		ModelRenderer rightEye = new ModelRenderer(this, 27, 0);
		rightEye.mirror = true;
		rightEye.setRotationPoint(-1.3f, -0.5f, -2.3f);
		rightEye.addBox(-2, -2.1f, -1.5f, 2, 2, 3, 0);
		setRotateAngle(rightEye, 0, -0.18f, -0.14f);

		head.addChild(jaw);
		head.addChild(leftEye);
		head.addChild(rightEye);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 0;
		float fy = -2.2f * 0.0625f;
		float fz = 6.4f * 0.0625f;
		setTranslation(fx, fy, fz);
		GlStateManager.scale(0.6f, 0.6f, 0.6f);
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
