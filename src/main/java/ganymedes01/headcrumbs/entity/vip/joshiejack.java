package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class joshiejack extends VIPHandler {

	@Override
	public void onSpawn(EntityCelebrity entity) {
		ItemStack rod = new ItemStack(Items.fishing_rod);
		if (entity.getRNG().nextFloat() < 0.25F)
			EnchantmentHelper.addRandomEnchantment(entity.getRNG(), rod, 5 + entity.getRNG().nextInt(18));

		entity.setCurrentItemOrArmor(0, rod);
	}
}