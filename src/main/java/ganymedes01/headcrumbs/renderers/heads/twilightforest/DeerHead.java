package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

public class DeerHead extends ModelHead {

	public static final DeerHead INSTANCE = new DeerHead();

	protected DeerHead() {
	}

	@Override
	public void init() {
		hideOverlay();

		head = new ModelRenderer(this, 0, 5);
		head.addBox(-2.0F, -8.0F, -2.0F, 4, 6, 6, 0.0F);
		head.setRotationPoint(0.0F, 2.0F, 0.0F);

		head.setTextureOffset(52, 0).addBox(-1.5F, -5.0F, -5.0F, 3, 3, 3, 0.0F);

		head.setTextureOffset(20, 0);
		head.addBox(-3.0F, -10.0F, 2.0F, 2, 2, 2, 0.0F);
		head.addBox(-3.0F, -10.0F, 2.0F, 2, 2, 2, 0.0F);
		head.addBox(-4.0F, -10.0F, 3.0F, 1, 1, 3, 0.0F);
		head.addBox(-5.0F, -11.0F, 5.0F, 1, 1, 5, 0.0F);
		head.addBox(-5.0F, -14.0F, 7.0F, 1, 4, 1, 0.0F);
		head.addBox(-6.0F, -17.0F, 6.0F, 1, 4, 1, 0.0F);
		head.addBox(-6.0F, -13.0F, 4.0F, 1, 1, 3, 0.0F);
		head.addBox(-6.0F, -14.0F, 1.0F, 1, 1, 4, 0.0F);
		head.addBox(-7.0F, -15.0F, -2.0F, 1, 1, 4, 0.0F);
		head.addBox(-6.0F, -16.0F, -5.0F, 1, 1, 4, 0.0F);
		head.addBox(-7.0F, -18.0F, 3.0F, 1, 5, 1, 0.0F);
		head.addBox(-6.0F, -19.0F, -2.0F, 1, 5, 1, 0.0F);

		head.addBox(1.0F, -10.0F, 2.0F, 2, 2, 2, 0.0F);
		head.addBox(3.0F, -10.0F, 3.0F, 1, 1, 3, 0.0F);
		head.addBox(4.0F, -11.0F, 5.0F, 1, 1, 5, 0.0F);
		head.addBox(4.0F, -14.0F, 6.0F, 1, 4, 1, 0.0F);
		head.addBox(5.0F, -17.0F, 7.0F, 1, 4, 1, 0.0F);
		head.addBox(5.0F, -13.0F, 4.0F, 1, 1, 3, 0.0F);
		head.addBox(5.0F, -14.0F, 1.0F, 1, 1, 4, 0.0F);
		head.addBox(6.0F, -15.0F, -2.0F, 1, 1, 4, 0.0F);
		head.addBox(5.0F, -16.0F, -5.0F, 1, 1, 4, 0.0F);
		head.addBox(6.0F, -18.0F, 3.0F, 1, 5, 1, 0.0F);
		head.addBox(5.0F, -19.0F, -2.0F, 1, 5, 1, 0.0F);
	}

	@Override
	public void preRenderItem(ItemRenderType type) {
		GL11.glScaled(0.75, 0.75, 0.75);
		if (type != ItemRenderType.EQUIPPED_FIRST_PERSON)
			GL11.glTranslated(0, -0.45, 0);
	}

	@Override
	public float playerRenderOffset() {
		return 2;
	}
}