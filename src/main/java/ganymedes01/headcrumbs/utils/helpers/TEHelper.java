package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class TEHelper extends HeadDropHelper
{
	public static final String MOD_ID = "thermalfoundation";

	public TEHelper()
	{
		super(MOD_ID);

		typesMap.put("Blizz", SkullTypes.blizz);
		typesMap.put("Blitz", SkullTypes.blitz);
		typesMap.put("Basalz", SkullTypes.basalz);
	}
}