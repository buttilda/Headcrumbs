package ganymedes01.headcrumbs.utils;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.libs.HeadDrop;
import ganymedes01.headcrumbs.libs.HeadDropRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraftforge.common.util.Constants;

public class HeadUtils
{

	public static final String OWNER_TAG = "SkullOwner";
	public static final String MODEL_TAG = "SkullModel";

	public static ItemStack getHeadfromEntity(EntityLivingBase target)
	{
		if(target.isChild())
			return null;

		if(target instanceof EntityHuman)
			return createHeadFor(((EntityHuman) target).getProfile());

		if(target instanceof EntityPlayer)
			return createHeadFor((EntityPlayer) target);

		return HeadDropRegistry.getHead(target);
	}

	public static ItemStack createHeadFor(String username)
	{
		return createHeadFor(new GameProfile(null, username));
	}

	public static ItemStack createHeadFor(EntityPlayer player)
	{
		return createHeadFor(player.getGameProfile());
	}

	public static ItemStack createHeadFor(GameProfile profile)
	{
		ItemStack stack = new ItemStack(Items.SKULL, 1, 3);
		stack.setTagCompound(new NBTTagCompound());
		NBTTagCompound profileData = new NBTTagCompound();
		NBTUtil.writeGameProfile(profileData, profile);
		stack.getTagCompound().setTag(OWNER_TAG, profileData);
		return stack;
	}

	public static GameProfile getGameProfile(ItemStack stack)
	{
		GameProfile profile = null;

		try
		{
			if(stack.hasTagCompound())
			{
				NBTTagCompound nbt = stack.getTagCompound();
				if(nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_COMPOUND))
					profile = NBTUtil.readGameProfileFromNBT(nbt.getCompoundTag(OWNER_TAG));
				else if(nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_STRING))
					profile = new GameProfile(null, nbt.getString(OWNER_TAG));
			}
		} catch(IllegalArgumentException e)
		{
		}

		return profile;
	}

	public static String getName(ItemStack stack)
	{
		if(stack.hasTagCompound())
		{
			NBTTagCompound nbt = stack.getTagCompound();
			if(nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_COMPOUND))
			{
				GameProfile profile = NBTUtil.readGameProfileFromNBT(nbt.getCompoundTag(OWNER_TAG));
				if(profile != null)
					return profile.getName();
			}
			else if(nbt.hasKey(OWNER_TAG, Constants.NBT.TAG_STRING))
				return nbt.getString(OWNER_TAG);
		}
		return null;
	}

	public static HeadDrop getModel(ItemStack stack)
	{
		return stack.hasTagCompound() ? getModel(stack.getTagCompound().getString(MODEL_TAG)) : HeadDrop.DEFAULT;
	}

	public static String getModelName(ItemStack stack)
	{
		return stack.hasTagCompound() ? stack.getTagCompound().getString(MODEL_TAG) : "minecraft:blaze";
	}

	public static HeadDrop getModel(String str)
	{
		String parts[] = str.split(":");
		if(parts.length == 2)
			return HeadDropRegistry.getHeadDrop(parts[0], parts[1]);
		else
			return HeadDrop.DEFAULT;
	}
}