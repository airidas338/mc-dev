package net.minecraft.server;
import java.util.concurrent.Callable;

final class q implements Callable {

   // $FF: synthetic field
   final Location a;


   q(Location var1) {
      this.a = var1;
   }

   public String a() {
      return CrashReportSystemDetails.a(this.a);
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
