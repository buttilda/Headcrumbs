package ganymedes01.headcrumbs.network.packet;

import com.google.common.collect.Iterables;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import cpw.mods.fml.common.network.ByteBufUtils;
import ganymedes01.headcrumbs.network.PacketHandler;
import ganymedes01.headcrumbs.network.PacketHandler.PacketType;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;

public class TextureRequestPacket extends CustomPacket {

	private String name;

	public TextureRequestPacket() {
		super(PacketType.TEXTURE_REQUEST);
	}

	public TextureRequestPacket(String name) {
		this();
		this.name = name;
	}

	@Override
	public void writeData(ByteBuf buffer) {
		ByteBufUtils.writeUTF8String(buffer, name);
	}

	@Override
	public void readData(ByteBuf buffer) {
		name = ByteBufUtils.readUTF8String(buffer);
	}

	@Override
	public void handleClientSide(World world, EntityPlayer player) {
	}

	@Override
	public void handleServerSide(World world, final EntityPlayer player) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				GameProfile profile = MinecraftServer.getServer().func_152358_ax().func_152655_a(name);

				if (profile != null) {
					Property property = Iterables.getFirst(profile.getProperties().get("textures"), null);

					if (property == null)
						profile = MinecraftServer.getServer().func_147130_as().fillProfileProperties(profile, true);

					PacketHandler.sendToPlayer(new TextureSendPacket(profile), player);
				}
			}

		}, name).start();
	}
}