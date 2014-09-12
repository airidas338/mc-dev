package net.minecraft.server;
import java.util.concurrent.Callable;

class ps implements Callable {

   // $FF: synthetic field
   final DedicatedServer a;


   ps(DedicatedServer var1) {
      this.a = var1;
   }

   public String a() {
      return "Dedicated Server (map_server.txt)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
