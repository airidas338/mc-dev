package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportConnectionPacketClass implements Callable {

   // $FF: synthetic field
   final Packet a;
   // $FF: synthetic field
   final PlayerConnection b;


   CrashReportConnectionPacketClass(PlayerConnection var1, Packet var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      return this.a.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
