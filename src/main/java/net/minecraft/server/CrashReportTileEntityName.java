package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportTileEntityName implements Callable {

   // $FF: synthetic field
   final TileEntity a;


   CrashReportTileEntityName(TileEntity var1) {
      this.a = var1;
   }

   public String a() {
      return (String)TileEntity.F().get(this.a.getClass()) + " // " + this.a.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
