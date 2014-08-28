package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;

public class TwilightForestHelper {

	private static final Map<String, SkullTypes> map = new HashMap<String, SkullTypes>();
	static {
		map.put("Penguin", SkullTypes.penguin);
		map.put("Bighorn Sheep", SkullTypes.bighorn);
		map.put("Wild Deer", SkullTypes.wildDeer);
		map.put("Wild Boar", SkullTypes.wildBoar);
		map.put("Redcap", SkullTypes.redcap);
		map.put("Redcap Sapper", SkullTypes.redcap);
		map.put("Skeleton Druid", SkullTypes.druid);
		map.put("Hedge Spider", SkullTypes.hedgeSpider);
		map.put("Mist Wolf", SkullTypes.mistWolf);
		map.put("Mini Ghast", SkullTypes.miniGhast);
		map.put("Tower Ghast", SkullTypes.guardGhast);
		map.put("King Spider", SkullTypes.kingSpider);
		map.put("Twilight Kobold", SkullTypes.kobold);
		map.put("Fire Beetle", SkullTypes.fireBeetle);
		map.put("Slime Beetle", SkullTypes.slimeBeetle);
		map.put("Pinch Beetle", SkullTypes.pinchBeetle);
		map.put("Tower Golem", SkullTypes.towerGolem);
		map.put("Hostile Wolf", SkullTypes.hostileWolf);
		map.put("Forest Squirrel", SkullTypes.squirrel);
		map.put("Swarm Spider", SkullTypes.swarmSpider);
		map.put("Redscale Broodling", SkullTypes.towerBroodling);
		map.put("WinterWolf", SkullTypes.winterWolf);
		map.put("Tower Termite", SkullTypes.towerwoodBorer);
	}

	public static ItemStack getHead(Entity entity) {
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
				SkullTypes type = map.get(mobName);
				if (type != null)
					return new ItemStack(ModItems.skull, 1, type.ordinal());
			}
		}

		return null;
	}
}