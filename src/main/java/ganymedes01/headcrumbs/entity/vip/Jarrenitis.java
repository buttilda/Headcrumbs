package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.entity.VIPHandler;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class Jarrenitis extends VIPHandler {

	private ItemStack held = null;

	@Override
	public void onSpawn(EntityCelebrity entity) {
		if (held == null)
			try {
				Class<?> ToolBuilder = Class.forName("tconstruct.library.crafting.ToolBuilder");
				Field f = ToolBuilder.getDeclaredField("instance");
				Object instance = f.get(null);
				Method m = instance.getClass().getMethod("buildTool", ItemStack.class, ItemStack.class, ItemStack.class, ItemStack.class, String.class);

				ItemStack rod1 = GameRegistry.findItemStack("TConstruct", "toughRod", 1);
				rod1.setItemDamage(2);
				ItemStack rod2 = rod1.copy();
				ItemStack plate = GameRegistry.findItemStack("TConstruct", "heavyPlate", 1);
				plate.setItemDamage(2);
				ItemStack blade = GameRegistry.findItemStack("TConstruct", "largeSwordBlade", 1);
				blade.setItemDamage(2);

				held = (ItemStack) m.invoke(instance, blade, rod1, plate, rod2, "Test");
				held.getTagCompound().getCompoundTag("InfiTool").setBoolean("Built", true);
			} catch (Exception e) {
				held = new ItemStack(Items.iron_sword);
				held.addEnchantment(Enchantment.knockback, 1);
			}

		entity.setCurrentItemOrArmor(0, ItemStack.copyItemStack(held));
	}
}