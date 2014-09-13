package net.minecraft.server;
import java.util.Random;

class bko implements bks {

   private bko() {}

   public boolean a(blf var1) {
      return var1.c[EnumFacing.NORTH.a()] && !var1.b[EnumFacing.NORTH.a()].d;
   }

   public blb a(EnumFacing var1, blf var2, Random var3) {
      blf var4 = var2;
      if(!var2.c[EnumFacing.NORTH.a()] || var2.b[EnumFacing.NORTH.a()].d) {
         var4 = var2.b[EnumFacing.SOUTH.a()];
      }

      var4.d = true;
      var4.b[EnumFacing.NORTH.a()].d = true;
      return new bky(var1, var4, var3);
   }

   // $FF: synthetic method
   bko(bkj var1) {
      this();
   }
}
