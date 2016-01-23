package ganymedes01.headcrumbs;

import ganymedes01.headcrumbs.blocks.BlockEmpty;
import ganymedes01.headcrumbs.blocks.BlockHeadcrumbsSkull;
import ganymedes01.headcrumbs.blocks.BlockPlayer;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static final Block skull = new BlockHeadcrumbsSkull();
	public static final Block player = new BlockPlayer();
	public static final Block empty = new BlockEmpty();

	public static void init() {
		registerBlock(skull);
		registerBlock(player);
		registerBlock(empty);
	}

	private static void registerBlock(Block block) {
		String[] strings = block.getUnlocalizedName().split("\\.");
		final String name = strings[strings.length - 1];

		if (block instanceof IHasCustomItem)
			GameRegistry.registerBlock(block, ((IHasCustomItem) block).getItemBlockClass(), name);
		else
			GameRegistry.registerBlock(block, name);
	}

	public static interface IHasCustomItem {

		Class<? extends ItemBlock> getItemBlockClass();
	}
}