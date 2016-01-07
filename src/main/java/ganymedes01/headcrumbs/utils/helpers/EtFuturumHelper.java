package ganymedes01.headcrumbs.utils.helpers;

import java.util.Random;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import cpw.mods.fml.common.Optional;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.etfuturum.api.client.ISkinDownloadCallback;
import ganymedes01.etfuturum.client.skins.PlayerModelManager;
import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.libs.SkullTypes;
import ganymedes01.headcrumbs.renderers.TileEntityBlockPlayerRenderer.PlayerForRendering;
import ganymedes01.headcrumbs.utils.TextureUtils;
import ganymedes01.headcrumbs.utils.Utils;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.resources.SkinManager.SkinAvailableCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EtFuturumHelper extends HeadDropHelper {

	public EtFuturumHelper() {
		super("etfuturum");

		typesMap.put("etfuturum.endermite", SkullTypes.endermite);

		if (isEnabled() && Headcrumbs.addPlayerHeadsAsDungeonLoot) {
			Random rand = new Random();
			int min = 1;
			int max = 1;
			int baseWeight = 3;
			Utils.addDungeonLoot(SkullTypes.guardian.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
			Utils.addDungeonLoot(SkullTypes.guardianElder.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
			Utils.addDungeonLoot(SkullTypes.shulker.getStack(), min, max, baseWeight + rand.nextInt(Headcrumbs.headsDungeonLootMaxWeight));
		}
	}

	@Override
	protected ItemStack getHeadForEntity(Entity entity) {
		ItemStack head = super.getHeadForEntity(entity);
		if (head != null)
			return head;

		String mobName = EntityList.getEntityString(entity);

		if (mobName != null && mobName.equals("etfuturum.rabbit")) {
			String name = entity.getCommandSenderName();
			if (name != null && name.equals("Toast"))
				return SkullTypes.rabbitToast.getStack();

			byte rabbitType = entity.getDataWatcher().getWatchableObjectByte(18);
			switch (rabbitType) {
				case 0:
					return SkullTypes.rabbitBrown.getStack();
				case 1:
					return SkullTypes.rabbitWhite.getStack();
				case 2:
					return SkullTypes.rabbitBlack.getStack();
				case 3:
					return SkullTypes.rabbitSplotched.getStack();
				case 4:
					return SkullTypes.rabbitGold.getStack();
				case 5:
					return SkullTypes.rabbitSalt.getStack();
			}
		}

		return null;
	}

	public static SkinAvailableCallback getSkinDownloadCallback(String name) {
		return new ISkinDownloadCallback() {
			@Override
			public void func_152121_a(Type texType, ResourceLocation texture) {
				TextureUtils.textures.get(texType).put(name, texture);
			}
		};
	}

	public static AbstractClientPlayer getPlayer(World world, GameProfile profile) {
		return new EtFuturumPlayerForRendering(world, profile);
	}

	public static boolean isAlexModel(ResourceLocation texture) {
		return PlayerModelManager.isPlayerModelAlex(texture);
	}

	@SideOnly(Side.CLIENT)
	@Optional.Interface(iface = "ganymedes01.etfuturum.api.client.ISkinDownloadCallback", modid = "etfuturum")
	private static class EtFuturumPlayerForRendering extends PlayerForRendering implements ISkinDownloadCallback {

		public EtFuturumPlayerForRendering(World world, GameProfile profile) {
			super(world, profile);
		}
	}
}