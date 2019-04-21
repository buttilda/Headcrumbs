package ganymedes01.headcrumbs.libs;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.heads.BatHead;
import ganymedes01.headcrumbs.renderers.heads.ChickenHead;
import ganymedes01.headcrumbs.renderers.heads.CowHead;
import ganymedes01.headcrumbs.renderers.heads.EndermanHead;
import ganymedes01.headcrumbs.renderers.heads.EndermiteHead;
import ganymedes01.headcrumbs.renderers.heads.GhastHead;
import ganymedes01.headcrumbs.renderers.heads.GuardianHead;
import ganymedes01.headcrumbs.renderers.heads.HorseHead;
import ganymedes01.headcrumbs.renderers.heads.MagmaCubeHead;
import ganymedes01.headcrumbs.renderers.heads.MooshroomHead;
import ganymedes01.headcrumbs.renderers.heads.OcelotHead;
import ganymedes01.headcrumbs.renderers.heads.PigHead;
import ganymedes01.headcrumbs.renderers.heads.PigmanHead;
import ganymedes01.headcrumbs.renderers.heads.PolarBearHead;
import ganymedes01.headcrumbs.renderers.heads.RabbitHead;
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
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DhampirHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DryadHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.DullahanHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.EnderDragonGirlHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.EnderEyeHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.FleshLichHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.GoGWitchHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.GryphonHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.HarpyHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.HunterHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MandragoraHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MermaidHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MimicHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MinotaurHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.MinotaurusHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.NagaHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.NineTailsHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SatyrHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SelkieHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.ShamanHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SharkoHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SirenHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SludgeGirlHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SphinxHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SprigganHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.SuccubusHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.ValkyrieHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.VampireHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.WerecatHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.WitherCowHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.YetiHead;
import ganymedes01.headcrumbs.renderers.heads.grimoireOfGaia.YukiOnnaHead;
import ganymedes01.headcrumbs.renderers.heads.lasercreeper.JetPackSpiderHead;
import ganymedes01.headcrumbs.renderers.heads.lasercreeper.LaserCreeperHead;
import ganymedes01.headcrumbs.renderers.heads.lasercreeper.RoboDinoHead;
import ganymedes01.headcrumbs.renderers.heads.lycanites.BehemothHead;
import ganymedes01.headcrumbs.renderers.heads.lycanites.BelphHead;
import ganymedes01.headcrumbs.renderers.heads.lycanites.PinkyHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.CicapteraHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.DuskLurkerHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.KrillHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.PlumperHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.VrontausaurusHead;
import ganymedes01.headcrumbs.renderers.heads.mysticalwildlife.YagaHogHead;
import ganymedes01.headcrumbs.renderers.heads.natura.ImpHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.JuggernautHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.LilyLurkerHead;
import ganymedes01.headcrumbs.renderers.heads.primitivemobs.SheepmanHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.CultistHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.EldrichCrabHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.EldrichGuardianHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.PechHead;
import ganymedes01.headcrumbs.renderers.heads.thaumcraft.TaintedSheepHead;
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
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.Utils;
import ganymedes01.headcrumbs.utils.helpers.ElementalCreepersHelper;
import ganymedes01.headcrumbs.utils.helpers.EnderZooHelper;
import ganymedes01.headcrumbs.utils.helpers.GrimoireOfGaiaHelper;
import ganymedes01.headcrumbs.utils.helpers.LaserCreepersHelper;
import ganymedes01.headcrumbs.utils.helpers.MysticalWildlifeHelper;
import ganymedes01.headcrumbs.utils.helpers.NaturaHelper;
import ganymedes01.headcrumbs.utils.helpers.PrimitiveMobsHelper;
import ganymedes01.headcrumbs.utils.helpers.TEHelper;
import ganymedes01.headcrumbs.utils.helpers.ThaumcraftHelper;
import ganymedes01.headcrumbs.utils.helpers.TwilightForestHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;

public enum SkullTypes
{

	// @formatter:off
	bat					(Strings.MC_PREFIX + "bat", 							null, 						BatHead.INSTANCE),
	polarBear			(Strings.MC_PREFIX + "bear/polarbear",			 		null, 						PolarBearHead.INSTANCE),
	blaze				(Strings.MC_PREFIX + "blaze", 							null, 						ModelHead.INSTANCE_NO_OVERLAY),
	ocelot				(Strings.MC_PREFIX + "cat/ocelot", 						null, 						OcelotHead.INSTANCE),
	ocelotBlack			(Strings.MC_PREFIX + "cat/black", 						null, 						OcelotHead.INSTANCE),
	ocelotRed			(Strings.MC_PREFIX + "cat/red", 						null, 						OcelotHead.INSTANCE),
	ocelotSiamese		(Strings.MC_PREFIX + "cat/siamese", 					null, 						OcelotHead.INSTANCE),
	chicken				(Strings.MC_PREFIX + "chicken", 						null, 						ChickenHead.INSTANCE),
	cow					(Strings.MC_PREFIX + "cow/cow", 						null, 						CowHead.INSTANCE),
	mooshroom			(Strings.MC_PREFIX + "cow/mooshroom", 					null, 						MooshroomHead.INSTANCE),
	enderman			(Strings.MC_PREFIX + "enderman/enderman", 				null, 						EndermanHead.INSTANCE),
	endermite			(Strings.MC_PREFIX + "endermite",			 			null, 						EndermiteHead.INSTANCE),
	ghast				(Strings.MC_PREFIX + "ghast/ghast", 					null, 						GhastHead.INSTANCE),
	guardian			(Strings.MC_PREFIX + "guardian",			 			null, 						GuardianHead.INSTANCE),
	guardianElder		(Strings.MC_PREFIX + "guardian_elder",			 		null, 						GuardianHead.INSTANCE),
	horseBlack			(Strings.MC_PREFIX + "horse/horse_black", 				null, 						HorseHead.INSTANCE_HORSE),
	horseBrown			(Strings.MC_PREFIX + "horse/horse_brown", 				null, 						HorseHead.INSTANCE_HORSE),
	horseChestnut		(Strings.MC_PREFIX + "horse/horse_chestnut", 			null, 						HorseHead.INSTANCE_HORSE),
	horseCreamy			(Strings.MC_PREFIX + "horse/horse_creamy", 				null, 						HorseHead.INSTANCE_HORSE),
	horseDarkBrown		(Strings.MC_PREFIX + "horse/horse_darkbrown",			null, 						HorseHead.INSTANCE_HORSE),
	horseGrey			(Strings.MC_PREFIX + "horse/horse_gray", 				null, 						HorseHead.INSTANCE_HORSE),
	horseWhite			(Strings.MC_PREFIX + "horse/horse_white", 				null, 						HorseHead.INSTANCE_HORSE),
	donkey				(Strings.MC_PREFIX + "horse/donkey", 					null, 						HorseHead.INSTANCE_MULE),
	mule				(Strings.MC_PREFIX + "horse/mule", 						null, 						HorseHead.INSTANCE_MULE),
	horseUndead			(Strings.MC_PREFIX + "horse/horse_zombie", 				null, 						HorseHead.INSTANCE_HORSE),
	horseSkeleton		(Strings.MC_PREFIX + "horse/horse_skeleton", 			null, 						HorseHead.INSTANCE_HORSE),
	ironGolem			(Strings.MC_PREFIX + "iron_golem", 						null, 						VillagerHead.INSTANCE128),
	pig					(Strings.MC_PREFIX + "pig/pig", 						null, 						PigHead.INSTANCE),
	rabbitBlack			(Strings.MC_PREFIX + "rabbit/black",			 		null, 						RabbitHead.INSTANCE),
	rabbitBrown			(Strings.MC_PREFIX + "rabbit/brown",			 		null, 						RabbitHead.INSTANCE),
	rabbitGold			(Strings.MC_PREFIX + "rabbit/gold",			 			null, 						RabbitHead.INSTANCE),
	rabbitSalt			(Strings.MC_PREFIX + "rabbit/salt",			 			null, 						RabbitHead.INSTANCE),
	rabbitToast			(Strings.MC_PREFIX + "rabbit/toast",		 			null, 						RabbitHead.INSTANCE),
	rabbitSplotched		(Strings.MC_PREFIX + "rabbit/white_splotched",			null, 						RabbitHead.INSTANCE),
	rabbitWhite			(Strings.MC_PREFIX + "rabbit/white",			 		null, 						RabbitHead.INSTANCE),
	sheep				(Strings.MC_PREFIX + "sheep/sheep", 					null, 						SheepHead.INSTANCE),
	silverfish			(Strings.MC_PREFIX + "silverfish", 						null, 						SilverfishHead.INSTANCE),
	slime				(Strings.MC_PREFIX + "slime/slime", 					null, 						SlimeHead.INSTANCE),
	magmaCube			(Strings.MC_PREFIX + "slime/magmacube", 				null, 						MagmaCubeHead.INSTANCE),
	snowMan				(Strings.MC_PREFIX + "snowman", 						null, 						SnowmanHead.INSTANCE),
	spider				(Strings.MC_PREFIX + "spider/spider", 					null, 						SpiderHead.INSTANCE),
	caveSpider			(Strings.MC_PREFIX + "spider/cave_spider",				null, 						SpiderHead.INSTANCE),
	squid				(Strings.MC_PREFIX + "squid", 							null, 						SquidHead.INSTANCE),
	villager			(Strings.MC_PREFIX + "villager/villager", 				null, 						VillagerHead.INSTANCE64),
	witch				(Strings.MC_PREFIX + "witch", 							null, 						WitchHead.INSTANCE),
	wither				(Strings.MC_PREFIX + "wither/wither", 					null, 						WitherHead.INSTANCE),
	wolf				(Strings.MC_PREFIX + "wolf/wolf", 						null, 						WolfHead.INSTANCE),
	zombieVillager		(Strings.MC_PREFIX + "zombie/zombie_villager",			null, 						ZombieVillagerHead.INSTANCE),
	pigman				(Strings.MC_PREFIX + "zombie_pigman", 					null, 						PigmanHead.INSTANCE),
	
	cakeCreeper			(Strings.EC_PREFIX + "cakecreeper",			 			ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	cookieCreeper		(Strings.EC_PREFIX + "cookiecreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	darkCreeper			(Strings.EC_PREFIX + "darkcreeper",			 			ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	earthCreeper		(Strings.EC_PREFIX + "earthcreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	enderCreeper		(Strings.EC_PREFIX + "endercreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	euCreeper			(Strings.EC_PREFIX + "eucreeper",			 			ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	fireCreeper			(Strings.EC_PREFIX + "firecreeper",			 			ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	fireworkCreeper		(Strings.EC_PREFIX + "fireworkcreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	friendlyCreeper		(Strings.EC_PREFIX + "friendlycreeper0",				ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	furnaceCreeper		(Strings.EC_PREFIX + "furnacecreeper",					ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	hydrogenCreeper		(Strings.EC_PREFIX + "hydrogencreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	iceCreeper			(Strings.EC_PREFIX + "icecreeper",			 			ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	illusionCreeper		(Strings.EC_PREFIX + "illusioncreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	lightCreeper		(Strings.EC_PREFIX + "lightcreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	lightningCreeper	(Strings.EC_PREFIX + "lightningcreeper",		 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	magmaCreeper		(Strings.EC_PREFIX + "magmacreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	psychicCreeper		(Strings.EC_PREFIX + "psychiccreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	reverseCreeper		(Strings.EC_PREFIX + "reversecreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	rfCreeper			(Strings.EC_PREFIX + "rfcreeper",			 			ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	sandstoneCreeper	(Strings.EC_PREFIX + "sandstonecreeper",			 	ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	spiderCreeper		(Strings.EC_PREFIX + "spidercreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	springCreeper		(Strings.EC_PREFIX + "springcreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	stoneCreeper		(Strings.EC_PREFIX + "stonecreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	warpCreeper			(Strings.EC_PREFIX + "warpcreeper",			 			ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	windCreeper			(Strings.EC_PREFIX + "windcreeper",			 			ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	waterCreeper		(Strings.EC_PREFIX + "watercreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	zombieCreeper		(Strings.EC_PREFIX + "zombiecreeper",			 		ElementalCreepersHelper.MOD_ID, 			ModelHead.INSTANCE_NO_OVERLAY),
	
	concussionCreeper	(Strings.EZ_PREFIX + "concussioncreeper", 				EnderZooHelper.MOD_ID, 						ModelHead.INSTANCE_NO_OVERLAY),
	enderminy			(Strings.EZ_PREFIX + "enderminy", 						EnderZooHelper.MOD_ID, 						EnderminyHead.INSTANCE),
	fallenKnight		(Strings.EZ_PREFIX + "fallen_knight", 					EnderZooHelper.MOD_ID, 						ModelHead.INSTANCE_NO_OVERLAY),
	witherWitch			(Strings.EZ_PREFIX + "wither_witch", 					EnderZooHelper.MOD_ID, 						WitchHead.INSTANCE),
	direWolf			(Strings.EZ_PREFIX + "dire_wolf", 						EnderZooHelper.MOD_ID, 						DireWolfHead.INSTANCE),
	witherCat			(Strings.EZ_PREFIX + "wither_cat_angry", 				EnderZooHelper.MOD_ID, 						OcelotHead.INSTANCE),
	
	anubis				(Strings.GOG_PREFIX + "anubis",							GrimoireOfGaiaHelper.MOD_ID, 				AnubisHead.INSTANCE),
	banshee				(Strings.GOG_PREFIX + "banshee",						GrimoireOfGaiaHelper.MOD_ID, 				BansheeHead.INSTANCE),
	baphomet			(Strings.GOG_PREFIX + "baphomet",						GrimoireOfGaiaHelper.MOD_ID, 				BaphometHead.INSTANCE),
	centaur				(Strings.GOG_PREFIX + "centaur01",						GrimoireOfGaiaHelper.MOD_ID, 				CentaurHead.INSTANCE),
	cobbleGolem			(Strings.GOG_PREFIX + "cobble_golem",					GrimoireOfGaiaHelper.MOD_ID, 				CobbleGolemHead.INSTANCE),
	cobblestoneGolem	(Strings.GOG_PREFIX + "cobblestone_golem",				GrimoireOfGaiaHelper.MOD_ID, 				CobblestoneGolemHead.INSTANCE),
	dhampir				(Strings.GOG_PREFIX + "dhampir",						GrimoireOfGaiaHelper.MOD_ID, 				DhampirHead.INSTANCE),
	dryad				(Strings.GOG_PREFIX + "dryad01",						GrimoireOfGaiaHelper.MOD_ID, 				DryadHead.INSTANCE),
	dullahan			(Strings.GOG_PREFIX + "dullahan",						GrimoireOfGaiaHelper.MOD_ID, 				DullahanHead.INSTANCE),
	enderDragonGirl		(Strings.GOG_PREFIX + "ender_dragon_girl",				GrimoireOfGaiaHelper.MOD_ID, 				EnderDragonGirlHead.INSTANCE),
	enderEye			(Strings.GOG_PREFIX + "ender_eye",						GrimoireOfGaiaHelper.MOD_ID, 				EnderEyeHead.INSTANCE),
	fleshLich			(Strings.GOG_PREFIX + "flesh_lich",						GrimoireOfGaiaHelper.MOD_ID, 				FleshLichHead.INSTANCE),
	gryphon				(Strings.GOG_PREFIX + "gryphon",						GrimoireOfGaiaHelper.MOD_ID, 				GryphonHead.INSTANCE),
	harpy				(Strings.GOG_PREFIX + "harpy01",						GrimoireOfGaiaHelper.MOD_ID, 				HarpyHead.INSTANCE),
	hunter				(Strings.GOG_PREFIX + "hunter",							GrimoireOfGaiaHelper.MOD_ID, 				HunterHead.INSTANCE),
	mandragora			(Strings.GOG_PREFIX + "mandragora",						GrimoireOfGaiaHelper.MOD_ID, 				MandragoraHead.INSTANCE),
	mermaid				(Strings.GOG_PREFIX + "mermaid",						GrimoireOfGaiaHelper.MOD_ID, 				MermaidHead.INSTANCE),
	mimic				(Strings.GOG_PREFIX + "mimic",							GrimoireOfGaiaHelper.MOD_ID, 				MimicHead.INSTANCE),
	minotaur			(Strings.GOG_PREFIX + "minotaur",						GrimoireOfGaiaHelper.MOD_ID, 				MinotaurHead.INSTANCE),
	minotaurus			(Strings.GOG_PREFIX + "minotaurus01",					GrimoireOfGaiaHelper.MOD_ID, 				MinotaurusHead.INSTANCE),
	naga				(Strings.GOG_PREFIX + "naga",							GrimoireOfGaiaHelper.MOD_ID, 				NagaHead.INSTANCE),
	nineTails			(Strings.GOG_PREFIX + "nine_tails",						GrimoireOfGaiaHelper.MOD_ID, 				NineTailsHead.INSTANCE),
	satyress			(Strings.GOG_PREFIX + "satyress01",						GrimoireOfGaiaHelper.MOD_ID, 				SatyrHead.INSTANCE),
	selkie				(Strings.GOG_PREFIX + "selkie",							GrimoireOfGaiaHelper.MOD_ID, 				SelkieHead.INSTANCE),
	shaman				(Strings.GOG_PREFIX + "shaman",							GrimoireOfGaiaHelper.MOD_ID, 				ShamanHead.INSTANCE),
	sharko				(Strings.GOG_PREFIX + "sharko",							GrimoireOfGaiaHelper.MOD_ID, 				SharkoHead.INSTANCE),
	siren				(Strings.GOG_PREFIX + "siren",							GrimoireOfGaiaHelper.MOD_ID, 				SirenHead.INSTANCE),
	sludgeGirl			(Strings.GOG_PREFIX + "sludge_girl01",					GrimoireOfGaiaHelper.MOD_ID, 				SludgeGirlHead.INSTANCE),
	sphinx				(Strings.GOG_PREFIX + "sphinx",							GrimoireOfGaiaHelper.MOD_ID, 				SphinxHead.INSTANCE),
	spriggan			(Strings.GOG_PREFIX + "spriggan",						GrimoireOfGaiaHelper.MOD_ID, 				SprigganHead.INSTANCE),
	succubus			(Strings.GOG_PREFIX + "succubus",						GrimoireOfGaiaHelper.MOD_ID, 				SuccubusHead.INSTANCE),
	valkyrie			(Strings.GOG_PREFIX + "valkyrie",						GrimoireOfGaiaHelper.MOD_ID, 				ValkyrieHead.INSTANCE),
	vampire				(Strings.GOG_PREFIX + "vampire",						GrimoireOfGaiaHelper.MOD_ID, 				VampireHead.INSTANCE),
	werecat				(Strings.GOG_PREFIX + "werecat01",						GrimoireOfGaiaHelper.MOD_ID, 				WerecatHead.INSTANCE),
	gogWitch			(Strings.GOG_PREFIX + "witch01",						GrimoireOfGaiaHelper.MOD_ID, 				GoGWitchHead.INSTANCE),
	witherCow			(Strings.GOG_PREFIX + "wither_cow",						GrimoireOfGaiaHelper.MOD_ID, 				WitherCowHead.INSTANCE),
	yeti				(Strings.GOG_PREFIX + "yeti",							GrimoireOfGaiaHelper.MOD_ID, 				YetiHead.INSTANCE),
	yukiOnna			(Strings.GOG_PREFIX + "yuki_onna",						GrimoireOfGaiaHelper.MOD_ID, 				YukiOnnaHead.INSTANCE),
	
	laserCreeper		(Strings.LC_PREFIX + "laser_creeper",			 		LaserCreepersHelper.MOD_ID, 				LaserCreeperHead.INSTANCE),
	roboDino			(Strings.LC_PREFIX + "robo_dino",			 			LaserCreepersHelper.MOD_ID, 				RoboDinoHead.INSTANCE),
	jetPackSpider		(Strings.LC_PREFIX + "jet_pack_spider",			 		LaserCreepersHelper.MOD_ID, 				JetPackSpiderHead.INSTANCE),

	//lycanites			("", 										"lycanitesmobs", 			LycaniteHead.INSTANCE),
	pinky				(Strings.LY_PREFIX + "pinky", 							"lycanitesmobs", 							PinkyHead.INSTANCE),
	behemoth			(Strings.LY_PREFIX + "behemoth", 						"lycanitesmobs", 							BehemothHead.INSTANCE),
	belph				(Strings.LY_PREFIX + "belph", 							"lycanitesmobs", 							BelphHead.INSTANCE),
	
	vrontausaurus		(Strings.MWL_PREFIX + "vrontausaurus",			 		MysticalWildlifeHelper.MOD_ID, 				VrontausaurusHead.INSTANCE),
	yagaHog				(Strings.MWL_PREFIX + "yaga_hog_dirt",			 		MysticalWildlifeHelper.MOD_ID, 				YagaHogHead.INSTANCE),
	duskLurker			(Strings.MWL_PREFIX + "dusk_lurker",			 		MysticalWildlifeHelper.MOD_ID, 				DuskLurkerHead.INSTANCE),
	cicapteraAzure		(Strings.MWL_PREFIX + "cicaptera_azure",			 	MysticalWildlifeHelper.MOD_ID, 				CicapteraHead.INSTANCE),
	cicapteraVerdant	(Strings.MWL_PREFIX + "cicaptera_verdant",			 	MysticalWildlifeHelper.MOD_ID, 				CicapteraHead.INSTANCE),
	cicapteraCrimson	(Strings.MWL_PREFIX + "cicaptera_crimson",			 	MysticalWildlifeHelper.MOD_ID, 				CicapteraHead.INSTANCE),
	cicapteraSandy		(Strings.MWL_PREFIX + "cicaptera_sandy",			 	MysticalWildlifeHelper.MOD_ID, 				CicapteraHead.INSTANCE),
	cicapteraWintry		(Strings.MWL_PREFIX + "cicaptera_wintry",			 	MysticalWildlifeHelper.MOD_ID, 				CicapteraHead.INSTANCE),
	plumper				(Strings.MWL_PREFIX + "plumper",			 			MysticalWildlifeHelper.MOD_ID, 				PlumperHead.INSTANCE),
	krill				(Strings.MWL_PREFIX + "krill",			 				MysticalWildlifeHelper.MOD_ID, 				KrillHead.INSTANCE),
	
	imp					(Strings.NA_PREFIX + "imp", 							NaturaHelper.MOD_ID, 						ImpHead.INSTANCE),
	nitroCreeper		(Strings.NA_PREFIX + "nitrocreeper", 					NaturaHelper.MOD_ID, 						ModelHead.INSTANCE_NO_OVERLAY),
	heatscarSpider		(Strings.NA_PREFIX + "heatscarspider", 					NaturaHelper.MOD_ID, 						SpiderHead.INSTANCE),
	
	rocketCreeper		(Strings.PM_PREFIX + "rocketcreeper/rocketcreeper", 	PrimitiveMobsHelper.MOD_ID, 				ModelHead.INSTANCE_NO_OVERLAY),
	festiveCreeper		(Strings.PM_PREFIX + "festivecreeper/festivecreeper", 	PrimitiveMobsHelper.MOD_ID, 				ModelHead.INSTANCE_NO_OVERLAY),
	supportCreeper		(Strings.PM_PREFIX + "supportcreeper/supportcreeper", 	PrimitiveMobsHelper.MOD_ID, 				ModelHead.INSTANCE_NO_OVERLAY),
	lostMiner			(Strings.PM_PREFIX + "villager/lostminer", 				PrimitiveMobsHelper.MOD_ID, 				VillagerHead.INSTANCE128x64),
	sheepman			(Strings.PM_PREFIX + "villager/sheepman", 				PrimitiveMobsHelper.MOD_ID, 				SheepmanHead.INSTANCE),
	wizard				(Strings.PM_PREFIX + "villager/wizard", 				PrimitiveMobsHelper.MOD_ID, 				VillagerHead.INSTANCE64),
	blazingJuggernaut	(Strings.PM_PREFIX + "blazingjuggernaut/blazingjuggernaut",		PrimitiveMobsHelper.MOD_ID,			JuggernautHead.INSTANCE),
	lilyLurker			(Strings.PM_PREFIX + "lilylurker/lilylurker",			PrimitiveMobsHelper.MOD_ID, 				LilyLurkerHead.INSTANCE),
	motherSpider		(Strings.PM_PREFIX + "spiderfamily/motherspider",		PrimitiveMobsHelper.MOD_ID, 				SpiderHead.INSTANCE),
	babySpider			(Strings.PM_PREFIX + "spiderfamily/babyspider",			PrimitiveMobsHelper.MOD_ID, 				SpiderHead.INSTANCE),
	skeletonWarrior		(Strings.PM_PREFIX + "skeletonwarrior/skeletonwarrior",	PrimitiveMobsHelper.MOD_ID, 				ModelHead.INSTANCE_NO_OVERLAY),
	brainSlime			(Strings.PM_PREFIX + "brainslime/slime_brain",			PrimitiveMobsHelper.MOD_ID, 				SlimeHead.INSTANCE),
	
	blizz				(Strings.TE_PREFIX + "Blizz", 							TEHelper.MOD_ID,							ModelHead.INSTANCE),
	blitz				(Strings.TE_PREFIX + "Blitz", 							TEHelper.MOD_ID,							ModelHead.INSTANCE),
	basalz				(Strings.TE_PREFIX + "Basalz", 							TEHelper.MOD_ID,							ModelHead.INSTANCE),

	angryZombie			(Strings.TC_PREFIX + "bzombievil", 						ThaumcraftHelper.MOD_ID, 					WitherHead.INSTANCE),
	fireBat				(Strings.TC_PREFIX + "firebat", 						ThaumcraftHelper.MOD_ID, 					BatHead.INSTANCE),
	thaumicSlime		(Strings.TC_PREFIX + "tslime", 							ThaumcraftHelper.MOD_ID, 					SlimeHead.INSTANCE),
	pech				(Strings.TC_PREFIX + "pech_forage", 					ThaumcraftHelper.MOD_ID, 					PechHead.INSTANCE),
	eldritchGuardian	(Strings.TC_PREFIX + "eldritch_guardian", 				ThaumcraftHelper.MOD_ID, 					EldrichGuardianHead.INSTANCE),
	cultist				(Strings.TC_PREFIX + "cultist", 						ThaumcraftHelper.MOD_ID, 					CultistHead.INSTANCE),
	eldritchCrab		(Strings.TC_PREFIX + "crab",			 				ThaumcraftHelper.MOD_ID, 					EldrichCrabHead.INSTANCE),
	
	hostileWolf			(Strings.MC_PREFIX + "wolf/wolf_angry", 				TwilightForestHelper.MOD_ID, 				WolfHead.INSTANCE),
	bunnyDutch			(Strings.TF_PREFIX + "bunnydutch", 						TwilightForestHelper.MOD_ID, 				BunnyHead.INSTANCE),
	penguin				(Strings.TF_PREFIX + "penguin", 						TwilightForestHelper.MOD_ID, 				PenguinHead.INSTANCE),
	bighorn				(Strings.TF_PREFIX + "bighorn", 						TwilightForestHelper.MOD_ID, 				BighornHead.INSTANCE),
	wildDeer			(Strings.TF_PREFIX + "wilddeer", 						TwilightForestHelper.MOD_ID, 				DeerHead.INSTANCE),
	wildBoar			(Strings.TF_PREFIX + "wildboar", 						TwilightForestHelper.MOD_ID, 				WildBoarHead.INSTANCE),
	redcap				(Strings.TF_PREFIX + "redcap", 							TwilightForestHelper.MOD_ID, 				RedcapHead.INSTANCE),
	druid				(Strings.TF_PREFIX + "skeletondruid", 					TwilightForestHelper.MOD_ID, 				ModelHead.INSTANCE),
	hedgeSpider			(Strings.TF_PREFIX + "hedgespider", 					TwilightForestHelper.MOD_ID, 				SpiderHead.INSTANCE),
	mistWolf			(Strings.TF_PREFIX + "mistwolf", 						TwilightForestHelper.MOD_ID, 				MistWolfHead.INSTANCE),
	miniGhast			(Strings.TF_PREFIX + "towerghast", 						TwilightForestHelper.MOD_ID,				GhastHead.INSTANCE),
	guardGhast			(Strings.TF_PREFIX + "towerghast_openeyes", 			TwilightForestHelper.MOD_ID, 				GhastHead.INSTANCE),
	kingSpider			(Strings.TF_PREFIX + "kingspider", 						TwilightForestHelper.MOD_ID, 				SpiderHead.INSTANCE),
	kobold				(Strings.TF_PREFIX + "kobold", 							TwilightForestHelper.MOD_ID, 				KoboldHead.INSTANCE),
	slimeBeetle			(Strings.TF_PREFIX + "slimebeetle", 					TwilightForestHelper.MOD_ID, 				SlimeBeetleHead.INSTANCE),
	fireBeetle			(Strings.TF_PREFIX + "firebeetle", 						TwilightForestHelper.MOD_ID, 				FireBeetleHead.INSTANCE),
	pinchBeetle			(Strings.TF_PREFIX + "pinchbeetle", 					TwilightForestHelper.MOD_ID, 				PinchBeetle.INSTANCE),
	towerGolem			(Strings.TF_PREFIX + "carminitegolem", 					TwilightForestHelper.MOD_ID, 				TowerGolemHead.INSTANCE),
	bunnyBrown			(Strings.TF_PREFIX + "bunnybrown", 						TwilightForestHelper.MOD_ID, 				BunnyHead.INSTANCE),
	bunnyWhite			(Strings.TF_PREFIX + "bunnywhite", 						TwilightForestHelper.MOD_ID, 				BunnyHead.INSTANCE),
	squirrel			(Strings.TF_PREFIX + "squirrel2", 						TwilightForestHelper.MOD_ID, 				SquirrelHead.INSTANCE),
	swarmSpider			(Strings.TF_PREFIX + "swarmspider", 					TwilightForestHelper.MOD_ID, 				SpiderHead.INSTANCE),
	towerBroodling		(Strings.TF_PREFIX + "towerbroodling", 					TwilightForestHelper.MOD_ID, 				SpiderHead.INSTANCE),
	winterWolf			(Strings.TF_PREFIX + "winterwolf", 						TwilightForestHelper.MOD_ID, 				MistWolfHead.INSTANCE),
	mazeSlime			(Strings.TF_PREFIX + "mazeslime", 						TwilightForestHelper.MOD_ID, 				SlimeHead.INSTANCE),
	towerwoodBorer		(Strings.TF_PREFIX + "towertermite", 					TwilightForestHelper.MOD_ID, 				SilverfishHead.INSTANCE),
	hydra				(Strings.TF_PREFIX + "hydra4", 							TwilightForestHelper.MOD_ID, 				HydraHead.INSTANCE),
	nagaTF				(Strings.TF_PREFIX + "nagahead", 						TwilightForestHelper.MOD_ID, 				NagaTFHead.INSTANCE),
	lich				(Strings.TF_PREFIX + "twilightlich64", 					TwilightForestHelper.MOD_ID, 				LichHead.INSTANCE),
	snowQueen			(Strings.TF_PREFIX + "snowqueen", 						TwilightForestHelper.MOD_ID, 				SnowQueenHead.INSTANCE),
	urGhast				(Strings.TF_PREFIX + "towerboss", 						TwilightForestHelper.MOD_ID, 				GhastHead.INSTANCE);
	// @formatter:on

	private final String mod;
	private final ResourceLocation texture;
	private final ModelHead model;
	private Boolean isActive = null;

	SkullTypes(String texture, String mod, ModelHead model)
	{
		this.mod = mod;
		this.texture = Utils.getResource(texture + ".png");
		this.model = model;
		if(model == null)
			throw new IllegalArgumentException("Head model for " + this + " cannot be null!");
	}

	public boolean usesProfile()
	{
		return false; // this == lycanites;
	}

	public boolean canShow()
	{
		return isModLoaded();
	}

	public ResourceLocation getTexture(GameProfile profile)
	{
		// if(this == lycanites)
		// return LycanitesHelperClient.getTexture(profile.getName());
		return texture;
	}

	public ModelHead model()
	{
		return isModLoaded() ? model : ModelHead.INSTANCE;
	}

	private boolean isModLoaded()
	{
		if(isActive == null)
			isActive = mod == null || Loader.isModLoaded(mod);
		return isActive;
	}

	public ItemStack getStack()
	{
		return getStack(1);
	}

	public ItemStack getStack(int size)
	{
		ItemStack stack = new ItemStack(ModBlocks.skull, size);
		NBTTagCompound nbt = new NBTTagCompound();
		stack.setTagCompound(nbt);
		nbt.setString(HeadUtils.MODEL_TAG, name());
		return stack;
	}
}