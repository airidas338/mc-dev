package net.minecraft.server;
import java.util.Random;

class bkl implements bks {

   private bkl() {}

   public boolean a(blf var1) {
      if(var1.c[EnumFacing.EAST.a()] && !var1.b[EnumFacing.EAST.a()].d && var1.c[EnumFacing.UP.a()] && !var1.b[EnumFacing.UP.a()].d) {
         blf var2 = var1.b[EnumFacing.EAST.a()];
         return var2.c[EnumFacing.UP.a()] && !var2.b[EnumFacing.UP.a()].d;
      } else {
         return false;
      }
   }

   public blb a(EnumFacing var1, blf var2, Random var3) {
      var2.d = true;
      var2.b[EnumFacing.EAST.a()].d = true;
      var2.b[EnumFacing.UP.a()].d = true;
      var2.b[EnumFacing.EAST.a()].b[EnumFacing.UP.a()].d = true;
      return new bkv(var1, var2, var3);
   }

   // $FF: synthetic method
   bkl(bkj var1) {
      this();
   }
}
