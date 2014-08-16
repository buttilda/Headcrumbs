package ganymedes01.headcrumbs.utils;

import ganymedes01.headcrumbs.libs.Reference;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;

import com.mojang.authlib.GameProfile;

public class TextureUtils {

	private static final Map<String, ResourceLocation> capes = new HashMap<String, ResourceLocation>();
	private static final Map<String, ResourceLocation> skins = new HashMap<String, ResourceLocation>();

	public static ResourceLocation getPlayerSkin(GameProfile profile) {
		if (profile != null) {
			String name = profile.getName();
			if (name != null && !name.isEmpty()) {
				ResourceLocation texture = skins.get(name);
				if (texture == null) {
					texture = new ResourceLocation(Reference.MOD_ID + ":skins/" + StringUtils.stripControlCodes(name));
					AbstractClientPlayer.getDownloadImageSkin(texture, name);
					skins.put(profile.getName(), texture);
				}
				return texture;
			}
		}
		return AbstractClientPlayer.locationStevePng;
	}

	public static ResourceLocation getPlayerCape(GameProfile profile) {
		if (profile != null) {
			String name = profile.getName();
			if (name != null && !name.isEmpty()) {
				ResourceLocation texture = capes.get(name);
				if (texture == null) {
					texture = new ResourceLocation(Reference.MOD_ID + ":cloaks/" + StringUtils.stripControlCodes(name));
					getDownloadImageCape(texture, name);
					capes.put(profile.getName(), texture);
				}
				return texture;
			}
		}
		return null;
	}

	private static void getDownloadImageCape(ResourceLocation resource, String name) {
		TextureManager manager = Minecraft.getMinecraft().getTextureManager();
		Object texture = manager.getTexture(resource);

		if (texture == null) {
			texture = new ThreadDownloadImageData((File) null, String.format("http://skins.minecraft.net/MinecraftCloaks/%s.png", StringUtils.stripControlCodes(name)), new ResourceLocation(Reference.MOD_ID + ":textures/empty.png"), new ImageBufferDownload());
			manager.loadTexture(resource, (ITextureObject) texture);
		}
	}
}