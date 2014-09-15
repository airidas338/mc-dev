package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportTileEntityType implements Callable {

   // $FF: synthetic field
   final TileEntity a;


   CrashReportTileEntityType(TileEntity var1) {
      this.a = var1;
   }

   public String a() {
      int var1 = Block.a(this.a.b.getData(this.a.c).c());

      try {
         return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(var1), Block.c(var1).a(), Block.c(var1).getClass().getCanonicalName()});
      } catch (Throwable var3) {
         return "ID #" + var1;
      }
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
