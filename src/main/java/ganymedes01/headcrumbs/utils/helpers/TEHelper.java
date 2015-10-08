package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class TEHelper extends HeadDropHelper {

	public TEHelper() {
		super("ThermalFoundation");

		typesMap.put("Blizz", SkullTypes.blizz);
		typesMap.put("Blitz", SkullTypes.blitz);
		typesMap.put("Basalz", SkullTypes.basalz);
	}
}