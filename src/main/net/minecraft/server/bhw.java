package net.minecraft.server;
import java.util.Random;

public class bhw extends bhp {

   private Block a;
   private int b;


   public bhw(int var1) {
      this.a = aty.cB;
      this.b = var1;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      while(var1.d(var3) && var3.o() > 2) {
         var3 = var3.b();
      }

      if(var1.p(var3).c() != aty.aJ) {
         return false;
      } else {
         int var4 = var2.nextInt(this.b - 2) + 2;
         byte var5 = 1;

         for(int var6 = var3.n() - var4; var6 <= var3.n() + var4; ++var6) {
            for(int var7 = var3.p() - var4; var7 <= var3.p() + var4; ++var7) {
               int var8 = var6 - var3.n();
               int var9 = var7 - var3.p();
               if(var8 * var8 + var9 * var9 <= var4 * var4) {
                  for(int var10 = var3.o() - var5; var10 <= var3.o() + var5; ++var10) {
                     Location var11 = new Location(var6, var10, var7);
                     Block var12 = var1.p(var11).c();
                     if(var12 == aty.d || var12 == aty.aJ || var12 == aty.aI) {
                        var1.a(var11, this.a.P(), 2);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
