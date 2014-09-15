package net.minecraft.server;
import java.util.concurrent.Callable;

class aqg implements Callable {

   // $FF: synthetic field
   final CommandBlockListenerAbstract a;


   aqg(CommandBlockListenerAbstract var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.l();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
