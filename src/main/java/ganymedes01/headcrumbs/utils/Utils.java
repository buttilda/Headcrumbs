package ganymedes01.headcrumbs.utils;

import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Utils {

	public static String getUnlocalisedName(String name) {
		return Reference.MOD_ID + "." + name;
	}

	public static ResourceLocation getResource(String path) {
		return new ResourceLocation(path);
	}

	public static ResourceLocation getResource(String mod, String path) {
		return new ResourceLocation(mod, path);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getTileEntity(IBlockAccess world, BlockPos pos, Class<T> cls) {
		TileEntity tile = world.getTileEntity(pos);
		if (!cls.isInstance(tile))
			return null;
		return (T) tile;
	}

	public static void addDungeonLoot(ItemStack stack, int minChance, int maxChance, int weight) {
		//		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		//		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		//		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		//		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		//		if (Loader.isModLoaded("ganysnether"))
		//			ChestGenHooks.addItem("ganysnether.undertaker", new WeightedRandomChestContent(stack, minChance, maxChance, weight));
	}

	public static void addStrongholdLoot(ItemStack stack, int minChance, int maxChance, int weight) {
		//		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		//		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		//		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
	}

	public static final void breakBlockWithParticles(World world, BlockPos pos, int meta) {
		IBlockState state = world.getBlockState(pos);
		if (state.getBlock().isAir(state, world, pos))
			return;
		world.setBlockToAir(pos);
		doBreakParticles(world, pos, state.getBlock(), meta);
	}

	public static final void doBreakParticles(World world, BlockPos pos, Block block, int meta) {
		world.playAuxSFXAtEntity(null, 2001, pos, Block.getIdFromBlock(block) + (meta << 12));
	}
}