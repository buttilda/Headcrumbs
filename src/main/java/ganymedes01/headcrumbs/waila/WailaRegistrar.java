package ganymedes01.headcrumbs.waila;

import ganymedes01.headcrumbs.blocks.BlockEmpty;
import ganymedes01.headcrumbs.blocks.BlockHeadcrumbsSkull;
import mcp.mobius.waila.api.IWailaRegistrar;

public class WailaRegistrar {

	public static void wailaCallback(IWailaRegistrar registrar) {
		registrar.registerStackProvider(new WailaDataProvider(), BlockHeadcrumbsSkull.class);
		registrar.registerStackProvider(new WailaDataProvider(), BlockEmpty.class);
	}
}