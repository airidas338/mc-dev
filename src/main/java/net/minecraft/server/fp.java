package net.minecraft.server;
import java.util.concurrent.Callable;

class fp implements Callable {

   // $FF: synthetic field
   final int a;
   // $FF: synthetic field
   final fn b;


   fp(fn var1, int var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      return gd.a[this.a];
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
