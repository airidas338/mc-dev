package net.minecraft.server;
import java.util.Random;

class bkn implements bks {

   private bkn() {}

   public boolean a(blf var1) {
      if(var1.c[EnumFacing.NORTH.a()] && !var1.b[EnumFacing.NORTH.a()].d && var1.c[EnumFacing.UP.a()] && !var1.b[EnumFacing.UP.a()].d) {
         blf var2 = var1.b[EnumFacing.NORTH.a()];
         return var2.c[EnumFacing.UP.a()] && !var2.b[EnumFacing.UP.a()].d;
      } else {
         return false;
      }
   }

   public blb a(EnumFacing var1, blf var2, Random var3) {
      var2.d = true;
      var2.b[EnumFacing.NORTH.a()].d = true;
      var2.b[EnumFacing.UP.a()].d = true;
      var2.b[EnumFacing.NORTH.a()].b[EnumFacing.UP.a()].d = true;
      return new bkx(var1, var2, var3);
   }

   // $FF: synthetic method
   bkn(bkj var1) {
      this();
   }
}
