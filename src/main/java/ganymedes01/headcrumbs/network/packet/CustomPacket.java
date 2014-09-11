package ganymedes01.headcrumbs.network.packet;

import ganymedes01.headcrumbs.network.PacketHandler.PacketType;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public abstract class CustomPacket {

	final PacketType type;

	CustomPacket(PacketType type) {
		this.type = type;
	}

	public final int getType() {
		return type.ordinal();
	}

	public abstract void writeData(ByteBuf buffer);

	public abstract void readData(ByteBuf buffer);

	public abstract void handleClientSide(World world, EntityPlayer player);

	public abstract void handleServerSide(World world, EntityPlayer player);
}