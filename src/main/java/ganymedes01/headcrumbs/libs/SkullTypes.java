package ganymedes01.headcrumbs.libs;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.heads.BatHead;
import ganymedes01.headcrumbs.renderers.heads.ChickenHead;
import ganymedes01.headcrumbs.renderers.heads.CowHead;
import ganymedes01.headcrumbs.renderers.heads.EnderDragonHead;
import ganymedes01.headcrumbs.renderers.heads.EndermanHead;
import ganymedes01.headcrumbs.renderers.heads.GhastHead;
import ganymedes01.headcrumbs.renderers.heads.HorseHead;
import ganymedes01.headcrumbs.renderers.heads.MagmaCubeHead;
import ganymedes01.headcrumbs.renderers.heads.MooshroomHead;
import ganymedes01.headcrumbs.renderers.heads.OcelotHead;
import ganymedes01.headcrumbs.renderers.heads.PigHead;
import ganymedes01.headcrumbs.renderers.heads.PigmanHead;
import ganymedes01.headcrumbs.renderers.heads.SheepHead;
import ganymedes01.headcrumbs.renderers.heads.SilverfishHead;
import ganymedes01.headcrumbs.renderers.heads.SlimeHead;
import ganymedes01.headcrumbs.renderers.heads.SnowmanHead;
import ganymedes01.headcrumbs.renderers.heads.SpiderHead;
import ganymedes01.headcrumbs.renderers.heads.SquidHead;
import ganymedes01.headcrumbs.renderers.heads.VillagerHead;
import ganymedes01.headcrumbs.renderers.heads.WitchHead;
import ganymedes01.headcrumbs.renderers.heads.WitherHead;
import ganymedes01.headcrumbs.renderers.heads.WolfHead;
import ganymedes01.headcrumbs.renderers.heads.ZombieVillagerHead;
import ganymedes01.headcrumbs.renderers.heads.enderzoo.DireWolfHead;
import ganymedes01.headcrumbs.renderers.heads.enderzoo.EnderminyHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.AnubisHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.BansheeHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.BaphometHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.CentaurHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.CobbleGolemHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.CobblestoneGolemHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.CockatriceHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.CyclopsHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DhampirHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DryadHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DullahanHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.EnderDragonGirlHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.EnderEyeHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.FleshLichHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.FutakuchiOnnaHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.GryphonHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.HarpyHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.HunterHead;
import ganymedes01.headcrumbs.renderers.heads.lycanites.BehemothHead;
import ganymedes01.headcrumbs.renderers.heads.lycanites.BelphHead;
import ganymedes01.headcrumbs.renderers.heads.lycanites.PinkyHead;
import ganymedes01.headcrumbs.renderers.heads.natura.ImpHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.JuggernautHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.LilyLurkerHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.SheepmanHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.EldrichGuardianHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.PechHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.TaintedSheepHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.BighornHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.BunnyHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.DeerHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.FireBeetleHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.KoboldHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.MistWolfHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.PenguinHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.PinchBeetle;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.RedcapHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.SlimeBeetleHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.SquirrelHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.TowerGolemHead;
import ganymedes01.headcrumbs.renderers.heads.twilightforest.WildBoarHead;
import ganymedes01.headcrumbs.utils.TextureUtils;
import ganymedes01.headcrumbs.utils.Utils;
import ganymedes01.headcrumbs.utils.helpers.LycanitesHelperClient;
import net.minecraft.util.ResourceLocation;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.Loader;

public enum SkullTypes {

	// @formatter:off
	player				(null, 														null, 					ModelHead.INSTANCE),
	blaze				(Strings.MC_PREFIX + "blaze", 								null, 					ModelHead.INSTANCE),
	enderman			(Strings.MC_PREFIX + "enderman/enderman", 					null, 					EndermanHead.INSTANCE),
	pigman				(Strings.MC_PREFIX + "zombie_pigman", 						null, 					PigmanHead.INSTANCE),
	spider				(Strings.MC_PREFIX + "spider/spider", 						null, 					SpiderHead.INSTANCE),
	caveSpider			(Strings.MC_PREFIX + "spider/cave_spider",					null, 					SpiderHead.INSTANCE),
	pig					(Strings.MC_PREFIX + "pig/pig", 							null, 					PigHead.INSTANCE),
	cow					(Strings.MC_PREFIX + "cow/cow", 							null, 					CowHead.INSTANCE),
	mooshroom			(Strings.MC_PREFIX + "cow/mooshroom", 						null, 					MooshroomHead.INSTANCE),
	sheep				(Strings.MC_PREFIX + "sheep/sheep", 						null, 					SheepHead.INSTANCE),
	wolf				(Strings.MC_PREFIX + "wolf/wolf", 							null, 					WolfHead.INSTANCE),
	villager			(Strings.MC_PREFIX + "villager/villager", 					null, 					VillagerHead.INSTANCE64),
	chicken				(Strings.MC_PREFIX + "chicken", 							null, 					ChickenHead.INSTANCE),
	witch				(Strings.MC_PREFIX + "witch", 								null, 					WitchHead.INSTANCE),
	zombieVillager		(Strings.MC_PREFIX + "zombie/zombie_villager",				null, 					ZombieVillagerHead.INSTANCE),
	ironGolem			(Strings.MC_PREFIX + "iron_golem", 							null, 					VillagerHead.INSTANCE128),
	squid				(Strings.MC_PREFIX + "squid", 								null, 					SquidHead.INSTANCE),
	wither				(Strings.MC_PREFIX + "wither/wither", 						null, 					WitherHead.INSTANCE),
	bunnyDutch			(Strings.TF_PREFIX + "bunnydutch", 							"TwilightForest", 		BunnyHead.INSTANCE),
	penguin				(Strings.TF_PREFIX + "penguin", 							"TwilightForest", 		PenguinHead.INSTANCE),
	bighorn				(Strings.TF_PREFIX + "bighorn", 							"TwilightForest", 		BighornHead.INSTANCE),
	wildDeer			(Strings.TF_PREFIX + "wilddeer", 							"TwilightForest", 		DeerHead.INSTANCE),
	wildBoar			(Strings.TF_PREFIX + "wildboar", 							"TwilightForest", 		WildBoarHead.INSTANCE),
	redcap				(Strings.TF_PREFIX + "redcap", 								"TwilightForest", 		RedcapHead.INSTANCE),
	druid				(Strings.TF_PREFIX + "skeletondruid", 						"TwilightForest", 		ModelHead.INSTANCE),
	hedgeSpider			(Strings.TF_PREFIX + "hedgespider", 						"TwilightForest", 		SpiderHead.INSTANCE),
	ghast				(Strings.MC_PREFIX + "ghast/ghast", 						null, 					GhastHead.INSTANCE),
	blizz				(Strings.TE_PREFIX + "Blizz", 								"ThermalFoundation",	ModelHead.INSTANCE),
	mistWolf			(Strings.TF_PREFIX + "mistwolf", 							"TwilightForest", 		MistWolfHead.INSTANCE),
	miniGhast			(Strings.TF_PREFIX + "towerghast", 							"TwilightForest",		GhastHead.INSTANCE),
	guardGhast			(Strings.TF_PREFIX + "towerghast_openeyes", 				"TwilightForest", 		GhastHead.INSTANCE),
	kingSpider			(Strings.TF_PREFIX + "kingspider", 							"TwilightForest", 		SpiderHead.INSTANCE),
	kobold				(Strings.TF_PREFIX + "kobold", 								"TwilightForest", 		KoboldHead.INSTANCE),
	slimeBeetle			(Strings.TF_PREFIX + "slimebeetle", 						"TwilightForest", 		SlimeBeetleHead.INSTANCE),
	fireBeetle			(Strings.TF_PREFIX + "firebeetle", 							"TwilightForest", 		FireBeetleHead.INSTANCE),
	pinchBeetle			(Strings.TF_PREFIX + "pinchbeetle", 						"TwilightForest", 		PinchBeetle.INSTANCE),
	towerGolem			(Strings.TF_PREFIX + "carminitegolem", 						"TwilightForest", 		TowerGolemHead.INSTANCE),
	enderDragon			(Strings.MC_PREFIX + "enderdragon/dragon", 					null, 					EnderDragonHead.INSTANCE),
	hostileWolf			(Strings.MC_PREFIX + "wolf/wolf_angry", 					"TwilightForest", 		WolfHead.INSTANCE),
	bunnyBrown			(Strings.TF_PREFIX + "bunnybrown", 							"TwilightForest", 		BunnyHead.INSTANCE),
	bunnyWhite			(Strings.TF_PREFIX + "bunnywhite", 							"TwilightForest", 		BunnyHead.INSTANCE),
	squirrel			(Strings.TF_PREFIX + "squirrel2", 							"TwilightForest", 		SquirrelHead.INSTANCE),
	ocelot				(Strings.MC_PREFIX + "cat/ocelot", 							null, 					OcelotHead.INSTANCE),
	ocelotBlack			(Strings.MC_PREFIX + "cat/black", 							null, 					OcelotHead.INSTANCE),
	ocelotRed			(Strings.MC_PREFIX + "cat/red", 							null, 					OcelotHead.INSTANCE),
	ocelotSiamese		(Strings.MC_PREFIX + "cat/siamese", 						null, 					OcelotHead.INSTANCE),
	bat					(Strings.MC_PREFIX + "bat", 								null, 					BatHead.INSTANCE),
	slime				(Strings.MC_PREFIX + "slime/slime", 						null, 					SlimeHead.INSTANCE),
	magmaCube			(Strings.MC_PREFIX + "slime/magmacube", 					null, 					MagmaCubeHead.INSTANCE),
	horseBlack			(Strings.MC_PREFIX + "horse/horse_black", 					null, 					HorseHead.INSTANCE_HORSE),
	horseBrown			(Strings.MC_PREFIX + "horse/horse_brown", 					null, 					HorseHead.INSTANCE_HORSE),
	horseChestnut		(Strings.MC_PREFIX + "horse/horse_chestnut", 				null, 					HorseHead.INSTANCE_HORSE),
	horseCreamy			(Strings.MC_PREFIX + "horse/horse_creamy", 					null, 					HorseHead.INSTANCE_HORSE),
	horseDarkBrown		(Strings.MC_PREFIX + "horse/horse_darkbrown",			 	null, 					HorseHead.INSTANCE_HORSE),
	horseGrey			(Strings.MC_PREFIX + "horse/horse_gray", 					null, 					HorseHead.INSTANCE_HORSE),
	horseWhite			(Strings.MC_PREFIX + "horse/horse_white", 					null, 					HorseHead.INSTANCE_HORSE),
	donkey				(Strings.MC_PREFIX + "horse/donkey", 						null, 					HorseHead.INSTANCE_MULE),
	mule				(Strings.MC_PREFIX + "horse/mule", 							null, 					HorseHead.INSTANCE_MULE),
	horseUndead			(Strings.MC_PREFIX + "horse/horse_zombie", 					null, 					HorseHead.INSTANCE_HORSE),
	horseSkeleton		(Strings.MC_PREFIX + "horse/horse_skeleton", 				null, 					HorseHead.INSTANCE_HORSE),
	snowMan				(Strings.MC_PREFIX + "snowman", 							null, 					SnowmanHead.INSTANCE),
	silverfish			(Strings.MC_PREFIX + "silverfish", 							null, 					SilverfishHead.INSTANCE),
	swarmSpider			(Strings.TF_PREFIX + "swarmspider", 						"TwilightForest", 		SpiderHead.INSTANCE),
	towerBroodling		(Strings.TF_PREFIX + "towerbroodling", 						"TwilightForest", 		SpiderHead.INSTANCE),
	winterWolf			(Strings.TF_PREFIX + "winterwolf", 							"TwilightForest", 		MistWolfHead.INSTANCE),
	mazeSlime			(Strings.TF_PREFIX + "mazeslime", 							"TwilightForest", 		SlimeHead.INSTANCE),
	towerwoodBorer		(Strings.TF_PREFIX + "towertermite", 						"TwilightForest", 		SilverfishHead.INSTANCE),
	imp					(Strings.NA_PREFIX + "imp", 								"Natura", 				ImpHead.INSTANCE),
	nitroCreeper		(Strings.NA_PREFIX + "creeperunstable", 					"Natura", 				ModelHead.INSTANCE_NO_OVERLAY),
	heatscarSpider		(Strings.NA_PREFIX + "flamespider", 						"Natura", 				SpiderHead.INSTANCE),
	angryZombie			(Strings.TC_PREFIX + "bzombievil", 							"Thaumcraft", 			WitherHead.INSTANCE),
	fireBat				(Strings.TC_PREFIX + "firebat", 							"Thaumcraft", 			BatHead.INSTANCE),
	thaumicSlime		(Strings.TC_PREFIX + "tslime", 								"Thaumcraft", 			SlimeHead.INSTANCE),
	taintedChicken		(Strings.TC_PREFIX + "chicken", 							"Thaumcraft", 			ChickenHead.INSTANCE),
	taintedCow			(Strings.TC_PREFIX + "cow", 								"Thaumcraft", 			CowHead.INSTANCE),
	taintedPig			(Strings.TC_PREFIX + "pig", 								"Thaumcraft", 			PigHead.INSTANCE),
	taintedCreeper		(Strings.TC_PREFIX + "creeper", 							"Thaumcraft", 			ModelHead.INSTANCE),
	taintedVillager		(Strings.TC_PREFIX + "villager", 							"Thaumcraft", 			VillagerHead.INSTANCE64),
	taintedSheep		(Strings.TC_PREFIX + "sheep", 								"Thaumcraft", 			TaintedSheepHead.INSTANCE),
	pech				(Strings.TC_PREFIX + "pech_forage", 						"Thaumcraft", 			PechHead.INSTANCE),
	eldritchGuardian	(Strings.TC_PREFIX + "eldritch_guardian", 					"Thaumcraft", 			EldrichGuardianHead.INSTANCE),
	lycanites			("", 														"lycanitesmobs", 		null),
	pinky				(Strings.LY_PREFIX + "pinky", 								"lycanitesmobs", 		PinkyHead.INSTANCE),
	behemoth			(Strings.LY_PREFIX + "behemoth", 							"lycanitesmobs", 		BehemothHead.INSTANCE),
	belph				(Strings.LY_PREFIX + "belph", 								"lycanitesmobs", 		BelphHead.INSTANCE),
	concussionCreeper	(Strings.EZ_PREFIX + "concussionCreeper", 					"EnderZoo", 			ModelHead.INSTANCE_NO_OVERLAY),
	enderminy			(Strings.EZ_PREFIX + "enderminy", 							"EnderZoo", 			EnderminyHead.INSTANCE),
	fallenKnight		(Strings.EZ_PREFIX + "fallen_knight", 						"EnderZoo", 			ModelHead.INSTANCE_NO_OVERLAY),
	witherWitch			(Strings.EZ_PREFIX + "wither_witch", 						"EnderZoo", 			WitchHead.INSTANCE),
	direWolf			(Strings.EZ_PREFIX + "dire_wolf", 							"EnderZoo", 			DireWolfHead.INSTANCE),
	witherCat			(Strings.EZ_PREFIX + "wither_cat_angry", 					"EnderZoo", 			OcelotHead.INSTANCE),
	rocketCreeper		(Strings.PM_PREFIX + "rocketcreeper/rocketcreeper", 		"primitivemobs", 		ModelHead.INSTANCE_NO_OVERLAY),
	festiveCreeper		(Strings.PM_PREFIX + "festivecreeper/festivecreeper", 		"primitivemobs", 		ModelHead.INSTANCE_NO_OVERLAY),
	supportCreeper		(Strings.PM_PREFIX + "supportcreeper/supportcreeper", 		"primitivemobs", 		ModelHead.INSTANCE_NO_OVERLAY),
	lostMiner			(Strings.PM_PREFIX + "villager/lostminer", 					"primitivemobs", 		VillagerHead.INSTANCE128x64),
	sheepman			(Strings.PM_PREFIX + "villager/sheepman", 					"primitivemobs", 		SheepmanHead.INSTANCE),
	summoner			(Strings.PM_PREFIX + "summoner/summoner", 					"primitivemobs", 		VillagerHead.INSTANCE64),
	blazingJuggernaut	(Strings.PM_PREFIX + "blazingjuggernaut/blazingjuggernaut",	"primitivemobs", 		JuggernautHead.INSTANCE),
	lilyLurker			(Strings.PM_PREFIX + "lilylurker/lilylurker",				"primitivemobs", 		LilyLurkerHead.INSTANCE),
	motherSpider		(Strings.PM_PREFIX + "spiderfamily/motherspider",			"primitivemobs", 		SpiderHead.INSTANCE),
	babySpider			(Strings.PM_PREFIX + "spiderfamily/babyspider",				"primitivemobs", 		SpiderHead.INSTANCE),
	skeletonWarrior		(Strings.PM_PREFIX + "skeletonwarrior/skeletonwarrior",		"primitivemobs", 		ModelHead.INSTANCE_NO_OVERLAY),
	brainSlime			(Strings.PM_PREFIX + "brainslime/brainslime",				"primitivemobs", 		SlimeHead.INSTANCE),
	anubis				(Strings.GOG_PREFIX + "Anubis",								"GrimoireOfGaia", 		AnubisHead.INSTANCE),
	banshee				(Strings.GOG_PREFIX + "Banshee",							"GrimoireOfGaia", 		BansheeHead.INSTANCE),
	baphomet			(Strings.GOG_PREFIX + "Baphomet",							"GrimoireOfGaia", 		BaphometHead.INSTANCE),
	centaur				(Strings.GOG_PREFIX + "Centaur",							"GrimoireOfGaia", 		CentaurHead.INSTANCE),
	cobbleGolem			(Strings.GOG_PREFIX + "Cobble_Golem",						"GrimoireOfGaia", 		CobbleGolemHead.INSTANCE),
	cobblestoneGolem	(Strings.GOG_PREFIX + "Cobblestone_Golem",					"GrimoireOfGaia", 		CobblestoneGolemHead.INSTANCE),
	cockatrice			(Strings.GOG_PREFIX + "Cockatrice",							"GrimoireOfGaia", 		CockatriceHead.INSTANCE),
	cyclops				(Strings.GOG_PREFIX + "Cyclops",							"GrimoireOfGaia", 		CyclopsHead.INSTANCE),
	dhampir				(Strings.GOG_PREFIX + "Dhampir",							"GrimoireOfGaia", 		DhampirHead.INSTANCE),
	dryad				(Strings.GOG_PREFIX + "Dryad01",							"GrimoireOfGaia", 		DryadHead.INSTANCE),
	dullahan			(Strings.GOG_PREFIX + "Dullahan",							"GrimoireOfGaia", 		DullahanHead.INSTANCE),
	enderDragonGirl		(Strings.GOG_PREFIX + "Ender_Dragon_Girl",					"GrimoireOfGaia", 		EnderDragonGirlHead.INSTANCE),
	enderEye			(Strings.GOG_PREFIX + "Ender_Eye",							"GrimoireOfGaia", 		EnderEyeHead.INSTANCE),
	fleshLich			(Strings.GOG_PREFIX + "Flesh_Lich",							"GrimoireOfGaia", 		FleshLichHead.INSTANCE),
	futakuchiOnna		(Strings.GOG_PREFIX + "Futakuchi_Onna",						"GrimoireOfGaia", 		FutakuchiOnnaHead.INSTANCE),
	gryphon				(Strings.GOG_PREFIX + "Gryphon",							"GrimoireOfGaia", 		GryphonHead.INSTANCE),
	harpy				(Strings.GOG_PREFIX + "Harpy01",							"GrimoireOfGaia", 		HarpyHead.INSTANCE),
	hunter				(Strings.GOG_PREFIX + "Hunter",								"GrimoireOfGaia", 		HunterHead.INSTANCE);
	// @formatter:on

	private final String mod;
	private final ResourceLocation texture;
	private final ModelHead model;
	private Boolean isActive = null;

	SkullTypes(String texture, String mod, ModelHead model) {
		this.mod = mod;
		this.texture = Utils.getResource(texture + ".png");
		this.model = model;
	}

	public boolean canShow() {
		return this != player && !Headcrumbs.enableMobsAndAnimalHeads ? false : isModLoaded();
	}

	public ResourceLocation getTexture(GameProfile name) {
		if (this == player || !isModLoaded())
			return TextureUtils.getPlayerSkin(name);
		if (this == lycanites)
			return LycanitesHelperClient.getTexture(name.getName());
		return texture;
	}

	public ModelHead model() {
		return isModLoaded() ? model : ModelHead.INSTANCE;
	}

	private boolean isModLoaded() {
		if (isActive == null)
			isActive = mod == null || Loader.isModLoaded(mod);
		return isActive;
	}
}