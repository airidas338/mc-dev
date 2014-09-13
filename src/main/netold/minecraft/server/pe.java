package net.minecraft.server;

public final class pe extends Thread {

   // $FF: synthetic field
   final po a;


   public pe(String var1, po var2) {
      super(var1);
      this.a = var2;
   }

   public void run() {
      this.a.r();
   }
}
