package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Optional;

public class ThaumcraftHelper extends HeadDropHelper
{
	public static final String MOD_ID = "thaumcraft";

	public ThaumcraftHelper()
	{
		super(MOD_ID);

		typesMap.put(MOD_ID + ".BrainyZombie", SkullTypes.angryZombie);
		typesMap.put(MOD_ID + ".GiantBrainyZombie", SkullTypes.angryZombie);
		typesMap.put(MOD_ID + ".Firebat", SkullTypes.fireBat);
		typesMap.put(MOD_ID + ".Pech", SkullTypes.pech);
		typesMap.put(MOD_ID + ".EldritchGuardian", SkullTypes.eldritchGuardian);
		typesMap.put(MOD_ID + ".CultistKnight", SkullTypes.cultist);
		typesMap.put(MOD_ID + ".CultistCleric", SkullTypes.cultist);
		typesMap.put(MOD_ID + ".EldritchCrab", SkullTypes.eldritchCrab);

		if(Loader.isModLoaded(MOD_ID))
			addAspects();
	}

	@Optional.Method(modid = MOD_ID)
	private void addAspects()
	{
		//		AspectList aspects = new AspectList().add(Aspect.MAN, 4).add(Aspect.DEATH, 4).add(Aspect.SOUL, 4);
		//		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.player, 1, OreDictionary.WILDCARD_VALUE), aspects);
		//		ThaumcraftApi.registerObjectTag(new ItemStack(ModBlocks.skull, 1, OreDictionary.WILDCARD_VALUE), aspects);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity)
	{
		ItemStack head = super.getHeadForEntity(entity);
		if(head != null)
			return head;

		if(getThaumicSlimeSize(entity) == 1)
			return SkullTypes.thaumicSlime.getStack();

		return null;
	}

	private static int getThaumicSlimeSize(Entity entity)
	{
		//		if (entity instanceof EntityThaumicSlime)
		//			return ((EntityThaumicSlime) entity).getSlimeSize();
		return -1;
	}
}