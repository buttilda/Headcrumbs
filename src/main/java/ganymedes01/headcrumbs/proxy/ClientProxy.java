package ganymedes01.headcrumbs.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.ReflectionHelper;
import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModItems;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.eventHandlers.RenderPlayerHandler;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.renderers.ItemSkullRender;
import ganymedes01.headcrumbs.renderers.RenderHuman;
import ganymedes01.headcrumbs.renderers.TileEntityBlockPlayerRenderer;
import ganymedes01.headcrumbs.renderers.TileEntityBlockSkullRenderer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import net.minecraft.init.Items;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.MinecraftForge;

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

		if (Loader.isModLoaded("etfuturum"))
			try {
				boolean enabled = ReflectionHelper.getPrivateValue(Class.forName("ganymedes01.etfuturum.EtFuturum"), null, "enablePlayerSkinOverlay");
				Headcrumbs.use18PlayerModel = enabled;
			} catch (ClassNotFoundException e) {
			}

		RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, new RenderHuman());

		for (SkullTypes type : SkullTypes.values())
			type.model().init();
	}
}