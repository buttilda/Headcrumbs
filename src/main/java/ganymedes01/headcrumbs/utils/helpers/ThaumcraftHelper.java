package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;

public class ThaumcraftHelper {

	private static final Map<String, SkullTypes> map = new HashMap<String, SkullTypes>();
	static {
		map.put("BrainyZombie", SkullTypes.angryZombie);
		map.put("GiantBrainyZombie", SkullTypes.angryZombie);
		map.put("Firebat", SkullTypes.fireBat);
		map.put("TaintedChicken", SkullTypes.taintedChicken);
		map.put("TaintedCow", SkullTypes.taintedCow);
		map.put("TaintedPig", SkullTypes.taintedPig);
		map.put("TaintedCreeper", SkullTypes.taintedCreeper);
		map.put("TaintedVillager", SkullTypes.taintedVillager);
		map.put("TaintedSheep", SkullTypes.taintedSheep);
		map.put("Pech", SkullTypes.pech);
		map.put("EldritchGuardian", SkullTypes.eldritchGuardian);
	}

	public static ItemStack getHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		int dot = mobName.indexOf('.') + 1;
		if (dot >= 0) {
			mobName = mobName.substring(dot);

			if (mobName.equals("ThaumSlime") && getThaumicSlimeSize(entity) == 1)
				return new ItemStack(ModItems.skull, 1, SkullTypes.thaumicSlime.ordinal());
			else {
				SkullTypes type = map.get(mobName);
				if (type != null)
					return new ItemStack(ModItems.skull, 1, type.ordinal());
			}
		}

		return null;
	}

	private static int getThaumicSlimeSize(Entity entity) {
		try {
			Method m = entity.getClass().getMethod("getSlimeSize");
			return (Integer) m.invoke(entity);
		} catch (Exception e) {
			return 0;
		}
	}
}