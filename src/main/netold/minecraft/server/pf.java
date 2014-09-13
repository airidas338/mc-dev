package net.minecraft.server;
import java.util.concurrent.Callable;

public class pf implements Callable {

   // $FF: synthetic field
   final MinecraftServer a;


   public pf(MinecraftServer var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.b.a?this.a.b.c():"N/A (disabled)";
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
