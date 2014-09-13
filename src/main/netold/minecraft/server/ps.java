package net.minecraft.server;
import java.util.concurrent.Callable;

class ps implements Callable {

   // $FF: synthetic field
   final po a;


   ps(po var1) {
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
