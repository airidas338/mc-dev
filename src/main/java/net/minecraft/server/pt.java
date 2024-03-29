package net.minecraft.server;
import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class pt implements Runnable {

   private static final Logger a = LogManager.getLogger();
   private final DedicatedServer b;
   private final long c;


   public pt(DedicatedServer var1) {
      this.b = var1;
      this.c = var1.aQ();
   }

   public void run() {
      while(this.b.t()) {
         long var1 = this.b.aJ();
         long var3 = MinecraftServer.ax();
         long var5 = var3 - var1;
         if(var5 > this.c) {
            a.fatal("A single server tick took " + String.format("%.2f", new Object[]{Float.valueOf((float)var5 / 1000.0F)}) + " seconds (should be max " + String.format("%.2f", new Object[]{Float.valueOf(0.05F)}) + ")");
            a.fatal("Considering it to be crashed, server will forcibly shutdown.");
            ThreadMXBean var7 = ManagementFactory.getThreadMXBean();
            ThreadInfo[] var8 = var7.dumpAllThreads(true, true);
            StringBuilder var9 = new StringBuilder();
            Error var10 = new Error();
            ThreadInfo[] var11 = var8;
            int var12 = var8.length;

            for(int var13 = 0; var13 < var12; ++var13) {
               ThreadInfo var14 = var11[var13];
               if(var14.getThreadId() == this.b.aK().getId()) {
                  var10.setStackTrace(var14.getStackTrace());
               }

               var9.append(var14);
               var9.append("\n");
            }

            CrashReport var16 = new CrashReport("Watching Server", var10);
            this.b.b(var16);
            CrashReportSystemDetails var17 = var16.a("Thread Dump");
            var17.a("Threads", (Object)var9);
            File var18 = new File(new File(this.b.w(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
            if(var16.a(var18)) {
               a.error("This crash report has been saved to: " + var18.getAbsolutePath());
            } else {
               a.error("We were unable to save this crash report to disk.");
            }

            this.a();
         }

         try {
            Thread.sleep(var1 + this.c - var3);
         } catch (InterruptedException var15) {
            ;
         }
      }

   }

   private void a() {
      try {
         Timer var1 = new Timer();
         var1.schedule(new pu(this), 10000L);
         System.exit(1);
      } catch (Throwable var2) {
         Runtime.getRuntime().halt(1);
      }

   }

}
