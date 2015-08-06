package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.Utils;

import java.util.Random;

public class EtFuturumHelper extends HeadDropHelper {

	public EtFuturumHelper() {
		super("etfuturum");

		typesMap.put("etfuturum.endermite", SkullTypes.endermite);

		Random rand = new Random();
		int min = 1;
		int max = 1;
		int baseWeight = 3;
		Utils.addDungeonLoot(SkullTypes.guardian.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.guardianElder.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.shulker.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.rabbitBlack.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.rabbitBrown.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.rabbitCaerbannog.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.rabbitGold.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.rabbitSalt.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.rabbitToast.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.rabbitSplotched.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		Utils.addDungeonLoot(SkullTypes.rabbitWhite.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
	}
}