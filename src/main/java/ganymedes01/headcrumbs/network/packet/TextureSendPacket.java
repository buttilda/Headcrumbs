package ganymedes01.headcrumbs.network.packet;

import java.util.Map;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.minecraft.MinecraftProfileTexture;
import com.mojang.authlib.minecraft.MinecraftProfileTexture.Type;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.headcrumbs.Headcrumbs;
import ganymedes01.headcrumbs.network.PacketHandler.PacketType;
import ganymedes01.headcrumbs.utils.TextureUtils;
import ganymedes01.headcrumbs.utils.helpers.EtFuturumHelper;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.resources.SkinManager.SkinAvailableCallback;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TextureSendPacket extends CustomPacket {

	private GameProfile profile;

	public TextureSendPacket() {
		super(PacketType.TEXTURE_SEND);
	}

	public TextureSendPacket(GameProfile profile) {
		this();
		this.profile = profile;
	}

	@Override
	public void writeData(ByteBuf buffer) {
		NBTTagCompound nbt = new NBTTagCompound();
		NBTUtil.func_152460_a(nbt, profile);
		ByteBufUtils.writeTag(buffer, nbt);
	}

	@Override
	public void readData(ByteBuf buffer) {
		NBTTagCompound nbt = ByteBufUtils.readTag(buffer);
		profile = NBTUtil.func_152459_a(nbt);
	}

	@Override
	@SuppressWarnings("unchecked")
	public void handleClientSide(World world, EntityPlayer player) {
		SkinManager skinManager = Minecraft.getMinecraft().func_152342_ad();
		Map<?, MinecraftProfileTexture> map = skinManager.func_152788_a(profile);

		for (Type type : Type.values())
			if (map.containsKey(type))
				skinManager.func_152789_a(map.get(type), type, getCallback(type));
	}

	@Override
	public void handleServerSide(World world, EntityPlayer player) {
	}

	@SideOnly(Side.CLIENT)
	private SkinAvailableCallback getCallback(Type type) {
		if (Headcrumbs.use18PlayerModel)
			return EtFuturumHelper.getSkinDownloadCallback(profile.getName());
		else
			return new SkinAvailableCallback() {
				@Override
				public void func_152121_a(Type texType, ResourceLocation texture) {
					TextureUtils.textures.get(texType).put(profile.getName(), texture);
				}
			};
	}
}