package ganymedes01.headcrumbs.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.item.ItemStack;

public class NEIHeadcrumbsConfig implements IConfigureNEI {

	@Override
	public void loadConfig() {
		API.hideItem(new ItemStack(ModBlocks.blockSkull));
		API.hideItem(new ItemStack(ModBlocks.blockPlayer));
		API.hideItem(new ItemStack(ModBlocks.blockEmpty));
	}

	@Override
	public String getName() {
		return Reference.MOD_NAME;
	}

	@Override
	public String getVersion() {
		return Reference.VERSION_NUMBER;
	}
}