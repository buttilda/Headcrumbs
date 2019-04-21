package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class MysticalWildlifeHelper extends HeadDropHelper {

	public static String MOD_ID = "mysticalwildlife";
	
	public MysticalWildlifeHelper() {
		super("mysticalwildlife");

		typesMap.put(MOD_ID + ".vrontausaurus", SkullTypes.vrontausaurus);
		typesMap.put(MOD_ID + ".yaga_hog", SkullTypes.yagaHog);
		typesMap.put(MOD_ID + ".dusk_lurker", SkullTypes.duskLurker);
		typesMap.put(MOD_ID + ".cicaptera_azure", SkullTypes.cicapteraAzure);
		typesMap.put(MOD_ID + ".cicaptera_verdant", SkullTypes.cicapteraVerdant);
		typesMap.put(MOD_ID + ".cicaptera_crimson", SkullTypes.cicapteraCrimson);
		typesMap.put(MOD_ID + ".cicaptera_sandy", SkullTypes.cicapteraSandy);
		typesMap.put(MOD_ID + ".cicaptera_wintry", SkullTypes.cicapteraWintry);
		typesMap.put(MOD_ID + ".plumper", SkullTypes.plumper);
		typesMap.put(MOD_ID + ".krill", SkullTypes.krill);
	}
}