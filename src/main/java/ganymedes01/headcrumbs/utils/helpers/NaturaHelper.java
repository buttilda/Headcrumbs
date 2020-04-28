package ganymedes01.headcrumbs.utils.helpers;

import com.progwml6.natura.entities.entity.monster.EntityBabyHeatscarSpider;
import com.progwml6.natura.entities.entity.monster.EntityHeatscarSpider;
import com.progwml6.natura.entities.entity.monster.EntityNitroCreeper;
import com.progwml6.natura.entities.entity.passive.EntityImp;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.heads.SpiderHead;
import ganymedes01.headcrumbs.renderers.heads.natura.ImpHead;

public class NaturaHelper extends HeadDropHelper
{

	public static final String MOD_ID = "natura";

	public NaturaHelper()
	{
		super(MOD_ID);

		super.registerMobHead("imp", ImpHead.INSTANCE);
		super.registerMobHead("nitrocreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("flamespiderbaby", "heatscarspider", SpiderHead.INSTANCE);
	}

	@Override
	public void registerTinkersHeadDrops() {
		TConstructHelper.registerHeadDrop(EntityNitroCreeper.class);
		TConstructHelper.registerHeadDrop(EntityImp.class);
		TConstructHelper.registerHeadDrop(EntityHeatscarSpider.class);
		TConstructHelper.registerHeadDrop(EntityBabyHeatscarSpider.class);
	}
}