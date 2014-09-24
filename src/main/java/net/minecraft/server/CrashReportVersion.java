package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportVersion implements Callable {

   // $FF: synthetic field
   final CrashReport a;


   CrashReportVersion(CrashReport var1) {
      this.a = var1;
   }

   public String a() {
      return "1.8";
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
