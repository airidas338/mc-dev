package net.minecraft.server;
import java.util.Random;

public class bhf extends WorldGenTreeAbstract {

   private boolean a;


   public bhf(boolean var1, boolean var2) {
      super(var1);
      this.a = var2;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      int var4 = var2.nextInt(3) + 5;
      if(this.a) {
         var4 += var2.nextInt(7);
      }

      boolean var5 = true;
      if(var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
         int var8;
         int var9;
         for(int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
            byte var7 = 1;
            if(var6 == var3.o()) {
               var7 = 0;
            }

            if(var6 >= var3.o() + 1 + var4 - 2) {
               var7 = 2;
            }

            for(var8 = var3.n() - var7; var8 <= var3.n() + var7 && var5; ++var8) {
               for(var9 = var3.p() - var7; var9 <= var3.p() + var7 && var5; ++var9) {
                  if(var6 >= 0 && var6 < 256) {
                     if(!this.a(var1.getData(new Location(var8, var6, var9)).c())) {
                        var5 = false;
                     }
                  } else {
                     var5 = false;
                  }
               }
            }
         }

         if(!var5) {
            return false;
         } else {
            Block var16 = var1.getData(var3.b()).c();
            if((var16 == Blocks.GRASS || var16 == Blocks.DIRT || var16 == Blocks.FARMLAND) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());

               int var17;
               for(var17 = var3.o() - 3 + var4; var17 <= var3.o() + var4; ++var17) {
                  var8 = var17 - (var3.o() + var4);
                  var9 = 1 - var8 / 2;

                  for(int var10 = var3.n() - var9; var10 <= var3.n() + var9; ++var10) {
                     int var11 = var10 - var3.n();

                     for(int var12 = var3.p() - var9; var12 <= var3.p() + var9; ++var12) {
                        int var13 = var12 - var3.p();
                        if(Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var8 != 0) {
                           Location var14 = new Location(var10, var17, var12);
                           Block var15 = var1.getData(var14).c();
                           if(var15.r() == Material.AIR || var15.r() == Material.LEAVES) {
                              this.a(var1, var14, Blocks.LEAVES, ayx.c.a());
                           }
                        }
                     }
                  }
               }

               for(var17 = 0; var17 < var4; ++var17) {
                  Block var18 = var1.getData(var3.b(var17)).c();
                  if(var18.r() == Material.AIR || var18.r() == Material.LEAVES) {
                     this.a(var1, var3.b(var17), Blocks.LOG, ayx.c.a());
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }
}
