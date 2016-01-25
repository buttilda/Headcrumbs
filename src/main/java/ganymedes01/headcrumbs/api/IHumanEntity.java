package ganymedes01.headcrumbs.api;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;

import net.minecraft.client.resources.SkinManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public interface IHumanEntity {

	GameProfile getProfile();

	void setProfile(GameProfile profile);

	String getUsername();

	void setUsername(String name);

	double getInterpolatedCapeX(float partialTickTime);

	double getInterpolatedCapeY(float partialTickTime);

	double getInterpolatedCapeZ(float partialTickTime);

	@SideOnly(Side.CLIENT)
	SkinManager.SkinAvailableCallback getCallback();

	@SideOnly(Side.CLIENT)
	boolean isTextureAvailable(MinecraftProfileTexture.Type type);

	@SideOnly(Side.CLIENT)
	void setTextureAvailable(MinecraftProfileTexture.Type type);

	@SideOnly(Side.CLIENT)
	ResourceLocation getTexture(MinecraftProfileTexture.Type type);

	@SideOnly(Side.CLIENT)
	boolean isProfileReady();
}