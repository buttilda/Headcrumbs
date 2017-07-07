package ganymedes01.headcrumbs.renderers.heads;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;

public class PolarBearHead extends ModelHead {
	public static final PolarBearHead INSTANCE = new PolarBearHead();

	@Override
	public void init() {
		hideOverlay();
		this.textureWidth = 128;
		this.textureHeight = 64;
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3.5F, -3.0F, -3.0F, 7, 7, 7, 0.0F);
		this.head.setRotationPoint(0.0F, 10.0F, -16.0F);
		this.head.setTextureOffset(0, 44).addBox(-2.5F, 1.0F, -6.0F, 5, 3, 3, 0.0F);
		this.head.setTextureOffset(26, 0).addBox(-4.5F, -4.0F, -1.0F, 2, 2, 1, 0.0F);
		ModelRenderer modelrenderer = this.head.setTextureOffset(26, 0);
		modelrenderer.mirror = true;
		modelrenderer.addBox(2.5F, -4.0F, -1.0F, 2, 2, 1, 0.0F);
	}

	@Override
	public void preRender(GameProfile profile) {
		GlStateManager.translate(0, -1, 1);
	}
}