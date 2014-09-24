package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportPlayers implements Callable {

   // $FF: synthetic field
   final World a;


   CrashReportPlayers(World var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.players.size() + " total; " + this.a.players.toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
