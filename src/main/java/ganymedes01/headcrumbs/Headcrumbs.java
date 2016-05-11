package ganymedes01.headcrumbs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ganymedes01.headcrumbs.configs.ConfigHandler;
import ganymedes01.headcrumbs.entity.EntityHuman;
import ganymedes01.headcrumbs.entity.VIPHandler;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.proxy.CommonProxy;
import ganymedes01.headcrumbs.recipes.StatueRecipe;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.helpers.ElementalCreepersHelper;
import ganymedes01.headcrumbs.utils.helpers.EnderZooHelper;
import ganymedes01.headcrumbs.utils.helpers.GrimoireOfGaiaHelper;
import ganymedes01.headcrumbs.utils.helpers.HeadDropHelper;
import ganymedes01.headcrumbs.utils.helpers.LaserCreepersHelper;
import ganymedes01.headcrumbs.utils.helpers.LycanitesHelper;
import ganymedes01.headcrumbs.utils.helpers.NaturaHelper;
import ganymedes01.headcrumbs.utils.helpers.PrimitiveMobsHelper;
import ganymedes01.headcrumbs.utils.helpers.TEHelper;
import ganymedes01.headcrumbs.utils.helpers.ThaumcraftHelper;
import ganymedes01.headcrumbs.utils.helpers.TwilightForestHelper;
import ganymedes01.headcrumbs.utils.helpers.VanillaHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenBase.SpawnListEntry;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms.IMCMessage;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;
import net.minecraftforge.oredict.RecipeSorter.Category;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Headcrumbs {

	@Instance(Reference.MOD_ID)
	public static Headcrumbs instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tab = new CreativeTabs(Reference.MOD_ID) {

		@SideOnly(Side.CLIENT)
		private ItemStack displayStack;

		@Override
		public Item getTabIconItem() {
			return Items.skull;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() {
			if (displayStack == null) {
				Random rand = new Random();
				List<SkullTypes> types = new ArrayList<SkullTypes>();
				for (SkullTypes type : SkullTypes.values())
					if (type.canShow() && !type.usesProfile())
						types.add(type);
				displayStack = types.isEmpty() ? new ItemStack(Items.skull, 1, rand.nextInt(3)) : types.get(rand.nextInt(types.size())).getStack();
			}
			return displayStack;
		}
	};

	public static CreativeTabs playersTab = new CreativeTabs(Reference.MOD_ID + ".players") {

		@SideOnly(Side.CLIENT)
		private ItemStack displayStack;

		@Override
		public Item getTabIconItem() {
			return Items.skull;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public ItemStack getIconItemStack() {
			if (displayStack == null) {
				List<String> names = getAllNames();
				displayStack = HeadUtils.createHeadFor(names.get(new Random().nextInt(names.size())));
			}
			return displayStack;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public void displayAllRelevantItems(List<ItemStack> list) {
			for (String name : Headcrumbs.getAllNames())
				list.add(HeadUtils.createHeadFor(name));
		}
	};

	// @formatter:off
	public static String[] others = {
		"ez", "saukawolf", "Fullapple1991", "Kaisacles", "Cindric", "wiiv", "deadmau5", "muted79", "DrummingFish",
		"Kyrinon", "KingPurpleRaptor", "DylanGK", "sadris", "Herobrine", "kehaan"
	};

	public static String[] modders = {
		"sinkillerj", "Silentine", "techbrew", "Drullkus", "aidancbrady", "Melonar", "Cricket", "YorkAARGH",
		"spacetoad", "FyberOptic", "Vexatos", "Mineshopper", "AUTOMATIC_MAIDEN", "sanandreasMC", "FatherToast",
		"Erasmus_Crowley", "Alblaka", "Emoniph", "Nuchaz", "powercrystals", "AbrarSyed", "sdkillen",
		"Taelnia", "Lycanite", "asiekierka", "GregoriusT", "skyboy", "Flaxbeard", "Emasher", "joshiejack", "Reika",
		"ganymedes01", "Pokefenn", "chylex", "vadis365", "jakimfett", "Lunatrius", "copygirl", "amadornes", "DrZhark",
		"KeldonSlayer", "KarelMikie3", "Mfernflower", "LuckyLucyF", "Tristaric", "fry_"
	};

	public static String[] youtubers = {
		"wyld", "SkythekidRS", "Bashur", "Straymaverick", "SOTMead", "Nerdcubed", "Kleetho", "DanTDM", "ashzification",
		"Runew0lf", "GiantWaffle", "Bacon_Donut", "Heph", "ChimneySwift", "FuriousDestroyer", "paulsoaresjr",
		"SuperGirlyGamer", "CyaNideEPiC", "Jarrenitis", "direwolf20", "Sjin", "Xephos", "LividCoffee", "pewdie",
		"Rythian", "Zoeya", "TheStrippin", "InTheLittleWood", "Quetzz", "Blorph", "xbony2", "generikb", "GameChap",
		"CaptainSparklez", "AntVenom", "CavemanFilms", "Fosler", "BevoLJ", "Sips_", "Honeydew", "thejims", "BertieChap",
		"TobyofBuscus", "corjaantje", "RealThinknoodles", "ZexyZek", "WesWilson", "BdoubleO100", "tedyhere", "riskable"
	};

	public static String[] mojang = {
		"Notch", "jeb_", "C418", "Dinnerbone", "Grumm", "Searge", "EvilSeph", "Marc_IRL", "FruktHamster", "ProfMobius",
		"carlmanneh", "vubui", "_tommo_", "kappe", "geuder", "mollstam", "xlson", "KrisJelbring", "amir343", "NeonMaster",
		"carnalizer", "eldrone", "MinecraftChick", "Bopogamel", "Hideous", "MidnightEnforcer"
	};

	public static String[] mindCrack = {
		"adlingtont", "AnderZEL", "Arkas", "Aureylian", "AvidyaZEN", "BlameTC", "Coestar", "Docm77",
		"Guude", "JSano19", "kurtmac", "SuperMCGamer", "Mhykol", "Millbee", "Nebris", "OMGchad", "Pakratt0013",
		"PauseUnpause", "Pyro_0", "SethBling", "Sevadus", "Vechs_", "VintageBeef", "W92Baj", "Zisteau"
	};

	public static String[] hermitcraft = {
		"Biffa2001", "falsesymmetry", "hypnotizd", "iJevin", "impulseSV", "Jessassin", "joehillssays",
		"Keralis1", "KingDaddyDMAC", "monkeyfarm", "Mumbo", "Pungence", "skyzm", "sl1pg8r", "Tango",
		"Tinfoilchef", "topmass", "xBCrafted", "Xisuma", "ZombieCleo", "zueljin", "Etho"
	};

	public static String[] forgeCraft = {
		"Imalune", "ShadwDrgn", "Cojomax99", "Freyjadono", "Vaht", "EcuTruin", "boni", "glasspelican",
		"Mr_okushama", "AlgorithmX2", "Mikeemoo", "_CrazyP_", "MysteriousAges", "MineMaarten", "nekosune", "Mr_Damien_Hazard",
		"tlovetech", "FireBall1725", "PurpleMentat", "Calclavia", "Minalien", "fuj1n", "Mithion", "RWTema", "alexbegt",
		"WayofFlowingTime", "TTFTCUTS", "bspkrs", "amnet", "azanor", "chicken_bones", "Cloudhunter", "RazzleberryFox",
		"CovertJaguar", "cpw11", "dan200", "Eloraam", "florastar", "iChun", "KingLemming", "Krapht", "peterixxx", "Adubbz",
		"LexManos", "TheMattaBase", "mDiyo", "Myrathi", "Morvelaira", "Pahimar", "sfPlayer1", "Arkember",
		"Rorax", "Sacheverell", "sirsengir", "Soaryn", "XCompWiz", "Vswe", "Vazkii", "ZeldoKavira", "AtomicBlom",
		"neptunepink", "EddieRuckus", "LordDusk", "Kihira", "Vaygrim", "Kaelten", "MatrexsVigil", "tfox83", "jadedcat", "mezz",
		"aivu", "ArashiDragon", "Binnie567", "c4ts", "Clairetic", "consolegrl", "Corosus", "electronicbird", "faunastar",
		"Forstride", "IceBladeRage", "Minakun", "odedex", "OvermindDL1", "RichardG867", "ted80", "Benimatic", "MrFlamegoat"
	};

	public static String[] ftb = {
		"eyamaz", "slowpoke101", "progwml6", "Captainnana", "Gideonseymour", "Watchful11", "SnowShock35"
	};

	public static String[] technic = {
		"GenPage", "Slink730", "sct", "KakerMix", "Skuli_Steinulf", "Talonos"
	};
	// @formatter:on

	public static boolean enableModSent = true;
	public static List<String> modsent = new ArrayList<String>();

	public static boolean addPlayerHeadsAsDungeonLoot = true;
	public static int headsDungeonLootWeight = 1;
	public static boolean enablePlayerStatues = true;
	public static boolean enableTooltips = true;

	public static boolean enableHumanMobs = true;
	public static int celebrityProb = 80, celebrityMin = 4, celebrityMax = 4;
	public static double babyHumanChance = 0.1;
	public static boolean enableVIPs = true;
	public static int[] blacklistedDimensions = { 1, -1 };
	public static String humanNamePrefix = "";
	public static boolean humansAttackTwins = true;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.INSTANCE.init(event.getSuggestedConfigurationFile());

		ModBlocks.init();

		OreDictionary.registerOre("itemSkull", new ItemStack(Items.skull, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("skullSkeleton", new ItemStack(Items.skull, 1, 0));
		OreDictionary.registerOre("skullWitherSkeleton", new ItemStack(Items.skull, 1, 1));
		OreDictionary.registerOre("skullZombie", new ItemStack(Items.skull, 1, 2));
		OreDictionary.registerOre("skullPlayer", new ItemStack(Items.skull, 1, 3));
		OreDictionary.registerOre("skullCreeper", new ItemStack(Items.skull, 1, 4));
		OreDictionary.registerOre("skullEnderDragon", new ItemStack(Items.skull, 1, 5));

		if (enableHumanMobs) {
			EntityRegistry.registerModEntity(EntityHuman.class, "Human", 0, instance, 512, 1, true);
			EntityRegistry.registerEgg(EntityHuman.class, 0xFFF144, 0x69DFDA);
			VIPHandler.init();
		}

		proxy.registerEntityRenderers();
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerRenderers();
		proxy.registerEvents();
		proxy.registerTileEntities();

		FMLInterModComms.sendMessage("Waila", "register", "ganymedes01.headcrumbs.waila.WailaRegistrar.wailaCallback");

		if (Loader.isModLoaded("ganysend"))
			addEnderFurnaceRecipe(new ItemStack(Items.nether_star), "skullWither");

		if (enablePlayerStatues) {
			GameRegistry.addRecipe(StatueRecipe.getRecipe(new ItemStack(ModBlocks.player), "x", "y", "y", 'x', new ItemStack(Items.skull, 1, 3), 'y', new ItemStack(Blocks.clay)));
			RecipeSorter.register("statue", StatueRecipe.class, Category.SHAPED, "after:minecraft:shaped");
		}
	}

	private void addEnderFurnaceRecipe(ItemStack output, Object... input) {
		NBTTagCompound nbt = new NBTTagCompound();

		NBTTagCompound out = new NBTTagCompound();
		output.writeToNBT(out);
		nbt.setTag("output", out);

		for (int i = 0; i < input.length; i++)
			if (input[i] != null)
				if (input[i] instanceof ItemStack) {
					NBTTagCompound in = new NBTTagCompound();
					((ItemStack) input[i]).writeToNBT(in);
					nbt.setTag("input" + i, in);
				} else
					nbt.setString("input" + i, (String) input[i]);

		FMLInterModComms.sendMessage("ganysend", "enderFurnaceRecipe", nbt);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		HeadDropHelper.register(new LaserCreepersHelper());
		HeadDropHelper.register(new TwilightForestHelper());
		HeadDropHelper.register(new TEHelper());
		HeadDropHelper.register(new NaturaHelper());
		HeadDropHelper.register(new ThaumcraftHelper());
		HeadDropHelper.register(new LycanitesHelper());
		HeadDropHelper.register(new EnderZooHelper());
		HeadDropHelper.register(new PrimitiveMobsHelper());
		HeadDropHelper.register(new GrimoireOfGaiaHelper());
		HeadDropHelper.register(new ElementalCreepersHelper());
		HeadDropHelper.register(new VanillaHelper());

		if (enableHumanMobs)
			addHumanSpawns();

		if (Loader.isModLoaded("TwilightForest")) {
			Item tropy = Item.itemRegistry.getObject(new ResourceLocation("TwilightForest", "item.trophy"));
			addConvertionRecipe(SkullTypes.hydra.getStack(), new ItemStack(tropy, 1, 0));
			addConvertionRecipe(SkullTypes.nagaTF.getStack(), new ItemStack(tropy, 1, 1));
			addConvertionRecipe(SkullTypes.lich.getStack(), new ItemStack(tropy, 1, 2));
			addConvertionRecipe(SkullTypes.urGhast.getStack(), new ItemStack(tropy, 1, 3));
			addConvertionRecipe(SkullTypes.snowQueen.getStack(), new ItemStack(tropy, 1, 4));
		}
	}

	private void addConvertionRecipe(ItemStack output, ItemStack input) {
		GameRegistry.addShapelessRecipe(output, input);
		GameRegistry.addShapelessRecipe(input, output);
	}

	@EventHandler
	public void imcEvent(IMCEvent event) {
		Logger logger = LogManager.getLogger(Reference.MOD_ID);
		for (IMCMessage message : event.getMessages())
			if (message.key.equals("add-username")) {
				if (!enableModSent) {
					logger.info(String.format("%s tried to add %s to the username list, but the feature has been disabled by the user.", message.getSender(), message.getStringValue()));
					continue;
				}
				if (message.isStringMessage()) {
					String username = message.getStringValue();
					if (!getAllNames().contains(username)) {
						modsent.add(username);
						logger.info(String.format("%s added %s to the username list", message.getSender(), message.getStringValue()));
					} else
						logger.info(String.format("%s tried to add %s to the username list, but it was already present", message.getSender(), message.getStringValue()));
				} else
					logger.error(String.format("Invalid message type sent from %s", message.getSender()));
			} else
				logger.error(String.format("Invalid message key sent from %s: %s", message.getSender(), message.key));
	}

	public static List<String> getAllNames() {
		Set<String> names = new HashSet<String>();
		names.addAll(Arrays.asList(others));
		names.addAll(Arrays.asList(modders));
		names.addAll(Arrays.asList(youtubers));
		names.addAll(Arrays.asList(mojang));
		names.addAll(Arrays.asList(mindCrack));
		names.addAll(Arrays.asList(hermitcraft));
		names.addAll(Arrays.asList(forgeCraft));
		names.addAll(Arrays.asList(ftb));
		names.addAll(Arrays.asList(technic));
		if (enableModSent)
			names.addAll(modsent);
		return new ArrayList<String>(names);
	}

	private static void addHumanSpawns() {
		List<BiomeDictionary.Type> blacklistedBiomes = Arrays.asList(BiomeDictionary.Type.MUSHROOM);
		List<String> blacklistedBiomeNames = Arrays.asList("Tainted Land");

		List<BiomeGenBase> biomes = new LinkedList<BiomeGenBase>();
		label: for (BiomeGenBase biome : BiomeGenBase.biomeRegistry)
			if (biome != null) {
				// Check if the biome name is blacklisted
				if (blacklistedBiomeNames.contains(biome.getBiomeName()))
					continue;

				// Check if the biome type is blacklisted
				for (BiomeDictionary.Type type : BiomeDictionary.getTypesForBiome(biome))
					if (blacklistedBiomes.contains(type))
						continue label;

				// Check if zombies can spawn on this biome
				for (Object obj : biome.getSpawnableList(EnumCreatureType.MONSTER))
					if (obj instanceof SpawnListEntry) {
						SpawnListEntry entry = (SpawnListEntry) obj;
						try {

							boolean isSpecialMobsZombie = Loader.isModLoaded("SpecialMobs") && Class.forName("toast.specialMobs.entity.zombie.Entity_SpecialZombie").isAssignableFrom(entry.entityClass);
							if (entry.entityClass == EntityZombie.class || isSpecialMobsZombie) {
								biomes.add(biome);
								continue label;
							}

						} catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
					}
			}

		EntityRegistry.addSpawn(EntityHuman.class, celebrityProb, celebrityMin, celebrityMax, EnumCreatureType.MONSTER, biomes.toArray(new BiomeGenBase[biomes.size()]));
	}
}