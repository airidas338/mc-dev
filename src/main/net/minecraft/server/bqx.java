package net.minecraft.server;
import java.util.concurrent.Callable;

class bqx implements Callable {

   // $FF: synthetic field
   final WorldData a;


   bqx(WorldData var1) {
      this.a = var1;
   }

   public String a() {
      return String.format("Game mode: %s (ID %d). Hardcore: %b. Cheats: %b", new Object[]{WorldData.o(this.a).b(), Integer.valueOf(WorldData.o(this.a).a()), Boolean.valueOf(WorldData.p(this.a)), Boolean.valueOf(WorldData.q(this.a))});
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
