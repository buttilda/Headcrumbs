package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class Turkey2349 extends VIPHandler {

    @Override
    protected ItemStack getItem(EntityHuman entity) {
	Block block = Block.REGISTRY.getObject(new ResourceLocation("chancecubes", "chance_Cube"));
	return block == null ? super.getItem(entity) : new ItemStack(block);
    }
}