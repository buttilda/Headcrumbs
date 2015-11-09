package ganymedes01.headcrumbs.utils.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.base.Strings;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.HeadUtils;
import lycanite.lycanitesmobs.AssetManager;
import lycanite.lycanitesmobs.ObjectManager;
import lycanite.lycanitesmobs.api.info.GroupInfo;
import lycanite.lycanitesmobs.api.info.MobInfo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class LycanitesHelperClient {

	private static final Map<String, ResourceLocation> map = new HashMap<String, ResourceLocation>();

	public static ModelBase getModel(String name) {
		return AssetManager.getModel(name);
	}

	public static ResourceLocation getTexture(String name) {
		if (!SkullTypes.lycanites.canShow())
			return null;
		ResourceLocation tex = map.get(name);
		if (tex == null) {
			MobInfo info = ObjectManager.getMobInfo(name);
			if (info != null) {
				GroupInfo group = info.group;
				if (group != null) {
					tex = new ResourceLocation(group.filename, "textures/entity/" + name + ".png");
					map.put(name, tex);
				}
			}
		}
		return tex;
	}

	public static List<ItemStack> getStacks() {
		List<ItemStack> list = new ArrayList<ItemStack>();
		for (String mob : ObjectManager.mobs.keySet()) {
			if (Strings.isNullOrEmpty(mob) || LycanitesHelper.blacklist.contains(mob.toLowerCase()))
				continue;
			list.add(getStackFor(mob));
		}

		return list;
	}

	private static ItemStack getStackFor(String mob) {
		ItemStack stack = HeadUtils.createHeadFor(mob);
		stack.setItemDamage(SkullTypes.lycanites.ordinal());
		return stack;
	}
}