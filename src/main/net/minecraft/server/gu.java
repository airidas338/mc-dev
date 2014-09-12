package net.minecraft.server;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.util.concurrent.GenericFutureListener;

class gu implements Runnable {

   // $FF: synthetic field
   final gy a;
   // $FF: synthetic field
   final gy b;
   // $FF: synthetic field
   final id c;
   // $FF: synthetic field
   final GenericFutureListener[] d;
   // $FF: synthetic field
   final NetworkManager e;


   gu(NetworkManager var1, gy var2, gy var3, id var4, GenericFutureListener[] var5) {
      this.e = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
      this.d = var5;
   }

   public void run() {
      if(this.a != this.b) {
         this.e.a(this.a);
      }

      ChannelFuture var1 = NetworkManager.a(this.e).writeAndFlush(this.c);
      if(this.d != null) {
         var1.addListeners(this.d);
      }

      var1.addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
   }
}
