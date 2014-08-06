package ganymedes01.headcrumbs.proxy;

import ganymedes01.headcrumbs.configs.ConfigHandler;
import ganymedes01.headcrumbs.eventHandlers.EntityDropEvent;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {

	public void registerEvents() {
		FMLCommonHandler.instance().bus().register(ConfigHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(new EntityDropEvent());
	}

	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityBlockSkull.class, Utils.getUnlocalizedName("head"));
		GameRegistry.registerTileEntity(TileEntityBlockPlayer.class, Utils.getUnlocalizedName("player"));
	}

	public void registerRenderers() {
	}
}