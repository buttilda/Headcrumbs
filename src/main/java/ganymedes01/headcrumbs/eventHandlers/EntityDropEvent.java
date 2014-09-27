package ganymedes01.headcrumbs.eventHandlers;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.HeadUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EntityDropEvent {

	@SubscribeEvent
	public void playerDrop(LivingDeathEvent event) {
		EntityLivingBase entity = event.entityLiving;
		if (entity.worldObj.getGameRules().getGameRuleBooleanValue("keepInventory") && entity instanceof EntityPlayerMP) {
			ArrayList<EntityItem> drops = new ArrayList<EntityItem>();

			ItemStack weapon = getWeapon(event.source);
			int looting = EnchantmentHelper.getEnchantmentLevel(Enchantment.looting.effectId, weapon);
			drop(event.entityLiving, event.source, looting, drops);

			if (!drops.isEmpty())
				for (EntityItem item : drops)
					((EntityPlayerMP) entity).joinEntityItemWithWorld(item);
		}
	}

	@SubscribeEvent
	public void dropEvent(LivingDropsEvent event) {
		drop(event.entityLiving, event.source, event.lootingLevel, event.drops);
	}

	private void drop(EntityLivingBase entity, DamageSource source, int looting, List<EntityItem> drops) {
		if (entity.worldObj.isRemote)
			return;
		if (entity.getHealth() > 0.0F)
			return;

		boolean isPoweredCreeper = Headcrumbs.enableChargedCreeperKills && isPoweredCreeper(source);
		int beheading = getBeaheadingLevel(getWeapon(source));

		if (isPoweredCreeper || shouldDoRandomDrop(entity.worldObj.rand, beheading, looting)) {
			ItemStack stack = HeadUtils.getHeadfromEntity(entity);
			if (stack == null)
				return;

			if (isPoweredCreeper || canDropThisHead(stack, beheading))
				if (isPlayerHead(stack) || Headcrumbs.enableMobsAndAnimalHeads)
					addDrop(stack, entity, drops);
		}
	}

	private boolean isPoweredCreeper(DamageSource source) {
		if (source.isExplosion() && source instanceof EntityDamageSource) {
			Entity entity = ((EntityDamageSource) source).getEntity();
			if (entity != null && entity instanceof EntityCreeper)
				return ((EntityCreeper) entity).getPowered();
		}

		return false;
	}

	private boolean canDropThisHead(ItemStack head, int beheading) {
		if (beheading > 0)
			return head.getItem() != Items.skull && !isPlayerHead(head);

		return head.getItem() == Items.skull ? head.getItemDamage() != 1 && Headcrumbs.enableVanillaHeadsDrop : true;
	}

	private boolean isPlayerHead(ItemStack stack) {
		return stack.getItem() == ModItems.skull && stack.getItemDamage() == SkullTypes.player.ordinal();
	}

	private boolean shouldDoRandomDrop(Random rand, int beheading, int looting) {
		if (beheading > 0)
			return rand.nextInt(100) < beheading * 10;

		return Headcrumbs.enableRandomHeadDrop && rand.nextInt(Headcrumbs.headDropChance / Math.max(looting + 1, 1)) == 0;
	}

	private int getBeaheadingLevel(ItemStack weapon) {
		if (Loader.isModLoaded("TConstruct"))
			try {
				Class<?> TinkerTools = Class.forName("tconstruct.tools.TinkerTools");
				Field field = TinkerTools.getDeclaredField("cleaver");
				field.setAccessible(true);
				Item cleaver = (Item) field.get(null);

				int beheading = weapon.getTagCompound().getCompoundTag("InfiTool").getInteger("Beheading");
				if (cleaver == weapon.getItem())
					beheading += 2;

				return beheading;
			} catch (Exception e) {
			}

		return 0;
	}

	private ItemStack getWeapon(DamageSource source) {
		if (source instanceof EntityDamageSource) {
			Entity entity = ((EntityDamageSource) source).getEntity();
			if (entity instanceof EntityPlayer)
				return ((EntityPlayer) entity).getCurrentEquippedItem();
		}
		return null;
	}

	private void addDrop(ItemStack stack, EntityLivingBase entity, List<EntityItem> list) {
		if (stack.stackSize <= 0)
			return;

		EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
		entityItem.delayBeforeCanPickup = 10;
		list.add(entityItem);
	}
}