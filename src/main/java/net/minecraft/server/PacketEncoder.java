package net.minecraft.server;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class PacketEncoder extends MessageToByteEncoder {

   private static final Logger a = LogManager.getLogger();
   private static final Marker b = MarkerManager.getMarker("PACKET_SENT", NetworkManager.b);
   private final EnumPacketDirection c;


   public PacketEncoder(EnumPacketDirection var1) {
      this.c = var1;
   }

   protected void a(ChannelHandlerContext var1, Packet var2, ByteBuf var3) throws IOException {
      Integer var4 = ((gy)var1.channel().attr(NetworkManager.c).get()).a(this.c, var2);
      if(a.isDebugEnabled()) {
         a.debug(b, "OUT: [{}:{}] {}", new Object[]{var1.channel().attr(NetworkManager.c).get(), var4, var2.getClass().getName()});
      }

      if(var4 == null) {
         throw new IOException("Can\'t serialize unregistered packet");
      } else {
         hd var5 = new hd(var3);
         var5.b(var4.intValue());

         try {
            if(var2 instanceof PacketPlayOutNamedEntitySpawn) {
               var2 = var2;
            }

            var2.b(var5);
         } catch (Throwable var7) {
            a.error(var7);
         }

      }
   }

   // $FF: synthetic method
   protected void encode(ChannelHandlerContext var1, Object var2, ByteBuf var3) throws IOException {
      this.a(var1, (Packet)var2, var3);
   }

}
