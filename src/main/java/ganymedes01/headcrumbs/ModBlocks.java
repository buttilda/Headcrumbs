package ganymedes01.headcrumbs;

import ganymedes01.headcrumbs.blocks.BlockSkull;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	public static final Block blockSkull = new BlockSkull();

	public static void init() {
		registerBlock(blockSkull);
	}

	private static void registerBlock(Block block) {
		String name = block.getUnlocalizedName();
		String[] strings = name.split("\\.");
		GameRegistry.registerBlock(block, strings[strings.length - 1]);
	}
}