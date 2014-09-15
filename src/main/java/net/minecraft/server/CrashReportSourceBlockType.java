package net.minecraft.server;
import java.util.concurrent.Callable;

class CrashReportSourceBlockType implements Callable {

   // $FF: synthetic field
   final Block a;
   // $FF: synthetic field
   final World b;


   CrashReportSourceBlockType(World var1, Block var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      try {
         return String.format("ID #%d (%s // %s)", new Object[]{Integer.valueOf(Block.getId(this.a)), this.a.a(), this.a.getClass().getCanonicalName()});
      } catch (Throwable var2) {
         return "ID #" + Block.getId(this.a);
      }
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
