package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

public class SlimeHead extends ModelHead {

	public static final SlimeHead INSTANCE = new SlimeHead();

	protected SlimeHead() {
	}

	@Override
	public void init() {
		float f1 = -24;
		head = new ModelRenderer(this, 0, 16);
		head.addBox(-3.0F, 17.0F + f1, -3.0F, 6, 6, 6);
		ModelRenderer slimeRightEye = new ModelRenderer(this, 32, 0);
		slimeRightEye.addBox(-3.25F, 18.0F + f1, -3.5F, 2, 2, 2);
		ModelRenderer slimeLeftEye = new ModelRenderer(this, 32, 4);
		slimeLeftEye.addBox(1.25F, 18.0F + f1, -3.5F, 2, 2, 2);
		ModelRenderer slimeMouth = new ModelRenderer(this, 32, 8);
		slimeMouth.addBox(0.0F, 21.0F + f1, -3.5F, 1, 1, 1);

		head.addChild(slimeMouth);
		head.addChild(slimeRightEye);
		head.addChild(slimeLeftEye);

		overlay = new ModelRenderer(this, 0, 0);
		overlay.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
	}

	@Override
	public void preRender() {
		GL11.glEnable(GL11.GL_NORMALIZE);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
	}
}