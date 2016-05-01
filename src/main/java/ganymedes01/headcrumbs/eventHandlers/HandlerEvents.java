package ganymedes01.headcrumbs.eventHandlers;

import java.util.Arrays;
import java.util.List;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.libs.CelebrityMap;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.StringUtils;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HandlerEvents {

	public static final HandlerEvents INSTANCE = new HandlerEvents();

	private static List<String> hardcodedBlacklist = Arrays.asList("Twilight Forest", "Erebus", "The Outer Lands");

	private HandlerEvents() {
	}

	@SubscribeEvent
	public void onCheckSpawn(LivingSpawnEvent.CheckSpawn event) {
		if (event.getEntityLiving() instanceof EntityHuman) {
			World world = event.getWorld();
			DimensionType dimType = world.provider.getDimensionType();
			if (hardcodedBlacklist.contains(dimType.getName()) || isDimensionBlackListed(dimType.getId()))
				event.setResult(Result.DENY);
		}
	}

	private static boolean isDimensionBlackListed(int dimensionId) {
		for (int id : Headcrumbs.blacklistedDimensions)
			if (dimensionId == id)
				return true;
		return false;
	}

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void dropEvent(LivingDropsEvent event) {
		EntityLivingBase entity = event.getEntityLiving();
		DamageSource source = event.getSource();
		List<EntityItem> drops = event.getDrops();

		if (entity.worldObj.isRemote)
			return;
		if (entity.getHealth() > 0.0F)
			return;

		if (isPoweredCreeper(source)) {
			ItemStack stack = HeadUtils.getHeadfromEntity(entity);
			if (stack == null || stack.getItem() == Items.skull)
				return;

			EntityItem entityItem = new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, stack);
			entityItem.setDefaultPickupDelay();
			drops.add(entityItem);
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

	@SubscribeEvent
	public void onTooltip(ItemTooltipEvent event) {
		if (!Headcrumbs.enableTooltips)
			return;
		ItemStack stack = event.getItemStack();
		if (stack != null && stack.getItem() == Items.skull && stack.getMetadata() == 3) {
			String name = HeadUtils.getName(stack);
			if (name != null) {
				String tip = CelebrityMap.getTooltip(name);
				if (!StringUtils.isNullOrEmpty(tip))
					event.getToolTip().add(tip);
			}
		}
	}
}