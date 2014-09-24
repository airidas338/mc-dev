package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportOperatingSystem implements Callable {

   // $FF: synthetic field
   final CrashReport a;


   CrashReportOperatingSystem(CrashReport var1) {
      this.a = var1;
   }

   public String a() {
      return System.getProperty("os.name") + " (" + System.getProperty("os.arch") + ") version " + System.getProperty("os.version");
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
