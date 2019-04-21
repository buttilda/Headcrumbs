package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class LaserCreepersHelper extends HeadDropHelper
{

	public static String MOD_ID = "lcrdrfs";

	public LaserCreepersHelper()
	{
		super(MOD_ID);

		typesMap.put(MOD_ID + ".laserCreeper", SkullTypes.laserCreeper);
		typesMap.put(MOD_ID + ".roboDino", SkullTypes.roboDino);
		typesMap.put(MOD_ID + ".jetPackSpider", SkullTypes.jetPackSpider);
	}
}