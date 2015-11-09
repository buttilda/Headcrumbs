package ganymedes01.headcrumbs.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import ganymedes01.headcrumbs.configs.ConfigHandler;
import ganymedes01.headcrumbs.eventHandlers.HandlerEvents;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public void registerEvents() {
		FMLCommonHandler.instance().bus().register(ConfigHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(new HandlerEvents());
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBlockSkull.class, Utils.getUnlocalisedName("head"));
		GameRegistry.registerTileEntity(TileEntityBlockPlayer.class, Utils.getUnlocalisedName("player"));
	}

	public void registerRenderers() {
	}
}