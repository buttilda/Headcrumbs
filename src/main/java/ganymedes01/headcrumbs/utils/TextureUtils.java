package ganymedes01.headcrumbs.utils;

import java.util.Map;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import ganymedes01.headcrumbs.api.IHumanEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TextureUtils {

	private static final ResourceLocation TEXTURE_STEVE = new ResourceLocation("textures/entity/steve.png");
	private static final ResourceLocation TEXTURE_ALEX = new ResourceLocation("textures/entity/alex.png");

	public static ResourceLocation getPlayerSkin(IHumanEntity human) {
		return getTextureForHuman(human, MinecraftProfileTexture.Type.SKIN);
	}

	public static ResourceLocation getPlayerCape(IHumanEntity human) {
		return getTextureForHuman(human, MinecraftProfileTexture.Type.CAPE);
	}

	private static ResourceLocation getTextureForHuman(IHumanEntity human, MinecraftProfileTexture.Type type) {
		if (human.isTextureAvailable(type))
			return human.getTexture(type);

		if (!human.isProfileReady())
			return getDefault(human.getProfile(), type);

		GameProfile profile = human.getProfile();
		if (type == MinecraftProfileTexture.Type.CAPE) {
			ResourceLocation cape = CapeUtils.getCape(profile);
			if (cape != null) {
				human.getCallback().skinAvailable(type, cape, null);
				return cape;
			}
		}

		return getPlayerTexture(profile, type, human.getCallback());
	}

	private static ResourceLocation getPlayerTexture(GameProfile profile, MinecraftProfileTexture.Type type, SkinManager.SkinAvailableCallback callBack) {
		if (profile != null && profile.getName() != null) {
			Minecraft minecraft = Minecraft.getMinecraft();
			Map<Type, MinecraftProfileTexture> map = minecraft.getSkinManager().loadSkinFromCache(profile);
			if (map.containsKey(type))
				return minecraft.getSkinManager().loadSkin(map.get(type), type, callBack);
		}
		return getDefault(profile, type);
	}

	public static ResourceLocation getDefault(GameProfile profile, MinecraftProfileTexture.Type type) {
		if (type == Type.CAPE)
			return null;
		else {
			String skinType = getPlayerSkinType(profile);
			if ("slim".equals(skinType))
				return TEXTURE_ALEX;
			else
				return TEXTURE_STEVE;
		}
	}

	public static String getPlayerSkinType(GameProfile profile) {
		String type = null;

		if (profile != null && profile.getName() != null) {
			Minecraft minecraft = Minecraft.getMinecraft();
			Map<Type, MinecraftProfileTexture> map = minecraft.getSkinManager().loadSkinFromCache(profile);
			if (map.containsKey(Type.SKIN))
				type = map.get(Type.SKIN).getMetadata("model");
		}
		if (type == null)
			type = "default";

		return type;
	}
}