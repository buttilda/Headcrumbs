package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Notch extends VIPHandler {

	@Override
	public void dropItems(EntityHuman entity, int looting) {
		super.dropItems(entity, looting);

		if (entity.getRNG().nextFloat() > 0.80F)
			entity.entityDropItem(new ItemStack(Items.GOLDEN_APPLE, 1, 1), 0);
	}
}