package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;

public class NaturaHelper {

	public static ItemStack getHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		else if (mobName.equals("Natura.Imp"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.imp.ordinal());
		else if (mobName.equals("Natura.NitroCreeper"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.nitroCreeper.ordinal());
		else if (mobName.equals("Natura.FlameSpiderBaby"))
			return new ItemStack(ModItems.skull, 1, SkullTypes.heatscarSpider.ordinal());
		else
			return null;
	}
}