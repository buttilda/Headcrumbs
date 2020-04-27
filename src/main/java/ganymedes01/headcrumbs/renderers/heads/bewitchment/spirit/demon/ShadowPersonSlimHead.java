package ganymedes01.headcrumbs.renderers.heads.bewitchment.spirit.demon;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

public class ShadowPersonSlimHead extends ModelHead {
	
	public static final ShadowPersonSlimHead INSTANCE = new ShadowPersonSlimHead();
	
	protected ShadowPersonSlimHead() {
	}
	
	@Override
	public void init() {
		hideOverlay();		
		this.textureWidth = 64;
		this.textureHeight = 64;


		head = new ModelRenderer(this, 0, 0);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);
		head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);

		ModelRenderer hatBrim = new ModelRenderer(this, 0, 35);
		hatBrim.setRotationPoint(0.0F, -5.8F, 0.0F);
		hatBrim.addBox(-6.0F, -0.5F, -6.0F, 12, 1, 12, 0.0F);

		ModelRenderer hatPipe = new ModelRenderer(this, 0, 49);
		hatPipe.setRotationPoint(0.0F, -0.3F, 0.0F);
		hatPipe.addBox(-4.5F, -3.5F, -4.5F, 9, 4, 9, 0.0F);

		head.addChild(hatBrim);
		hatBrim.addChild(hatPipe);
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
