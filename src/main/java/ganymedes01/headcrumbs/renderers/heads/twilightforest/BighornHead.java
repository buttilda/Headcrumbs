package ganymedes01.headcrumbs.renderers.heads.twilightforest;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import ganymedes01.headcrumbs.renderers.heads.SheepHead;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.passive.EntitySheep;

public class BighornHead extends SheepHead {

	public static final BighornHead INSTANCE = new BighornHead();

	protected BighornHead() {
	}

	@Override
	public void init() {
		super.init();
		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3.0F, -7.0F, -4.5F, 6, 6, 7, 0.0F);
		head.setRotationPoint(0.0F, 0.0F, 0.0F);

		head.setTextureOffset(28, 16).addBox(-5.0F, -7.0F, -1.0F, 2, 2, 2, 0.0F);
		head.setTextureOffset(16, 13).addBox(-6.0F, -8.0F, 0.0F, 2, 2, 4, 0.0F);
		head.setTextureOffset(16, 19).addBox(-7.0F, -7.0F, 3.0F, 2, 5, 2, 0.0F);
		head.setTextureOffset(18, 27).addBox(-8.0F, -3.0F, 1.0F, 2, 2, 3, 0.0F);
		head.setTextureOffset(28, 27).addBox(-9.0F, -4.0F, 0.0F, 2, 2, 1, 0.0F);

		head.setTextureOffset(28, 16).addBox(3.0F, -7.0F, -1.0F, 2, 2, 2, 0.0F);
		head.setTextureOffset(16, 13).addBox(4.0F, -8.0F, 0.0F, 2, 2, 4, 0.0F);
		head.setTextureOffset(16, 19).addBox(5.0F, -7.0F, 3.0F, 2, 5, 2, 0.0F);
		head.setTextureOffset(18, 27).addBox(6.0F, -3.0F, 1.0F, 2, 2, 3, 0.0F);
		head.setTextureOffset(28, 27).addBox(7.0F, -4.0F, 0.0F, 2, 2, 1, 0.0F);

		overlay = new ModelRenderer(this, 0, 0);
		overlay.addBox(-3.0F, -7.0F, -2.5F, 6, 6, 6, 0.6F);
		hideOverlay();
	}

	@Override
	public void renderSpecial(GameProfile profile, float skullRotation) {
		int colour = 12;
		OpenGLHelper.colour(EntitySheep.fleeceColorTable[colour][0], EntitySheep.fleeceColorTable[colour][1], EntitySheep.fleeceColorTable[colour][2]);
		renderOverlay(skullRotation);
	}
}