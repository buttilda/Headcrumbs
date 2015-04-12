package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
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
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class VanillaHelper extends HeadDropHelper {

	public VanillaHelper() {
		super("minecraft");
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		// Could easily add the mod names to the map like in the other cases
		// but it would stop heads from dropping from other mod's mobs that extend the vanilla ones

		if (entity instanceof EntityMob) {
			if (entity instanceof EntityCreeper)
				return new ItemStack(Items.skull, 1, 4);
			else if (entity instanceof EntitySkeleton) {
				int type = ((EntitySkeleton) entity).getSkeletonType();
				if (type == 1) // Wither
					return new ItemStack(Items.skull, 1, 1);
				else if (type == 0) // Normal
					return new ItemStack(Items.skull, 1, 0);
			} else if (entity instanceof EntityZombie) {
				if (entity instanceof EntityPigZombie)
					return new ItemStack(ModItems.skull, 1, SkullTypes.pigman.ordinal());
				else if (((EntityZombie) entity).isVillager())
					return new ItemStack(ModItems.skull, 1, SkullTypes.zombieVillager.ordinal());
				else
					return new ItemStack(Items.skull, 1, 2);
			} else if (entity instanceof EntityEnderman)
				return new ItemStack(ModItems.skull, 1, SkullTypes.enderman.ordinal());
			else if (entity instanceof EntityBlaze)
				return new ItemStack(ModItems.skull, 1, SkullTypes.blaze.ordinal());
			else if (entity instanceof EntitySpider) {
				if (entity instanceof EntityCaveSpider)
					return new ItemStack(ModItems.skull, 1, SkullTypes.caveSpider.ordinal());
				return new ItemStack(ModItems.skull, 1, SkullTypes.spider.ordinal());
			} else if (entity instanceof EntityWitch)
				return new ItemStack(ModItems.skull, 1, SkullTypes.witch.ordinal());
			else if (entity instanceof EntityWither)
				return new ItemStack(ModItems.skull, 1 + (entity.worldObj.rand.nextInt(100) == 0 ? 1 + entity.worldObj.rand.nextInt(2) : 0), SkullTypes.wither.ordinal());
			else if (entity instanceof EntitySilverfish)
				return new ItemStack(ModItems.skull, 1, SkullTypes.silverfish.ordinal());
		} else if (entity instanceof EntityAnimal) {
			if (entity instanceof EntityPig)
				return new ItemStack(ModItems.skull, 1, SkullTypes.pig.ordinal());
			else if (entity instanceof EntityCow) {
				if (entity instanceof EntityMooshroom)
					return new ItemStack(ModItems.skull, 1, SkullTypes.mooshroom.ordinal());
				else
					return new ItemStack(ModItems.skull, 1, SkullTypes.cow.ordinal());
			} else if (entity instanceof EntitySheep)
				return new ItemStack(ModItems.skull, 1, SkullTypes.sheep.ordinal());
			else if (entity instanceof EntityWolf)
				return new ItemStack(ModItems.skull, 1, SkullTypes.wolf.ordinal());
			else if (entity instanceof EntityChicken)
				return new ItemStack(ModItems.skull, 1, SkullTypes.chicken.ordinal());
			else if (entity instanceof EntityOcelot)
				switch (((EntityOcelot) entity).getTameSkin()) {
					case 0:
						return new ItemStack(ModItems.skull, 1, SkullTypes.ocelot.ordinal());
					case 1:
						return new ItemStack(ModItems.skull, 1, SkullTypes.ocelotBlack.ordinal());
					case 2:
						return new ItemStack(ModItems.skull, 1, SkullTypes.ocelotRed.ordinal());
					case 3:
						return new ItemStack(ModItems.skull, 1, SkullTypes.ocelotSiamese.ordinal());
				}
			else if (entity instanceof EntityHorse) {
				int type = ((EntityHorse) entity).getHorseType();

				if (type == 0)
					switch (((EntityHorse) entity).getHorseVariant() & 255) {
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
		} else if (entity instanceof EntityVillager)
			return new ItemStack(ModItems.skull, 1, SkullTypes.villager.ordinal());
		else if (entity instanceof EntityIronGolem)
			return new ItemStack(ModItems.skull, 1, SkullTypes.ironGolem.ordinal());
		else if (entity instanceof EntitySquid)
			return new ItemStack(ModItems.skull, 1, SkullTypes.squid.ordinal());
		else if (entity instanceof EntityGhast)
			return new ItemStack(ModItems.skull, 1, SkullTypes.ghast.ordinal());
		else if (entity instanceof EntityDragon)
			return new ItemStack(ModItems.skull, 1, SkullTypes.enderDragon.ordinal());
		else if (entity instanceof EntityBat)
			return new ItemStack(ModItems.skull, 1, SkullTypes.bat.ordinal());
		else if (entity instanceof EntitySlime && ((EntitySlime) entity).getSlimeSize() == 1) {
			if (entity instanceof EntityMagmaCube)
				return new ItemStack(ModItems.skull, 1, SkullTypes.magmaCube.ordinal());
			return new ItemStack(ModItems.skull, 1, SkullTypes.slime.ordinal());
		} else if (entity instanceof EntitySnowman)
			return new ItemStack(ModItems.skull, 1, SkullTypes.snowMan.ordinal());

		return null;
	}

	@Override
	protected boolean isEnabled() {
		return true;
	}

	@Override
	public int compareTo(HeadDropHelper obj) {
		return 1;
	}
}