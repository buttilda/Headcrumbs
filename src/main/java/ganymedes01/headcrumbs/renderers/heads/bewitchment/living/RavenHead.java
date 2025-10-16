package ganymedes01.headcrumbs.renderers.heads.bewitchment.living;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class RavenHead extends ModelHead {
	
	public static final RavenHead INSTANCE = new RavenHead();
	
	protected RavenHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;

		float fy = -5.5f;
		float fz = 2.6f;

		head = new ModelRenderer(this, 42, 0);
//		head.setRotationPoint(0, -1, -2);
		head.setRotationPoint(0, -1, 0);
		head.addBox(-2.5f, -2.5f, -5.6f, 5, 5, 6, 0);
		setRotateAngle(head, 0.54f, 0, 0);

		ModelRenderer beak00 = new ModelRenderer(this, 42, 12);
		beak00.setRotationPoint(0, -1, -5.2f);
		beak00.addBox(-0.9f, 0, -3, 2, 2, 3, 0);
		setRotateAngle(beak00, 0.35f, 0, 0);

		ModelRenderer beak01a = new ModelRenderer(this, 42, 12);
		beak01a.setRotationPoint(0, 0, -3);
		beak01a.addBox(-1, 0, 0, 2, 2, 3, 0);
		setRotateAngle(beak01a, -0.26f, 0, 0);

		ModelRenderer beak01b = new ModelRenderer(this, 42, 12);
		beak01b.setRotationPoint(0, 0, 0);
		beak01b.addBox(-1.1f, 0, -3, 1, 2, 3, 0);

		beak00.addChild(beak01b);
		beak00.addChild(beak01a);
		head.addChild(beak00);
	}
	
	@Override
	public void preRender(GameProfile profile) {

		float fx = 2f * 0.0625f;
		float fy = -1.5f * 0.0625f;
		float fz = 3.1f * 0.0625f;
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
