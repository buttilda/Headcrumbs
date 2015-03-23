package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

public class SlimeBeetleHead extends ModelHead {

	public static final SlimeBeetleHead INSTANCE = new SlimeBeetleHead();

	protected SlimeBeetleHead() {
		textureHeight = 64;

		hideOverlay();
		float f = 4;
		float f2 = -2;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0f, -4.0f + f2, -6.0f + f, 8, 6, 6);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		ModelRenderer antenna1 = new ModelRenderer(this, 38, 4);
		antenna1.addBox(0.0f, -0.5f, -0.5f, 12, 1, 1);
		antenna1.setRotationPoint(1.0f, -3.0f + f2, -5.0f + f);
		antenna1.rotateAngleX = 0.0f;
		antenna1.rotateAngleY = 1.047198f;
		antenna1.rotateAngleZ = -0.296706f;
		ModelRenderer antenna2 = new ModelRenderer(this, 38, 4);
		antenna2.addBox(0.0f, -0.5f, -0.5f, 12, 1, 1);
		antenna2.setRotationPoint(-1.0f, -3.0f + f2, -5.0f + f);
		antenna2.rotateAngleX = 0.0f;
		antenna2.rotateAngleY = 2.094395f;
		antenna2.rotateAngleZ = 0.296706f;
		ModelRenderer eye1 = new ModelRenderer(this, 15, 12);
		eye1.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye1.setRotationPoint(-3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer eye2 = new ModelRenderer(this, 15, 12);
		eye2.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye2.setRotationPoint(3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer mouth = new ModelRenderer(this, 17, 12);
		mouth.addBox(-1.0f, -1.0f, -1.0f, 2, 2, 1);
		mouth.setRotationPoint(0.0f, 1.0f + f2, -6.0f + f);
		head.addChild(antenna1);
		head.addChild(antenna2);
		head.addChild(eye1);
		head.addChild(eye2);
		head.addChild(mouth);
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}

	@Override
	public void preRenderItem(ItemRenderType type) {
		if (type == ItemRenderType.INVENTORY)
			GL11.glTranslated(0, 0.25, 0.5);
	}
}