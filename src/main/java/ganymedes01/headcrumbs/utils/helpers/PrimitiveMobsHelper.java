package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class PrimitiveMobsHelper extends HeadDropHelper
{
	public static String MOD_ID = "primitivemobs";

	public PrimitiveMobsHelper()
	{
		super(MOD_ID);

		typesMap.put(MOD_ID + ".Summoner", SkullTypes.summoner);
		typesMap.put(MOD_ID + ".LilyLurker", SkullTypes.lilyLurker);
		typesMap.put(MOD_ID + ".SheepmanSmith", SkullTypes.sheepman);
		typesMap.put(MOD_ID + ".Sheepman", SkullTypes.sheepman);
		typesMap.put(MOD_ID + ".BlazingJuggernaut", SkullTypes.blazingJuggernaut);
		typesMap.put(MOD_ID + ".MotherSpider", SkullTypes.motherSpider);
		typesMap.put(MOD_ID + ".BabySpider", SkullTypes.babySpider);
		typesMap.put(MOD_ID + ".SkeletonWarrior", SkullTypes.skeletonWarrior);
		typesMap.put(MOD_ID + ".BrainSlime", SkullTypes.brainSlime);
		typesMap.put(MOD_ID + ".LostMiner", SkullTypes.lostMiner);
		typesMap.put(MOD_ID + ".SupportCreeper", SkullTypes.supportCreeper);
		typesMap.put(MOD_ID + ".FestiveCreeper", SkullTypes.festiveCreeper);
		typesMap.put(MOD_ID + ".RocketCreeper", SkullTypes.rocketCreeper);
	}
}