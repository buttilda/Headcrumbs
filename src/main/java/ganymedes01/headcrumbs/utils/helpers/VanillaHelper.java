package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.Headcrumbs;
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
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityElderGuardian;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityPolarBear;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.EntityZombieVillager;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityDonkey;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityMule;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySkeletonHorse;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.passive.EntityZombieHorse;
import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;
import slimeknights.tconstruct.library.TinkerRegistry;

public class VanillaHelper extends HeadDropHelper
{

	// This is done so that changing a mobs id name in the future isn't trivial and is only in one place instead of two
	private static String bat = "bat";
	private static String blaze = "blaze";
	private static String cave_spider = "cave_spider";
	private static String chicken = "chicken";
	private static String cow = "cow";
	private static String donkey = "donkey";
	private static String enderman = "enderman";
	private static String endermite = "endermite";
	private static String elder_guardian = "elder_guardian";
	private static String ghast = "ghast";
	private static String guardian = "guardian";
	private static String horse_black = "horse_black";
	private static String horse_brown = "horse_brown";
	private static String horse_chestnut = "horse_chestnut";
	private static String horse_creamy = "horse_creamy";
	private static String horse_darkbrown = "horse_darkbrown";
	private static String horse_gray = "horse_gray";
	private static String horse_skeleton = "horse_skeleton";
	private static String horse_white = "horse_white";
	private static String horse_zombie = "zombie_horse";
	private static String iron_golem = "villager_golem";
	private static String magma_cube = "magma_cube";
	private static String mooshroom = "mooshroom";
	private static String mule = "mule";
	private static String ocelot = "ocelot";
	private static String ocelot_black = "ocelot_black";
	private static String ocelot_red = "ocelot_red";
	private static String ocelot_siamese = "ocelot_siamese";
	private static String polar_bear = "polar_bear";
	private static String pig = "pig";
	private static String rabbit_black = "rabbit_black";
	private static String rabbit_brown = "rabbit_brown";
	private static String rabbit_gold = "rabbit_gold";
	private static String rabbit_salt = "rabbit_salt";
	private static String rabbit_toast = "rabbit_toast";
	private static String rabbit_white = "rabbit_white";
	private static String rabbit_white_splotched = "rabbit_white_splotched";
	private static String sheep = "sheep";
	private static String silverfish = "silverfish";
	private static String slime = "slime";
	private static String snowman = "snowman";
	private static String spider = "spider";
	private static String squid = "squid";
	private static String villager = "villager";
	private static String witch = "witch";
	private static String wither = "wither";
	private static String wolf = "wolf";
	private static String zombie_villager = "zombie_villager";
	private static String zombie_pigman = "zombie_pigman";

	public VanillaHelper()
	{
		super("minecraft");

		super.registerMobHead(bat, BatHead.INSTANCE);
		super.registerMobHead(blaze, ModelHead.INSTANCE_NO_OVERLAY);
		super.registerMobHead(cave_spider, "spider/cave_spider", SpiderHead.INSTANCE);
		super.registerMobHead(chicken, ChickenHead.INSTANCE);
		super.registerMobHead(cow, "cow/cow", CowHead.INSTANCE);
		super.registerMobHead(donkey, "horse/donkey", HorseHead.INSTANCE_MULE);
		super.registerMobHead(enderman, "enderman/enderman", EndermanHead.INSTANCE);
		super.registerMobHead(endermite, EndermiteHead.INSTANCE);
		super.registerMobHead(elder_guardian, "guardian_elder", GuardianHead.INSTANCE);
		super.registerMobHead(ghast, "ghast/ghast", GhastHead.INSTANCE);
		super.registerMobHead(guardian, GuardianHead.INSTANCE);
		super.registerMobHead(horse_black, "horse/horse_black", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(horse_brown, "horse/horse_brown", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(horse_chestnut, "horse/horse_chestnut", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(horse_creamy, "horse/horse_creamy", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(horse_darkbrown, "horse/horse_darkbrown", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(horse_gray, "horse/horse_gray", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(horse_white, "horse/horse_white", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(horse_skeleton, "horse/horse_skeleton", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(horse_zombie, "horse/horse_zombie", HorseHead.INSTANCE_HORSE);
		super.registerMobHead(iron_golem, "iron_golem", VillagerHead.INSTANCE128);
		super.registerMobHead(magma_cube, "slime/magmacube", MagmaCubeHead.INSTANCE);
		super.registerMobHead(mooshroom, "cow/mooshroom", MooshroomHead.INSTANCE);
		super.registerMobHead(mule, "horse/mule", HorseHead.INSTANCE_MULE);
		super.registerMobHead(ocelot, "cat/ocelot", OcelotHead.INSTANCE);
		super.registerMobHead(ocelot_black, "cat/black", OcelotHead.INSTANCE);
		super.registerMobHead(ocelot_red, "cat/red", OcelotHead.INSTANCE);
		super.registerMobHead(ocelot_siamese, "cat/siamese", OcelotHead.INSTANCE);
		super.registerMobHead(polar_bear, "bear/polarbear", PolarBearHead.INSTANCE);
		super.registerMobHead(pig, "pig/pig", PigHead.INSTANCE);
		super.registerMobHead(rabbit_black, "rabbit/black", RabbitHead.INSTANCE);
		super.registerMobHead(rabbit_brown, "rabbit/brown", RabbitHead.INSTANCE);
		super.registerMobHead(rabbit_gold, "rabbit/gold", RabbitHead.INSTANCE);
		super.registerMobHead(rabbit_salt, "rabbit/salt", RabbitHead.INSTANCE);
		super.registerMobHead(rabbit_toast, "rabbit/toast", RabbitHead.INSTANCE);
		super.registerMobHead(rabbit_white, "rabbit/white", RabbitHead.INSTANCE);
		super.registerMobHead(rabbit_white_splotched, "rabbit/white_splotched", RabbitHead.INSTANCE);
		super.registerMobHead(sheep, "sheep/sheep", SheepHead.INSTANCE);
		super.registerMobHead(silverfish, SilverfishHead.INSTANCE);
		super.registerMobHead(slime, "slime/slime", SlimeHead.INSTANCE);
		super.registerMobHead(snowman, SnowmanHead.INSTANCE);
		super.registerMobHead(spider, "spider/spider", SpiderHead.INSTANCE);
		super.registerMobHead(squid, SquidHead.INSTANCE);
		super.registerMobHead(villager, "villager/villager", VillagerHead.INSTANCE);
		super.registerMobHead(witch, WitchHead.INSTANCE);
		super.registerMobHead(wither, "wither/wither", WitherHead.INSTANCE);
		super.registerMobHead(wolf, "wolf/wolf", WolfHead.INSTANCE);
		super.registerMobHead(zombie_villager, "zombie/zombie_villager", ZombieVillagerHead.INSTANCE);
		super.registerMobHead(zombie_pigman, PigmanHead.INSTANCE);
	}

	@Override
	public void registerTinkersHeadDrops() {
		TConstructHelper.registerHeadDrop(EntityBat.class);
		TConstructHelper.registerHeadDrop(EntityBlaze.class);
		TConstructHelper.registerHeadDrop(EntityCaveSpider.class);
		TConstructHelper.registerHeadDrop(EntityChicken.class);
		TConstructHelper.registerHeadDrop(EntityCow.class);
		TConstructHelper.registerHeadDrop(EntityDonkey.class);
		TConstructHelper.registerHeadDrop(EntityEnderman.class);
		TConstructHelper.registerHeadDrop(EntityEndermite.class);
		TConstructHelper.registerHeadDrop(EntityElderGuardian.class);
		TConstructHelper.registerHeadDrop(EntityGhast.class);
		TConstructHelper.registerHeadDrop(EntityGuardian.class);
		TConstructHelper.registerHeadDrop(EntityHorse.class);
		TConstructHelper.registerHeadDrop(EntitySkeletonHorse.class);
		TConstructHelper.registerHeadDrop(EntityZombieHorse.class);
		TConstructHelper.registerHeadDrop(EntityIronGolem.class);
		TConstructHelper.registerHeadDrop(EntityMagmaCube.class);
		TConstructHelper.registerHeadDrop(EntityMooshroom.class);
		TConstructHelper.registerHeadDrop(EntityMule.class);
		TConstructHelper.registerHeadDrop(EntityOcelot.class);
		TConstructHelper.registerHeadDrop(EntityPolarBear.class);
		TConstructHelper.registerHeadDrop(EntityPig.class);
		TConstructHelper.registerHeadDrop(EntityRabbit.class);
		TConstructHelper.registerHeadDrop(EntitySheep.class);
		TConstructHelper.registerHeadDrop(EntitySilverfish.class);
		TConstructHelper.registerHeadDrop(EntitySlime.class);
		TConstructHelper.registerHeadDrop(EntitySnowman.class);
		TConstructHelper.registerHeadDrop(EntitySpider.class);
		TConstructHelper.registerHeadDrop(EntityVillager.class);
		TConstructHelper.registerHeadDrop(EntityWitch.class);
		TConstructHelper.registerHeadDrop(EntityWither.class);
		TConstructHelper.registerHeadDrop(EntityWolf.class);
		TConstructHelper.registerHeadDrop(EntityZombieVillager.class);
		TConstructHelper.registerHeadDrop(EntityPigZombie.class);
	}
	
	@Override
	public ItemStack getHeadForEntity(String entityName, Entity entity)
	{
		// Could easily add the mod names to the map like in the other
		// cases
		// but it would stop heads from dropping from other mod's mobs
		// that
		// extend the vanilla ones

		if(entity instanceof EntityMob)
		{
			if(entity instanceof EntityBlaze)
				return getStack(modID, blaze);
			else if(entity instanceof EntityEnderman)
				return getStack(modID, enderman);
			else if(entity instanceof EntityEndermite)
				return getStack(modID, endermite);
			else if(entity instanceof EntityElderGuardian)
				return getStack(modID, elder_guardian);
			else if(entity instanceof EntityGuardian)
				return getStack(modID, guardian);
			else if(entity instanceof EntityZombie)
			{
				if(entity instanceof EntityPigZombie)
					return getStack(modID, zombie_pigman);
				else if(entity instanceof EntityZombieVillager)
					return getStack(modID, zombie_villager);
			}
			else if(entity instanceof EntitySilverfish)
				return getStack(modID, silverfish);
			else if(entity instanceof EntitySpider)
			{
				if(entity instanceof EntityCaveSpider)
					return getStack(modID, cave_spider);
				return getStack(modID, spider);
			}
			else if(entity instanceof EntityWitch)
				return getStack(modID, witch);
			else if(entity instanceof EntityWither)
				return getStack(modID, wither);
		}
		else if(entity instanceof EntityAnimal)
		{
			if(entity instanceof EntityChicken)
				return getStack(modID, chicken);
			else if(entity instanceof EntityCow)
			{
				if(entity instanceof EntityMooshroom)
					return getStack(modID, mooshroom);
				return getStack(modID, cow);
			}
			else if(entity instanceof EntityHorse)
			{
				int type = ((EntityHorse) entity).getHorseVariant();

				if(type == 0)
					switch(((EntityHorse) entity).getHorseVariant() & 255)
					{
						case 0:
							return getStack(modID, horse_white);
						case 1:
							return getStack(modID, horse_creamy);
						case 2:
							return getStack(modID, horse_chestnut);
						case 3:
							return getStack(modID, horse_brown);
						case 4:
							return getStack(modID, horse_black);
						case 5:
							return getStack(modID, horse_gray);
						case 6:
							return getStack(modID, horse_darkbrown);
					}
				else if(type == 1)
					return getStack(modID, donkey);
				else if(type == 2)
					return getStack(modID, mule);
				else if(type == 3)
					return getStack(modID, horse_zombie);
				else if(type == 4)
					return getStack(modID, horse_skeleton);
			}
			else if(entity instanceof EntityOcelot)
			{
				switch(((EntityOcelot) entity).getTameSkin())
				{
					case 0:
						return getStack(modID, ocelot);
					case 1:
						return getStack(modID, ocelot_black);
					case 2:
						return getStack(modID, ocelot_red);
					case 3:
						return getStack(modID, ocelot_siamese);
				}
			}
			else if(entity instanceof EntityPolarBear)
				return getStack(modID, polar_bear);
			else if(entity instanceof EntityPig)
				return getStack(modID, pig);
			else if(entity instanceof EntityRabbit)
			{
				String name = entity.getName();
				if(name != null && name.equals("Toast"))
					return getStack(modID, rabbit_toast);

				int rabbitType = ((EntityRabbit) entity).getRabbitType();
				switch(rabbitType)
				{
					case 0:
						return getStack(modID, rabbit_brown);
					case 1:
						return getStack(modID, rabbit_white);
					case 2:
						return getStack(modID, rabbit_black);
					case 3:
						return getStack(modID, rabbit_white_splotched);
					case 4:
						return getStack(modID, rabbit_gold);
					case 5:
						return getStack(modID, rabbit_salt);
				}
			}
			else if(entity instanceof EntitySheep)
				return getStack(modID, sheep);
			else if(entity instanceof EntityWolf)
				return getStack(modID, wolf);
		}
		else if(entity instanceof EntityBat)
			return getStack(modID, bat);
		else if(entity instanceof EntityGhast)
			return getStack(modID, ghast);
		else if(entity instanceof EntityIronGolem)
			return getStack(modID, iron_golem);
		else if(entity instanceof EntitySlime && ((EntitySlime) entity).getSlimeSize() == 1)
		{
			if(entity instanceof EntityMagmaCube)
				return getStack(modID, magma_cube);
			return getStack(modID, slime);
		}
		else if(entity instanceof EntitySnowman)
			return getStack(modID, snowman);
		else if(entity instanceof EntitySquid)
			return getStack(modID, squid);
		else if(entity instanceof EntityVillager)
			return getStack(modID, villager);

		return super.getHeadForEntity(entityName, entity);
	}

	@Override
	public String getTextureLocBase()
	{
		return Strings.MC_PREFIX;
	}
}