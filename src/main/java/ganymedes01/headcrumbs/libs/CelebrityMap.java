package ganymedes01.headcrumbs.libs;

import java.util.HashMap;
import java.util.Map;

public class CelebrityMap {

	private static Map<String, String> map = new HashMap<String, String>();
	static {
		initMap();
	}

	public static String getTooltip(String name) {
		return map.get(name);
	}

	private static void initMap() {
		map.clear();
		map.put("FatherToast", "Special Mobs");
		map.put("AUTOMATIC_MAIDEN", "Chisel");
		map.put("Erasmus_Crowley", "ExNihilo");
		map.put("Alblaka", "IndustrialCraft");
		map.put("_CrazyP_", "EnderIO");
		map.put("AbrarSyed", "ForgeGradle");
		map.put("AlgorithmX2", "Applied Energistics");
		map.put("azanor", "Thaumcraft");
		map.put("bspkrs", "MCP");
		map.put("C418", "Soundtrack");
		map.put("chicken_bones", "NotEnoughItems");
		map.put("chylex", "HardcoreEnderExpansion");
		map.put("Cloudhunter", "ComputerCraft");
		map.put("CovertJaguar", "RailCraft");
		map.put("cpw11", "ForgeModLoader");
		map.put("dan200", "ComputerCraft");
		map.put("direwolf20", "Take it easy!");
		map.put("Eloraam", "RedPower");
		map.put("Emoniph", "Witchery");
		map.put("FireBall1725", "Applied Energistics");
		map.put("Flaxbeard", "Professor Flaxbeard's Wondrous Steam Power Mod");
		map.put("GregoriusT", "GregTech");
		map.put("Jarrenitis", "Help spread the gaming!");
		map.put("jakimfett", "MineChem");
		map.put("joshiejack", "Mariculture");
		map.put("Kihira", "Player Beacons");
		map.put("KingLemming", "Thermal Expansion");
		map.put("Kobata", "InventoryTweaks");
		map.put("Krapht", "LogisticsPipes");
		map.put("LexManos", "Forge");
		map.put("MatrexsVigil", "Pam's Harvestcraft");
		map.put("mDiyo", "Tinker's Construct");
		map.put("Mikeemoo", "OpenBlocks");
		map.put("Minalien", "MFFS");
		map.put("MineMaarten", "PneumaticCraft");
		map.put("Mithion", "Ars Magica");
		map.put("nekosune", "Thaumic Tinkerer");
		map.put("neptunepink", "Factorization");
		map.put("Nuchaz", "BiblioCraft");
		map.put("iChun", "Morph");
		map.put("Pahimar", "Equivalent Exchange 3");
		map.put("Pokefenn", "Totemic");
		map.put("powercrystals", "MineFactory Reloaded");
		map.put("ProfMobius", "JABBA");
		map.put("progwml6", "FTB Launcher");
		map.put("Quetzz", "Blue Power");
		map.put("Reika", "RotaryCraft");
		map.put("RWTema", "Extra Utilities");
		map.put("sfPlayer1", "IndustrialCraft 2");
		map.put("sirsengir", "Forestry");
		map.put("skyboy", "MineFactory Reloaded");
		map.put("Soaryn", "XyCraft");
		map.put("Taelnia", "JABBA");
		map.put("TTFTCUTS", "Alternate Terrain Generation");
		map.put("vadis365", "The Erebus");
		map.put("Vazkii", "Botania");
		map.put("Vswe", "Steve's Carts");
		map.put("WayofFlowingTime", "BloodMagic");
		map.put("x3n0ph0b3", "Equivalent Exchange");
		map.put("XCompWiz", "Mystcraft");
		map.put("ZeldoKavira", "Thermal Expansion");
		map.put("calclavia", "Universal Electricity");
		map.put("Mineshopper", "Carpenter's Blocks");
		map.put("asiekierka", "Computronics");
		map.put("fuj1n", "Tinker's Construct");
		map.put("boni", "Tinker's Construct");
		map.put("FyberOptic", "Hopper Ducts");
		map.put("spacetoad", "BuildCraft");
		map.put("aidancbrady", "Mekanism");
		map.put("Adubbz", "Biomes O'Plenty");
		map.put("Binnie567", "Extra Bees");
		map.put("ShadwDrgn", "Soul Shards");
		map.put("techbrew", "JourneyMap");
		map.put("Silentine", "Grimoire Of Gaia 3");
		map.put("sinkillerj", "ProjectE");
		map.put("mezz", "Forestry");

		map.put("ganymedes01", "Gany's Mods");
	}
}