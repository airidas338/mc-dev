package net.minecraft.server;
import java.util.Random;

class bkm implements bks {

   private bkm() {}

   public boolean a(blf var1) {
      return var1.c[EnumFacing.UP.a()] && !var1.b[EnumFacing.UP.a()].d;
   }

   public blb a(EnumFacing var1, blf var2, Random var3) {
      var2.d = true;
      var2.b[EnumFacing.UP.a()].d = true;
      return new bkw(var1, var2, var3);
   }

   // $FF: synthetic method
   bkm(bkj var1) {
      this();
   }
}
