package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class C418 extends VIPHandler {

	@Override
	protected int maxDropAmount() {
		return 1;
	}

	@Override
	protected ItemStack getItem(EntityHuman entity) {
		int i = Item.getIdFromItem(Items.record_13);
		int j = Item.getIdFromItem(Items.record_wait);

		return new ItemStack(Item.getItemById(i + entity.getRNG().nextInt(j - i + 1)));
	}
}