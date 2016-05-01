package ganymedes01.headcrumbs.utils;

import java.awt.Color;

import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Loader;

public class Utils {

	public static String getUnlocalisedName(String name) {
		return Reference.MOD_ID + "." + name;
	}

	public static String getBlockTexture(String name) {
		return Reference.ITEM_BLOCK_TEXTURE_PATH + name;
	}

	public static String getItemTexture(String name) {
		return Reference.ITEM_BLOCK_TEXTURE_PATH + name;
	}

	public static String getEntityTexture(String name) {
		return Reference.ENTITY_TEXTURE_PATH + name + ".png";
	}

	public static String getConainerName(String name) {
		return "container." + Reference.MOD_ID + "." + name;
	}

	public static int getColour(int R, int G, int B) {
		return new Color(R < 0 ? 0 : R, G < 0 ? 0 : G, B < 0 ? 0 : B).getRGB() & 0x00ffffff;
	}

	public static ResourceLocation getResource(String path) {
		return new ResourceLocation(path);
	}

	@SuppressWarnings("unchecked")
	public static <T> T getTileEntity(IBlockAccess world, BlockPos pos, Class<T> cls) {
		TileEntity tile = world.getTileEntity(pos);
		if (!cls.isInstance(tile))
			return null;
		return (T) tile;
	}

	public static void addDungeonLoot(ItemStack stack, int minChance, int maxChance, int weight) {
		ChestGenHooks.addItem(ChestGenHooks.DUNGEON_CHEST, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		ChestGenHooks.addItem(ChestGenHooks.MINESHAFT_CORRIDOR, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_DESERT_CHEST, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		ChestGenHooks.addItem(ChestGenHooks.PYRAMID_JUNGLE_CHEST, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		if (Loader.isModLoaded("ganysnether"))
			ChestGenHooks.addItem("ganysnether.undertaker", new WeightedRandomChestContent(stack, minChance, maxChance, weight));
	}

	public static void addStrongholdLoot(ItemStack stack, int minChance, int maxChance, int weight) {
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CORRIDOR, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_LIBRARY, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
		ChestGenHooks.addItem(ChestGenHooks.STRONGHOLD_CROSSING, new WeightedRandomChestContent(stack, minChance, maxChance, weight));
	}

	public static final void breakBlockWithParticles(World world, BlockPos pos, int meta) {
		IBlockState state = world.getBlockState(pos);
		if (state.getBlock().isAir(world, pos))
			return;
		world.setBlockToAir(pos);
		doBreakParticles(world, pos, state.getBlock(), meta);
	}

	public static final void doBreakParticles(World world, BlockPos pos, Block block, int meta) {
		world.playAuxSFXAtEntity(null, 2001, pos, Block.getIdFromBlock(block) + (meta << 12));
	}
}