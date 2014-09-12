package ganymedes01.headcrumbs.utils;

import ganymedes01.headcrumbs.network.PacketHandler;
import ganymedes01.headcrumbs.network.packet.TextureRequestPacket;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TextureUtils {

	public static final Map<String, GameProfile> profiles = new HashMap<String, GameProfile>();

	public static ResourceLocation getPlayerSkin(GameProfile profile) {
		return getPlayerImage(profile, MinecraftProfileTexture.Type.SKIN);
	}

	public static ResourceLocation getPlayerCape(GameProfile profile) {
		return getPlayerImage(profile, MinecraftProfileTexture.Type.CAPE);
	}

	@SuppressWarnings("unchecked")
	private static ResourceLocation getPlayerImage(final GameProfile profile, MinecraftProfileTexture.Type type) {
		if (profile != null) {
			if (profile.getName().equals(Minecraft.getMinecraft().thePlayer.getGameProfile().getName()))
				return Minecraft.getMinecraft().thePlayer.getLocationSkin();

			if (profiles.containsKey(profile.getName())) {
				Minecraft minecraft = Minecraft.getMinecraft();
				Map<MinecraftProfileTexture.Type, MinecraftProfileTexture> map = minecraft.func_152342_ad().func_152788_a(profiles.get(profile.getName()));

				if (map.containsKey(type))
					return minecraft.func_152342_ad().func_152792_a(map.get(type), type);
			} else {
				// Store profile with self to avoid thread spam
				profiles.put(profile.getName(), profile);

				// Request texture from server
				PacketHandler.sendToServer(new TextureRequestPacket(profile.getName()));
			}
		}

		return type == Type.CAPE ? null : AbstractClientPlayer.locationStevePng;
	}
}