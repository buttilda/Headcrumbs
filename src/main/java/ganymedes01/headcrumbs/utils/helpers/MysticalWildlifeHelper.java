package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.CicapteraHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.DuskLurkerHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.KrillHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.PlumperHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.VrontausaurusHead;
import lykrast.mysticalwildlife.common.entity.EntityCicaptera;
import lykrast.mysticalwildlife.common.entity.EntityDuskLurker;
import lykrast.mysticalwildlife.common.entity.EntityKrill;
import lykrast.mysticalwildlife.common.entity.EntityPlumper;
import lykrast.mysticalwildlife.common.entity.EntityVrontausaurus;
import lykrast.mysticalwildlife.common.entity.EntityYagaHog;

public class MysticalWildlifeHelper extends HeadDropHelper
{

	public static final String MOD_ID = "mysticalwildlife";

	public MysticalWildlifeHelper()
	{
		super("mysticalwildlife");

		super.registerMobHead("cicaptera_azure", CicapteraHead.INSTANCE);
		super.registerMobHead("cicaptera_crimson", CicapteraHead.INSTANCE);
		super.registerMobHead("cicaptera_sandy", CicapteraHead.INSTANCE);
		super.registerMobHead("cicaptera_verdant", CicapteraHead.INSTANCE);
		super.registerMobHead("cicaptera_wintry", CicapteraHead.INSTANCE);
		super.registerMobHead("dusk_lurker", DuskLurkerHead.INSTANCE);
		super.registerMobHead("krill", KrillHead.INSTANCE);
		super.registerMobHead("plumper", PlumperHead.INSTANCE);
		super.registerMobHead("vrontausaurus", VrontausaurusHead.INSTANCE);
		super.registerMobHead("yaga_hog", "yaga_hog_dirt", VrontausaurusHead.INSTANCE);	
	}

	@Override
	public void registerTinkersHeadDrops() {
		TConstructHelper.registerHeadDrop(EntityCicaptera.class);
		TConstructHelper.registerHeadDrop(EntityDuskLurker.class);
		TConstructHelper.registerHeadDrop(EntityKrill.class);
		TConstructHelper.registerHeadDrop(EntityPlumper.class);
		TConstructHelper.registerHeadDrop(EntityVrontausaurus.class);
		TConstructHelper.registerHeadDrop(EntityYagaHog.class);
	}
}