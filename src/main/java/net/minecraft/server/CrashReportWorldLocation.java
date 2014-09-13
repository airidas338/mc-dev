package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportWorldLocation implements Callable {

   // $FF: synthetic field
   final Location a;
   // $FF: synthetic field
   final World b;


   CrashReportWorldLocation(World var1, Location var2) {
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
