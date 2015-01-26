package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;

public class EnderZooHelper {

	public static ItemStack getHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		else if (mobName.equals("enderzoo.ConcussionCreeper"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.concussionCreeper.ordinal());
		else if (mobName.equals("enderzoo.Enderminy"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.enderminy.ordinal());
		else if (mobName.equals("enderzoo.FallenKnight"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.fallenKnight.ordinal());
		else if (mobName.equals("enderzoo.WitherWitch"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.witherWitch.ordinal());
		else if (mobName.equals("enderzoo.WitherCat"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.witherCat.ordinal());
		else if (mobName.equals("enderzoo.DireWolf"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.direWolf.ordinal());
		else
			return null;
	}
}