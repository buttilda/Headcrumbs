package ganymedes01.headcrumbs.recipe;

import java.util.Arrays;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.nbt.NBTTagCompound;

public class PlayerSkullRecipe extends ShapelessRecipes {

	public PlayerSkullRecipe(ItemStack output, ItemStack input) {
		super(output, Arrays.asList(input));
	}

	@Override
	public ItemStack getCraftingResult(InventoryCrafting grid) {
		ItemStack newHead = super.getCraftingResult(grid);

		for (int i = 0; i < grid.getSizeInventory(); i++) {
			ItemStack head = grid.getStackInSlot(i);
			if (head != null && head.hasTagCompound()) {
				newHead.setTagCompound((NBTTagCompound) head.getTagCompound().copy());
				break;
			}
		}

		return newHead;
	}
}