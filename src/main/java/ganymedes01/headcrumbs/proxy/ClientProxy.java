package ganymedes01.headcrumbs.proxy;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.ModBlocks;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.renderers.LayerCustomCape;
import ganymedes01.headcrumbs.renderers.RenderHuman;
import ganymedes01.headcrumbs.renderers.TileEntityBlockPlayerRenderer;
import ganymedes01.headcrumbs.renderers.TileEntityBlockSkullRenderer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockPlayer;
import ganymedes01.headcrumbs.tileentities.TileEntityBlockSkull;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.item.Item;
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
	public void registerEntityRenderers() {
		if (Headcrumbs.enableHumanMobs)
			RenderingRegistry.registerEntityRenderingHandler(EntityHuman.class, new IRenderFactory<EntityHuman>() {

				@Override
				public Render<? super EntityHuman> createRenderFor(RenderManager manager) {
					return new RenderHuman(manager);
				}
			});
	}

	@Override
	public void registerRenderers() {
		for (SkullTypes type : SkullTypes.values())
			type.model().init();

		ItemModelMesher mesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();
		mesher.register(Item.getItemFromBlock(ModBlocks.empty), 0, new ModelResourceLocation(Reference.MOD_ID + ":empty", "inventory"));
		mesher.register(Item.getItemFromBlock(ModBlocks.skull), 0, new ModelResourceLocation(Reference.MOD_ID + ":skull", "inventory"));
		mesher.register(Item.getItemFromBlock(ModBlocks.player), 0, new ModelResourceLocation(Reference.MOD_ID + ":player", "inventory"));

		LayerCustomCape customCapeRenderer = new LayerCustomCape();
		for (RenderPlayer renderer : Minecraft.getMinecraft().getRenderManager().getSkinMap().values())
			renderer.addLayer(customCapeRenderer);
	}
}