package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class Darkosto extends VIPHandler {

    @Override
    protected ItemStack getItem(EntityHuman entity) {
	ItemStack cake = new ItemStack(Items.CAKE);
	cake.setStackDisplayName("Happy Birthday!");
	return cake;
    }
}
