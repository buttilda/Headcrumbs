package ganymedes01.headcrumbs.utils;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.helpers.HeadDropHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraftforge.common.util.Constants;

public class HeadUtils {

	public static final String OWNER_TAG = "SkullOwner";
	public static final String MODEL_TAG = "SkullModel";

	public static final List<ItemStack> players = new LinkedList<ItemStack>();

	public static void loadPlayerHeads() {
		Random rand = new Random();

		List<String> allNames = Headcrumbs.getAllNames();
		Collections.sort(allNames, new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {
				return s1.compareTo(s2);
			}
		});

		for (String name : allNames) {
			name = name.trim();
			if (name == null || name.isEmpty())
				continue;

			ItemStack head = createHeadFor(name);
			if (Headcrumbs.addPlayerHeadsAsDungeonLoot) {
				rand.setSeed(name.hashCode());
				Utils.addDungeonLoot(head.copy(), 1, 1, 1 + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
				Utils.addStrongholdLoot(head.copy(), 1, 1, 2 + rand.nextInt(Math.max(1, Headcrumbs.headsDungeonLootMaxWeight - 1)));
			}

			players.add(head);
		}
	}

	public static ItemStack getHeadfromEntity(EntityLivingBase target) {
		if (target.isChild())
			return null;

		if (target instanceof EntityHuman)
			return createHeadFor(((EntityHuman) target).getProfile());

		if (target instanceof EntityPlayer)
			return createHeadFor((EntityPlayer) target);

		ItemStack head = HeadDropHelper.getHead(target);
		if (head != null)
			return head;

		return null;
	}

	public static ItemStack createHeadFor(String username) {
		return createHeadFor(new GameProfile(null, UsernameUtils.getFixedUsername(username)));
	}

	public static ItemStack createHeadFor(EntityPlayer player) {
		return createHeadFor(player.getGameProfile());
	}

	public static ItemStack createHeadFor(GameProfile profile) {
		ItemStack stack = new ItemStack(Items.skull, 1, 3);
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound profileData = new NBTTagCompound();
		NBTUtil.writeGameProfile(profileData, profile);
		stack.getTagCompound().setTag(OWNER_TAG, profileData);
		return stack;
	}

	public static GameProfile getGameProfile(ItemStack stack) {
		GameProfile profile = null;

		try {
			if (stack.hasTagCompound()) {
				NBTTagCompound nbt = stack.getTagCompound();
				if (nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_COMPOUND))
					profile = NBTUtil.readGameProfileFromNBT(nbt.getCompoundTag(OWNER_TAG));
				else if (nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_STRING))
					profile = new GameProfile(null, nbt.getString(OWNER_TAG));
			}
		} catch (IllegalArgumentException e) {
		}

		return profile;
	}

	public static String getName(ItemStack stack) {
		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_COMPOUND)) {
				GameProfile profile = NBTUtil.readGameProfileFromNBT(nbt.getCompoundTag(OWNER_TAG));
				if (profile != null)
					return profile.getName();
			} else if (nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_STRING))
				return nbt.getString(OWNER_TAG);
		}
		return null;
	}

	public static SkullTypes getModel(ItemStack stack) {
		return stack.hasTagCompound() ? getModel(stack.getTagCompound().getString(MODEL_TAG)) : SkullTypes.blaze;
	}

	public static SkullTypes getModel(String str) {
		try {
			return SkullTypes.valueOf(str);
		} catch (Exception e) {
			return SkullTypes.blaze;
		}
	}
}