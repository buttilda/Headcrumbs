package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.ItemStack;

public class TwilightForestHelper extends HeadDropHelper
{
	public static final String MOD_ID = "twilightforest";

	public TwilightForestHelper()
	{
		super(MOD_ID);

		typesMap.put(MOD_ID + ".Penguin", SkullTypes.penguin);
		typesMap.put(MOD_ID + ".Bighorn Sheep", SkullTypes.bighorn);
		typesMap.put(MOD_ID + ".Wild Deer", SkullTypes.wildDeer);
		typesMap.put(MOD_ID + ".Wild Boar", SkullTypes.wildBoar);
		typesMap.put(MOD_ID + ".Redcap", SkullTypes.redcap);
		typesMap.put(MOD_ID + ".Redcap Sapper", SkullTypes.redcap);
		typesMap.put(MOD_ID + ".Skeleton Druid", SkullTypes.druid);
		typesMap.put(MOD_ID + ".Hedge Spider", SkullTypes.hedgeSpider);
		typesMap.put(MOD_ID + ".Mist Wolf", SkullTypes.mistWolf);
		typesMap.put(MOD_ID + ".Mini Ghast", SkullTypes.miniGhast);
		typesMap.put(MOD_ID + ".Tower Ghast", SkullTypes.guardGhast);
		typesMap.put(MOD_ID + ".King Spider", SkullTypes.kingSpider);
		typesMap.put(MOD_ID + ".Twilight Kobold", SkullTypes.kobold);
		typesMap.put(MOD_ID + ".Fire Beetle", SkullTypes.fireBeetle);
		typesMap.put(MOD_ID + ".Slime Beetle", SkullTypes.slimeBeetle);
		typesMap.put(MOD_ID + ".Pinch Beetle", SkullTypes.pinchBeetle);
		typesMap.put(MOD_ID + ".Tower Golem", SkullTypes.towerGolem);
		typesMap.put(MOD_ID + ".Hostile Wolf", SkullTypes.hostileWolf);
		typesMap.put(MOD_ID + ".Forest Squirrel", SkullTypes.squirrel);
		typesMap.put(MOD_ID + ".Swarm Spider", SkullTypes.swarmSpider);
		typesMap.put(MOD_ID + ".Redscale Broodling", SkullTypes.towerBroodling);
		typesMap.put(MOD_ID + ".WinterWolf", SkullTypes.winterWolf);
		typesMap.put(MOD_ID + ".Tower Termite", SkullTypes.towerwoodBorer);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity)
	{
		ItemStack head = super.getHeadForEntity(entity);
		if(head != null)
			return head;

		String mobName = EntityList.getEntityString(entity);

		if(mobName == null)
			return null;

		if(mobName.equals(MOD_ID + ".Forest Bunny"))
		{
			Integer type;
			try
			{
				type = (Integer) entity.getClass().getMethod("getBunnyType").invoke(entity);
			} catch(Exception e)
			{
				type = 0;
			}
			SkullTypes skullType = SkullTypes.bunnyDutch;
			switch(type)
			{
				case 3:
					skullType = SkullTypes.bunnyBrown;
					break;
				case 2:
					skullType = SkullTypes.bunnyWhite;
					break;
			}
			return skullType.getStack();
		}
		else if(mobName.equals(MOD_ID + ".Maze Slime") && ((EntitySlime) entity).getSlimeSize() == 1)
			return SkullTypes.mazeSlime.getStack();

		return null;
	}
}