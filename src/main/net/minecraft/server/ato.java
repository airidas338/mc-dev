package net.minecraft.server;

class ato implements Runnable {

   // $FF: synthetic field
   final Location a;
   // $FF: synthetic field
   final atn b;


   ato(atn var1, Location var2) {
      this.b = var1;
      this.a = var2;
   }

   public void run() {
      bcm var1 = this.b.a.s(this.a);
      if(var1 instanceof bck) {
         ((bck)var1).m();
         this.b.a.c(this.a, aty.bY, 1, 0);
      }

   }
}
