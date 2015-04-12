package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.libs.SkullTypes;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.Loader;

public abstract class ModHeadDropHelper {

	public static final List<ModHeadDropHelper> helpers = new LinkedList<ModHeadDropHelper>();

	public static ItemStack getHead(Entity entity) {
		for (ModHeadDropHelper helper : helpers)
			if (helper.isEnabled()) {
				ItemStack head = helper.getHeadForEntity(entity);
				if (head != null)
					return head;
			}
		return null;
	}

	public static void register(ModHeadDropHelper helper) {
		helpers.add(helper);
	}

	protected final String modID;
	protected final Map<String, SkullTypes> typesMap = new HashMap<String, SkullTypes>();

	public ModHeadDropHelper(String modID) {
		this.modID = modID;
	}

	protected boolean isEnabled() {
		return Loader.isModLoaded(modID);
	}

	protected ItemStack getHeadForEntity(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if (mobName == null)
			return null;
		SkullTypes type = typesMap.get(mobName);
		if (type != null)
			return new ItemStack(ModItems.skull, 1, type.ordinal());

		return null;
	}
}