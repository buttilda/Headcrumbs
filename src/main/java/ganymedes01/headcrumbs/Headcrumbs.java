package ganymedes01.headcrumbs;

import ganymedes01.headcrumbs.configs.ConfigHandler;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.proxy.CommonProxy;
import ganymedes01.headcrumbs.utils.HeadUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_NUMBER, dependencies = Reference.DEPENDENCIES, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Headcrumbs {

	@Instance(Reference.MOD_ID)
	public static Headcrumbs instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;

	public static CreativeTabs tab = new CreativeTabs(Reference.MOD_ID) {

		@Override
		public Item getTabIconItem() {
			return ModItems.skull;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public int func_151243_f() {
			Random rand = new Random();
			List<SkullTypes> types = new ArrayList<SkullTypes>();
			for (SkullTypes type : SkullTypes.values())
				if (type.canShow())
					types.add(type);
			return types.get(rand.nextInt(types.size())).ordinal();
		}
	};

	public static String[] others = { "Jeb_Jeb", "KingPurpleRaptor", "DylanGK" };
	public static String[] modders = { "ganymedes01", "Pokefenn", "chylex", "vadis365", "CrazyPants", "Kihira", "Country_Gamer", "jakimfett", "mats000", "kris545545" };
	public static String[] youtubers = { "direwolf20", "Sjin", "Xephos", "LividCoffee", "Rythian", "Zoeya", "TheStrippin", "inthelittlewood", "Quetzz", "Blorph", "xbony2", "CaptainSparklez", "AntVenom", "CavemanFilms", "Fosler", "BevoLJ", "Sips_", "Honeydew", "TobyTurner", "corjaantje" };
	public static String[] mojang = { "Notch", "jeb_", "C418", "Dinnerbone", "Grumm", "Searge_DP", "EvilSeph", "TheMogMiner" };
	public static String[] mindCrack = { "adlingtont", "AnderZEL", "Arkas", "Aureylian", "AvidyaZEN", "BdoubleO100", "BlameTC", "Coestar", "Docm77", "Etho", "generikb", "Guude", "jsano19", "kurtmac", "mcgamer", "Mhykol", "Millbee", "Nebris", "Pakratt0013", "paulsoaresjr", "PauseUnpause", "Pyro_0", "SethBling", "sevadus", "Vechs_", "VintageBeef", "W92Baj", "Zisteau" };
	public static String[] forgeCraft = { "fuj1n", "Mithion", "RWTema", "WayofFlowingTime", "TTFTCUTS", "bspkrs", "futureamnet", "azanor", "chicken_bones", "Cloudhunter", "CovertJaguar", "cpw11", "dan200", "Eloraam", "florastar", "ohaiiChun", "KingLemmingCoFH", "Krapht", "LexManos", "TheMattaBase", "mDiyo", "Myrathi", "Morvelaira", "Pahimar", "sfPlayer1", "ProfMobius", "Rorax", "Sacheverell", "sirsengir", "Soaryn", "x3n0ph0b3", "XCompWiz", "Vswe", "Vazkii", "ZeldoKavira", "neptunepink", "EddieRuckus" };
	public static String[] ftb = { "eyamaz", "jadedcat", "slowpoke101", "progwml6" };

	public static boolean enableVanillaHeadsDrop = true;
	public static boolean enableRandomHeadDrop = true;
	public static int headDropChance = 10;
	public static boolean addPlayerHeadsAsDungeonLoot = true;
	public static boolean enableMobsAndAnimalHeads = true;
	public static int headsDungeonLootMaxWeight = 6;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		ConfigHandler.INSTANCE.init(event.getSuggestedConfigurationFile());

		ModBlocks.init();
		ModItems.init();

		HeadUtils.loadPlayerHeads();

		OreDictionary.registerOre("itemSkull", new ItemStack(ModItems.skull, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("itemSkull", new ItemStack(Items.skull, 1, OreDictionary.WILDCARD_VALUE));
		for (SkullTypes type : SkullTypes.values())
			OreDictionary.registerOre("skull" + type.name().substring(0, 1).toUpperCase() + type.name().substring(1), new ItemStack(ModItems.skull, 1, type.ordinal()));
		OreDictionary.registerOre("skullSkeleton", new ItemStack(Items.skull, 1, 0));
		OreDictionary.registerOre("skullWitherSkeleton", new ItemStack(Items.skull, 1, 1));
		OreDictionary.registerOre("skullZombie", new ItemStack(Items.skull, 1, 2));
		OreDictionary.registerOre("skullPlayer", new ItemStack(Items.skull, 1, 3));
		OreDictionary.registerOre("skullCreeper", new ItemStack(Items.skull, 1, 4));

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.registerEvents();
		proxy.registerTileEntities();
		proxy.registerRenderers();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}