package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.renderers.ModelHead;
import net.minecraft.client.model.ModelRenderer;

import org.lwjgl.opengl.GL11;

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
	public void preRender(GameProfile profile) {
		if (profile != null && "deadmau5".equals(profile.getName())) {
			GL11.glScalef(0.85F, 0.85F, 0.85F);
			GL11.glTranslatef(0, 0.0625F, 0);
		}
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		if (profile != null && "deadmau5".equals(profile.getName())) {
			setRotation(earLeft, head.rotateAngleX, head.rotateAngleY, head.rotateAngleZ);
			setRotation(earRight, head.rotateAngleX, head.rotateAngleY, head.rotateAngleZ);

			GL11.glScalef(4F / 3F, 4F / 3F, 4F / 3F);
			earLeft.render(0.0625F);
			earRight.render(0.0625F);
		}
	}
}