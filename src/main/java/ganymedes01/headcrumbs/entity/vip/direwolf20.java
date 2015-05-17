package ganymedes01.headcrumbs.entity.vip;

import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class direwolf20 extends VIPHandler {

	@Override
	public void onSpawn(EntityHuman entity) {
		ItemStack wrench = GameRegistry.findItemStack("BuildCraft|Core", "wrenchItem", 1);
		if (wrench != null)
			entity.setCurrentItemOrArmor(0, wrench);
	}
}