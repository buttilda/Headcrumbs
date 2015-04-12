package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import com.mojang.authlib.GameProfile;

public class PlayerHead extends ModelHead {

	public static final PlayerHead INSTANCE = new PlayerHead();

	private ModelRenderer earLeft, earRight;

	protected PlayerHead() {
	}

	@Override
	public void init() {
		earLeft = new ModelRenderer(this, 24, 0);
		earLeft.addBox(-7.5F, -10.5F, -1.0F, 6, 6, 1);
		earRight = new ModelRenderer(this, 24, 0);
		earRight.addBox(1.5F, -10.5F, -1.0F, 6, 6, 1);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		if (profile != null && "deadmau5".equals(profile.getName())) {
			OpenGLHelper.scale(0.85F, 0.85F, 0.85F);
			OpenGLHelper.translate(0, -0.2F, 0);
		}
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		if (profile != null && "deadmau5".equals(profile.getName())) {
			setRotation(earLeft, head.rotateAngleX, head.rotateAngleY, head.rotateAngleZ);
			setRotation(earRight, head.rotateAngleX, head.rotateAngleY, head.rotateAngleZ);

			OpenGLHelper.scale(4F / 3F, 4F / 3F, 4F / 3F);
			earLeft.render(0.0625F);
			earRight.render(0.0625F);
		}
	}
}