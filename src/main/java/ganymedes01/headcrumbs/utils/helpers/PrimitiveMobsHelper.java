package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class PrimitiveMobsHelper extends ModHeadDropHelper {

	public PrimitiveMobsHelper() {
		super("primitivemobs");

		typesMap.put("primitivemobs.Summoner", SkullTypes.summoner);
		typesMap.put("primitivemobs.LilyLurker", SkullTypes.lilyLurker);
		typesMap.put("primitivemobs.SheepmanSmith", SkullTypes.sheepman);
		typesMap.put("primitivemobs.Sheepman", SkullTypes.sheepman);
		typesMap.put("primitivemobs.BlazingJuggernaut", SkullTypes.blazingJuggernaut);
		typesMap.put("primitivemobs.MotherSpider", SkullTypes.motherSpider);
		typesMap.put("primitivemobs.BabySpider", SkullTypes.babySpider);
		typesMap.put("primitivemobs.SkeletonWarrior", SkullTypes.skeletonWarrior);
		typesMap.put("primitivemobs.BrainSlime", SkullTypes.brainSlime);
		typesMap.put("primitivemobs.LostMiner", SkullTypes.lostMiner);
		typesMap.put("primitivemobs.SupportCreeper", SkullTypes.supportCreeper);
		typesMap.put("primitivemobs.FestiveCreeper", SkullTypes.festiveCreeper);
		typesMap.put("primitivemobs.RocketCreeper", SkullTypes.rocketCreeper);
	}
}