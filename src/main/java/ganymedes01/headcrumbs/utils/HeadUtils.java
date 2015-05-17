package ganymedes01.headcrumbs.utils;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.helpers.HeadDropHelper;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.util.Constants;

import com.mojang.authlib.GameProfile;

public class HeadUtils {

	private static final String OWNER_TAG = "SkullOwner";

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
			return createHeadFor(((EntityHuman) target).getUsername());

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
		ItemStack stack = new ItemStack(ModItems.skull, 1, SkullTypes.player.ordinal());
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound profileData = new NBTTagCompound();
		NBTUtil.func_152460_a(profileData, profile);
		stack.getTagCompound().setTag(OWNER_TAG, profileData);

		return stack;
	}

	public static GameProfile getGameProfile(ItemStack stack) {
		GameProfile profile = null;

		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_COMPOUND))
				profile = NBTUtil.func_152459_a(nbt.getCompoundTag(OWNER_TAG));
			else if (nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_STRING))
				profile = new GameProfile(null, nbt.getString(OWNER_TAG));
			else if (nbt.hasKey("OwnerUUID", Constants.NBT.TAG_STRING)) {
				profile = MinecraftServer.getServer().func_152358_ax().func_152652_a(UUID.fromString(nbt.getString("OwnerUUID")));
				profile = MinecraftServer.getServer().func_147130_as().fillProfileProperties(profile, true);
			}
		}

		return profile;
	}

	public static String getName(ItemStack stack) {
		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();
			if (nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_COMPOUND)) {
				GameProfile profile = NBTUtil.func_152459_a(nbt.getCompoundTag(OWNER_TAG));
				if (profile != null)
					return profile.getName();
			} else if (nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_STRING))
				return nbt.getString(OWNER_TAG);
		}

		return null;
	}
}