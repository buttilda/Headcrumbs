package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.heads.GhastHead;
import ganymedes01.headcrumbs.renderers.heads.SilverfishHead;
import ganymedes01.headcrumbs.renderers.heads.SlimeHead;
import ganymedes01.headcrumbs.renderers.heads.SpiderHead;
import ganymedes01.headcrumbs.renderers.heads.WolfHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.BighornHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.BunnyHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.DeerHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.FireBeetleHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.HydraHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.KoboldHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.LichHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.MistWolfHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.NagaTFHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.PenguinHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.PinchBeetle;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.RedcapHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.SlimeBeetleHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.SnowQueenHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.SquirrelHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.TowerGolemHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.WildBoarHead;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;

public class TwilightForestHelper extends HeadDropHelper
{
	public static final String MOD_ID = "twilightforest";

	public TwilightForestHelper()
	{
		super(MOD_ID);

		super.registerMobHeadDiffTextureBase("hostile_wolf", Strings.MC_PREFIX + "wolf/wolf_angry", WolfHead.INSTANCE);
		super.registerMobHead("bunnydutch", BunnyHead.INSTANCE);
		super.registerMobHead("penguin", PenguinHead.INSTANCE);
		super.registerMobHead("bighorn_sheep", "bighorn", BighornHead.INSTANCE);
		super.registerMobHead("wild_deer", "wilddeer", DeerHead.INSTANCE);
		super.registerMobHead("wild_boar", "wildboar", WildBoarHead.INSTANCE);
		super.registerMobHead("redcap", RedcapHead.INSTANCE);
		super.registerMobHead("redcap_snapper", "redcap", RedcapHead.INSTANCE);
		super.registerMobHead("skeleton_druid", "skeletondruid", ModelHead.INSTANCE);
		super.registerMobHead("hedge_spider", "hedgespider", SpiderHead.INSTANCE);
		super.registerMobHead("mist_wolf", "mistwolf", MistWolfHead.INSTANCE);
		super.registerMobHead("mini_ghast", "towerghast", GhastHead.INSTANCE);
		super.registerMobHead("tower_ghast", "towerghast_openeyes", GhastHead.INSTANCE);
		super.registerMobHead("king_spider", "kingspider", SpiderHead.INSTANCE);
		super.registerMobHead("twilight_kobold", "kobold", KoboldHead.INSTANCE);
		super.registerMobHead("slime_beetle", "slimebeetle", SlimeBeetleHead.INSTANCE);
		super.registerMobHead("fire_beetle", "firebeetle", FireBeetleHead.INSTANCE);
		super.registerMobHead("pinch_beetle", "pinchbeetle", PinchBeetle.INSTANCE);
		super.registerMobHead("tower_golem", "carminitegolem", TowerGolemHead.INSTANCE);
		super.registerMobHead("tower_golem", "carminitegolem", TowerGolemHead.INSTANCE);
		super.registerMobHead("bunnybrown", BunnyHead.INSTANCE);
		super.registerMobHead("bunnywhite", BunnyHead.INSTANCE);
		super.registerMobHead("forest_squirrel", "squirrel2", SquirrelHead.INSTANCE);
		super.registerMobHead("swarm_spider", "swarmspider", SpiderHead.INSTANCE);
		super.registerMobHead("redscale_broodling", "towerbroodling", SpiderHead.INSTANCE);
		super.registerMobHead("winterwolf", "winterwolf", MistWolfHead.INSTANCE);
		super.registerMobHead("mazeslime", SlimeHead.INSTANCE);
		super.registerMobHead("tower_termite", "towertermite", SilverfishHead.INSTANCE);
		super.registerMobHead("hydra", HydraHead.INSTANCE);
		super.registerMobHead("nagaTF", NagaTFHead.INSTANCE);
		super.registerMobHead("lich", LichHead.INSTANCE);
		super.registerMobHead("snowQueen", SnowQueenHead.INSTANCE);
		super.registerMobHead("urGhast", GhastHead.INSTANCE);
	}

	@Override
	public ItemStack getHeadForEntity(String entityName, Entity entity)
	{
		ItemStack head = super.getHeadForEntity(entityName, entity);
		if(head != null)
			return head;

		if(entityName == null)
			return null;

		if(entityName.equals("forest_bunny"))
		{
			Integer type;
			try
			{
				type = (Integer) entity.getClass().getMethod("getBunnyType").invoke(entity);
			} catch(Exception e)
			{
				type = 0;
			}
			String mobNameToGet = "bunnydutch";
			switch(type)
			{
				case 3:
					mobNameToGet = "bunnybrown";
					break;
				case 2:
					mobNameToGet = "bunnywhite";
					break;
			}
			return getStack(modID, mobNameToGet);
		}
		else if(entityName.equals("maze_slime") && ((EntitySlime) entity).getSlimeSize() == 1)
			return getStack(modID, "maze_slime");

		return null;
	}

	@Override
	public String getTextureLocBase()
	{
		return Strings.TF_PREFIX;
	}
}