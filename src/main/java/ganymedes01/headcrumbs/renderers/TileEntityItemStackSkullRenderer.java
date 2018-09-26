package ganymedes01.headcrumbs.renderers;

import net.minecraft.client.renderer.tileentity.TileEntityItemStackRenderer;
import net.minecraft.client.renderer.tileentity.TileEntitySkullRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class TileEntityItemStackSkullRenderer extends TileEntityItemStackRenderer {

	public void func_192838_a(ItemStack p_192838_1_, float p_192838_2_) {
		TileEntityBlockSkullRenderer.INSTANCE.renderSkull(0.0F, 0.0F, 0.0F, EnumFacing.UP, 180.0F, p_192838_1_.getMetadata(), gameprofile, -1, 0.0F);
	}
}
