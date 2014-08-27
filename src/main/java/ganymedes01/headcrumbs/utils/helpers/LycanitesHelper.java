package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.HeadUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lycanite.lycanitesmobs.ObjectManager;
import lycanite.lycanitesmobs.api.info.GroupInfo;
import lycanite.lycanitesmobs.api.info.MobInfo;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import com.google.common.base.Strings;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class LycanitesHelper {

	@SideOnly(Side.CLIENT)
	private static final Map<String, ResourceLocation> map = new HashMap<String, ResourceLocation>();
	private static final List<String> blacklist = Arrays.asList("pinky", "behemoth", "belph");
	private static final List<String> prefixes = Arrays.asList("arcticmobs", "demonmobs", "desertmobs", "forestmobs", "freshwatermobs", "infernomobs", "junglemobs", "mountainmobs", "plainsmobs", "saltwatermobs", "swampmobs");

	@SideOnly(Side.CLIENT)
	public static ResourceLocation getTexture(String name) {
		if (!HeadUtils.lycanites)
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

	@SideOnly(Side.CLIENT)
	public static List<ItemStack> getStacks() {
		List<ItemStack> list = new ArrayList<ItemStack>();
		for (String mob : ObjectManager.mobs.keySet()) {
			if (Strings.isNullOrEmpty(mob) || blacklist.contains(mob.toLowerCase()))
				continue;
			list.add(getStackFor(mob));
		}

		return list;
	}

	public static String capitaliseString(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1);
	}

	public static ItemStack getHead(Entity entity) {
		String mobName = EntityList.getEntityString(entity);
		if (mobName != null) {
			int dot = mobName.indexOf('.') + 1;
			if (dot > 1) {
				String prefix = mobName.substring(0, dot - 1);
				if (prefixes.contains(prefix))
					mobName = mobName.substring(dot).toLowerCase();
			}
			return !blacklist.contains(mobName) ? getStackFor(mobName) : null;
		}
		return null;
	}

	private static ItemStack getStackFor(String mob) {
		ItemStack stack = HeadUtils.createHeadFor(mob);
		stack.setItemDamage(SkullTypes.lycanites.ordinal());
		return stack;
	}
}