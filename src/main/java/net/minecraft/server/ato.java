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
      TileEntity var1 = this.b.a.getTileEntity(this.a);
      if(var1 instanceof TileEntityBeacon) {
         ((TileEntityBeacon)var1).m();
         this.b.a.playBlockAction(this.a, Blocks.BEACON, 1, 0);
      }

   }
}
