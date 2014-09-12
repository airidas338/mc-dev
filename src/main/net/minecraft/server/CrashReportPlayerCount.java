package net.minecraft.server;
import java.util.concurrent.Callable;

public class CrashReportPlayerCount implements Callable {

   // $FF: synthetic field
   final MinecraftServer a;


   public CrashReportPlayerCount(MinecraftServer var1) {
      this.a = var1;
   }

   public String a() {
      return MinecraftServer.a(this.a).p() + " / " + MinecraftServer.a(this.a).q() + "; " + MinecraftServer.a(this.a).e;
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
