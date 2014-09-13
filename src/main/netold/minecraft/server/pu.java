package net.minecraft.server;
import java.util.TimerTask;

class pu extends TimerTask {

   // $FF: synthetic field
   final pt a;


   pu(pt var1) {
      this.a = var1;
   }

   public void run() {
      Runtime.getRuntime().halt(1);
   }
}
