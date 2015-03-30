package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

public class BatHead extends ModelHead {

	public static final BatHead INSTANCE = new BatHead();

	protected BatHead() {
	}

	@Override
	public void init() {
		textureWidth = 64;
		textureHeight = 64;
		hideOverlay();
		float f1 = -3;
		float f2 = 5;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -3.0F + f1, -3.0F + f2, 6, 6, 6);
		ModelRenderer ear1 = new ModelRenderer(this, 24, 0);
		ear1.addBox(-4.0F, -6.0F + f1, -2.0F + f2, 3, 4, 1);
		head.addChild(ear1);
		ModelRenderer ear2 = new ModelRenderer(this, 24, 0);
		ear2.mirror = true;
		ear2.addBox(1.0F, -6.0F + f1, -2.0F + f2, 3, 4, 1);
		head.addChild(ear2);
	}

	@Override
	public void preRender(GameProfile profile) {
		GL11.glScaled(0.5, 0.5, 0.5);
	}

	@Override
	public float playerRenderOffset() {
		return 3;
	}
}