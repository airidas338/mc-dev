package net.minecraft.server;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

class ri implements GenericFutureListener {

   // $FF: synthetic field
   final NetworkManager a;
   // $FF: synthetic field
   final ChatComponentText b;
   // $FF: synthetic field
   final ServerConnection c;


   ri(ServerConnection var1, NetworkManager var2, ChatComponentText var3) {
      this.c = var1;
      this.a = var2;
      this.b = var3;
   }

   public void operationComplete(Future var1) {
      this.a.a((IChatBaseComponent)this.b);
   }
}
