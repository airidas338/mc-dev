package net.minecraft.server;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;

class ServerConnectionChannel extends ChannelInitializer {

   // $FF: synthetic field
   final ServerConnection a;


   ServerConnectionChannel(ServerConnection var1) {
      this.a = var1;
   }

   protected void initChannel(Channel var1) {
      try {
         var1.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
      } catch (ChannelException var4) {
         ;
      }

      try {
         var1.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
      } catch (ChannelException var3) {
         ;
      }
      var1.pipeline().addLast("timeout", new ReadTimeoutHandler(30)).addLast("legacy_query", new LegacyPingHandler(this.a)).addLast("splitter", new PacketSplitter()).addLast("decoder", new PacketDecoder(EnumPacketDirection.SERVERBOUND)).addLast("prepender", new PacketPrepender()).addLast("encoder", new PacketEncoder(EnumPacketDirection.CLIENTBOUND));
      NetworkManager var2 = new NetworkManager(EnumPacketDirection.SERVERBOUND);
      ServerConnection.a(this.a).add(var2);
      var1.pipeline().addLast("packet_handler", var2);
      var2.a(new HandshakeListener(ServerConnection.b(this.a), var2));
   }
}
