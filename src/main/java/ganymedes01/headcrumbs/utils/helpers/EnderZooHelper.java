package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.heads.OcelotHead;
import ganymedes01.headcrumbs.renderers.heads.WitchHead;
import ganymedes01.headcrumbs.renderers.heads.enderzoo.DireWolfHead;
import ganymedes01.headcrumbs.renderers.heads.enderzoo.EnderminyHead;

public class EnderZooHelper extends HeadDropHelper
{

	public static final String MOD_ID = "enderiozoo";

	public EnderZooHelper()
	{
		super(MOD_ID);

		super.registerMobHead("concussioncreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("enderminy", EnderminyHead.INSTANCE);
		super.registerMobHead("fallenknight", "fallen_knight", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("witherwitch", "wither_witch", WitchHead.INSTANCE);
		super.registerMobHead("withercat", "dire_wolf", DireWolfHead.INSTANCE);
		super.registerMobHead("direwolf", "wither_cat_angry", OcelotHead.INSTANCE);
	}

	@Override
	public String getTextureLocBase()
	{
		return Strings.EZ_PREFIX;
	}

	@Override
	public void registerTinkersHeadDrops() {
//		TConstructHelper.registerHeadDrop(EntityCo);
	}
}