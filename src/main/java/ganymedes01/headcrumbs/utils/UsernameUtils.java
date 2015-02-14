package ganymedes01.headcrumbs.utils;

import java.util.HashMap;
import java.util.Map;

public class UsernameUtils {

	private static final Map<String, String> map = new HashMap<String, String>();

	public static String getFixedUsername(String username) {
		String name = map.get(username);
		return name != null ? name : username;
	}

	public static void initMap() {
		map.put("ohaiiChun", "iChun");
		map.put("KingLemmingCoFH", "KingLemming");
		map.put("Reika_Kalseki", "Reika");
		map.put("skyboy026", "skyboy");
		map.put("inthelittlewood", "InTheLittleWood");
		map.put("mcgamer", "SuperMCGamer");
		map.put("jsano19", "JSano19");
		map.put("hephinator", "Heph");
		map.put("BigBagComplex", "BigBagChris");
	}
}