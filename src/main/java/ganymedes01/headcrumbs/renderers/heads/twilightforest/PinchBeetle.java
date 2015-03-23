package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

public class PinchBeetle extends ModelHead {

	public static final PinchBeetle INSTANCE = new PinchBeetle();

	protected PinchBeetle() {
		hideOverlay();
		float f = 4;
		float f2 = -2;
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-4.0f, -4.0f + f2, -6.0f + f, 8, 6, 6);
		head.setRotationPoint(0.0f, 0.0f, 0.0f);
		ModelRenderer jaw1a = new ModelRenderer(this, 40, 6);
		jaw1a.addBox(-1.0f, -1.0f, -1.5f, 8, 2, 3);
		jaw1a.setRotationPoint(-3.0f, 1.0f + f2, -6.0f + f);
		setRotation(jaw1a, 0.0f, 2.635447f, 0.0f);
		ModelRenderer jaw1b = new ModelRenderer(this, 40, 10);
		jaw1b.addBox(-1.0f, -1.0f, -1.0f, 10, 2, 2);
		jaw1b.setRotationPoint(7.0f, 0.0f, 0.0f);
		setRotation(jaw1b, 0.0f, -1.047197f, 0.0f);
		ModelRenderer jaw2a = new ModelRenderer(this, 40, 6);
		jaw2a.addBox(-1.0f, -1.0f, -1.5f, 8, 2, 3);
		jaw2a.setRotationPoint(3.0f, 1.0f + f2, -6.0f + f);
		setRotation(jaw2a, 0.0f, 0.541052f, 0.0f);
		ModelRenderer jaw2b = new ModelRenderer(this, 40, 10);
		jaw2b.addBox(-1.0f, -1.0f, -1.0f, 10, 2, 2);
		jaw2b.setRotationPoint(7.0f, 0.0f, 0.0f);
		setRotation(jaw2b, 0.0f, 1.047197f, 0.0f);
		ModelRenderer antenna1 = new ModelRenderer(this, 42, 4);
		antenna1.addBox(0.0f, -0.5f, -0.5f, 10, 1, 1);
		antenna1.setRotationPoint(1.0f, -3.0f + f2, -5.0f + f);
		setRotation(antenna1, 0.0f, 1.047198f, -0.296706f);
		ModelRenderer antenna2 = new ModelRenderer(this, 42, 4);
		antenna2.addBox(0.0f, -0.5f, -0.5f, 10, 1, 1);
		antenna2.setRotationPoint(-1.0f, -3.0f + f2, -5.0f + f);
		setRotation(antenna2, 0.0f, 2.094395f, 0.296706f);
		ModelRenderer eye1 = new ModelRenderer(this, 15, 12);
		eye1.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye1.setRotationPoint(-3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer eye2 = new ModelRenderer(this, 15, 12);
		eye2.addBox(-1.5f, -1.5f, -1.5f, 3, 3, 3);
		eye2.setRotationPoint(3.0f, -2.0f + f2, -5.0f + f);
		ModelRenderer tooth1a = new ModelRenderer(this, 0, 0);
		tooth1a.addBox(0.0f, -0.5f, -0.0f, 2, 1, 1);
		tooth1a.setRotationPoint(9.0f, 0.0f, 0.0f);
		setRotation(tooth1a, 0.0f, -0.5235987f, 0.0f);
		ModelRenderer tooth1b = new ModelRenderer(this, 0, 0);
		tooth1b.addBox(-2.5f, -0.5f, -0.0f, 2, 1, 1);
		tooth1b.setRotationPoint(6.0f, 0.0f, 0.0f);
		setRotation(tooth1b, 0.0f, 1.5707963f, 0.0f);
		ModelRenderer tooth1c = new ModelRenderer(this, 0, 0);
		tooth1c.addBox(-2.5f, -0.5f, -0.0f, 2, 1, 1);
		tooth1c.setRotationPoint(3.0f, 0.0f, 0.0f);
		setRotation(tooth1c, 0.0f, 1.5707963f, 0.0f);
		ModelRenderer tooth2a = new ModelRenderer(this, 0, 0);
		tooth2a.addBox(0.0f, -0.5f, -1.0f, 2, 1, 1);
		tooth2a.setRotationPoint(9.0f, 0.0f, 0.0f);
		setRotation(tooth2a, 0.0f, 0.5235987f, 0.0f);
		ModelRenderer tooth2b = new ModelRenderer(this, 0, 0);
		tooth2b.addBox(-2.5f, -0.5f, -1.0f, 2, 1, 1);
		tooth2b.setRotationPoint(6.0f, 0.0f, 0.0f);
		setRotation(tooth2b, 0.0f, -1.5707963f, 0.0f);
		ModelRenderer tooth2c = new ModelRenderer(this, 0, 0);
		tooth2c.addBox(-2.5f, -0.5f, -1.0f, 2, 1, 1);
		tooth2c.setRotationPoint(3.0f, 0.0f, 0.0f);
		setRotation(tooth2c, 0.0f, -1.5707963f, 0.0f);
		head.addChild(jaw1a);
		jaw1a.addChild(jaw1b);
		jaw1b.addChild(tooth1a);
		jaw1b.addChild(tooth1b);
		jaw1b.addChild(tooth1c);
		jaw2b.addChild(tooth2a);
		jaw2b.addChild(tooth2b);
		jaw2b.addChild(tooth2c);
		head.addChild(jaw2a);
		jaw2a.addChild(jaw2b);
		head.addChild(antenna1);
		head.addChild(antenna2);
		head.addChild(eye1);
		head.addChild(eye2);
	}

	@Override
	public void preRenderItem(ItemRenderType type) {
		GL11.glScaled(0.65, 0.65, 0.65);
		if (type == ItemRenderType.INVENTORY)
			GL11.glTranslated(0, 0.5, 0.5);
	}

	@Override
	public float playerRenderOffset() {
		return 1;
	}
}