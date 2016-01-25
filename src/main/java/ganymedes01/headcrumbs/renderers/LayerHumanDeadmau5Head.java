package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.utils.TextureUtils;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerHumanDeadmau5Head implements LayerRenderer<EntityHuman> {

	private final RenderHuman renderer;

	public LayerHumanDeadmau5Head(RenderHuman renderer) {
		this.renderer = renderer;
	}

	@Override
	public void doRenderLayer(EntityHuman human, float p_177141_2_, float p_177141_3_, float partialTicks, float p_177141_5_, float p_177141_6_, float p_177141_7_, float scale) {
		ResourceLocation skin = TextureUtils.getPlayerSkin(human);

		if (human.getName().equals("deadmau5") && !human.isInvisible()) {
			renderer.bindTexture(skin);

			for (int i = 0; i < 2; i++) {
				float f = human.prevRotationYaw + (human.rotationYaw - human.prevRotationYaw) * partialTicks - (human.prevRenderYawOffset + (human.renderYawOffset - human.prevRenderYawOffset) * partialTicks);
				float f1 = human.prevRotationPitch + (human.rotationPitch - human.prevRotationPitch) * partialTicks;
				GlStateManager.pushMatrix();
				GlStateManager.rotate(f, 0.0F, 1.0F, 0.0F);
				GlStateManager.rotate(f1, 1.0F, 0.0F, 0.0F);
				GlStateManager.translate(0.375F * (i * 2 - 1), 0.0F, 0.0F);
				GlStateManager.translate(0.0F, -0.375F, 0.0F);
				GlStateManager.rotate(-f1, 1.0F, 0.0F, 0.0F);
				GlStateManager.rotate(-f, 0.0F, 1.0F, 0.0F);
				float size = 4F / 3F;
				GlStateManager.scale(size, size, size);
				renderer.getMainModel().renderDeadmau5Head(0.0625F);
				GlStateManager.popMatrix();
			}
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return true;
	}
}