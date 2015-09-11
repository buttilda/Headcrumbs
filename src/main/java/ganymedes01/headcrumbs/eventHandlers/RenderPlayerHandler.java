package ganymedes01.headcrumbs.eventHandlers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.renderers.OpenGLHelper;
import ganymedes01.headcrumbs.renderers.TileEntityBlockSkullRenderer;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.RenderPlayerEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlayerHandler {

	@SubscribeEvent
	public void renderPlayerEvent(RenderPlayerEvent.Pre event) {
		if (event.entityPlayer != null) {
			ModelBiped model = event.renderer.modelBipedMain;
			if (model == null)
				return;

			ItemStack head = event.entityPlayer.inventory.armorItemInSlot(3);
			setHiddenState(model, head != null && head.getItem() == ModItems.skull);
		}
	}

	@SubscribeEvent
	public void renderHelmetEvent(RenderPlayerEvent.Specials.Post event) {
		if (event.entityPlayer != null) {
			ModelBiped model = event.renderer.modelBipedMain;

			ItemStack head = event.entityPlayer.inventory.armorItemInSlot(3);
			if (head != null && head.getItem() == ModItems.skull) {
				OpenGLHelper.colour(1.0F, 1.0F, 1.0F);

				setHiddenState(model, false);
				model.bipedHead.postRender(0.0625F);
				setHiddenState(model, true);

				OpenGLHelper.pushMatrix();
				OpenGLHelper.scale(1.0F, -1.0F, -1.0F);
				TileEntityBlockSkullRenderer.instance.renderHead(-0.5F, 0.0F, -0.5F, head);
				OpenGLHelper.popMatrix();
			}
		}
	}

	private void setHiddenState(ModelBiped model, boolean isHidden) {
		model.bipedHead.isHidden = isHidden;
		model.bipedHeadwear.isHidden = isHidden;
	}
}