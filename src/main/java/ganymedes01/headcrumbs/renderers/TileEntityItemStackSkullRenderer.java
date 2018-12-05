package ganymedes01.headcrumbs.renderers;

import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.item.ItemStack;

public class TileEntityItemStackSkullRenderer extends TileEntityItemStackRenderer {

	public void func_192838_a(ItemStack stack, float p_192838_2_) {
		System.out.println("gere");
		TileEntityBlockSkullRenderer.INSTANCE.renderHead(0.0F, 0.0F, 0.0F, stack.getMetadata(), 0f,
				HeadUtils.getModel(stack), HeadUtils.getGameProfile(stack), -1);
	}
}
