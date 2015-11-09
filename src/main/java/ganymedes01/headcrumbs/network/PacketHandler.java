package ganymedes01.headcrumbs.network;

import java.util.EnumMap;

import com.google.common.collect.Maps;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.FMLOutboundHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import ganymedes01.headcrumbs.libs.Reference;
import ganymedes01.headcrumbs.network.packet.CustomPacket;
import ganymedes01.headcrumbs.network.packet.TextureRequestPacket;
import ganymedes01.headcrumbs.network.packet.TextureSendPacket;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.network.Packet;

@Sharable
public final class PacketHandler {

	private static Codec CODEC;
	private static final EnumMap<Side, FMLEmbeddedChannel> CHANNELS = Maps.newEnumMap(Side.class);

	public enum PacketType {
		TEXTURE_REQUEST(TextureRequestPacket.class),
		TEXTURE_SEND(TextureSendPacket.class);

		final Class<? extends CustomPacket> cls;

		PacketType(Class<? extends CustomPacket> cls) {
			this.cls = cls;
		}
	}

	public static void init() {
		if (!CHANNELS.isEmpty())
			return;

		CODEC = new Codec();

		for (PacketType packet : PacketType.values())
			CODEC.addDiscriminator(packet.ordinal(), packet.cls);

		CHANNELS.putAll(NetworkRegistry.INSTANCE.newChannel(Reference.MOD_ID, CODEC, new HandlerServer()));

		if (FMLCommonHandler.instance().getSide().isClient()) {
			FMLEmbeddedChannel channel = CHANNELS.get(Side.CLIENT);
			String codecName = channel.findChannelHandlerNameForType(Codec.class);
			channel.pipeline().addAfter(codecName, "ClientHandler", new HandlerClient());
		}
	}

	public static void register(int id, Class<? extends CustomPacket> packetType) {
		CODEC.addDiscriminator(id, packetType);
	}

	public static FMLEmbeddedChannel getClientChannel() {
		return CHANNELS.get(Side.CLIENT);
	}

	public static FMLEmbeddedChannel getServerChannel() {
		return CHANNELS.get(Side.SERVER);
	}

	public static void sendToServer(CustomPacket packet) {
		getClientChannel().attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
		getClientChannel().writeAndFlush(packet);
	}

	public static void sendToPlayer(CustomPacket packet, EntityPlayer player) {
		getServerChannel().attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
		getServerChannel().attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
		getServerChannel().writeAndFlush(packet);
	}

	public static void sendToAllAround(CustomPacket packet, NetworkRegistry.TargetPoint point) {
		getServerChannel().attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
		getServerChannel().attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
		getServerChannel().writeAndFlush(packet);
	}

	public static void sendToDimension(CustomPacket packet, int dimension) {
		getServerChannel().attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
		getServerChannel().attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(dimension);
		getServerChannel().writeAndFlush(packet);
	}

	public static void sendToAll(CustomPacket packet) {
		getServerChannel().attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
		getServerChannel().writeAndFlush(packet);
	}

	public static Packet toMcPacket(CustomPacket packet) {
		return CHANNELS.get(FMLCommonHandler.instance().getEffectiveSide()).generatePacketFrom(packet);
	}

	private static final class Codec extends FMLIndexedMessageToMessageCodec<CustomPacket> {

		@Override
		public void encodeInto(ChannelHandlerContext ctx, CustomPacket packet, ByteBuf target) throws Exception {
			packet.writeData(target);
		}

		@Override
		public void decodeInto(ChannelHandlerContext ctx, ByteBuf source, CustomPacket packet) {
			packet.readData(source);
		}
	}

	@Sharable
	@SideOnly(Side.CLIENT)
	private static final class HandlerClient extends SimpleChannelInboundHandler<CustomPacket> {

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, CustomPacket packet) throws Exception {
			Minecraft mc = Minecraft.getMinecraft();
			packet.handleClientSide(mc.theWorld, mc.thePlayer);
		}
	}

	@Sharable
	private static final class HandlerServer extends SimpleChannelInboundHandler<CustomPacket> {

		@Override
		protected void channelRead0(ChannelHandlerContext ctx, CustomPacket packet) throws Exception {
			if (FMLCommonHandler.instance().getEffectiveSide().isClient())
				return;

			EntityPlayerMP player = ((NetHandlerPlayServer) ctx.channel().attr(NetworkRegistry.NET_HANDLER).get()).playerEntity;
			packet.handleServerSide(player.worldObj, player);
		}
	}
}