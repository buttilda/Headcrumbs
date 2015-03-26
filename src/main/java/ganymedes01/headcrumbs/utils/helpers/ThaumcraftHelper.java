package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import thaumcraft.common.entities.monster.EntityThaumicSlime;

public class ThaumcraftHelper extends ModHeadDropHelper {

	public ThaumcraftHelper() {
		super("Thaumcraft");

		typesMap.put("BrainyZombie", SkullTypes.angryZombie);
		typesMap.put("GiantBrainyZombie", SkullTypes.angryZombie);
		typesMap.put("Firebat", SkullTypes.fireBat);
		typesMap.put("TaintedChicken", SkullTypes.taintedChicken);
		typesMap.put("TaintedCow", SkullTypes.taintedCow);
		typesMap.put("TaintedPig", SkullTypes.taintedPig);
		typesMap.put("TaintedCreeper", SkullTypes.taintedCreeper);
		typesMap.put("TaintedVillager", SkullTypes.taintedVillager);
		typesMap.put("TaintedSheep", SkullTypes.taintedSheep);
		typesMap.put("Pech", SkullTypes.pech);
		typesMap.put("EldritchGuardian", SkullTypes.eldritchGuardian);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		int dot = mobName.indexOf('.') + 1;
		if (dot >= 0) {
			mobName = mobName.substring(dot);

			if (mobName.equals("ThaumSlime") && getThaumicSlimeSize(entity) == 1)
				return new ItemStack(ModItems.skull, 1, SkullTypes.thaumicSlime.ordinal());
			else {
				SkullTypes type = typesMap.get(mobName);
				if (type != null)
					return new ItemStack(ModItems.skull, 1, type.ordinal());
			}
		}

		return null;
	}

	private static int getThaumicSlimeSize(Entity entity) {
		if (entity instanceof EntityThaumicSlime)
			return ((EntityThaumicSlime) entity).getSlimeSize();
		return 0;
	}
}