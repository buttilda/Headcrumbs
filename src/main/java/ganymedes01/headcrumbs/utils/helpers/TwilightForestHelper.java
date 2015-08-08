package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;

public class TwilightForestHelper extends HeadDropHelper {

	public TwilightForestHelper() {
		super("TwilightForest");

		typesMap.put("TwilightForest.Penguin", SkullTypes.penguin);
		typesMap.put("TwilightForest.Bighorn Sheep", SkullTypes.bighorn);
		typesMap.put("TwilightForest.Wild Deer", SkullTypes.wildDeer);
		typesMap.put("TwilightForest.Wild Boar", SkullTypes.wildBoar);
		typesMap.put("TwilightForest.Redcap", SkullTypes.redcap);
		typesMap.put("TwilightForest.Redcap Sapper", SkullTypes.redcap);
		typesMap.put("TwilightForest.Skeleton Druid", SkullTypes.druid);
		typesMap.put("TwilightForest.Hedge Spider", SkullTypes.hedgeSpider);
		typesMap.put("TwilightForest.Mist Wolf", SkullTypes.mistWolf);
		typesMap.put("TwilightForest.Mini Ghast", SkullTypes.miniGhast);
		typesMap.put("TwilightForest.Tower Ghast", SkullTypes.guardGhast);
		typesMap.put("TwilightForest.King Spider", SkullTypes.kingSpider);
		typesMap.put("TwilightForest.Twilight Kobold", SkullTypes.kobold);
		typesMap.put("TwilightForest.Fire Beetle", SkullTypes.fireBeetle);
		typesMap.put("TwilightForest.Slime Beetle", SkullTypes.slimeBeetle);
		typesMap.put("TwilightForest.Pinch Beetle", SkullTypes.pinchBeetle);
		typesMap.put("TwilightForest.Tower Golem", SkullTypes.towerGolem);
		typesMap.put("TwilightForest.Hostile Wolf", SkullTypes.hostileWolf);
		typesMap.put("TwilightForest.Forest Squirrel", SkullTypes.squirrel);
		typesMap.put("TwilightForest.Swarm Spider", SkullTypes.swarmSpider);
		typesMap.put("TwilightForest.Redscale Broodling", SkullTypes.towerBroodling);
		typesMap.put("TwilightForest.WinterWolf", SkullTypes.winterWolf);
		typesMap.put("TwilightForest.Tower Termite", SkullTypes.towerwoodBorer);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		ItemStack head = super.getHeadForEntity(entity);
		if (head != null)
			return head;

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
			SkullTypes skullType = SkullTypes.bunnyDutch;
			switch (type) {
				case 3:
					skullType = SkullTypes.bunnyBrown;
					break;
				case 2:
					skullType = SkullTypes.bunnyWhite;
					break;
			}
			return skullType.getStack();
		} else if (mobName.equals("TwilightForest.Maze Slime") && ((EntitySlime) entity).getSlimeSize() == 1)
			return SkullTypes.mazeSlime.getStack();

		return null;
	}
}