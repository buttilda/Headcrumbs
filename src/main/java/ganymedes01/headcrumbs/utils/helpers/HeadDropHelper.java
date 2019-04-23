package ganymedes01.headcrumbs.utils.helpers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.libs.HeadDrop;
import ganymedes01.headcrumbs.libs.Strings;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.Loader;

public abstract class HeadDropHelper
{
	protected final String modID;
	private final Map<String, HeadDrop> heads = new HashMap<String, HeadDrop>();

	public HeadDropHelper(String modID)
	{
		this.modID = modID;
	}

	public boolean isEnabled()
	{
		return Loader.isModLoaded(modID);
	}

	public String getModID()
	{
		return this.modID;
	}

	public ItemStack getHeadForEntity(String entityName, Entity ent)
	{
		if(entityName == null)
			return ItemStack.EMPTY;
		if(heads.containsKey(entityName))
			return getStack(modID, entityName);

		return ItemStack.EMPTY;
	}

	public HeadDrop getHeadDropForEntity(String entityName)
	{
		if(entityName == null)
			return HeadDrop.DEFAULT;
		if(heads.containsKey(entityName))
			return heads.get(entityName);

		return HeadDrop.DEFAULT;
	}

	public String getTextureLocBase()
	{
		return modID + Strings.DEFAULT_TEXTURE_LOC;
	}

	public void registerMobHead(String entityName, ModelHead head)
	{
		this.registerMobHead(entityName, entityName, head);
	}

	public void registerMobHead(String entityName, String textureFile, ModelHead head)
	{
		heads.put(entityName, new HeadDrop(getTextureLocBase() + textureFile, head));
	}

	public void registerMobHeadDiffTextureBase(String entityName, String textureFile, ModelHead head)
	{
		heads.put(entityName, new HeadDrop(textureFile, head));
	}

	public void initModels()
	{
		for(HeadDrop head : heads.values())
			head.getModel().init();
	}

	public List<ItemStack> getItemStacks()
	{
		List<ItemStack> headStacks = new ArrayList<ItemStack>();

		for(String name : heads.keySet())
			headStacks.add(getStack(this.modID, name));

		return headStacks;
	}

	public static ItemStack getStack(String modID, String name)
	{
		return getStack(modID + ":" + name);
	}

	public static ItemStack getStack(String name)
	{
		return getStack(1, name);
	}

	public static ItemStack getStack(int size, String name)
	{
		ItemStack stack = new ItemStack(ModBlocks.skull, size);
		NBTTagCompound nbt = new NBTTagCompound();
		stack.setTagCompound(nbt);
		nbt.setString(HeadUtils.MODEL_TAG, name);
		return stack;
	}
}