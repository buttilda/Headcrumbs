package ganymedes01.headcrumbs.utils.helpers;

import ganymedes01.headcrumbs.libs.SkullTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class GrimoireOfGaiaHelper extends ModHeadDropHelper {

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
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		String mobName = EntityList.getEntityString(entity);

		if ("GrimoireOfGaia.Bone Knight".equals(mobName))
			return new ItemStack(Items.skull);
		else if ("GrimoireOfGaia.Creep".equals(mobName))
			return new ItemStack(Items.skull, 1 + entity.worldObj.rand.nextInt(3), 4);

		return super.getHeadForEntity(entity);
	}
}