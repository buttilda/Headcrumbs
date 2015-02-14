package ganymedes01.headcrumbs.utils;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.helpers.EnderZooHelper;
import ganymedes01.headcrumbs.utils.helpers.LycanitesHelper;
import ganymedes01.headcrumbs.utils.helpers.NaturaHelper;
import ganymedes01.headcrumbs.utils.helpers.TEHelper;
import ganymedes01.headcrumbs.utils.helpers.ThaumcraftHelper;
import ganymedes01.headcrumbs.utils.helpers.TwilightForestHelper;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

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
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.util.Constants;

import com.mojang.authlib.GameProfile;

public class HeadUtils {

	public static final List<ItemStack> players = new LinkedList<ItemStack>();

	public static boolean twilightForest = false;
	public static boolean thermalExpansion = false;
	public static boolean natura = false;
	public static boolean thaumcraft = false;
	public static boolean lycanites = false;
	public static boolean enderzoo = false;

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

		if (twilightForest) {
			ItemStack head = TwilightForestHelper.getHead(target);
			if (head != null)
				return head;
		}

		if (thermalExpansion) {
			ItemStack head = TEHelper.getHead(target);
			if (head != null)
				return head;
		}

		if (natura) {
			ItemStack head = NaturaHelper.getHead(target);
			if (head != null)
				return head;
		}

		if (thaumcraft) {
			ItemStack head = ThaumcraftHelper.getHead(target);
			if (head != null)
				return head;
		}

		if (lycanites) {
			ItemStack head = LycanitesHelper.getHead(target);
			if (head != null)
				return head;
		}

		if (enderzoo) {
			ItemStack head = EnderZooHelper.getHead(target);
			if (head != null)
				return head;
		}

		if (target instanceof EntityCelebrity)
			return createHeadFor(((EntityCelebrity) target).getUsername());

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
		return createHeadFor(new GameProfile(null, username));
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

	public static GameProfile getGameProfile(ItemStack stack) {
		GameProfile profile = null;

		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey("SkullOwner", Constants.NBT.TAG_COMPOUND))
				profile = NBTUtil.func_152459_a(nbt.getCompoundTag("SkullOwner"));
			else if (nbt.hasKey("SkullOwner", Constants.NBT.TAG_STRING))
				profile = new GameProfile(null, nbt.getString("SkullOwner"));
			else if (nbt.hasKey("OwnerUUID", Constants.NBT.TAG_STRING)) {
				profile = MinecraftServer.getServer().func_152358_ax().func_152652_a(UUID.fromString(nbt.getString("OwnerUUID")));
				profile = MinecraftServer.getServer().func_147130_as().fillProfileProperties(profile, true);
			}
		}

		return profile;
	}

	public static String getName(ItemStack stack) {
		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey("SkullOwner", Constants.NBT.TAG_COMPOUND))
				return NBTUtil.func_152459_a(nbt.getCompoundTag("SkullOwner")).getName();
			else if (nbt.hasKey("SkullOwner", Constants.NBT.TAG_STRING))
				return nbt.getString("SkullOwner");
		}

		return null;
	}
}