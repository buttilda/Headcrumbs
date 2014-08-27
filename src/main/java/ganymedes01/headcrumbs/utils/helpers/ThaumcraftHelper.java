package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;

import java.lang.reflect.Method;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;

public class ThaumcraftHelper {

	public static ItemStack getHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		else if (mobName.equals("Thaumcraft.BrainyZombie") || mobName.equals("Thaumcraft.GiantBrainyZombie"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.angryZombie.ordinal());
		else if (mobName.equals("Thaumcraft.Firebat"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.fireBat.ordinal());
		else if (mobName.equals("Thaumcraft.ThaumSlime") && getThaumicSlimeSize(entity) == 1)
			return new ItemStack(ModItems.skull, 1, SkullTypes.thaumicSlime.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedChicken"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedChicken.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedCow"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedCow.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedPig"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedPig.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedCreeper"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedCreeper.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedVillager"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedVillager.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedSheep"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedVillager.ordinal());
		else if (mobName.equals("Thaumcraft.Pech"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.pech.ordinal());
		else if (mobName.equals("Thaumcraft.EldritchGuardian"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.eldritchGuardian.ordinal());

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