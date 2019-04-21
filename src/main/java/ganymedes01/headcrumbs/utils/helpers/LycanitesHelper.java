package ganymedes01.headcrumbs.utils.helpers;

public class LycanitesHelper //extends HeadDropHelper
{

	//	public static final List<String> blacklist = Arrays.asList("pinky", "behemoth", "belph");
	//	public static final List<String> prefixes = Arrays.asList("arcticmobs", "demonmobs", "desertmobs", "forestmobs", "freshwatermobs", "infernomobs", "junglemobs", "mountainmobs", "plainsmobs", "saltwatermobs", "swampmobs");
	//
	//	public static final String MOD_ID = "lycanitesmobs";
	//
	//	public LycanitesHelper()
	//	{
	//		super(MOD_ID);
	//	}
	//
	//	public static String capitaliseString(String string)
	//	{
	//		return string.substring(0, 1).toUpperCase() + string.substring(1);
	//	}
	//
	//	@Override
	//	protected ItemStack getHeadForEntity(Entity entity)
	//	{
	//
	//		String mobName = EntityList.getEntityString(entity);
	//		if(mobName == null)
	//			return null;
	//
	//		int dot = mobName.indexOf('.') + 1;
	//		if(dot > 1)
	//		{
	//			String prefix = mobName.substring(0, dot - 1);
	//			if(prefixes.contains(prefix))
	//			{
	//				mobName = mobName.substring(dot).toLowerCase();
	//				return !blacklist.contains(mobName) ? getStackFor(mobName) : null;
	//			}
	//		}
	//
	//		return null;
	//	}
	//
	//	private static ItemStack getStackFor(String mob)
	//	{
	//		ItemStack stack = HeadUtils.createHeadFor(mob);
	//		stack.setItemDamage(SkullTypes.lycanites.ordinal());
	//		return stack;
	//	}
}