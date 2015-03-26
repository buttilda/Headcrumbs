package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;

public class NaturaHelper extends ModHeadDropHelper {

	public NaturaHelper() {
		super("Natura");

		typesMap.put("Natura.Imp", SkullTypes.imp);
		typesMap.put("Natura.NitroCreeper", SkullTypes.nitroCreeper);
		typesMap.put("Natura.FlameSpiderBaby", SkullTypes.heatscarSpider);
	}
}