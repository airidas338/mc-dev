package net.minecraft.server;
import java.util.concurrent.Callable;

class ahc implements Callable {

   // $FF: synthetic field
   final ItemStack a;
   // $FF: synthetic field
   final ahb b;


   ahc(ahb var1, ItemStack var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      return this.a.getName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
