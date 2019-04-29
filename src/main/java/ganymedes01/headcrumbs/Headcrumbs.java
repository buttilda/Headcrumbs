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
import ganymedes01.headcrumbs.libs.HeadDropRegistry;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.proxy.CommonProxy;
import ganymedes01.headcrumbs.recipes.StatueRecipe;
import ganymedes01.headcrumbs.utils.HeadUtils;
import ganymedes01.headcrumbs.utils.helpers.ElementalCreepersHelper;
import ganymedes01.headcrumbs.utils.helpers.EnderZooHelper;
import ganymedes01.headcrumbs.utils.helpers.GrimoireOfGaiaHelper;
import ganymedes01.headcrumbs.utils.helpers.LaserCreepersHelper;
import ganymedes01.headcrumbs.utils.helpers.MysticalWildlifeHelper;
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
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biome.SpawnListEntry;
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
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.GameData;
import slimeknights.tconstruct.library.TinkerRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, guiFactory = Reference.GUI_FACTORY_CLASS, dependencies = "required-after:tconstruct@[1.12.2-2.12.0.149,);")
public class Headcrumbs
{
	public static final Random rand = new Random();

	@Instance(Reference.MOD_ID)
	public static Headcrumbs instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tab = new CreativeTabs(Reference.MOD_ID)
	{
		@Override
		public ItemStack createIcon()
		{
			return new ItemStack(Items.SKULL);
		}
	};

	// @formatter:off
    public static String[] others = { "ez", "saukawolf", "Fullapple1991", "Cindric", "wiiv", "deadmau5", "muted79",
	    "DrummingFish", "Kyrinon", "KingPurpleRaptor", "DylanGK", "sadris", "Herobrine", "kehaan" };

    public static String[] modders = { "sinkillerj", "Silentine", "techbrew", "Drullkus", "aidancbrady", "Melonar",
	    "Cricket", "YorkAARGH", "spacetoad", "FyberOptic", "Vexatos", "Mineshopper", "AUTOMATIC_MAIDEN",
	    "sanandreasMC", "FatherToast", "Erasmus_Crowley", "Alblaka", "Emoniph", "Nuchaz", "powercrystals",
	    "AbrarSyed", "sdkillen", "Taelnia", "Lycanite", "asiekierka", "GregoriusT", "skyboy", "Flaxbeard",
	    "Emasher", "joshiejack", "Reika", "ganymedes01", "Pokefenn", "chylex", "vadis365", "jakimfett", "Lunatrius",
	    "copygirl", "amadornes", "DrZhark", "KeldonSlayer", "KarelMikie3", "Mfernflower", "LuckyLucyF", "Tristaric",
	    "fry_", "Turkey2349", "Funwayguy", "Lykrast" };

    public static String[] youtubers = { "wyld", "SkythekidRS", "Bashur", "Straymaverick", "SOTMead", "Nerdcubed",
	    "Kleetho", "DanTDM", "ashzification", "Runew0lf", "GiantWaffle", "Bacon_Donut", "Heph", "ChimneySwift",
	    "FuriousDestroyer", "paulsoaresjr", "SuperGirlyGamer", "CyaNideEPiC", "Jarrenitis", "direwolf20", "Sjin",
	    "Xephos", "LividCoffee", "pewdie", "Rythian", "Zoeya", "TheStrippin", "InTheLittleWood", "Quetzz", "Blorph",
	    "xbony2", "generikb", "GameChap", "CaptainSparklez", "AntVenom", "CavemanFilms", "Fosler", "BevoLJ",
	    "Sips_", "Honeydew", "thejims", "BertieChap", "TobyofBuscus", "corjaantje", "RealThinknoodles", "ZexyZek",
	    "WesWilson", "BdoubleO100", "tedyhere", "riskable" };

    public static String[] mojang = { "Notch", "jeb_", "C418", "Dinnerbone", "Grumm", "Searge", "EvilSeph", "Marc_IRL",
	    "FruktHamster", "ProfMobius", "carlmanneh", "vubui", "_tommo_", "kappe", "geuder", "mollstam", "xlson",
	    "KrisJelbring", "amir343", "NeonMaster", "carnalizer", "eldrone", "MinecraftChick", "Bopogamel", "Hideous",
	    "MidnightEnforcer", "Morre" };

    public static String[] mindCrack = { "adlingtont", "AnderZEL", "Arkas", "Aureylian", "AvidyaZEN", "BlameTC",
	    "Coestar", "Docm77", "Guude", "JSano19", "kurtmac", "SuperMCGamer", "Mhykol", "Millbee", "Nebris",
	    "OMGchad", "Pakratt0013", "PauseUnpause", "Pyro_0", "SethBling", "Sevadus", "Vechs_", "VintageBeef",
	    "W92Baj", "Zisteau" };

    public static String[] hermitcraft = { "Biffa2001", "falsesymmetry", "hypnotizd", "iJevin", "impulseSV",
	    "Jessassin", "joehillssays", "Keralis1", "KingDaddyDMAC", "monkeyfarm", "Mumbo", "Pungence", "skyzm",
	    "sl1pg8r", "Tango", "Tinfoilchef", "topmass", "xBCrafted", "Xisuma", "ZombieCleo", "zueljin", "Etho" };

    public static String[] forgeCraft = { "Imalune", "ShadwDrgn", "Cojomax99", "Freyjadono", "Vaht", "EcuTruin", "boni",
	    "glasspelican", "Mr_okushama", "AlgorithmX2", "Mikeemoo", "_CrazyP_", "MysteriousAges", "MineMaarten",
	    "nekosune", "Mr_Damien_Hazard", "tlovetech", "FireBall1725", "PurpleMentat", "Calclavia", "Minalien",
	    "fuj1n", "Mithion", "RWTema", "alexbegt", "WayofFlowingTime", "TTFTCUTS", "bspkrs", "amnet", "azanor",
	    "chicken_bones", "Cloudhunter", "RazzleberryFox", "CovertJaguar", "cpw11", "dan200", "Eloraam", "florastar",
	    "iChun", "KingLemming", "Krapht", "peterixxx", "Adubbz", "LexManos", "TheMattaBase", "mDiyo", "Myrathi",
	    "Morvelaira", "Pahimar", "sfPlayer1", "Arkember", "x3n0ph0b3", "Rorax", "Sacheverell", "sirsengir",
	    "Soaryn", "XCompWiz", "Vswe", "Vazkii", "ZeldoKavira", "AtomicBlom", "neptunepink", "EddieRuckus",
	    "LordDusk", "Kihira", "Vaygrim", "Kaelten", "MatrexsVigil", "tfox83", "jadedcat", "mezz", "aivu",
	    "ArashiDragon", "Binnie567", "c4ts", "Clairetic", "consolegrl", "Corosus", "electronicbird", "faunastar",
	    "Forstride", "IceBladeRage", "Minakun", "odedex", "OvermindDL1", "RichardG867", "ted80", "Benimatic",
	    "MrFlamegoat" };

    public static String[] ftb = { "eyamaz", "slowpoke101", "progwml6", "Captainnana", "Gideonseymour", "Watchful11",
	    "SnowShock35", "Darkosto" };

    public static String[] technic = { "GenPage", "Slink730", "sct", "KakerMix", "Skuli_Steinulf", "Talonos" };
    // @formatter:on

	public static boolean enableModSent = true;
	public static List<String> modsent = new ArrayList<String>();

	public static boolean enablePlayerHeadsDrop = false;
	public static boolean enableMobsAndAnimalHeads = false;

	public static int headDropChance = 200;
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
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigHandler.INSTANCE.init(event.getSuggestedConfigurationFile());

		OreDictionary.registerOre("itemSkull", new ItemStack(Items.SKULL, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("skullSkeleton", new ItemStack(Items.SKULL, 1, 0));
		OreDictionary.registerOre("skullWitherSkeleton", new ItemStack(Items.SKULL, 1, 1));
		OreDictionary.registerOre("skullZombie", new ItemStack(Items.SKULL, 1, 2));
		OreDictionary.registerOre("skullPlayer", new ItemStack(Items.SKULL, 1, 3));
		OreDictionary.registerOre("skullCreeper", new ItemStack(Items.SKULL, 1, 4));
		OreDictionary.registerOre("skullEnderDragon", new ItemStack(Items.SKULL, 1, 5));

		if(enableHumanMobs)
		{
			EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, "Human"), EntityHuman.class, "Human", 0, instance, 512, 1, true, 0xFFF144, 0x69DFDA);
			VIPHandler.init();
		}

		HeadDropRegistry.register(new VanillaHelper());
		HeadDropRegistry.register(new LaserCreepersHelper());
		HeadDropRegistry.register(new TwilightForestHelper());
		HeadDropRegistry.register(new TEHelper());
		HeadDropRegistry.register(new NaturaHelper());
		HeadDropRegistry.register(new ThaumcraftHelper());
		HeadDropRegistry.register(new EnderZooHelper());
		HeadDropRegistry.register(new PrimitiveMobsHelper());
		HeadDropRegistry.register(new GrimoireOfGaiaHelper());
		HeadDropRegistry.register(new ElementalCreepersHelper());
		HeadDropRegistry.register(new MysticalWildlifeHelper());

		proxy.registerEntityRenderers();
		proxy.registerEvents();
		proxy.registerTileEntities();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenderers();

		FMLInterModComms.sendMessage("Waila", "register", "ganymedes01.headcrumbs.waila.WailaRegistrar.wailaCallback");

		if(Loader.isModLoaded("ganysend"))
			addEnderFurnaceRecipe(new ItemStack(Items.NETHER_STAR), "skullWither");

		if(enablePlayerStatues)
		{
			GameData.register_impl(StatueRecipe.getRecipe("Statue recipe", new ItemStack(ModBlocks.player), "x", "y", "y", 'x', new ItemStack(Items.SKULL, 1, 3), 'y', new ItemStack(Blocks.CLAY)));
			// RecipeSorter.register("statue", StatueRecipe.class,
			// Category.SHAPED, "after:minecraft:shaped");
		}
	}

	private void addEnderFurnaceRecipe(ItemStack output, Object... input)
	{
		NBTTagCompound nbt = new NBTTagCompound();

		NBTTagCompound out = new NBTTagCompound();
		output.writeToNBT(out);
		nbt.setTag("output", out);

		for(int i = 0; i < input.length; i++)
			if(input[i] != null)
				if(input[i] instanceof ItemStack)
				{
					NBTTagCompound in = new NBTTagCompound();
					((ItemStack) input[i]).writeToNBT(in);
					nbt.setTag("input" + i, in);
				}
				else
					nbt.setString("input" + i, (String) input[i]);

		FMLInterModComms.sendMessage("ganysend", "enderFurnaceRecipe", nbt);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		if(enableHumanMobs)
			addHumanSpawns();

		if(Loader.isModLoaded("TwilightForest"))
		{
			Item tropy = Item.REGISTRY.getObject(new ResourceLocation("TwilightForest", "item.trophy"));
			addConvertionRecipe("Hydra recipe", HeadDropRegistry.getHead(TwilightForestHelper.MOD_ID, "hydra"), new ItemStack(tropy, 1, 0));
			addConvertionRecipe("Naga recipe", HeadDropRegistry.getHead(TwilightForestHelper.MOD_ID, "nagaTF"), new ItemStack(tropy, 1, 1));
			addConvertionRecipe("Lich recipe", HeadDropRegistry.getHead(TwilightForestHelper.MOD_ID, "lich"), new ItemStack(tropy, 1, 2));
			addConvertionRecipe("Ur Ghast recipe", HeadDropRegistry.getHead(TwilightForestHelper.MOD_ID, "urGhast"), new ItemStack(tropy, 1, 3));
			addConvertionRecipe("Snow Queen recipe", HeadDropRegistry.getHead(TwilightForestHelper.MOD_ID, "snowQueen"), new ItemStack(tropy, 1, 4));
		}

		if(Loader.isModLoaded("tconstruct"))
		{
			TinkerRegistry.registerHeadDrop(EntityHuman.class, (entity) -> {
				return HeadUtils.getHeadfromEntity(entity);
			});
		}
	}

	private void addConvertionRecipe(String name, ItemStack output, ItemStack input)
	{
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, "Recipes"), new ResourceLocation(Reference.MOD_ID, name), output, Ingredient.fromStacks(input));
		GameRegistry.addShapelessRecipe(new ResourceLocation(Reference.MOD_ID, "Recipes"), new ResourceLocation(Reference.MOD_ID, name + " reversed"), input, Ingredient.fromStacks(output));
	}

	@EventHandler
	public void imcEvent(IMCEvent event)
	{
		Logger logger = LogManager.getLogger(Reference.MOD_ID);
		for(IMCMessage message : event.getMessages())
			if(message.key.equals("add-username"))
			{
				if(!enableModSent)
				{
					logger.info(String.format("%s tried to add %s to the username list, but the feature has been disabled by the user.", message.getSender(), message.getStringValue()));
					continue;
				}
				if(message.isStringMessage())
				{
					String username = message.getStringValue();
					if(!getAllNames().contains(username))
					{
						modsent.add(username);
						logger.info(String.format("%s added %s to the username list", message.getSender(), message.getStringValue()));
					}
					else
						logger.info(String.format("%s tried to add %s to the username list, but it was already present", message.getSender(), message.getStringValue()));
				}
				else
					logger.error(String.format("Invalid message type sent from %s", message.getSender()));
			}
			else
				logger.error(String.format("Invalid message key sent from %s: %s", message.getSender(), message.key));
	}

	public static List<String> getAllNames()
	{
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
		if(enableModSent)
			names.addAll(modsent);
		return new ArrayList<String>(names);
	}

	private static void addHumanSpawns()
	{
		List<BiomeDictionary.Type> blacklistedBiomes = Arrays.asList(BiomeDictionary.Type.MUSHROOM);
		List<String> blacklistedBiomeNames = Arrays.asList("Tainted Land");

		List<Biome> biomes = new LinkedList<Biome>();
		label: for(Biome biome : Biome.REGISTRY)
			if(biome != null)
			{
				// Check if the biome name is blacklisted
				if(blacklistedBiomeNames.contains(biome.getRegistryName().getPath()))
					continue;

				// Check if the biome type is blacklisted
				for(BiomeDictionary.Type type : BiomeDictionary.getTypes(biome))
					if(blacklistedBiomes.contains(type))
						continue label;

				// Check if zombies can spawn on this biome
				for(Object obj : biome.getSpawnableList(EnumCreatureType.MONSTER))
					if(obj instanceof SpawnListEntry)
					{
						SpawnListEntry entry = (SpawnListEntry) obj;
						try
						{

							boolean isSpecialMobsZombie = Loader.isModLoaded("SpecialMobs") && Class.forName("toast.specialMobs.entity.zombie.Entity_SpecialZombie").isAssignableFrom(entry.entityClass);
							if(entry.entityClass == EntityZombie.class || isSpecialMobsZombie)
							{
								biomes.add(biome);
								continue label;
							}

						} catch(ClassNotFoundException e)
						{
							e.printStackTrace();
						}
					}
			}

		EntityRegistry.addSpawn(EntityHuman.class, celebrityProb, celebrityMin, celebrityMax, EnumCreatureType.MONSTER, biomes.toArray(new Biome[biomes.size()]));
	}
}
