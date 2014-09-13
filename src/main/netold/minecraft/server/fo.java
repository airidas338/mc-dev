package net.minecraft.server;
import java.util.concurrent.Callable;

class fo implements Callable {

   // $FF: synthetic field
   final String a;
   // $FF: synthetic field
   final fn b;


   fo(fn var1, String var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      return gd.a[((gd)fn.b(this.b).get(this.a)).a()];
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
