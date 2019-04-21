package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GrimoireOfGaiaHelper extends HeadDropHelper {

	public static final String MOD_ID = "grimoireofgaia";
	public GrimoireOfGaiaHelper() {
		super(MOD_ID);

		typesMap.put(MOD_ID + ".Anubis", SkullTypes.anubis);
		typesMap.put(MOD_ID + ".Banshee", SkullTypes.banshee);
		typesMap.put(MOD_ID + ".Baphomet", SkullTypes.baphomet);
		typesMap.put(MOD_ID + ".Centaur", SkullTypes.centaur);
		typesMap.put(MOD_ID + ".Cobble Golem", SkullTypes.cobbleGolem);
		typesMap.put(MOD_ID + ".Cobblestone Golem", SkullTypes.cobblestoneGolem);
		typesMap.put(MOD_ID + ".Dhampir", SkullTypes.dhampir);
		typesMap.put(MOD_ID + ".Dryad", SkullTypes.dryad);
		typesMap.put(MOD_ID + ".Dullahan", SkullTypes.dullahan);
		typesMap.put(MOD_ID + ".Ender Dragon Girl", SkullTypes.enderDragonGirl);
		typesMap.put(MOD_ID + ".Ender Eye", SkullTypes.enderEye);
		typesMap.put(MOD_ID + ".Flesh Lich", SkullTypes.fleshLich);
		typesMap.put(MOD_ID + ".Gryphon", SkullTypes.gryphon);
		typesMap.put(MOD_ID + ".Harpy", SkullTypes.harpy);
		typesMap.put(MOD_ID + ".Hunter", SkullTypes.hunter);
		typesMap.put(MOD_ID + ".Mandragora", SkullTypes.mandragora);
		typesMap.put(MOD_ID + ".Mermaid", SkullTypes.mermaid);
		typesMap.put(MOD_ID + ".Mimic", SkullTypes.mimic);
		typesMap.put(MOD_ID + ".Minotaur", SkullTypes.minotaur);
		typesMap.put(MOD_ID + ".Minotaurus", SkullTypes.minotaurus);
		typesMap.put(MOD_ID + ".Naga", SkullTypes.naga);
		typesMap.put(MOD_ID + ".Nine Tails", SkullTypes.nineTails);
		typesMap.put(MOD_ID + ".Satyress", SkullTypes.satyress);
		typesMap.put(MOD_ID + ".Selkie", SkullTypes.selkie);
		typesMap.put(MOD_ID + ".Shaman", SkullTypes.shaman);
		typesMap.put(MOD_ID + ".Sharko", SkullTypes.sharko);
		typesMap.put(MOD_ID + ".Siren", SkullTypes.siren);
		typesMap.put(MOD_ID + ".Sludge Girl", SkullTypes.sludgeGirl);
		typesMap.put(MOD_ID + ".Sphinx", SkullTypes.sphinx);
		typesMap.put(MOD_ID + ".Spriggan", SkullTypes.spriggan);
		typesMap.put(MOD_ID + ".Succubus", SkullTypes.succubus);
		typesMap.put(MOD_ID + ".Valkyrie", SkullTypes.valkyrie);
		typesMap.put(MOD_ID + ".Vampire", SkullTypes.vampire);
		typesMap.put(MOD_ID + ".Werecat", SkullTypes.werecat);
		typesMap.put(MOD_ID + ".Witch", SkullTypes.gogWitch);
		typesMap.put(MOD_ID + ".Wither Cow", SkullTypes.witherCow);
		typesMap.put(MOD_ID + ".Yeti", SkullTypes.yeti);
		typesMap.put(MOD_ID + ".Yuki Onna", SkullTypes.yukiOnna);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if ("GrimoireOfGaia.Bone Knight".equals(mobName))
			return new ItemStack(Items.SKULL);
		else if ("GrimoireOfGaia.Creep".equals(mobName))
			return new ItemStack(Items.SKULL, 1 + entity.world.rand.nextInt(3), 4);

		return super.getHeadForEntity(entity);
	}
}