package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportJavaVersion implements Callable {

   // $FF: synthetic field
   final CrashReport a;


   CrashReportJavaVersion(CrashReport var1) {
      this.a = var1;
   }

   public String a() {
      return System.getProperty("java.version") + ", " + System.getProperty("java.vendor");
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
