package ganymedes01.headcrumbs;

import ganymedes01.headcrumbs.blocks.BlockEmpty;
import ganymedes01.headcrumbs.blocks.BlockHeadcrumbsSkull;
import ganymedes01.headcrumbs.blocks.BlockPlayer;
import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static final Block skull = new BlockHeadcrumbsSkull();
	public static final Block player = new BlockPlayer();
	public static final Block empty = new BlockEmpty();

	public static void init() {
		registerBlock(skull, "skull");
		registerBlock(player, "player");
		registerBlock(empty, "empty");
	}

	private static void registerBlock(Block block, String name) {
		GameRegistry.register(block.setRegistryName(Reference.MOD_ID, name).setUnlocalizedName(Reference.MOD_ID + "." + name));
		if (block instanceof IHasCustomItem)
			GameRegistry.register(((IHasCustomItem) block).getItemBlock().setRegistryName(Reference.MOD_ID, name).setUnlocalizedName(Reference.MOD_ID + "." + name));
	}

	public static interface IHasCustomItem {
		ItemBlock getItemBlock();
	}
}