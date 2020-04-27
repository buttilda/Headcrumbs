package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.ghost;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class GhostHead extends ModelHead {
	
	public static final GhostHead INSTANCE = new GhostHead();
	
	protected GhostHead() {
	}
	
	private ModelRenderer skull01;
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;


		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		skull01 = new ModelRenderer(this, 34, 0);
		skull01.setRotationPoint(0.0F, 0.0F, 0.0F);
		skull01.addBox(-3.5F, -7.5F, -3.0F, 7, 5, 6, 0.0F);

		ModelRenderer skullJaw = new ModelRenderer(this, 19, 30);
		skullJaw.setRotationPoint(0.0F, -1.9F, 0.9F);
		skullJaw.addBox(-2.5F, -1.0F, -3.5F, 5, 2, 5, 0.0F);
		setRotateAngle(skullJaw, 0.17453292519943295F, 0.0F, 0.0F);

		skull01.addChild(skullJaw);
	}
	
	@Override
	public void preRender(GameProfile profile) {
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.25F);
	}
	
	@Override
	public void render(float rotationX, float rotationY) {
		head.rotateAngleY = rotationX / (180F / (float) Math.PI);
		head.rotateAngleX = rotationY / (180F / (float) Math.PI);
		skull01.rotateAngleY = rotationX / (180F / (float) Math.PI);
		skull01.rotateAngleX = rotationY / (180F / (float) Math.PI);
		head.render(0.0625F);
		skull01.render(0.0625F);
		
	}
	
	@Override
	public void postRender() {
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1F);
		
		GlStateManager.disableAlpha();
		GlStateManager.disableBlend();
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
