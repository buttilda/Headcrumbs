package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.Strings;
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
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;

public class VanillaHelper extends HeadDropHelper
{

	public VanillaHelper()
	{
		super("minecraft");

		super.registerMobHead("bat", BatHead.INSTANCE);
		super.registerMobHead("polarbear", "bear/polarbear", PolarBearHead.INSTANCE);
		super.registerMobHead("blaze", ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead("ocelot", "cat/ocelot", OcelotHead.INSTANCE);
		super.registerMobHead("ocelot_black", "cat/black", OcelotHead.INSTANCE);
		super.registerMobHead("ocelot_red", "cat/red", OcelotHead.INSTANCE);
		super.registerMobHead("ocelot_siamese", "cat/siamese", OcelotHead.INSTANCE);
		super.registerMobHead("chicken", ChickenHead.INSTANCE);
		super.registerMobHead("cow", "cow/cow", CowHead.INSTANCE);
		super.registerMobHead("mooshroom", "cow/mooshroom", MooshroomHead.INSTANCE);
		super.registerMobHead("enderman", "enderman/enderman", EndermanHead.INSTANCE);
		super.registerMobHead("endermite", EndermiteHead.INSTANCE);
		super.registerMobHead("ghast", "ghast/ghast", GhastHead.INSTANCE);
		super.registerMobHead("guardian", GuardianHead.INSTANCE);
		super.registerMobHead("guardian_elder", GuardianHead.INSTANCE);
		super.registerMobHead("horse_black", "horse/horse_black", HorseHead.INSTANCE_HORSE);
		super.registerMobHead("horse_brown", "horse/horse_brown", HorseHead.INSTANCE_HORSE);
		super.registerMobHead("horse_chestnut", "horse/horse_chestnut", HorseHead.INSTANCE_HORSE);
		super.registerMobHead("horse_creamy", "horse/horse_creamy", HorseHead.INSTANCE_HORSE);
		super.registerMobHead("horse_darkbrown", "horse/horse_darkbrown", HorseHead.INSTANCE_HORSE);
		super.registerMobHead("horse_gray", "horse/horse_gray", HorseHead.INSTANCE_HORSE);
		super.registerMobHead("donkey", "horse/donkey", HorseHead.INSTANCE_MULE);
		super.registerMobHead("mule", "horse/mule", HorseHead.INSTANCE_MULE);
		super.registerMobHead("horse_zombie", "horse/horse_zombie", HorseHead.INSTANCE_HORSE);
		super.registerMobHead("horse_skeleton", "horse/horse_skeleton", HorseHead.INSTANCE_HORSE);
		super.registerMobHead("iron_golem", VillagerHead.INSTANCE128);
		super.registerMobHead("pig", "pig/pig", PigHead.INSTANCE);
		super.registerMobHead("rabbit_black", "rabbit/black", RabbitHead.INSTANCE);
		super.registerMobHead("rabbit_brown", "rabbit/brown", RabbitHead.INSTANCE);
		super.registerMobHead("rabbit_gold", "rabbit/gold", RabbitHead.INSTANCE);
		super.registerMobHead("rabbit_salt", "rabbit/salt", RabbitHead.INSTANCE);
		super.registerMobHead("rabbit_toast", "rabbit/toast", RabbitHead.INSTANCE);
		super.registerMobHead("rabbit_white_splotched", "rabbit/white_splotched", RabbitHead.INSTANCE);
		super.registerMobHead("rabbit_white", "rabbit/white", RabbitHead.INSTANCE);
		super.registerMobHead("sheep", "sheep/sheep", SheepHead.INSTANCE);
		super.registerMobHead("silverfish", SilverfishHead.INSTANCE);
		super.registerMobHead("slime", "slime/slime", SlimeHead.INSTANCE);
		super.registerMobHead("magmacube", "slime/magmacube", MagmaCubeHead.INSTANCE);
		super.registerMobHead("snowMan", SnowmanHead.INSTANCE);
		super.registerMobHead("spider", "spider/spider", SpiderHead.INSTANCE);
		super.registerMobHead("cave_spider", "spider/cave_spider", SpiderHead.INSTANCE);
		super.registerMobHead("squid", SquidHead.INSTANCE);
		super.registerMobHead("villager", "villager/villager", VillagerHead.INSTANCE);
		super.registerMobHead("witch", WitchHead.INSTANCE);
		super.registerMobHead("wither", "wither/wither", WitherHead.INSTANCE);
		super.registerMobHead("wolf", "wolf/wolf", WolfHead.INSTANCE);
		super.registerMobHead("zombie_villager", "zombie/zombie_villager", ZombieVillagerHead.INSTANCE);
		super.registerMobHead("zombie_pigman", PigmanHead.INSTANCE);
	}

	@Override
	public ItemStack getHeadForEntity(String entityName, Entity ent)
	{
		// Could easily add the mod names to the map like in the other
		// cases
		// but it would stop heads from dropping from other mod's mobs
		// that
		// extend the vanilla ones

		//		if(entity instanceof EntityMob)
		//		{
		//			if(entity instanceof EntityZombie)
		//			{
		//				if(entity instanceof EntityPigZombie)
		//					return SkullTypes.pigman.getStack();
		//				else if(entity instanceof EntityZombieVillager)
		//					return SkullTypes.zombieVillager.getStack();
		//			}
		//			else if(entity instanceof EntityEnderman)
		//				return SkullTypes.enderman.getStack();
		//			else if(entity instanceof EntityBlaze)
		//				return SkullTypes.blaze.getStack();
		//			else if(entity instanceof EntitySpider)
		//			{
		//				if(entity instanceof EntityCaveSpider)
		//					return SkullTypes.caveSpider.getStack();
		//				return SkullTypes.spider.getStack();
		//			}
		//			else if(entity instanceof EntityWitch)
		//				return SkullTypes.witch.getStack();
		//			else if(entity instanceof EntityWither)
		//				return SkullTypes.wither.getStack(1 + (entity.world.rand.nextInt(100) == 0 ? 1 + entity.world.rand.nextInt(2) : 0));
		//			else if(entity instanceof EntitySilverfish)
		//				return SkullTypes.silverfish.getStack();
		//			else if(entity instanceof EntityGuardian)
		//				return SkullTypes.guardian.getStack();
		//			else if(entity instanceof EntityElderGuardian)
		//				return SkullTypes.guardianElder.getStack();
		//			else if(entity instanceof EntityEndermite)
		//				return SkullTypes.endermite.getStack();
		//		}
		//		else if(entity instanceof EntityAnimal)
		//		{
		//			if(entity instanceof EntityPig)
		//				return SkullTypes.pig.getStack();
		//			else if(entity instanceof EntityCow)
		//			{
		//				if(entity instanceof EntityMooshroom)
		//					return SkullTypes.mooshroom.getStack();
		//				else
		//					return SkullTypes.cow.getStack();
		//			}
		//			else if(entity instanceof EntitySheep)
		//				return SkullTypes.sheep.getStack();
		//			else if(entity instanceof EntityWolf)
		//				return SkullTypes.wolf.getStack();
		//			else if(entity instanceof EntityChicken)
		//				return SkullTypes.chicken.getStack();
		//			else if(entity instanceof EntityOcelot)
		//				switch(((EntityOcelot) entity).getTameSkin())
		//				{
		//					case 0:
		//						return SkullTypes.ocelot.getStack();
		//					case 1:
		//						return SkullTypes.ocelotBlack.getStack();
		//					case 2:
		//						return SkullTypes.ocelotRed.getStack();
		//					case 3:
		//						return SkullTypes.ocelotSiamese.getStack();
		//				}
		//			else if(entity instanceof EntityHorse)
		//			{
		//				int type = ((EntityHorse) entity).getHorseVariant();
		//
		//				if(type == 0)
		//					switch(((EntityHorse) entity).getHorseVariant() & 255)
		//					{
		//						case 0:
		//							return SkullTypes.horseWhite.getStack();
		//						case 1:
		//							return SkullTypes.horseCreamy.getStack();
		//						case 2:
		//							return SkullTypes.horseChestnut.getStack();
		//						case 3:
		//							return SkullTypes.horseBrown.getStack();
		//						case 4:
		//							return SkullTypes.horseBlack.getStack();
		//						case 5:
		//							return SkullTypes.horseGrey.getStack();
		//						case 6:
		//							return SkullTypes.horseDarkBrown.getStack();
		//					}
		//				else if(type == 1)
		//					return SkullTypes.donkey.getStack();
		//				else if(type == 2)
		//					return SkullTypes.mule.getStack();
		//				else if(type == 3)
		//					return SkullTypes.horseUndead.getStack();
		//				else if(type == 4)
		//					return SkullTypes.horseSkeleton.getStack();
		//			}
		//			else if(entity instanceof EntityRabbit)
		//			{
		//				String name = entity.getName();
		//				if(name != null && name.equals("Toast"))
		//					return SkullTypes.rabbitToast.getStack();
		//
		//				int rabbitType = ((EntityRabbit) entity).getRabbitType();
		//				switch(rabbitType)
		//				{
		//					case 0:
		//						return SkullTypes.rabbitBrown.getStack();
		//					case 1:
		//						return SkullTypes.rabbitWhite.getStack();
		//					case 2:
		//						return SkullTypes.rabbitBlack.getStack();
		//					case 3:
		//						return SkullTypes.rabbitSplotched.getStack();
		//					case 4:
		//						return SkullTypes.rabbitGold.getStack();
		//					case 5:
		//						return SkullTypes.rabbitSalt.getStack();
		//				}
		//			}
		//		}
		//		else if(entity instanceof EntityVillager)
		//			return SkullTypes.villager.getStack();
		//		else if(entity instanceof EntityIronGolem)
		//			return SkullTypes.ironGolem.getStack();
		//		else if(entity instanceof EntitySquid)
		//			return SkullTypes.squid.getStack();
		//		else if(entity instanceof EntityGhast)
		//			return SkullTypes.ghast.getStack();
		//		else if(entity instanceof EntityBat)
		//			return SkullTypes.bat.getStack();
		//		else if(entity instanceof EntitySlime && ((EntitySlime) entity).getSlimeSize() == 1)
		//		{
		//			if(entity instanceof EntityMagmaCube)
		//				return SkullTypes.magmaCube.getStack();
		//			return SkullTypes.slime.getStack();
		//		}
		//		else if(entity instanceof EntitySnowman)
		//			return SkullTypes.snowMan.getStack();
		//
		//		return null;
		//		
		return super.getHeadForEntity(entityName, ent);
	}

	@Override
	public String getTextureLocBase()
	{
		return Strings.MC_PREFIX;
	}
}