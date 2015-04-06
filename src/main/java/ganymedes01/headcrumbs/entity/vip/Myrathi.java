package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;

import java.awt.Color;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Myrathi extends VIPHandler {

	@Override
	protected int minDropAmount() {
		return 1;
	}

	@Override
	protected int maxBaseDropAmount() {
		return 5;
	}

	@Override
	protected ItemStack getItem(EntityCelebrity entity) {
		ItemStack trousers = new ItemStack(Items.leather_leggings);
		trousers.setItemDamage(1 + entity.getRNG().nextInt(Items.leather_leggings.getMaxDamage()));
		Items.leather_leggings.func_82813_b(trousers, new Color(entity.getRNG().nextInt(256), entity.getRNG().nextInt(256), entity.getRNG().nextInt(256)).getRGB());
		return trousers;
	}
}