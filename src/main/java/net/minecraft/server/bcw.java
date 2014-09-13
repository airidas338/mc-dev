package net.minecraft.server;

public class bcw extends TileEntity implements IUpdatePlayerListBox {

   public void c() {
      if(this.b != null && !this.b.D && this.b.K() % 20L == 0L) {
         this.e = this.w();
         if(this.e instanceof BlockDaylightDetector) {
            ((BlockDaylightDetector)this.e).d(this.b, this.c);
         }
      }

   }
}
