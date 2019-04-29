package ganymedes01.headcrumbs;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import ganymedes01.headcrumbs.blocks.BlockEmpty;
import ganymedes01.headcrumbs.blocks.BlockHeadcrumbsSkull;
import ganymedes01.headcrumbs.blocks.BlockPlayer;
import ganymedes01.headcrumbs.items.ItemHeadcrumbsSkull;
import ganymedes01.headcrumbs.items.ItemStatue;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.utils.HeadUtils;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ModBlocks
{

	public static final Block skull = new BlockHeadcrumbsSkull();
	public static final Block player = new BlockPlayer();
	public static final Block empty = new BlockEmpty();

	@SubscribeEvent
	public void onBlockRegistry(RegistryEvent.Register<Block> e)
	{
		e.getRegistry().register(skull.setRegistryName(Reference.MOD_ID, "skull").setTranslationKey(Reference.MOD_ID + "." + "skull"));
		e.getRegistry().register(player.setRegistryName(Reference.MOD_ID, "player").setTranslationKey(Reference.MOD_ID + "." + "player"));
		e.getRegistry().register(empty.setRegistryName(Reference.MOD_ID, "empty").setTranslationKey(Reference.MOD_ID + "." + "empty"));
	}

	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> e)
	{
		e.getRegistry().register(new ItemHeadcrumbsSkull(skull).setRegistryName(skull.getRegistryName()).setTranslationKey(skull.getTranslationKey()));
		e.getRegistry().register(new ItemStatue(player).setRegistryName(player.getRegistryName()).setTranslationKey(player.getTranslationKey()));
	}

	private static final List<ResourceLocation> overworldLoot = Arrays.asList(LootTableList.CHESTS_SIMPLE_DUNGEON, LootTableList.CHESTS_ABANDONED_MINESHAFT, LootTableList.CHESTS_DESERT_PYRAMID, LootTableList.CHESTS_JUNGLE_TEMPLE, LootTableList.CHESTS_IGLOO_CHEST);
	private static final List<ResourceLocation> specialLoot = Arrays.asList(LootTableList.CHESTS_NETHER_BRIDGE, LootTableList.CHESTS_STRONGHOLD_LIBRARY, LootTableList.CHESTS_STRONGHOLD_CROSSING, LootTableList.CHESTS_STRONGHOLD_CORRIDOR, LootTableList.CHESTS_END_CITY_TREASURE);

	@SubscribeEvent
	public void onRegisterLootTable(LootTableLoadEvent event)
	{
		if(Headcrumbs.addPlayerHeadsAsDungeonLoot)
		{
			LootPool main = event.getTable().getPool("main");
			if(main == null)
				return;

			int weight = -1;
			if(specialLoot.contains(event.getName()))
				weight = Headcrumbs.headsDungeonLootWeight + 1;
			else if(overworldLoot.contains(event.getName()))
				weight = Headcrumbs.headsDungeonLootWeight;

			LootFunction lootFunction = new LootFunction(null)
			{
				private List<String> allNames = null;

				@Override
				public ItemStack apply(ItemStack stack, Random rand, LootContext context)
				{
					if(allNames == null || allNames.isEmpty())
						allNames = Headcrumbs.getAllNames();

					String name = allNames.get(rand.nextInt(allNames.size()));
					allNames.remove(name);
					return HeadUtils.createHeadFor(name);
				}
			};

			if(weight > 0)
			{
				main.addEntry(new LootEntryItem(Items.SKULL, weight, 0, new LootFunction[] { lootFunction }, new LootCondition[0], Reference.MOD_ID + ":player_heads0"));
				main.addEntry(new LootEntryItem(Items.SKULL, weight, 0, new LootFunction[] { lootFunction }, new LootCondition[0], Reference.MOD_ID + ":player_heads1"));
				main.addEntry(new LootEntryItem(Items.SKULL, weight, 0, new LootFunction[] { lootFunction }, new LootCondition[0], Reference.MOD_ID + ":player_heads2"));
			}
		}
	}
}