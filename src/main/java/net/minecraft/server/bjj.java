package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bjj extends bms {

   public bjj() {}

   public bjj(int var1, Random var2, bjb var3, EnumFacing var4) {
      super(var1);
      this.m = var4;
      this.l = var3;
   }

   protected void a(NBTTagCompound var1) {}

   protected void b(NBTTagCompound var1) {}

   public static bjb a(List var0, Random var1, int var2, int var3, int var4, EnumFacing var5) {
      bjb var6 = new bjb(var2, var3 - 5, var4, var2, var3 + 2, var4);
      switch(bjf.a[var5.ordinal()]) {
      case 1:
         var6.d = var2 + 2;
         var6.c = var4 - 8;
         break;
      case 2:
         var6.d = var2 + 2;
         var6.f = var4 + 8;
         break;
      case 3:
         var6.a = var2 - 8;
         var6.f = var4 + 2;
         break;
      case 4:
         var6.d = var2 + 8;
         var6.f = var4 + 2;
      }

      return bms.a(var0, var6) != null?null:var6;
   }

   public void a(bms var1, List var2, Random var3) {
      int var4 = this.d();
      if(this.m != null) {
         switch(bjf.a[this.m.ordinal()]) {
         case 1:
            bje.a(var1, var2, var3, this.l.a, this.l.b, this.l.c - 1, EnumFacing.NORTH, var4);
            break;
         case 2:
            bje.a(var1, var2, var3, this.l.a, this.l.b, this.l.f + 1, EnumFacing.SOUTH, var4);
            break;
         case 3:
            bje.a(var1, var2, var3, this.l.a - 1, this.l.b, this.l.c, EnumFacing.WEST, var4);
            break;
         case 4:
            bje.a(var1, var2, var3, this.l.d + 1, this.l.b, this.l.c, EnumFacing.EAST, var4);
         }
      }

   }

   public boolean a(World var1, Random var2, bjb var3) {
      if(this.a(var1, var3)) {
         return false;
      } else {
         this.a(var1, var3, 0, 5, 0, 2, 7, 1, Blocks.AIR.P(), Blocks.AIR.P(), false);
         this.a(var1, var3, 0, 0, 7, 2, 2, 8, Blocks.AIR.P(), Blocks.AIR.P(), false);

         for(int var4 = 0; var4 < 5; ++var4) {
            this.a(var1, var3, 0, 5 - var4 - (var4 < 4?1:0), 2 + var4, 2, 7 - var4, 2 + var4, Blocks.AIR.P(), Blocks.AIR.P(), false);
         }

         return true;
      }
   }
}
