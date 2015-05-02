package ganymedes01.headcrumbs.proxy;

import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.entity.EntityCelebrity;
import ganymedes01.headcrumbs.eventHandlers.RenderPlayerHandler;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.renderers.ItemSkullRender;
import ganymedes01.headcrumbs.renderers.ModelHead;
import ganymedes01.headcrumbs.renderers.RenderCelebrity;
import ganymedes01.headcrumbs.renderers.TileEntityBlockPlayerRenderer;
import ganymedes01.headcrumbs.renderers.TileEntityBlockSkullRenderer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerEvents() {
		super.registerEvents();

		MinecraftForge.EVENT_BUS.register(new RenderPlayerHandler());
	}

	@Override
	public void registerTileEntities() {
		super.registerTileEntities();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockSkull.class, new TileEntityBlockSkullRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockPlayer.class, new TileEntityBlockPlayerRenderer());
	}

	@Override
	public void registerRenderers() {
		MinecraftForgeClient.registerItemRenderer(ModItems.skull, new ItemSkullRender());
		MinecraftForgeClient.registerItemRenderer(Items.skull, new ItemSkullRender());

		RenderingRegistry.registerEntityRenderingHandler(EntityCelebrity.class, new RenderCelebrity());

		for (SkullTypes type : SkullTypes.values()) {
			ModelHead model = type.model();
			if (model != null)
				model.init();
		}
	}
}