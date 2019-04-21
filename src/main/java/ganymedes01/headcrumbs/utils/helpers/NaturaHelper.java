package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class NaturaHelper extends HeadDropHelper
{

	public static final String MOD_ID = "natura";

	public NaturaHelper()
	{
		super(MOD_ID);

		typesMap.put(MOD_ID + ".Imp", SkullTypes.imp);
		typesMap.put(MOD_ID + ".NitroCreeper", SkullTypes.nitroCreeper);
		typesMap.put(MOD_ID + ".FlameSpiderBaby", SkullTypes.heatscarSpider);
	}
}