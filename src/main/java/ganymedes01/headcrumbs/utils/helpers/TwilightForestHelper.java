package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;

public class TwilightForestHelper extends HeadDropHelper {

	public TwilightForestHelper() {
		super("twilightforest");

		typesMap.put("twilightforest.Penguin", SkullTypes.penguin);
		typesMap.put("twilightforest.Bighorn Sheep", SkullTypes.bighorn);
		typesMap.put("twilightforest.Wild Deer", SkullTypes.wildDeer);
		typesMap.put("twilightforest.Wild Boar", SkullTypes.wildBoar);
		typesMap.put("twilightforest.Redcap", SkullTypes.redcap);
		typesMap.put("twilightforest.Redcap Sapper", SkullTypes.redcap);
		typesMap.put("twilightforest.Skeleton Druid", SkullTypes.druid);
		typesMap.put("twilightforest.Hedge Spider", SkullTypes.hedgeSpider);
		typesMap.put("twilightforest.Mist Wolf", SkullTypes.mistWolf);
		typesMap.put("twilightforest.Mini Ghast", SkullTypes.miniGhast);
		typesMap.put("twilightforest.Tower Ghast", SkullTypes.guardGhast);
		typesMap.put("twilightforest.King Spider", SkullTypes.kingSpider);
		typesMap.put("twilightforest.Twilight Kobold", SkullTypes.kobold);
		typesMap.put("twilightforest.Fire Beetle", SkullTypes.fireBeetle);
		typesMap.put("twilightforest.Slime Beetle", SkullTypes.slimeBeetle);
		typesMap.put("twilightforest.Pinch Beetle", SkullTypes.pinchBeetle);
		typesMap.put("twilightforest.Tower Golem", SkullTypes.towerGolem);
		typesMap.put("twilightforest.Hostile Wolf", SkullTypes.hostileWolf);
		typesMap.put("twilightforest.Forest Squirrel", SkullTypes.squirrel);
		typesMap.put("twilightforest.Swarm Spider", SkullTypes.swarmSpider);
		typesMap.put("twilightforest.Redscale Broodling", SkullTypes.towerBroodling);
		typesMap.put("twilightforest.WinterWolf", SkullTypes.winterWolf);
		typesMap.put("twilightforest.Tower Termite", SkullTypes.towerwoodBorer);
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