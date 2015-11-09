package ganymedes01.headcrumbs.utils;

import java.awt.Color;

import cpw.mods.fml.common.Loader;
import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ChestGenHooks;

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
	public static <T> T getTileEntity(IBlockAccess world, int x, int y, int z, Class<T> cls) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (!cls.isInstance(tile))
			return null;
		return (T) tile;
	}

	public static void dropStack(World world, int x, int y, int z, ItemStack stack) {
		if (!world.isRemote && stack != null && world.getGameRules().getGameRuleBooleanValue("doTileDrops")) {
			float f = 0.7F;
			double d0 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
			double d1 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
			double d2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
			EntityItem entityItem = new EntityItem(world, x + d0, y + d1, z + d2, stack);
			entityItem.delayBeforeCanPickup = 10;
			world.spawnEntityInWorld(entityItem);
		}
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

	public static final void breakBlockWithParticles(World world, int x, int y, int z, int meta) {
		Block block = world.getBlock(x, y, z);
		if (block.isAir(world, x, y, z))
			return;
		world.setBlockToAir(x, y, z);
		doBreakParticles(world, x, y, z, block, meta);
	}

	public static final void doBreakParticles(World world, int x, int y, int z, Block block, int meta) {
		world.playAuxSFXAtEntity(null, 2001, x, y, z, Block.getIdFromBlock(block) + (meta << 12));
	}
}