package net.minecraft.server;
import java.util.Random;

class bkk implements bks {

   private bkk() {}

   public boolean a(blf var1) {
      return var1.c[EnumFacing.EAST.a()] && !var1.b[EnumFacing.EAST.a()].d;
   }

   public blb a(EnumFacing var1, blf var2, Random var3) {
      var2.d = true;
      var2.b[EnumFacing.EAST.a()].d = true;
      return new bku(var1, var2, var3);
   }

   // $FF: synthetic method
   bkk(bkj var1) {
      this();
   }
}
