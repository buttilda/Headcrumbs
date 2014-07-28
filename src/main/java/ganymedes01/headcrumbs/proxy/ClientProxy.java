package ganymedes01.headcrumbs.proxy;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.eventHandlers.RenderPlayerHandler;
import ganymedes01.headcrumbs.renderers.ItemSkullRender;
import ganymedes01.headcrumbs.renderers.TileEntityBlockSkullRender;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockNewSkull;
import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerEvents() {
		super.registerEvents();

		MinecraftForge.EVENT_BUS.register(new RenderPlayerHandler());
	}

	@Override
	public void registerTileEntities() {
		super.registerTileEntities();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockNewSkull.class, new TileEntityBlockSkullRender());
	}

	@Override
	public void registerRenderers() {
		MinecraftForgeClient.registerItemRenderer(ModItems.skull, new ItemSkullRender());
		MinecraftForgeClient.registerItemRenderer(Items.skull, new ItemSkullRender());
	}
}