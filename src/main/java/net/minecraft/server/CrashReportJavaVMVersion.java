package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportJavaVMVersion implements Callable {

   // $FF: synthetic field
   final CrashReport a;


   CrashReportJavaVMVersion(CrashReport var1) {
      this.a = var1;
   }

   public String a() {
      return System.getProperty("java.vm.name") + " (" + System.getProperty("java.vm.info") + "), " + System.getProperty("java.vm.vendor");
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
