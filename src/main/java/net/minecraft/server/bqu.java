package net.minecraft.server;
import java.util.concurrent.Callable;

class bqu implements Callable {

   // $FF: synthetic field
   final WorldData a;


   bqu(WorldData var1) {
      this.a = var1;
   }

   public String a() {
      return String.valueOf(WorldData.i(this.a));
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
