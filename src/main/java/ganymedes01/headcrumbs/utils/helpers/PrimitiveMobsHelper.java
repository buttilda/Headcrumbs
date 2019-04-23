package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.heads.SlimeHead;
import ganymedes01.headcrumbs.renderers.heads.SpiderHead;
import ganymedes01.headcrumbs.renderers.heads.VillagerHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.JuggernautHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.LilyLurkerHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.SheepmanHead;

public class PrimitiveMobsHelper extends HeadDropHelper
{
	public static final String MOD_ID = "primitivemobs";

	public PrimitiveMobsHelper()
	{
		super(MOD_ID);

		super.registerMobHead("rocketcreeper", "rocketcreeper/rocketcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("festivecreeper", "festivecreeper/festivecreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("supportcreeper", "supportcreeper/supportcreeper", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("lostminer", "villager/lostminer", VillagerHead.INSTANCE128x64);
		super.registerMobHead("sheepman", "villager/sheepman", SheepmanHead.INSTANCE);
		super.registerMobHead("sheepmansmith", "villager/sheepman", SheepmanHead.INSTANCE);
		super.registerMobHead("wizard", "villager/wizard", VillagerHead.INSTANCE64);
		super.registerMobHead("blazingjuggernaut", "blazingjuggernaut/blazingjuggernaut", JuggernautHead.INSTANCE);
		super.registerMobHead("lilylurker", "lilylurker/lilylurker", LilyLurkerHead.INSTANCE);
		super.registerMobHead("motherspider", "spiderfamily/motherspider", SpiderHead.INSTANCE);
		super.registerMobHead("babyspider", "spiderfamily/babyspider", SpiderHead.INSTANCE);
		super.registerMobHead("skeletonwarrior", "skeletonwarrior/skeletonwarrior", ModelHead.INSTANCE);
		super.registerMobHead("brainslime", "brainslime/slime_brain", SlimeHead.INSTANCE);
	}
}