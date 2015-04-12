package ganymedes01.headcrumbs.renderers.heads;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.model.ModelRenderer;
import net.minecraftforge.client.IItemRenderer.ItemRenderType;

import com.mojang.authlib.GameProfile;

public class EnderDragonHead extends ModelHead {

	public static final EnderDragonHead INSTANCE = new EnderDragonHead();

	protected EnderDragonHead() {
	}

	@Override
	public void init() {
		setSecondTexture(Utils.getResource(Strings.MC_PREFIX + "enderdragon/dragon_eyes.png"));

		float f1 = -14.0F;
		float f2 = -8.0F;
		textureWidth = 256;
		textureHeight = 256;

		setTextureOffset("head.upperhead", 112, 30);
		setTextureOffset("head.upperlip", 176, 44);
		setTextureOffset("head.scale", 0, 0);
		setTextureOffset("head.nostril", 112, 0);
		setTextureOffset("jaw.jaw", 176, 65);

		head = new ModelRenderer(this, "head");
		head.addBox("upperlip", -6.0F, -1.0F + f2, -8.0F + f1, 12, 5, 16);
		head.addBox("upperhead", -8.0F, -8.0F + f2, 6.0F + f1, 16, 16, 16);
		head.mirror = true;
		head.addBox("scale", -5.0F, -12.0F + f2, 12.0F + f1, 2, 4, 6);
		head.addBox("nostril", -5.0F, -3.0F + f2, -6.0F + f1, 2, 2, 4);
		head.mirror = false;
		head.addBox("scale", 3.0F, -12.0F + f2, 12.0F + f1, 2, 4, 6);
		head.addBox("nostril", 3.0F, -3.0F + f2, -6.0F + f1, 2, 2, 4);
		overlay = new ModelRenderer(this, "jaw");
		overlay.setRotationPoint(0.0F, 4.0F + f2, 8.0F + f1);
		overlay.addBox("jaw", -6.0F, 0.0F, -16.0F, 12, 4, 16);
		overlay.rotateAngleX = 0.2F;
		head.addChild(overlay);
		hideOverlay();
	}

	@Override
	public void preRender(GameProfile profile) {
		OpenGLHelper.scale(0.5, 0.5, 0.5);
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		renderLitUp(skullRotation);
	}

	@Override
	public void preRenderItem(GameProfile profile, ItemRenderType type) {
		OpenGLHelper.scale(0.75, 0.75, 0.75);
	}
}