package ganymedes01.headcrumbs.configs;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.libs.Reference;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	public static ConfigHandler INSTANCE = new ConfigHandler();
	public Configuration configFile;
	public String[] usedCategories = { Configuration.CATEGORY_GENERAL, "heads", "mob" };

	public void init(File file) {
		configFile = new Configuration(file);

		syncConfigs();
	}

	private void syncConfigs() {
		Headcrumbs.enableRandomHeadDrop = configFile.get(Configuration.CATEGORY_GENERAL, "Heads drop randomly", Headcrumbs.enableRandomHeadDrop, "Heads will drop randomly when entities or players die").setRequiresMcRestart(false).getBoolean();
		Headcrumbs.enableVanillaHeadsDrop = configFile.get(Configuration.CATEGORY_GENERAL, "Vanilla heads drop randomly", Headcrumbs.enableVanillaHeadsDrop, "Vanilla Heads (creeper, skeleton, zombie) will drop randomly when entities die").setRequiresMcRestart(false).getBoolean();
		Headcrumbs.addPlayerHeadsAsDungeonLoot = configFile.get(Configuration.CATEGORY_GENERAL, "Add player heads as dungeon loot", Headcrumbs.addPlayerHeadsAsDungeonLoot).setRequiresMcRestart(false).getBoolean();
		Headcrumbs.enableMobsAndAnimalHeads = configFile.get(Configuration.CATEGORY_GENERAL, "Enable mobs and animals heads", Headcrumbs.enableMobsAndAnimalHeads, "Setting this to false will cause only player heads to show in the creative tab and drop updon death").setRequiresMcRestart(false).getBoolean();
		Headcrumbs.hidePlayerHeadsFromTab = configFile.get(Configuration.CATEGORY_GENERAL, "Hide player heads from tab", Headcrumbs.hidePlayerHeadsFromTab, "Setting this to true will hide the named player heads from the creative tab and NEI").setRequiresMcRestart(true).getBoolean();
		Headcrumbs.enableChargedCreeperKills = configFile.get(Configuration.CATEGORY_GENERAL, "Enable charged creeper kills", Headcrumbs.enableChargedCreeperKills, "Setting this to true will cause heads to drop 100% of the time when an entity is killed by a charged creeper").setRequiresMcRestart(true).getBoolean();
		Headcrumbs.enablePlayerStatues = configFile.get(Configuration.CATEGORY_GENERAL, "Enable player statues", Headcrumbs.enablePlayerStatues, "Setting this to true allow statues to be built (Turning this off won't destroy existing statues)").setRequiresMcRestart(false).getBoolean();
		Headcrumbs.enableTooltips = configFile.get(Configuration.CATEGORY_GENERAL, "Enable head item tooltips", Headcrumbs.enableTooltips, "Enables tooltips with informations about certain names (mod authors mostly)").setRequiresMcRestart(false).getBoolean();

		Headcrumbs.headDropChance = configFile.get(Configuration.CATEGORY_GENERAL, "Chance of random head drop", Headcrumbs.headDropChance, "Random.nextInt(X / (fortune+1)) == 0").setRequiresMcRestart(false).getInt();
		Headcrumbs.headsDungeonLootMaxWeight = configFile.get(Configuration.CATEGORY_GENERAL, "Player heads loot weight", Headcrumbs.headsDungeonLootMaxWeight, "The bigger this number the easier it will be to find heads in dungeons.\nSome heads will be rarer than others.\nExamples: Diamond is 1, Redstone is 10").setRequiresMcRestart(true).getInt();

		Headcrumbs.others = configFile.get("heads", "others", Headcrumbs.others).setRequiresMcRestart(true).getStringList();
		Headcrumbs.modders = configFile.get("heads", "modders", Headcrumbs.modders).setRequiresMcRestart(true).getStringList();
		Headcrumbs.youtubers = configFile.get("heads", "youtubers", Headcrumbs.youtubers).setRequiresMcRestart(true).getStringList();
		Headcrumbs.mojang = configFile.get("heads", "mojang", Headcrumbs.mojang).setRequiresMcRestart(true).getStringList();
		Headcrumbs.mindCrack = configFile.get("heads", "mindCrack", Headcrumbs.mindCrack).setRequiresMcRestart(true).getStringList();
		Headcrumbs.forgeCraft = configFile.get("heads", "forgeCraft", Headcrumbs.forgeCraft).setRequiresMcRestart(true).getStringList();
		Headcrumbs.ftb = configFile.get("heads", "ftb", Headcrumbs.ftb).setRequiresMcRestart(true).getStringList();

		Headcrumbs.enableCelebrityMobs = configFile.get("mob", "Enable celebrity mobs", Headcrumbs.enableCelebrityMobs).setRequiresMcRestart(true).getBoolean();
		Headcrumbs.enableVIPs = configFile.get("mob", "Enable VIP drops", Headcrumbs.enableVIPs, "Setting this to false will disable special drops/wheapons for certain celebrities. Existing mobs will still hold the wheapons they spawned with.").setRequiresMcRestart(true).getBoolean();
		Headcrumbs.celebrityID = configFile.get("mob", "Mob ID", Headcrumbs.celebrityID, "WARNING: CHANGING THIS WILL CAUSE EXISTING CELEBRITIES TO VANISH FROM EXISTING WORLDS!").setRequiresMcRestart(true).getInt();
		Headcrumbs.celebrityProb = configFile.get("mob", "Spawn probability", Headcrumbs.celebrityProb, "The change the mob will spawn. Base values: zombies, skeletons, spider, creepers = 100, endermen = 10, witches = 5").setRequiresMcRestart(true).getInt();
		Headcrumbs.celebrityMin = configFile.get("mob", "Minimum group size", Headcrumbs.celebrityMin, "The minimum size of the group of mobs that will spawn at once").setRequiresMcRestart(true).getInt();
		Headcrumbs.celebrityMax = configFile.get("mob", "Maximum group size", Headcrumbs.celebrityMax, "The maximum size of the group of mobs that will spawn at once").setRequiresMcRestart(true).getInt();

		String block = configFile.get(Configuration.CATEGORY_GENERAL, "Statue block material", Block.blockRegistry.getNameForObject(Blocks.clay), "modId:name. Whatever block is set here will be the block used to make player statues (2 tall and right-click the top one with a player head)").getString();
		Headcrumbs.clay = (Block) Block.blockRegistry.getObject(block);
		if (Headcrumbs.clay == null)
			Headcrumbs.clay = Blocks.clay;

		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.modID))
			syncConfigs();
	}
}