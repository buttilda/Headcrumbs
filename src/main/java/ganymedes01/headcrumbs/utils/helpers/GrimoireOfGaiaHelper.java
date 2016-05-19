package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GrimoireOfGaiaHelper extends HeadDropHelper {

	public GrimoireOfGaiaHelper() {
		super("GrimoireOfGaia");

		typesMap.put("GrimoireOfGaia.Anubis", SkullTypes.anubis);
		typesMap.put("GrimoireOfGaia.Banshee", SkullTypes.banshee);
		typesMap.put("GrimoireOfGaia.Baphomet", SkullTypes.baphomet);
		typesMap.put("GrimoireOfGaia.Centaur", SkullTypes.centaur);
		typesMap.put("GrimoireOfGaia.Cobble Golem", SkullTypes.cobbleGolem);
		typesMap.put("GrimoireOfGaia.Cobblestone Golem", SkullTypes.cobblestoneGolem);
		typesMap.put("GrimoireOfGaia.Cockatrice", SkullTypes.cockatrice);
		typesMap.put("GrimoireOfGaia.Cyclops", SkullTypes.cyclops);
		typesMap.put("GrimoireOfGaia.Dhampir", SkullTypes.dhampir);
		typesMap.put("GrimoireOfGaia.Dryad", SkullTypes.dryad);
		typesMap.put("GrimoireOfGaia.Dullahan", SkullTypes.dullahan);
		typesMap.put("GrimoireOfGaia.Ender Dragon Girl", SkullTypes.enderDragonGirl);
		typesMap.put("GrimoireOfGaia.Ender Eye", SkullTypes.enderEye);
		typesMap.put("GrimoireOfGaia.Flesh Lich", SkullTypes.fleshLich);
		typesMap.put("GrimoireOfGaia.Futakuchi Onna", SkullTypes.futakuchiOnna);
		typesMap.put("GrimoireOfGaia.Gryphon", SkullTypes.gryphon);
		typesMap.put("GrimoireOfGaia.Harpy", SkullTypes.harpy);
		typesMap.put("GrimoireOfGaia.Hunter", SkullTypes.hunter);
		typesMap.put("GrimoireOfGaia.Jorogumo", SkullTypes.jorogumo);
		typesMap.put("GrimoireOfGaia.Mandragora", SkullTypes.mandragora);
		typesMap.put("GrimoireOfGaia.Mermaid", SkullTypes.mermaid);
		typesMap.put("GrimoireOfGaia.Mimic", SkullTypes.mimic);
		typesMap.put("GrimoireOfGaia.Minotaur", SkullTypes.minotaur);
		typesMap.put("GrimoireOfGaia.Minotaurus", SkullTypes.minotaurus);
		typesMap.put("GrimoireOfGaia.Naga", SkullTypes.naga);
		typesMap.put("GrimoireOfGaia.Nine Tails", SkullTypes.nineTails);
		typesMap.put("GrimoireOfGaia.Sahuagin", SkullTypes.sahuagin);
		typesMap.put("GrimoireOfGaia.Satyr", SkullTypes.satyr);
		typesMap.put("GrimoireOfGaia.Selkie", SkullTypes.selkie);
		typesMap.put("GrimoireOfGaia.Shaman", SkullTypes.shaman);
		typesMap.put("GrimoireOfGaia.Sharko", SkullTypes.sharko);
		typesMap.put("GrimoireOfGaia.Siren", SkullTypes.siren);
		typesMap.put("GrimoireOfGaia.Sludge Girl", SkullTypes.sludgeGirl);
		typesMap.put("GrimoireOfGaia.Sphinx", SkullTypes.sphinx);
		typesMap.put("GrimoireOfGaia.Spriggan", SkullTypes.spriggan);
		typesMap.put("GrimoireOfGaia.Succubus", SkullTypes.succubus);
		typesMap.put("GrimoireOfGaia.Butler", SkullTypes.butler);
		typesMap.put("GrimoireOfGaia.Swamper", SkullTypes.swamper);
		typesMap.put("GrimoireOfGaia.Valkyrie", SkullTypes.valkyrie);
		typesMap.put("GrimoireOfGaia.Vampire", SkullTypes.vampire);
		typesMap.put("GrimoireOfGaia.Werecat", SkullTypes.werecat);
		typesMap.put("GrimoireOfGaia.Witch", SkullTypes.gogWitch);
		typesMap.put("GrimoireOfGaia.Wither Cow", SkullTypes.witherCow);
		typesMap.put("GrimoireOfGaia.Yeti", SkullTypes.yeti);
		typesMap.put("GrimoireOfGaia.Yuki Onna", SkullTypes.yukiOnna);
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if ("GrimoireOfGaia.Bone Knight".equals(mobName))
			return new ItemStack(Items.SKULL);
		else if ("GrimoireOfGaia.Creep".equals(mobName))
			return new ItemStack(Items.SKULL, 1 + entity.worldObj.rand.nextInt(3), 4);

		return super.getHeadForEntity(entity);
	}
}