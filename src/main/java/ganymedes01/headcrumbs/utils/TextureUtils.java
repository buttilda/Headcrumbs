package ganymedes01.headcrumbs.utils;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;
import com.mojang.authlib.properties.Property;

public class TextureUtils {

	private static final Map<String, GameProfile> profiles = new HashMap<String, GameProfile>();

	public static ResourceLocation getPlayerSkin(GameProfile profile) {
		return getPlayerImage(profile, MinecraftProfileTexture.Type.SKIN);
	}

	public static ResourceLocation getPlayerCape(GameProfile profile) {
		return getPlayerImage(profile, MinecraftProfileTexture.Type.CAPE);
	}

	@SuppressWarnings("unchecked")
	private static ResourceLocation getPlayerImage(final GameProfile profile, MinecraftProfileTexture.Type type) {
		if (profile != null)
			if (profiles.containsKey(profile.getName())) {
				Minecraft minecraft = Minecraft.getMinecraft();
				Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraft.func_152342_ad().func_152788_a(profiles.get(profile.getName()));

				if (map.containsKey(type))
					return minecraft.func_152342_ad().func_152792_a(map.get(type), type);
			} else {
				// If it's the same as the client player, store client player's profile
				if (profile.getName().equals(Minecraft.getMinecraft().thePlayer.getGameProfile().getName())) {
					profiles.put(profile.getName(), Minecraft.getMinecraft().thePlayer.getGameProfile());
					return AbstractClientPlayer.locationStevePng;
				}

				// Store profile with self to avoid thread spam
				profiles.put(profile.getName(), profile);

				// Start thread to download image
				new Thread(new Runnable() {

					@Override
					public void run() {
						GameProfile gp = profile;
						GameProfile gameprofile = MinecraftServer.getServer().func_152358_ax().func_152655_a(gp.getName());

						if (gameprofile != null) {
							Property property = (Property) Iterables.getFirst(gameprofile.getProperties().get("textures"), (Object) null);

							if (property == null)
								gameprofile = MinecraftServer.getServer().func_147130_as().fillProfileProperties(gameprofile, true);

							gp = gameprofile;
							profiles.put(gp.getName(), gp);
						}
					}

				}, profile.getName()).start();
			}

		return type == Type.CAPE ? null : AbstractClientPlayer.locationStevePng;
	}
}