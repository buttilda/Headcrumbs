package ganymedes01.headcrumbs.proxy;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.renderers.RenderHuman;
import ganymedes01.headcrumbs.renderers.TileEntityBlockPlayerRenderer;
import ganymedes01.headcrumbs.renderers.TileEntityBlockSkullRenderer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerEvents() {
		super.registerEvents();
	}

	@Override
	public void registerTileEntities() {
		super.registerTileEntities();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockSkull.class, new TileEntityBlockSkullRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityBlockPlayer.class, new TileEntityBlockPlayerRenderer());
	}

	@Override
	public void registerRenderers() {
		if (Headcrumbs.enableHumanMobs)
			RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, new IRenderFactory<EntityHuman>() {

				@Override
				public Render<? super EntityHuman> createRenderFor(RenderManager manager) {
					return new RenderHuman(manager);
				}
			});

		for (SkullTypes type : SkullTypes.values())
			type.model().init();
	}
}