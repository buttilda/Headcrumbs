package ganymedes01.headcrumbs.utils.helpers;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Optional;
import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;
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
		typesMap.put("Thaumcraft.CultistKnight", SkullTypes.cultist);
		typesMap.put("Thaumcraft.CultistCleric", SkullTypes.cultist);
		typesMap.put("Thaumcraft.EldritchCrab", SkullTypes.eldritchCrab);

		if (Loader.isModLoaded("Thaumcraft"))
			addAspects();
	}

	@Optional.Method(modid = "Thaumcraft")
	private void addAspects() {
		AspectList aspects = new AspectList().add(Aspect.MAN, 4).add(Aspect.DEATH, 4).add(Aspect.SOUL, 4);
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.blockPlayer, 1, OreDictionary.WILDCARD_VALUE), aspects);
		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.blockSkull, 1, OreDictionary.WILDCARD_VALUE), aspects);
		ThaumcraftApi.registerObjectTag(new ItemStack(ModItems.skull, 1, OreDictionary.WILDCARD_VALUE), aspects);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		ItemStack head = super.getHeadForEntity(entity);
		if (head != null)
			return head;

		if (getThaumicSlimeSize(entity) == 1)
			return SkullTypes.thaumicSlime.getStack();

		return null;
	}

	private static int getThaumicSlimeSize(Entity entity) {
		if (entity instanceof EntityThaumicSlime)
			return ((EntityThaumicSlime) entity).getSlimeSize();
		return -1;
	}
}