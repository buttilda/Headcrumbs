package ganymedes01.headcrumbs.network.packet;

import com.mojang.authlib.GameProfile;

import cpw.mods.fml.common.network.ByteBufUtils;
import ganymedes01.headcrumbs.network.PacketHandler.PacketType;
import ganymedes01.headcrumbs.utils.TextureUtils;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTUtil;
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
	public void handleClientSide(World world, EntityPlayer player) {
		TextureUtils.profiles.put(profile.getName(), profile);
	}

	@Override
	public void handleServerSide(World world, EntityPlayer player) {
	}
}