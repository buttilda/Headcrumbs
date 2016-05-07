package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;

public class direwolf20 extends VIPHandler {

	@Override
	public void onSpawn(EntityHuman entity, DifficultyInstance difficulty) {
		Item wrench = Item.itemRegistry.getObject(new ResourceLocation("BuildCraft|Core", "wrenchItem"));
		if (wrench != null)
			entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(wrench));
	}
}