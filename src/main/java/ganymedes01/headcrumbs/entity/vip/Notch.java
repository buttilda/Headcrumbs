package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Notch extends VIPHandler {

	@Override
	public void dropItems(EntityCelebrity entity, int looting) {
		if (entity.getRNG().nextFloat() < 0.05F)
			entity.entityDropItem(getItem(entity), 0);
		else
			super.dropItems(entity, looting);
	}

	@Override
	protected ItemStack getItem(EntityCelebrity entity) {
		return new ItemStack(Items.golden_apple, 1, 1);
	}
}