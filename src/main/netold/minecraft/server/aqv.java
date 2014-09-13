package net.minecraft.server;
import java.util.concurrent.Callable;

class aqv implements Callable {

   // $FF: synthetic field
   final dt a;
   // $FF: synthetic field
   final aqu b;


   aqv(aqu var1, dt var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      return j.a(this.a);
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
