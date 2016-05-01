package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;

public class Jarrenitis extends VIPHandler {

	private ItemStack held = null;

	@Override
	public void onSpawn(EntityHuman entity, DifficultyInstance difficulty) {
		held = new ItemStack(Items.iron_sword);
		held.addEnchantment(Enchantments.knockback, 1);
		held.setStackDisplayName("Ultimus?");

		entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, ItemStack.copyItemStack(held));
	}
}