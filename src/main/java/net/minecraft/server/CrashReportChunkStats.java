package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportChunkStats implements Callable {

   // $FF: synthetic field
   final World a;


   CrashReportChunkStats(World var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.chunkProvider.getName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
