package net.minecraft.server;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;

class rf extends ChannelInitializer {

   // $FF: synthetic field
   final rc a;


   rf(rc var1) {
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

      var1.pipeline().addLast("timeout", new ReadTimeoutHandler(30)).addLast("legacy_query", new ra(this.a)).addLast("splitter", new hh()).addLast("decoder", new he(ie.a)).addLast("prepender", new hi()).addLast("encoder", new hf(ie.b));
      gr var2 = new gr(ie.a);
      rc.a(this.a).add(var2);
      var1.pipeline().addLast("packet_handler", var2);
      var2.a((hg)(new ro(rc.b(this.a), var2)));
   }
}
