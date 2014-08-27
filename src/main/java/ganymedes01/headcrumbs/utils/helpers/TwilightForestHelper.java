package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;

public class TwilightForestHelper {

	public static ItemStack getHead(Entity entity) {
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

}