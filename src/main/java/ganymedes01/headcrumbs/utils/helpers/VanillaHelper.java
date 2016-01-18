package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityEndermite;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGuardian;
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
import net.minecraft.entity.passive.EntityRabbit;
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
				if (((EntitySkeleton) entity).getSkeletonType() == 0) // Only drop normal skeleton's head. Vanilla handles withers
					return new ItemStack(Items.skull, 1, 0);
			} else if (entity instanceof EntityZombie) {
				if (entity instanceof EntityPigZombie)
					return SkullTypes.pigman.getStack();
				else if (((EntityZombie) entity).isVillager())
					return SkullTypes.zombieVillager.getStack();
				else
					return new ItemStack(Items.skull, 1, 2);
			} else if (entity instanceof EntityEnderman)
				return SkullTypes.enderman.getStack();
			else if (entity instanceof EntityBlaze)
				return SkullTypes.blaze.getStack();
			else if (entity instanceof EntitySpider) {
				if (entity instanceof EntityCaveSpider)
					return SkullTypes.caveSpider.getStack();
				return SkullTypes.spider.getStack();
			} else if (entity instanceof EntityWitch)
				return SkullTypes.witch.getStack();
			else if (entity instanceof EntityWither)
				return SkullTypes.wither.getStack(1 + (entity.worldObj.rand.nextInt(100) == 0 ? 1 + entity.worldObj.rand.nextInt(2) : 0));
			else if (entity instanceof EntitySilverfish)
				return SkullTypes.silverfish.getStack();
			else if (entity instanceof EntityGuardian)
				return (((EntityGuardian) entity).isElder() ? SkullTypes.guardianElder : SkullTypes.guardian).getStack();
			else if (entity instanceof EntityEndermite)
				return SkullTypes.endermite.getStack();
		} else if (entity instanceof EntityAnimal) {
			if (entity instanceof EntityPig)
				return SkullTypes.pig.getStack();
			else if (entity instanceof EntityCow) {
				if (entity instanceof EntityMooshroom)
					return SkullTypes.mooshroom.getStack();
				else
					return SkullTypes.cow.getStack();
			} else if (entity instanceof EntitySheep)
				return SkullTypes.sheep.getStack();
			else if (entity instanceof EntityWolf)
				return SkullTypes.wolf.getStack();
			else if (entity instanceof EntityChicken)
				return SkullTypes.chicken.getStack();
			else if (entity instanceof EntityOcelot)
				switch (((EntityOcelot) entity).getTameSkin()) {
					case 0:
						return SkullTypes.ocelot.getStack();
					case 1:
						return SkullTypes.ocelotBlack.getStack();
					case 2:
						return SkullTypes.ocelotRed.getStack();
					case 3:
						return SkullTypes.ocelotSiamese.getStack();
				}
			else if (entity instanceof EntityHorse) {
				int type = ((EntityHorse) entity).getHorseType();

				if (type == 0)
					switch (((EntityHorse) entity).getHorseVariant() & 255) {
						case 0:
							return SkullTypes.horseWhite.getStack();
						case 1:
							return SkullTypes.horseCreamy.getStack();
						case 2:
							return SkullTypes.horseChestnut.getStack();
						case 3:
							return SkullTypes.horseBrown.getStack();
						case 4:
							return SkullTypes.horseBlack.getStack();
						case 5:
							return SkullTypes.horseGrey.getStack();
						case 6:
							return SkullTypes.horseDarkBrown.getStack();
					}
				else if (type == 1)
					return SkullTypes.donkey.getStack();
				else if (type == 2)
					return SkullTypes.mule.getStack();
				else if (type == 3)
					return SkullTypes.horseUndead.getStack();
				else if (type == 4)
					return SkullTypes.horseSkeleton.getStack();
			} else if (entity instanceof EntityRabbit) {
				String name = entity.getName();
				if (name != null && name.equals("Toast"))
					return SkullTypes.rabbitToast.getStack();

				int rabbitType = ((EntityRabbit) entity).getRabbitType();
				switch (rabbitType) {
					case 0:
						return SkullTypes.rabbitBrown.getStack();
					case 1:
						return SkullTypes.rabbitWhite.getStack();
					case 2:
						return SkullTypes.rabbitBlack.getStack();
					case 3:
						return SkullTypes.rabbitSplotched.getStack();
					case 4:
						return SkullTypes.rabbitGold.getStack();
					case 5:
						return SkullTypes.rabbitSalt.getStack();
				}
			}
		} else if (entity instanceof EntityVillager)
			return SkullTypes.villager.getStack();
		else if (entity instanceof EntityIronGolem)
			return SkullTypes.ironGolem.getStack();
		else if (entity instanceof EntitySquid)
			return SkullTypes.squid.getStack();
		else if (entity instanceof EntityGhast)
			return SkullTypes.ghast.getStack();
		else if (entity instanceof EntityDragon)
			return SkullTypes.enderDragon.getStack();
		else if (entity instanceof EntityBat)
			return SkullTypes.bat.getStack();
		else if (entity instanceof EntitySlime && ((EntitySlime) entity).getSlimeSize() == 1) {
			if (entity instanceof EntityMagmaCube)
				return SkullTypes.magmaCube.getStack();
			return SkullTypes.slime.getStack();
		} else if (entity instanceof EntitySnowman)
			return SkullTypes.snowMan.getStack();

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