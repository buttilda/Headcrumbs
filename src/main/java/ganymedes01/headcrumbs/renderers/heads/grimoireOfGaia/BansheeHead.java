package ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

public class BansheeHead extends ModelHead {

	public static final BansheeHead INSTANCE = new BansheeHead();

	protected BansheeHead() {
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -6.0F, -3.0F, 6, 6, 6);
		head.setTextureSize(64, 32);
		head.mirror = true;
		setRotation(head, 0.0F, 0.0F, 0.0F);
		overlay = new ModelRenderer(this, 36, 0);
		overlay.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		overlay.setTextureSize(64, 32);
		overlay.mirror = true;
		setRotation(overlay, 0.0F, 0.0F, 0.0F);
		ModelRenderer hair1 = new ModelRenderer(this, 36, 14);
		hair1.addBox(-4.0F, -7.5F, -0.5F, 8, 7, 2);
		hair1.setTextureSize(64, 32);
		hair1.mirror = true;
		setRotation(hair1, 0.0872665F, 0.0F, 0.0F);
		ModelRenderer hair2 = new ModelRenderer(this, 36, 23);
		hair2.addBox(-5.0F, -8.5F, 1.5F, 10, 10, 4);
		hair2.setTextureSize(64, 32);
		hair2.mirror = true;
		setRotation(hair2, 0.1745329F, 0.0F, 0.0F);
		ModelRenderer hair3 = new ModelRenderer(this, 36, 37);
		hair3.addBox(-6.0F, -9.5F, 5.5F, 12, 12, 6);
		hair3.setTextureSize(64, 32);
		hair3.mirror = true;
		setRotation(hair3, 0.1745329F, 0.0F, 0.0F);
		ModelRenderer hair4 = new ModelRenderer(this, 6, 41);
		hair4.addBox(-4.0F, -7.5F, 5.5F, 8, 8, 14);
		hair4.setTextureSize(64, 32);
		hair4.mirror = true;
		setRotation(hair4, 0.1745329F, 0.0F, 0.0F);

		head.addChild(hair1);
		head.addChild(hair2);
		head.addChild(hair3);
		head.addChild(hair4);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		OpenGLHelper.scale(0.75F, 0.75F, 0.75F);
		OpenGLHelper.translate(0, -0.5F, -0.5F);
	}
}