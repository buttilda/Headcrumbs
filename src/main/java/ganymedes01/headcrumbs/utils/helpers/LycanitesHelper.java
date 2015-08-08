package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.HeadUtils;

import java.util.Arrays;
import java.util.List;

import lycanite.lycanitesmobs.demonmobs.entity.EntityBehemoth;
import lycanite.lycanitesmobs.demonmobs.entity.EntityBelph;
import lycanite.lycanitesmobs.demonmobs.entity.EntityPinky;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;

public class LycanitesHelper extends HeadDropHelper {

	public static final List<String> blacklist = Arrays.asList("pinky", "behemoth", "belph");
	public static final List<String> prefixes = Arrays.asList("arcticmobs", "demonmobs", "desertmobs", "forestmobs", "freshwatermobs", "infernomobs", "junglemobs", "mountainmobs", "plainsmobs", "saltwatermobs", "swampmobs");

	public LycanitesHelper() {
		super("lycanitesmobs");
	}

	public static String capitaliseString(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		String mobName = EntityList.getEntityString(entity);
		if (mobName == null)
			return null;

		if (entity instanceof EntityPinky)
			return SkullTypes.pinky.getStack();
		else if (entity instanceof EntityBehemoth)
			return SkullTypes.behemoth.getStack();
		else if (entity instanceof EntityBelph)
			return SkullTypes.belph.getStack();
		else {
			int dot = mobName.indexOf('.') + 1;
			if (dot > 1) {
				String prefix = mobName.substring(0, dot - 1);
				if (prefixes.contains(prefix)) {
					mobName = mobName.substring(dot).toLowerCase();
					return !blacklist.contains(mobName) ? getStackFor(mobName) : null;
				}
			}
		}
		return null;
	}

	private static ItemStack getStackFor(String mob) {
		ItemStack stack = HeadUtils.createHeadFor(mob);
		stack.setItemDamage(SkullTypes.lycanites.ordinal());
		return stack;
	}
}