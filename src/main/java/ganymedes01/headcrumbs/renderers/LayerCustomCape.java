package ganymedes01.headcrumbs.renderers;

import java.lang.reflect.Field;
import java.util.Map;

import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import ganymedes01.headcrumbs.utils.CapeUtils;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerCustomCape implements LayerRenderer<AbstractClientPlayer> {

	private final Field playerInfoField = ReflectionHelper.findField(AbstractClientPlayer.class, "playerInfo", "field_175157_a");
	private final Field playerTexturesField = ReflectionHelper.findField(NetworkPlayerInfo.class, "playerTextures", "field_187107_a");

	public LayerCustomCape() {
		playerInfoField.setAccessible(true);
		playerTexturesField.setAccessible(true);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void doRenderLayer(AbstractClientPlayer entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		if (entity.getLocationCape() != null)
			return;
		ResourceLocation cape = CapeUtils.getCape(entity.getGameProfile());
		if (cape == null)
			return;

		try {
			NetworkPlayerInfo playerInfo = (NetworkPlayerInfo) playerInfoField.get(entity);
			if (playerInfo != null) {
				Map<Type, ResourceLocation> playerTextures = (Map<Type, ResourceLocation>) playerTexturesField.get(playerInfo);
				playerTextures.put(Type.CAPE, cape);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean shouldCombineTextures() {
		return false;
	}
}