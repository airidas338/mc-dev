package net.minecraft.server;
import java.util.Random;

class bkq implements bks {

   private bkq() {}

   public boolean a(blf var1) {
      return !var1.c[EnumFacing.WEST.a()] && !var1.c[EnumFacing.EAST.a()] && !var1.c[EnumFacing.NORTH.a()] && !var1.c[EnumFacing.SOUTH.a()] && !var1.c[EnumFacing.UP.a()];
   }

   public blb a(EnumFacing var1, blf var2, Random var3) {
      var2.d = true;
      return new bld(var1, var2, var3);
   }

   // $FF: synthetic method
   bkq(bkj var1) {
      this();
   }
}
