package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class Soaryn extends VIPHandler {

	@Override
	protected ItemStack getItem(EntityCelebrity entity) {
		return new ItemStack(Blocks.chest);
	}
}