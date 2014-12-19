package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Myrathi extends VIPHandler {

	@Override
	protected int minDropAmount() {
		return 1;
	}

	@Override
	protected int maxDropAmount() {
		return 5;
	}

	@Override
	protected ItemStack getItem(EntityCelebrity entity) {
		ItemStack stack = new ItemStack(Items.leather_leggings);
		stack.setItemDamage(1 + entity.getRNG().nextInt(Items.leather_leggings.getMaxDamage()));
		return stack;
	}
}