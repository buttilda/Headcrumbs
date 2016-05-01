package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.DifficultyInstance;

public class joshiejack extends VIPHandler {

	@Override
	public void onSpawn(EntityHuman entity, DifficultyInstance difficulty) {
		if (entity.getHeldItem(EnumHand.MAIN_HAND) != null)
			return;
		entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.fishing_rod));
	}
}