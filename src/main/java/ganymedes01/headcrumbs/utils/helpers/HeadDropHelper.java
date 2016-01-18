package ganymedes01.headcrumbs.utils.helpers;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;

public abstract class HeadDropHelper implements Comparable<HeadDropHelper> {

	public static final List<HeadDropHelper> helpers = new LinkedList<HeadDropHelper>();

	public static ItemStack getHead(Entity entity) {
		for (HeadDropHelper helper : helpers)
			if (helper.isEnabled()) {
				ItemStack head = helper.getHeadForEntity(entity);
				if (head != null)
					return head;
			}
		return null;
	}

	public static void register(HeadDropHelper helper) {
		helpers.add(helper);
		Collections.sort(helpers);
	}

	protected final String modID;
	protected final Map<String, SkullTypes> typesMap = new HashMap<String, SkullTypes>();

	public HeadDropHelper(String modID) {
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
			return type.getStack();

		return null;
	}

	@Override
	public int compareTo(HeadDropHelper obj) {
		return obj instanceof VanillaHelper ? -1 : 0;
	}
}