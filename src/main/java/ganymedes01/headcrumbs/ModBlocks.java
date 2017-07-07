package ganymedes01.headcrumbs;

import ganymedes01.headcrumbs.blocks.BlockEmpty;
import ganymedes01.headcrumbs.blocks.BlockHeadcrumbsSkull;
import ganymedes01.headcrumbs.blocks.BlockPlayer;
import ganymedes01.headcrumbs.items.ItemHeadcrumbsSkull;
import ganymedes01.headcrumbs.items.ItemStatue;
import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModBlocks {

	public static final Block skull = new BlockHeadcrumbsSkull();
	public static final Block player = new BlockPlayer();
	public static final Block empty = new BlockEmpty();

	@SubscribeEvent
	public void onBlockRegistry(RegistryEvent.Register<Block> e) {
		e.getRegistry().register(skull.setRegistryName(Reference.MOD_ID, "skull").setUnlocalizedName(Reference.MOD_ID + "." + "skull"));
		e.getRegistry().register(player.setRegistryName(Reference.MOD_ID, "player").setUnlocalizedName(Reference.MOD_ID + "." + "player"));
		e.getRegistry().register(empty.setRegistryName(Reference.MOD_ID, "empty").setUnlocalizedName(Reference.MOD_ID + "." + "empty"));
	}

	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> e) {
		e.getRegistry().register(new ItemHeadcrumbsSkull(skull).setRegistryName(Reference.MOD_ID, "skull").setUnlocalizedName(Reference.MOD_ID + "." + "skull"));
		e.getRegistry().register(new ItemStatue(player).setRegistryName(Reference.MOD_ID, "player").setUnlocalizedName(Reference.MOD_ID + "." + "player"));
	}
}