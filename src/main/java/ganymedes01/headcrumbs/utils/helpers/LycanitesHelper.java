package ganymedes01.headcrumbs.utils.helpers;

import java.util.Arrays;
import java.util.List;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;

public class LycanitesHelper extends HeadDropHelper {

	public static final List<String> prefixes = Arrays.asList("arcticmobs", "demonmobs", "desertmobs", "forestmobs", "freshwatermobs", "infernomobs", "junglemobs", "mountainmobs", "plainsmobs", "saltwatermobs", "swampmobs", "shadowmobs");

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

		int dot = mobName.indexOf('.') + 1;
		if (dot > 1) {
			String prefix = mobName.substring(0, dot - 1);
			if (prefixes.contains(prefix)) {
				mobName = mobName.substring(dot).toLowerCase();
				return getStackFor(mobName);
			}
		}
		return null;
	}

	public static ItemStack getStackFor(String mob) {
		ItemStack stack = SkullTypes.lycanites.getStack();
		NBTTagCompound profileData = new NBTTagCompound();
		NBTUtil.writeGameProfile(profileData, new GameProfile(null, mob));
		stack.getTagCompound().setTag(HeadUtils.OWNER_TAG, profileData);
		return stack;
	}
}