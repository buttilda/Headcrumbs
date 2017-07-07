package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerHumanCape implements LayerRenderer<EntityHuman> {

	private final RenderHuman renderer;

	public LayerHumanCape(RenderHuman renderer) {
		this.renderer = renderer;
	}

	@Override
	public void doRenderLayer(EntityHuman human, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		ResourceLocation cape = TextureUtils.getPlayerCape(human);

		if (!human.isInvisible() && cape != null) {
			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
			renderer.bindTexture(cape);
			GlStateManager.pushMatrix();
			GlStateManager.translate(0.0F, 0.0F, 0.125F);
			double d0 = human.getInterpolatedCapeX(partialTicks);
			double d1 = human.getInterpolatedCapeY(partialTicks);
			double d2 = human.getInterpolatedCapeZ(partialTicks);
			float f = human.prevRenderYawOffset + (human.renderYawOffset - human.prevRenderYawOffset) * partialTicks;
			double d3 = MathHelper.sin(f * (float) Math.PI / 180.0F);
			double d4 = -MathHelper.cos(f * (float) Math.PI / 180.0F);
			float f1 = (float) d1 * 10.0F;
			f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
			float f2 = (float) (d0 * d3 + d2 * d4) * 100.0F;
			float f3 = (float) (d0 * d4 - d2 * d3) * 100.0F;

			if (f2 < 0.0F)
				f2 = 0.0F;

			float f4 = human.prevRenderYawOffset + (human.renderYawOffset - human.prevRenderYawOffset) * partialTicks;
			f1 = f1 + MathHelper.sin((human.prevDistanceWalkedModified + (human.distanceWalkedModified - human.prevDistanceWalkedModified) * partialTicks) * 6.0F) * 32.0F * f4;

			if (human.isSneaking())
				f1 += 25.0F;

			if (human.isChild()) {
				GlStateManager.scale(0.5F, 0.5F, 0.5F);
				GlStateManager.translate(0.0F, 24.0F * scale, -2F * scale);
			}

			GlStateManager.rotate(6.0F + f2 / 2.0F + f1, 1.0F, 0.0F, 0.0F);
			GlStateManager.rotate(f3 / 2.0F, 0.0F, 0.0F, 1.0F);
			GlStateManager.rotate(-f3 / 2.0F, 0.0F, 1.0F, 0.0F);
			GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
			renderer.getMainModel().renderCape(0.0625F);
			GlStateManager.popMatrix();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}