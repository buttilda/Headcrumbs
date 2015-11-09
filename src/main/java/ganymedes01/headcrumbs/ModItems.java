package ganymedes01.headcrumbs;

import java.lang.reflect.Field;

import cpw.mods.fml.common.registry.GameRegistry;
import ganymedes01.headcrumbs.items.Skull;
import net.minecraft.item.Item;

public class ModItems {

	public static final Item skull = new Skull();

	public static void init() {
		try {
			for (Field f : ModItems.class.getDeclaredFields()) {
				Object obj = f.get(null);
				if (obj instanceof Item)
					registerItem((Item) obj);
				else if (obj instanceof Item[])
					for (Item item : (Item[]) obj)
						registerItem(item);
			}
		} catch (IllegalAccessException e) {
			throw new RuntimeException(e);
		}
	}

	private static void registerItem(Item item) {
		String name = item.getUnlocalizedName();
		String[] strings = name.split("\\.");
		GameRegistry.registerItem(item, strings[strings.length - 1]);
	}
}