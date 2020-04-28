package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.ghost;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class GhostHead extends ModelHead {
	
	public static final GhostHead INSTANCE = new GhostHead();
	
	protected GhostHead() {
		super(64);
	}
	
	@Override
	public void init() {
		this.textureWidth = 64;
		this.textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		overlay = new ModelRenderer(this, 34, 0);
		overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
		overlay.addBox(-3.5F, -7.5F, -3.0F, 7, 5, 6, 0.0F);

		ModelRenderer skullJaw = new ModelRenderer(this, 19, 30);
		skullJaw.setRotationPoint(0.0F, -1.9F, 0.9F);
		skullJaw.addBox(-2.5F, -1.0F, -3.5F, 5, 2, 5, 0.0F);
		setRotateAngle(skullJaw, 0.17453292519943295F, 0.0F, 0.0F);

		overlay.addChild(skullJaw);
	}
	
	@Override
	public void preRender(GameProfile profile) {
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 0.25F);
		GlStateManager.depthMask(false);
		
		GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
	}
	
	@Override
	public void postRender() {
		GlStateManager.depthMask(true);
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
