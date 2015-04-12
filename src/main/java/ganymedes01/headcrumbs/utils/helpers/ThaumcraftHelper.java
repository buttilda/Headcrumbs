package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import thaumcraft.common.entities.monster.EntityThaumicSlime;

public class ThaumcraftHelper extends HeadDropHelper {

	public ThaumcraftHelper() {
		super("Thaumcraft");

		typesMap.put("Thaumcraft.BrainyZombie", SkullTypes.angryZombie);
		typesMap.put("Thaumcraft.GiantBrainyZombie", SkullTypes.angryZombie);
		typesMap.put("Thaumcraft.Firebat", SkullTypes.fireBat);
		typesMap.put("Thaumcraft.TaintedChicken", SkullTypes.taintedChicken);
		typesMap.put("Thaumcraft.TaintedCow", SkullTypes.taintedCow);
		typesMap.put("Thaumcraft.TaintedPig", SkullTypes.taintedPig);
		typesMap.put("Thaumcraft.TaintedCreeper", SkullTypes.taintedCreeper);
		typesMap.put("Thaumcraft.TaintedVillager", SkullTypes.taintedVillager);
		typesMap.put("Thaumcraft.TaintedSheep", SkullTypes.taintedSheep);
		typesMap.put("Thaumcraft.Pech", SkullTypes.pech);
		typesMap.put("Thaumcraft.EldritchGuardian", SkullTypes.eldritchGuardian);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		ItemStack head = super.getHeadForEntity(entity);
		if (head != null)
			return head;

		if (getThaumicSlimeSize(entity) == 1)
			return new ItemStack(ModItems.skull, 1, SkullTypes.thaumicSlime.ordinal());

		return null;
	}

	private static int getThaumicSlimeSize(Entity entity) {
		if (entity instanceof EntityThaumicSlime)
			return ((EntityThaumicSlime) entity).getSlimeSize();
		return -1;
	}
}