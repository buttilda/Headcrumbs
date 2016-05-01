package ganymedes01.headcrumbs.entity.vip;

import java.util.List;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.oredict.OreDictionary;

public class jadedcat extends VIPHandler {

	@Override
	protected ItemStack getItem(EntityHuman entity) {
		List<ItemStack> list = OreDictionary.getOres("dyePurple");
		return !list.isEmpty() ? list.get(entity.getRNG().nextInt(list.size())) : super.getItem(entity);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return SoundEvents.entity_cat_purreow;
	}

	@Override
	protected SoundEvent hurtSound() {
		return SoundEvents.entity_cat_hurt;
	}

	@Override
	protected SoundEvent deathSound() {
		return SoundEvents.entity_cat_death;
	}
}