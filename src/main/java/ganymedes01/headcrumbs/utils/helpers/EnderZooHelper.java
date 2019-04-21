package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class EnderZooHelper extends HeadDropHelper {

	public static String MOD_ID = "enderiozoo";
	public EnderZooHelper() {
		super(MOD_ID);

		typesMap.put(MOD_ID + ".ConcussionCreeper", SkullTypes.concussionCreeper);
		typesMap.put(MOD_ID + ".Enderminy", SkullTypes.enderminy);
		typesMap.put(MOD_ID + ".FallenKnight", SkullTypes.fallenKnight);
		typesMap.put(MOD_ID + ".WitherWitch", SkullTypes.witherWitch);
		typesMap.put(MOD_ID + ".WitherCat", SkullTypes.witherCat);
		typesMap.put(MOD_ID + ".DireWolf", SkullTypes.direWolf);
	}
}