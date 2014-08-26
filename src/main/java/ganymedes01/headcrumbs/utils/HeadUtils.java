package ganymedes01.headcrumbs.utils;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.Loader;

public class HeadUtils {

	public static final List<ItemStack> players = new LinkedList<ItemStack>();

	public static void loadPlayerHeads() {
		Random rand = new Random();

		List<String> allNames = new LinkedList<String>();
		allNames.addAll(Arrays.asList(Headcrumbs.others));
		allNames.addAll(Arrays.asList(Headcrumbs.modders));
		allNames.addAll(Arrays.asList(Headcrumbs.youtubers));
		allNames.addAll(Arrays.asList(Headcrumbs.mojang));
		allNames.addAll(Arrays.asList(Headcrumbs.mindCrack));
		allNames.addAll(Arrays.asList(Headcrumbs.forgeCraft));
		allNames.addAll(Arrays.asList(Headcrumbs.ftb));

		Collections.sort(allNames, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return s1.toLowerCase().compareTo(s2.toLowerCase());
			}
		});

		for (String name : allNames) {
			name = name.trim();
			if (name == null || name.isEmpty())
				continue;

			ItemStack head = createHeadFor(name);
			if (Headcrumbs.addPlayerHeadsAsDungeonLoot) {
				rand.setSeed(name.hashCode());
				Utils.addDungeonLoot(head.copy(), 1, 1, 1 + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
				Utils.addStrongholdLoot(head.copy(), 1, 1, 2 + rand.nextInt(Math.max(1, Headcrumbs.headsDungeonLootMaxWeight - 1)));
			}

			players.add(head);
		}
	}

	public static ItemStack getHeadfromEntity(EntityLivingBase target) {
		if (target.isChild())
			return null;

		if (Loader.isModLoaded("TwilightForest")) {
			ItemStack head = getTFMobHead(target);
			if (head != null)
				return head;
		}

		if (Loader.isModLoaded("ThermalExpansion")) {
			ItemStack head = getTEMobHead(target);
			if (head != null)
				return head;
		}

		if (Loader.isModLoaded("Natura")) {
			ItemStack head = getNaturaHead(target);
			if (head != null)
				return head;
		}

		if (Loader.isModLoaded("Thaumcraft")) {
			ItemStack head = getThaumcraftHead(target);
			if (head != null)
				return head;
		}

		if (target instanceof EntityMob) {
			if (target instanceof EntityCreeper)
				return new ItemStack(Items.skull, 1, 4);
			else if (target instanceof EntitySkeleton) {
				int type = ((EntitySkeleton) target).getSkeletonType();
				if (type == 1) // Wither
					return new ItemStack(Items.skull, 1, 1);
				else if (type == 0) // Normal
					return new ItemStack(Items.skull, 1, 0);
			} else if (target instanceof EntityZombie) {
				if (target instanceof EntityPigZombie)
					return new ItemStack(ModItems.skull, 1, SkullTypes.pigman.ordinal());
				else if (((EntityZombie) target).isVillager())
					return new ItemStack(ModItems.skull, 1, SkullTypes.zombieVillager.ordinal());
				else
					return new ItemStack(Items.skull, 1, 2);
			} else if (target instanceof EntityEnderman)
				return new ItemStack(ModItems.skull, 1, SkullTypes.enderman.ordinal());
			else if (target instanceof EntityBlaze)
				return new ItemStack(ModItems.skull, 1, SkullTypes.blaze.ordinal());
			else if (target instanceof EntitySpider) {
				if (target instanceof EntityCaveSpider)
					return new ItemStack(ModItems.skull, 1, SkullTypes.caveSpider.ordinal());
				return new ItemStack(ModItems.skull, 1, SkullTypes.spider.ordinal());
			} else if (target instanceof EntityWitch)
				return new ItemStack(ModItems.skull, 1, SkullTypes.witch.ordinal());
			else if (target instanceof EntityWither)
				return new ItemStack(ModItems.skull, 1 + (target.worldObj.rand.nextInt(100) == 0 ? 1 + target.worldObj.rand.nextInt(2) : 0), SkullTypes.wither.ordinal());
			else if (target instanceof EntitySilverfish)
				return new ItemStack(ModItems.skull, 1, SkullTypes.silverfish.ordinal());
		} else if (target instanceof EntityPlayer)
			return createHeadFor((EntityPlayer) target);
		else if (target instanceof EntityAnimal) {
			if (target instanceof EntityPig)
				return new ItemStack(ModItems.skull, 1, SkullTypes.pig.ordinal());
			else if (target instanceof EntityCow) {
				if (target instanceof EntityMooshroom)
					return new ItemStack(ModItems.skull, 1, SkullTypes.mooshroom.ordinal());
				else
					return new ItemStack(ModItems.skull, 1, SkullTypes.cow.ordinal());
			} else if (target instanceof EntitySheep)
				return new ItemStack(ModItems.skull, 1, SkullTypes.sheep.ordinal());
			else if (target instanceof EntityWolf)
				return new ItemStack(ModItems.skull, 1, SkullTypes.wolf.ordinal());
			else if (target instanceof EntityChicken)
				return new ItemStack(ModItems.skull, 1, SkullTypes.chicken.ordinal());
			else if (target instanceof EntityOcelot)
				switch (((EntityOcelot) target).getTameSkin()) {
					case 0:
						return new ItemStack(ModItems.skull, 1, SkullTypes.ocelot.ordinal());
					case 1:
						return new ItemStack(ModItems.skull, 1, SkullTypes.ocelotBlack.ordinal());
					case 2:
						return new ItemStack(ModItems.skull, 1, SkullTypes.ocelotRed.ordinal());
					case 3:
						return new ItemStack(ModItems.skull, 1, SkullTypes.ocelotSiamese.ordinal());
				}
			else if (target instanceof EntityHorse) {
				int type = ((EntityHorse) target).getHorseType();

				if (type == 0)
					switch (((EntityHorse) target).getHorseVariant() & 255) {
						case 0:
							return new ItemStack(ModItems.skull, 1, SkullTypes.horseWhite.ordinal());
						case 1:
							return new ItemStack(ModItems.skull, 1, SkullTypes.horseCreamy.ordinal());
						case 2:
							return new ItemStack(ModItems.skull, 1, SkullTypes.horseChestnut.ordinal());
						case 3:
							return new ItemStack(ModItems.skull, 1, SkullTypes.horseBrown.ordinal());
						case 4:
							return new ItemStack(ModItems.skull, 1, SkullTypes.horseBlack.ordinal());
						case 5:
							return new ItemStack(ModItems.skull, 1, SkullTypes.horseGrey.ordinal());
						case 6:
							return new ItemStack(ModItems.skull, 1, SkullTypes.horseDarkBrown.ordinal());
					}
				else if (type == 1)
					return new ItemStack(ModItems.skull, 1, SkullTypes.donkey.ordinal());
				else if (type == 2)
					return new ItemStack(ModItems.skull, 1, SkullTypes.mule.ordinal());
				else if (type == 3)
					return new ItemStack(ModItems.skull, 1, SkullTypes.horseUndead.ordinal());
				else if (type == 4)
					return new ItemStack(ModItems.skull, 1, SkullTypes.horseSkeleton.ordinal());
			}
		} else if (target instanceof EntityVillager)
			return new ItemStack(ModItems.skull, 1, SkullTypes.villager.ordinal());
		else if (target instanceof EntityIronGolem)
			return new ItemStack(ModItems.skull, 1, SkullTypes.ironGolem.ordinal());
		else if (target instanceof EntitySquid)
			return new ItemStack(ModItems.skull, 1, SkullTypes.squid.ordinal());
		else if (target instanceof EntityGhast)
			return new ItemStack(ModItems.skull, 1, SkullTypes.ghast.ordinal());
		else if (target instanceof EntityDragon)
			return new ItemStack(ModItems.skull, 1, SkullTypes.enderDragon.ordinal());
		else if (target instanceof EntityBat)
			return new ItemStack(ModItems.skull, 1, SkullTypes.bat.ordinal());
		else if (target instanceof EntitySlime && ((EntitySlime) target).getSlimeSize() == 1) {
			if (target instanceof EntityMagmaCube)
				return new ItemStack(ModItems.skull, 1, SkullTypes.magmaCube.ordinal());
			return new ItemStack(ModItems.skull, 1, SkullTypes.slime.ordinal());
		} else if (target instanceof EntitySnowman)
			return new ItemStack(ModItems.skull, 1, SkullTypes.snowMan.ordinal());

		return null;
	}

	public static ItemStack createHeadFor(String username) {
		return createHeadFor(new GameProfile(UUID.nameUUIDFromBytes(username.getBytes()), username));
	}

	public static ItemStack createHeadFor(EntityPlayer player) {
		return createHeadFor(player.getGameProfile());
	}

	public static ItemStack createHeadFor(GameProfile profile) {
		ItemStack stack = new ItemStack(ModItems.skull, 1, SkullTypes.player.ordinal());
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound profileData = new NBTTagCompound();
		NBTUtil.func_152460_a(profileData, profile);
		stack.getTagCompound().setTag("SkullOwner", profileData);

		return stack;
	}

	private static ItemStack getTFMobHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		if (mobName.equals("TwilightForest.Forest Bunny")) {
			Integer type;
			try {
				type = (Integer) entity.getClass().getMethod("getBunnyType").invoke(entity);
			} catch (Exception e) {
				type = 0;
			}
			int meta = 0;
			switch (type) {
				case 0:
				case 1:
					meta = SkullTypes.bunnyDutch.ordinal();
					break;
				case 3:
					meta = SkullTypes.bunnyBrown.ordinal();
					break;
				case 2:
					meta = SkullTypes.bunnyWhite.ordinal();
					break;
			}
			return new ItemStack(ModItems.skull, 1, meta);
		} else if (mobName.equals("TwilightForest.Penguin"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.penguin.ordinal());
		else if (mobName.equals("TwilightForest.Bighorn Sheep"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.bighorn.ordinal());
		else if (mobName.equals("TwilightForest.Wild Deer"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.wildDeer.ordinal());
		else if (mobName.equals("TwilightForest.Wild Boar"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.wildBoar.ordinal());
		else if (mobName.equals("TwilightForest.Redcap") || mobName.equals("TwilightForest.Redcap Sapper"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.redcap.ordinal());
		else if (mobName.equals("TwilightForest.Skeleton Druid"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.druid.ordinal());
		else if (mobName.equals("TwilightForest.Hedge Spider"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.hedgeSpider.ordinal());
		else if (mobName.equals("TwilightForest.Mist Wolf"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.mistWolf.ordinal());
		else if (mobName.equals("TwilightForest.Mini Ghast"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.miniGhast.ordinal());
		else if (mobName.equals("TwilightForest.Tower Ghast"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.guardGhast.ordinal());
		else if (mobName.equals("TwilightForest.King Spider"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.kingSpider.ordinal());
		else if (mobName.equals("TwilightForest.Kobold"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.kobold.ordinal());
		else if (mobName.equals("TwilightForest.Fire Beetle"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.fireBeetle.ordinal());
		else if (mobName.equals("TwilightForest.Slime Beetle"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.slimeBeetle.ordinal());
		else if (mobName.equals("TwilightForest.Pinch Beetle"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.pinchBeetle.ordinal());
		else if (mobName.equals("TwilightForest.Tower Golem"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.towerGolem.ordinal());
		else if (mobName.equals("TwilightForest.Hostile Wolf"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.hostileWolf.ordinal());
		else if (mobName.equals("TwilightForest.Forest Squirrel"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.hostileWolf.ordinal());
		else if (mobName.equals("TwilightForest.Swarm Spider"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.swarmSpider.ordinal());
		else if (mobName.equals("TwilightForest.Redscale Broodling"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.towerBroodling.ordinal());
		else if (mobName.equals("TwilightForest.WinterWolf"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.winterWolf.ordinal());
		else if (mobName.equals("TwilightForest.Maze Slime") && ((EntitySlime) entity).getSlimeSize() == 1)
			return new ItemStack(ModItems.skull, 1, SkullTypes.mazeSlime.ordinal());
		else if (mobName.equals("TwilightForest.Tower Termite"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.towerwoodBorer.ordinal());
		else
			return null;
	}

	private static ItemStack getTEMobHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		if (mobName.equals("Blizz"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.blizz.ordinal());
		else
			return null;
	}

	private static ItemStack getNaturaHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		else if (mobName.equals("Natura.Imp"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.imp.ordinal());
		else if (mobName.equals("Natura.NitroCreeper"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.nitroCreeper.ordinal());
		else if (mobName.equals("Natura.FlameSpiderBaby"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.heatscarSpider.ordinal());
		else
			return null;
	}

	private static ItemStack getThaumcraftHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		else if (mobName.equals("Thaumcraft.BrainyZombie") || mobName.equals("Thaumcraft.GiantBrainyZombie"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.angryZombie.ordinal());
		else if (mobName.equals("Thaumcraft.Firebat"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.fireBat.ordinal());
		else if (mobName.equals("Thaumcraft.ThaumSlime") && getThaumicSlimeSize(entity) == 1)
			return new ItemStack(ModItems.skull, 1, SkullTypes.thaumicSlime.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedChicken"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedChicken.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedCow"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedCow.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedPig"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedPig.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedCreeper"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedCreeper.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedVillager"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedVillager.ordinal());
		else if (mobName.equals("Thaumcraft.TaintedSheep"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.taintedVillager.ordinal());
		else if (mobName.equals("Thaumcraft.Pech"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.pech.ordinal());
		else if (mobName.equals("Thaumcraft.EldritchGuardian"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.eldritchGuardian.ordinal());

		return null;
	}

	private static int getThaumicSlimeSize(Entity entity) {
		try {
			Method m = entity.getClass().getMethod("getSlimeSize");
			return (Integer) m.invoke(entity);
		} catch (Exception e) {
			return 0;
		}
	}
}