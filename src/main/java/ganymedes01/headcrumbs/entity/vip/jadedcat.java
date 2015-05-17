package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;

import java.util.List;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class jadedcat extends VIPHandler {

	@Override
	protected ItemStack getItem(EntityHuman entity) {
		List<ItemStack> list = OreDictionary.getOres("dyePurple");
		return !list.isEmpty() ? list.get(entity.getRNG().nextInt(list.size())) : super.getItem(entity);
	}

	@Override
	public String livingSound() {
		return "mob.cat.meow";
	}

	@Override
	protected String hurtSound() {
		return "mob.cat.hitt";
	}

	@Override
	protected String deathSound() {
		return "mob.cat.hitt";
	}
}