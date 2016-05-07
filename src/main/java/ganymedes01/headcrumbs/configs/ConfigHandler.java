package ganymedes01.headcrumbs.configs;

import java.io.File;

import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.libs.Reference;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ConfigHandler {

	public static ConfigHandler INSTANCE = new ConfigHandler();
	public Configuration configFile;
	public String[] usedCategories = { Configuration.CATEGORY_GENERAL, "heads", "mob" };

	public void init(File file) {
		configFile = new Configuration(file);

		syncConfigs();
	}

	private void syncConfigs() {
		Headcrumbs.addPlayerHeadsAsDungeonLoot = configFile.get(Configuration.CATEGORY_GENERAL, "Add player heads as dungeon loot", Headcrumbs.addPlayerHeadsAsDungeonLoot).setRequiresMcRestart(false).getBoolean();
		Headcrumbs.headsDungeonLootMaxWeight = configFile.get(Configuration.CATEGORY_GENERAL, "Player heads loot weight", Headcrumbs.headsDungeonLootMaxWeight, "The bigger this number the easier it will be to find heads in dungeons.\nSome heads will be rarer than others.\nExamples: Diamond is 1, Redstone is 10").setRequiresMcRestart(true).getInt();
		Headcrumbs.enablePlayerStatues = configFile.get(Configuration.CATEGORY_GENERAL, "Enable player statues", Headcrumbs.enablePlayerStatues, "Setting this to true allow statues to be built (Turning this off won't destroy existing statues)").setRequiresMcRestart(false).getBoolean();

		Headcrumbs.enableTooltips = configFile.get(Configuration.CATEGORY_GENERAL, "Enable head item tooltips", Headcrumbs.enableTooltips, "Enables tooltips with informations about certain names (mod authors mostly)").setRequiresMcRestart(false).getBoolean();

		Headcrumbs.others = configFile.get("heads", "others", Headcrumbs.others).setRequiresMcRestart(true).getStringList();
		Headcrumbs.modders = configFile.get("heads", "modders", Headcrumbs.modders).setRequiresMcRestart(true).getStringList();
		Headcrumbs.youtubers = configFile.get("heads", "youtubers", Headcrumbs.youtubers).setRequiresMcRestart(true).getStringList();
		Headcrumbs.mojang = configFile.get("heads", "mojang", Headcrumbs.mojang).setRequiresMcRestart(true).getStringList();
		Headcrumbs.mindCrack = configFile.get("heads", "mindCrack", Headcrumbs.mindCrack).setRequiresMcRestart(true).getStringList();
		Headcrumbs.hermitcraft = configFile.get("heads", "hermitcraft", Headcrumbs.hermitcraft).setRequiresMcRestart(true).getStringList();
		Headcrumbs.forgeCraft = configFile.get("heads", "forgeCraft", Headcrumbs.forgeCraft).setRequiresMcRestart(true).getStringList();
		Headcrumbs.ftb = configFile.get("heads", "ftb", Headcrumbs.ftb).setRequiresMcRestart(true).getStringList();
		Headcrumbs.technic = configFile.get("heads", "technic", Headcrumbs.technic).setRequiresMcRestart(true).getStringList();
		Headcrumbs.enableModSent = configFile.get("heads", "Enable usernames sent by other mods", Headcrumbs.enableModSent, "Other mods can add usernames using inter-mod communications, turns this config to false will prevent that from happening").setRequiresMcRestart(true).getBoolean();

		Headcrumbs.enableHumanMobs = configFile.get("mob", "Enable celebrity mobs", Headcrumbs.enableHumanMobs).setRequiresMcRestart(true).getBoolean();
		Headcrumbs.enableVIPs = configFile.get("mob", "Enable VIP drops", Headcrumbs.enableVIPs, "Setting this to false will disable special drops/weapons for certain celebrities. Existing mobs will still hold the weapons they spawned with.").setRequiresMcRestart(true).getBoolean();
		Headcrumbs.celebrityProb = configFile.get("mob", "Spawn probability", Headcrumbs.celebrityProb, "The change the mob will spawn. Base values: zombies, skeletons, spider, creepers = 100, endermen = 10, witches = 5").setRequiresMcRestart(true).getInt();
		Headcrumbs.celebrityMin = configFile.get("mob", "Minimum group size", Headcrumbs.celebrityMin, "The minimum size of the group of mobs that will spawn at once").setRequiresMcRestart(true).getInt();
		Headcrumbs.celebrityMax = configFile.get("mob", "Maximum group size", Headcrumbs.celebrityMax, "The maximum size of the group of mobs that will spawn at once").setRequiresMcRestart(true).getInt();
		Headcrumbs.blacklistedDimensions = configFile.get("mob", "Dimension Blacklist", Headcrumbs.blacklistedDimensions).getIntList();
		Headcrumbs.humanNamePrefix = configFile.get("mob", "prefix", Headcrumbs.humanNamePrefix, "This prefix will be shown in front of celebrities names in-world. Meant to be used to differentiate celebrities from real players.").getString();
		Headcrumbs.babyHumanChance = configFile.get("mob", "Baby human chance", Headcrumbs.babyHumanChance, "Chance that a human mob will spawn as a baby. Set to -1 to disable.").setRequiresMcRestart(false).getDouble(Headcrumbs.babyHumanChance);
		Headcrumbs.humansAttackTwins = configFile.get("mob", "Humans attack twins", Headcrumbs.humansAttackTwins, "Setting this to false will force humans to not attack players with the same name as themselves").setRequiresMcRestart(true).getBoolean();

		if (configFile.hasChanged())
			configFile.save();
	}

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (Reference.MOD_ID.equals(eventArgs.getModID()))
			syncConfigs();
	}
}