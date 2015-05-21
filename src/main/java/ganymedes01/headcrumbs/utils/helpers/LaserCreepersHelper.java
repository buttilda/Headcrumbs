package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class LaserCreepersHelper extends HeadDropHelper {

	public LaserCreepersHelper() {
		super("lasercreepers");

		typesMap.put("lasercreepers.laserCreeper", SkullTypes.laserCreeper);
		typesMap.put("lasercreepers.roboDino", SkullTypes.roboDino);
		typesMap.put("lasercreepers.jetPackSpider", SkullTypes.jetPackSpider);
	}
}