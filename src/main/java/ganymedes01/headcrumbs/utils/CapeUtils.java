package ganymedes01.headcrumbs.utils;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import com.mojang.authlib.GameProfile;

import ganymedes01.headcrumbs.libs.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class CapeUtils {

	private static final ArrayList<String> USERS_WITH_CAPES = new ArrayList<String>();
	private static ResourceLocation DEFAULT = Utils.getResource(Reference.MOD_ID + ":textures/capes/default.png");
	private static ResourceLocation KPR = Utils.getResource(Reference.MOD_ID + ":textures/capes/KingPurpleRaptor.png");

	static {
		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					Scanner scanner = new Scanner(new URL("https://raw.github.com/ganymedes01/Version-Checks/master/UsersWithCapes.txt").openStream());
					while (scanner.hasNext())
						USERS_WITH_CAPES.add(scanner.nextLine());
					scanner.close();
				} catch (IOException e) {
				}
			}
		}).start();
	}

	public static ResourceLocation getCape(GameProfile profile) {
		String name = profile != null ? profile.getName() : null;
		if (!USERS_WITH_CAPES.contains(name))
			return null;
		else if ("KingPurpleRaptor".equals(name))
			return KPR;
		else
			return DEFAULT;
	}
}