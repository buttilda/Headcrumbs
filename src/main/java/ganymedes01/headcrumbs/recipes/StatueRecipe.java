package ganymedes01.headcrumbs.recipes;

import java.util.Map;

import com.google.common.collect.Maps;

import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

public class StatueRecipe extends ShapedRecipes {

	public StatueRecipe(String name, int width, int height, NonNullList<Ingredient> input, ItemStack output) {
		super(name, width, height, input, output);
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting inv) {
		ItemStack stack = super.getCraftingResult(inv);

		for (int i = 0; i < 3; i++) {
			ItemStack head = inv.getStackInSlot(i);
			if (head != null && head.hasTagCompound()) {
				stack.setTagCompound((NBTTagCompound) head.getTagCompound().copy());
				break;
			}
		}

		return stack;
	}

	public static StatueRecipe getRecipe(String name, ItemStack stack, Object... input) {
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

		NonNullList<Ingredient> ingredients = NonNullList.create();

		for (int i1 = 0; i1 < j * k; ++i1) {
			char c0 = s.charAt(i1);

			if (map.containsKey(Character.valueOf(c0)))
				ingredients.add(Ingredient.fromStacks(map.get(Character.valueOf(c0)).copy()));
		}

		StatueRecipe recipe = new StatueRecipe(name, j, k, ingredients, stack);
		recipe.setRegistryName(new ResourceLocation(Reference.MOD_ID, name));
		return recipe;
	}
}