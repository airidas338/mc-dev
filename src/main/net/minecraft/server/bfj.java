package net.minecraft.server;
import java.util.concurrent.Callable;

class bfj implements Callable {

   // $FF: synthetic field
   final Location a;
   // $FF: synthetic field
   final bfh b;


   bfj(bfh var1, Location var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      return CrashReportSystemDetails.a(this.a);
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
