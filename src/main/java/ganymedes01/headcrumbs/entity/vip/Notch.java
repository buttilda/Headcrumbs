package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Notch extends VIPHandler {

	@Override
	public void dropRare(EntityHuman entity, int looting) {
		if (entity.getRNG().nextBoolean())
			entity.entityDropItem(getItem(entity), 0);
	}

	@Override
	protected ItemStack getItem(EntityHuman entity) {
		return new ItemStack(Items.golden_apple, 1, 1);
	}
}