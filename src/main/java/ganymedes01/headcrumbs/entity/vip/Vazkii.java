package ganymedes01.headcrumbs.entity.vip;

import java.util.List;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class Vazkii extends VIPHandler {

	public static final String[] PETAL = { "petalWhite", "petalOrange", "petalMagenta", "petalLightBlue", "petalYellow", "petalLime", "petalPink", "petalGray", "petalLightGray", "petalCyan", "petalPurple", "petalBlue", "petalBrown", "petalGreen", "petalRed", "petalBlack", };

	@Override
	protected ItemStack getItem(EntityHuman entity) {
		String petal = PETAL[entity.getRNG().nextInt(PETAL.length)];
		List<ItemStack> stacks = OreDictionary.getOres(petal);
	return !stacks.isEmpty() ? stacks.get(0).copy() : super.getItem(entity);
    }
}