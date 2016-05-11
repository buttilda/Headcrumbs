package ganymedes01.headcrumbs.utils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.utils.helpers.HeadDropHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.LootTableLoadEvent;

public class HeadUtils {

	public static final String OWNER_TAG = "SkullOwner";
	public static final String MODEL_TAG = "SkullModel";

	private static final List<ResourceLocation> overworldLoot = Arrays.asList(LootTableList.CHESTS_SIMPLE_DUNGEON, LootTableList.CHESTS_ABANDONED_MINESHAFT, LootTableList.CHESTS_DESERT_PYRAMID, LootTableList.CHESTS_JUNGLE_TEMPLE, LootTableList.CHESTS_IGLOO_CHEST);
	private static final List<ResourceLocation> specialLoot = Arrays.asList(LootTableList.CHESTS_NETHER_BRIDGE, LootTableList.CHESTS_STRONGHOLD_LIBRARY, LootTableList.CHESTS_STRONGHOLD_CROSSING, LootTableList.CHESTS_STRONGHOLD_CORRIDOR, LootTableList.CHESTS_END_CITY_TREASURE);

	private static class HeadLootFunction extends LootFunction {

		private static List<String> allNames = null;

		protected HeadLootFunction() {
			super(null);
		}

		@Override
		public ItemStack apply(ItemStack stack, Random rand, LootContext context) {
			if (allNames == null || allNames.isEmpty())
				allNames = Headcrumbs.getAllNames();

			String name = allNames.get(rand.nextInt(allNames.size()));
			allNames.remove(name);
			return HeadUtils.createHeadFor(name);
		}
	}

	public static void onRegisterLootTable(LootTableLoadEvent event) {
		if (Headcrumbs.addPlayerHeadsAsDungeonLoot) {
			LootPool main = event.getTable().getPool("main");
			if (main == null)
				return;

			int weight = -1;
			if (specialLoot.contains(event.getName()))
				weight = Headcrumbs.headsDungeonLootWeight + 1;
			else if (overworldLoot.contains(event.getName()))
				weight = Headcrumbs.headsDungeonLootWeight;

			if (weight > 0) {
				main.addEntry(new LootEntryItem(Items.skull, weight, 0, new LootFunction[] { new HeadLootFunction() }, new LootCondition[0], Reference.MOD_ID + ":player_heads0"));
				main.addEntry(new LootEntryItem(Items.skull, weight, 0, new LootFunction[] { new HeadLootFunction() }, new LootCondition[0], Reference.MOD_ID + ":player_heads1"));
				main.addEntry(new LootEntryItem(Items.skull, weight, 0, new LootFunction[] { new HeadLootFunction() }, new LootCondition[0], Reference.MOD_ID + ":player_heads2"));
			}
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
		return createHeadFor(new GameProfile(null, username));
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