package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.libs.ItemRenderType;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;

public class TileEntityItemStackSkullRenderer extends TileEntityItemStackRenderer {
	
	@Override
	public void renderByItem(ItemStack stack, float partialTicks) {
		HeadUtils.getModel(stack).getModel().preRenderItem(HeadUtils.getGameProfile(stack), ItemRenderType.INVENTORY);
		TileEntityBlockSkullRenderer.INSTANCE.renderHead(0.0F, -0.1F, 0.0F, stack.getMetadata(), 0f,
				HeadUtils.getModel(stack), HeadUtils.getGameProfile(stack), -1);
	}
}
