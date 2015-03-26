package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;

public class TwilightForestHelper extends ModHeadDropHelper {

	public TwilightForestHelper() {
		super("TwilightForest");

		typesMap.put("Penguin", SkullTypes.penguin);
		typesMap.put("Bighorn Sheep", SkullTypes.bighorn);
		typesMap.put("Wild Deer", SkullTypes.wildDeer);
		typesMap.put("Wild Boar", SkullTypes.wildBoar);
		typesMap.put("Redcap", SkullTypes.redcap);
		typesMap.put("Redcap Sapper", SkullTypes.redcap);
		typesMap.put("Skeleton Druid", SkullTypes.druid);
		typesMap.put("Hedge Spider", SkullTypes.hedgeSpider);
		typesMap.put("Mist Wolf", SkullTypes.mistWolf);
		typesMap.put("Mini Ghast", SkullTypes.miniGhast);
		typesMap.put("Tower Ghast", SkullTypes.guardGhast);
		typesMap.put("King Spider", SkullTypes.kingSpider);
		typesMap.put("Twilight Kobold", SkullTypes.kobold);
		typesMap.put("Fire Beetle", SkullTypes.fireBeetle);
		typesMap.put("Slime Beetle", SkullTypes.slimeBeetle);
		typesMap.put("Pinch Beetle", SkullTypes.pinchBeetle);
		typesMap.put("Tower Golem", SkullTypes.towerGolem);
		typesMap.put("Hostile Wolf", SkullTypes.hostileWolf);
		typesMap.put("Forest Squirrel", SkullTypes.squirrel);
		typesMap.put("Swarm Spider", SkullTypes.swarmSpider);
		typesMap.put("Redscale Broodling", SkullTypes.towerBroodling);
		typesMap.put("WinterWolf", SkullTypes.winterWolf);
		typesMap.put("Tower Termite", SkullTypes.towerwoodBorer);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;

		int dot = mobName.indexOf('.') + 1;
		if (dot >= 0) {
			mobName = mobName.substring(dot);

			if (mobName.equals("Forest Bunny")) {
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
			} else if (mobName.equals("Maze Slime") && ((EntitySlime) entity).getSlimeSize() == 1)
				return new ItemStack(ModItems.skull, 1, SkullTypes.mazeSlime.ordinal());
			else {
				SkullTypes type = typesMap.get(mobName);
				if (type != null)
					return new ItemStack(ModItems.skull, 1, type.ordinal());
			}
		}

		return null;
	}
}