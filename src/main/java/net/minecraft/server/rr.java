package net.minecraft.server;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.Future;

class rr implements ChannelFutureListener {

   // $FF: synthetic field
   final LoginListener a;


   rr(LoginListener var1) {
      this.a = var1;
   }

   public void a(ChannelFuture var1) {
      this.a.a.a(LoginListener.a(this.a).aI());
   }

   // $FF: synthetic method
   public void operationComplete(ChannelFuture var1) {
      this.a((ChannelFuture)var1);
   }
}
