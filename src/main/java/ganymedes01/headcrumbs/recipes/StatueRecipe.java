package ganymedes01.headcrumbs.recipes;

import java.util.Map;

import com.google.common.collect.Maps;

import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;

public class StatueRecipe extends ShapedRecipes {

	public StatueRecipe(int width, int height, ItemStack[] input, ItemStack output) {
		super(width, height, input, output);
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack stack = super.getCraftingResult(inv);

		ItemStack head = inv.getStackInSlot(0);
		if (head.hasTagCompound())
			stack.setTagCompound((NBTTagCompound) head.getTagCompound().copy());

		return stack;
	}

	public static StatueRecipe getRecipe(ItemStack stack, Object... input) {
		String s = "";
		int i = 0;
		int j = 0;
		int k = 0;

		if (input[i] instanceof String[]) {
			String[] astring = (String[]) input[i++];

			for (int l = 0; l < astring.length; l++) {
				String s2 = astring[l];
				++k;
				j = s2.length();
				s = s + s2;
			}
		} else
			while (input[i] instanceof String) {
				String s1 = (String) input[i++];
				++k;
				j = s1.length();
				s = s + s1;
			}

		Map<Character, ItemStack> map;

		for (map = Maps.<Character, ItemStack> newHashMap(); i < input.length; i += 2) {
			Character character = (Character) input[i];
			ItemStack itemstack = null;

			if (input[i + 1] instanceof Item)
				itemstack = new ItemStack((Item) input[i + 1]);
			else if (input[i + 1] instanceof Block)
				itemstack = new ItemStack((Block) input[i + 1], 1, 32767);
			else if (input[i + 1] instanceof ItemStack)
				itemstack = (ItemStack) input[i + 1];

			map.put(character, itemstack);
		}

		ItemStack[] aitemstack = new ItemStack[j * k];

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (map.containsKey(Character.valueOf(c0)))
				aitemstack[i1] = map.get(Character.valueOf(c0)).copy();
			else
				aitemstack[i1] = null;
		}

		return new StatueRecipe(j, k, aitemstack, stack);
	}
}