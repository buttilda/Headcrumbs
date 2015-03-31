package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import org.lwjgl.opengl.GL11;

import com.mojang.authlib.GameProfile;

public class HorseHead extends ModelHead {

	public static final HorseHead INSTANCE_HORSE = new HorseHead(false);
	public static final HorseHead INSTANCE_MULE = new HorseHead(true);

	private final boolean isMule;

	protected HorseHead(boolean isMule) {
		this.isMule = isMule;
	}

	@Override
	public void init() {
		textureWidth = 128;
		textureHeight = 128;

		head = new ModelRenderer(this, 0, 0);

		float f1 = -2;
		float f2 = -4;
		ModelRenderer head2 = new ModelRenderer(this, 0, 0);
		head2.addBox(-2.5F, -10.0F + f2, -1.5F + f1, 5, 5, 7);
		ModelRenderer mouthTop = new ModelRenderer(this, 24, 18);
		mouthTop.addBox(-2.0F, -10.0F + f2, -7.0F + f1, 4, 3, 6);
		ModelRenderer mouthBottom = new ModelRenderer(this, 24, 27);
		mouthBottom.addBox(-2.0F, -7.0F + f2, -6.5F + f1, 4, 2, 5);
		ModelRenderer neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-2.05F, -9.8F + f2, -2.0F + f1, 4, 14, 8);
		ModelRenderer mane = new ModelRenderer(this, 58, 0);
		mane.addBox(-1.0F, -11.5F + f2, 5.0F + f1, 2, 16, 4);

		if (isMule) {
			ModelRenderer muleLeftEar = new ModelRenderer(this, 0, 12);
			muleLeftEar.addBox(-2.0F, -16.0F + f2, 4.0F + f1, 2, 7, 1);
			ModelRenderer muleRightEar = new ModelRenderer(this, 0, 12);
			muleRightEar.addBox(0.0F, -16.0F + f2, 4.0F + f1, 2, 7, 1);
			setRotation(muleLeftEar, 0, 0, -0.06F);
			setRotation(muleRightEar, 0, 0, 0.06F);

			head.addChild(muleRightEar);
			head.addChild(muleLeftEar);
		} else {
			ModelRenderer horseLeftEar = new ModelRenderer(this, 0, 0);
			horseLeftEar.addBox(0.45F, -12.0F + f2, 4.0F + f1, 2, 3, 1);
			ModelRenderer horseRightEar = new ModelRenderer(this, 0, 0);
			horseRightEar.addBox(-2.45F, -12.0F + f2, 4.0F + f1, 2, 3, 1);

			head.addChild(horseRightEar);
			head.addChild(horseLeftEar);
		}

		head.addChild(head2);
		head.addChild(neck);
		head.addChild(mane);
		head.addChild(mouthTop);
		head.addChild(mouthBottom);

		hideOverlay();
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		GL11.glScaled(0.75, 0.75, 0.75);
		if (type != ItemRenderType.EQUIPPED_FIRST_PERSON)
			GL11.glTranslated(0, -0.45, 0);
	}
}