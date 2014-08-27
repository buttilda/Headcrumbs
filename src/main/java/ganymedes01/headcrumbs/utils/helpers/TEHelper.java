package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;

public class TEHelper {

	public static ItemStack getHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		if (mobName.equals("Blizz"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.blizz.ordinal());
		else
			return null;
	}
}