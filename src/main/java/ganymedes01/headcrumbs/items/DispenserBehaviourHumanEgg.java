package ganymedes01.headcrumbs.items;

import ganymedes01.headcrumbs.entity.EntityHuman;
import net.minecraft.block.BlockDispenser;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;

public class DispenserBehaviourHumanEgg extends BehaviorDefaultDispenseItem {

	@Override
	public ItemStack dispenseStack(IBlockSource block, ItemStack stack) {
		EnumFacing enumfacing = BlockDispenser.func_149937_b(block.getBlockMetadata());
		double d0 = block.getX() + enumfacing.getFrontOffsetX();
		double d1 = block.getYInt() + 0.2F;
		double d2 = block.getZ() + enumfacing.getFrontOffsetZ();
		EntityHuman entity = HumanEgg.spawnHuman(block.getWorld(), d0, d1, d2);

		if (stack.hasDisplayName())
			entity.setUsername(stack.getDisplayName());

		stack.splitStack(1);
		return stack;
	}
}