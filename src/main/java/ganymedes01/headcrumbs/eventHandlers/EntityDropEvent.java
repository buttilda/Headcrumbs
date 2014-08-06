package ganymedes01.headcrumbs.eventHandlers;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.HeadUtils;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityDropEvent {

	@SubscribeEvent
	public void dropEvent(LivingDropsEvent event) {
		if (event.entityLiving.worldObj.isRemote)
			return;
		if (event.entityLiving.getHealth() > 0.0F)
			return;

		if (shouldDoRandomDrop(event.entityLiving.worldObj.rand, event.lootingLevel) || isPoweredCreeper(event.source)) {
			ItemStack stack = HeadUtils.getHeadfromEntity(event.entityLiving);
			if (stack != null && canDropThisHead(stack)) {
				if (!isPlayerHead(stack) && !Headcrumbs.enableMobsAndAnimalHeads)
					return;
				addDrop(stack, event.entityLiving, event.drops);
			}
		}
	}

	private boolean isPoweredCreeper(DamageSource source) {
		if (source.isExplosion() && source instanceof EntityDamageSource) {
			Entity entity = ((EntityDamageSource) source).getEntity();
			if (entity != null && entity instanceof EntityCreeper) {
				EntityCreeper creeper = (EntityCreeper) entity;
				return creeper.getPowered();
			}
		}

		return false;
	}

	private boolean canDropThisHead(ItemStack stack) {
		return stack.getItem() == Items.skull ? stack.getItemDamage() != 1 && Headcrumbs.enableVanillaHeadsDrop : true;
	}

	private boolean isPlayerHead(ItemStack stack) {
		return stack.getItemDamage() == SkullTypes.player.ordinal();
	}

	private boolean shouldDoRandomDrop(Random rand, int looting) {
		return Headcrumbs.enableRandomHeadDrop && rand.nextInt(Headcrumbs.headDropChance / Math.max(looting, 1)) == 0;
	}

	private void addDrop(ItemStack stack, EntityLivingBase entity, List<EntityItem> list) {
		if (stack.stackSize <= 0)
			return;

		EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
		entityItem.delayBeforeCanPickup = 10;
		list.add(entityItem);
	}
}