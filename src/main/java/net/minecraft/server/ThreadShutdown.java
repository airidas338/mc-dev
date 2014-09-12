package net.minecraft.server;

public final class ThreadShutdown extends Thread {

   // $FF: synthetic field
   final DedicatedServer a;


   public ThreadShutdown(String var1, DedicatedServer var2) {
      super(var1);
      this.a = var2;
   }

   public void run() {
      this.a.r();
   }
}
