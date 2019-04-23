package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.renderers.ModelHead;

public class TEHelper extends HeadDropHelper
{
	public static final String MOD_ID = "thermalfoundation";

	public TEHelper()
	{
		super(MOD_ID);

		super.registerMobHead("blizz", ModelHead.INSTANCE);
		super.registerMobHead("blitz", ModelHead.INSTANCE);
		super.registerMobHead("basalz", ModelHead.INSTANCE);
	}
}