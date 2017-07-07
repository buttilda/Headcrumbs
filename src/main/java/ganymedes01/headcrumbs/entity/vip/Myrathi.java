package ganymedes01.headcrumbs.entity.vip;

import java.awt.Color;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
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
	protected ItemStack getItem(EntityHuman entity) {
		ItemStack trousers = new ItemStack(Items.LEATHER_LEGGINGS);
		trousers.setItemDamage(1 + entity.getRNG().nextInt(Items.LEATHER_LEGGINGS.getMaxDamage(trousers)));
		Items.LEATHER_LEGGINGS.setColor(trousers, new Color(entity.getRNG().nextInt(256), entity.getRNG().nextInt(256), entity.getRNG().nextInt(256), 0).getRGB());
		return trousers;
	}
}