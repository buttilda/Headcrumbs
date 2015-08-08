package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import com.mojang.authlib.GameProfile;

public class HydraHead extends ModelHead {

	public static final HydraHead INSTANCE = new HydraHead();

	protected HydraHead() {
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.scale(0.25, 0.25, 0.25);
	}

	@Override
	public void init() {
		textureWidth = 512;
		textureHeight = 256;
		ModelRenderer jaw = new ModelRenderer(this, 272, 92);
		jaw.setRotationPoint(0.0F, 10.0F, -20.0F);
		jaw.addBox(-15.0F, 0.0F, -32.0F, 30, 8, 32, 0.0F);
		ModelRenderer upperlip = new ModelRenderer(this, 272, 56);
		upperlip.setRotationPoint(0.0F, 0.0F, 0.0F);
		upperlip.addBox(-15.0F, -2.0F, -56.0F, 30, 12, 24, 0.0F);
		ModelRenderer fin = new ModelRenderer(this, 128, 200);
		fin.setRotationPoint(0.0F, 0.0F, 0.0F);
		fin.addBox(-2.0F, -30.0F, -12.0F, 4, 24, 24, 0.0F);
		head = new ModelRenderer(this, 272, 0);
		head.setRotationPoint(24.0F, -16.0F, 0.0F);
		head.addBox(-16.0F, -14.0F, -32.0F, 32, 24, 32, 0.0F);
		ModelRenderer frill = new ModelRenderer(this, 272, 200);
		frill.setRotationPoint(0.0F, 0.0F, -14.0F);
		frill.addBox(-24.0F, -40.0F, 0.0F, 48, 48, 4, 0.0F);
		setRotation(frill, -0.5235987755982988F, 0.0F, 0.0F);
		ModelRenderer rearjaw = new ModelRenderer(this, 272, 132);
		rearjaw.setRotationPoint(0.0F, 0.0F, 0.0F);
		rearjaw.addBox(-15.0F, 10.0F, -20.0F, 30, 8, 16, 0.0F);

		head.addChild(rearjaw);
		head.addChild(fin);
		head.addChild(frill);
		head.addChild(jaw);
		head.addChild(upperlip);

		hideOverlay();
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		OpenGLHelper.translate(0, -0.125, 0);
		OpenGLHelper.scale(0.75, 0.75, 0.75);
	}
}