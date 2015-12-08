package ganymedes01.headcrumbs.utils;

import java.util.Map;

import com.google.common.collect.Maps;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.network.PacketHandler;
import ganymedes01.headcrumbs.network.packet.TextureRequestPacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

@SideOnly(Side.CLIENT)
public class TextureUtils {

	private static final ResourceLocation LARGE_STEVE_TEXTURE = new ResourceLocation("etfuturum", "textures/entity/steve.png");

	public static final Map<MinecraftProfileTexture.Type, Map<String, ResourceLocation>> textures = Maps.newHashMap();

	static {
		textures.put(Type.CAPE, Maps.newHashMap());
		textures.put(Type.SKIN, Maps.newHashMap());
	}

	public static ResourceLocation getPlayerSkin(GameProfile profile) {
		return getPlayerImage(profile, MinecraftProfileTexture.Type.SKIN);
	}

	public static ResourceLocation getPlayerCape(GameProfile profile) {
		return getPlayerImage(profile, MinecraftProfileTexture.Type.CAPE);
	}

	private static ResourceLocation getPlayerImage(GameProfile profile, MinecraftProfileTexture.Type type) {
		if (profile != null && profile.getName() != null) {
			Minecraft mc = Minecraft.getMinecraft();
			if (profile.getName().equals(mc.thePlayer.getGameProfile().getName())) {
				ResourceLocation texture = type == Type.CAPE ? mc.thePlayer.getLocationCape() : mc.thePlayer.getLocationSkin();
				if (texture != null && Headcrumbs.use18PlayerModel)
					texture = new ResourceLocation("etfuturum", texture.getResourcePath());
				return texture;
			}

			Map<String, ResourceLocation> mappedTextures = textures.get(type);
			if (mappedTextures.containsKey(profile.getName()))
				return mappedTextures.get(profile.getName());
			else {
				// Store profile with the default to avoid thread spam
				mappedTextures.put(profile.getName(), getDefault(type));

				// Request texture from server
				PacketHandler.sendToServer(new TextureRequestPacket(profile.getName()));
			}
		}

		return getDefault(type);
	}

	public static ResourceLocation getDefault(MinecraftProfileTexture.Type type) {
		return type == Type.CAPE ? null : Headcrumbs.use18PlayerModel ? LARGE_STEVE_TEXTURE : AbstractClientPlayer.locationStevePng;
	}
}