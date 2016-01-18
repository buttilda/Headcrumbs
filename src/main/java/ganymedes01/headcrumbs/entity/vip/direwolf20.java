package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.DifficultyInstance;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class direwolf20 extends VIPHandler {

	@Override
	public void onSpawn(EntityHuman entity, DifficultyInstance difficulty) {
		Item wrench = GameRegistry.findItem("BuildCraft|Core", "wrenchItem");
		if (wrench != null)
			entity.setCurrentItemOrArmor(0, new ItemStack(wrench));
	}
}