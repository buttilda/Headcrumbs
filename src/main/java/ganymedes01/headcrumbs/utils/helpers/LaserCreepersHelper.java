package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.renderers.heads.lasercreeper.JetPackSpiderHead;
import ganymedes01.headcrumbs.renderers.heads.lasercreeper.LaserCreeperHead;
import ganymedes01.headcrumbs.renderers.heads.lasercreeper.RoboDinoHead;

public class LaserCreepersHelper extends HeadDropHelper
{

	public static final String MOD_ID = "lcrdrfs";

	public LaserCreepersHelper()
	{
		super(MOD_ID);

		super.registerMobHead("laserCreeper", "laser_creeper", LaserCreeperHead.INSTANCE);
		super.registerMobHead("roboDino", "robo_dino", RoboDinoHead.INSTANCE);
		super.registerMobHead("jetPackSpider", "jet_pack_spider", JetPackSpiderHead.INSTANCE);
	}

	@Override
	public void registerTinkersHeadDrops() {
	}
}