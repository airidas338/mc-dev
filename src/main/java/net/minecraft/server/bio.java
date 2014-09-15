package net.minecraft.server;
import java.util.Random;

public class bio extends WorldGenTreeAbstract {

   public bio(boolean var1) {
      super(var1);
   }

   public boolean generate(World var1, Random var2, Location var3) {
      int var4 = var2.nextInt(4) + 6;
      int var5 = 1 + var2.nextInt(2);
      int var6 = var4 - var5;
      int var7 = 2 + var2.nextInt(2);
      boolean var8 = true;
      if(var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
         int var11;
         int var21;
         for(int var9 = var3.o(); var9 <= var3.o() + 1 + var4 && var8; ++var9) {
            boolean var10 = true;
            if(var9 - var3.o() < var5) {
               var21 = 0;
            } else {
               var21 = var7;
            }

            for(var11 = var3.n() - var21; var11 <= var3.n() + var21 && var8; ++var11) {
               for(int var12 = var3.p() - var21; var12 <= var3.p() + var21 && var8; ++var12) {
                  if(var9 >= 0 && var9 < 256) {
                     Block var13 = var1.getData(new Location(var11, var9, var12)).c();
                     if(var13.getMaterial() != Material.AIR && var13.getMaterial() != Material.LEAVES) {
                        var8 = false;
                     }
                  } else {
                     var8 = false;
                  }
               }
            }
         }

         if(!var8) {
            return false;
         } else {
            Block var20 = var1.getData(var3.b()).c();
            if((var20 == Blocks.GRASS || var20 == Blocks.DIRT || var20 == Blocks.FARMLAND) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());
               var21 = var2.nextInt(2);
               var11 = 1;
               byte var22 = 0;

               int var14;
               int var23;
               for(var23 = 0; var23 <= var6; ++var23) {
                  var14 = var3.o() + var4 - var23;

                  for(int var15 = var3.n() - var21; var15 <= var3.n() + var21; ++var15) {
                     int var16 = var15 - var3.n();

                     for(int var17 = var3.p() - var21; var17 <= var3.p() + var21; ++var17) {
                        int var18 = var17 - var3.p();
                        if(Math.abs(var16) != var21 || Math.abs(var18) != var21 || var21 <= 0) {
                           Location var19 = new Location(var15, var14, var17);
                           if(!var1.getData(var19).c().m()) {
                              this.a(var1, var19, Blocks.LEAVES, ayx.b.a());
                           }
                        }
                     }
                  }

                  if(var21 >= var11) {
                     var21 = var22;
                     var22 = 1;
                     ++var11;
                     if(var11 > var7) {
                        var11 = var7;
                     }
                  } else {
                     ++var21;
                  }
               }

               var23 = var2.nextInt(3);

               for(var14 = 0; var14 < var4 - var23; ++var14) {
                  Block var24 = var1.getData(var3.b(var14)).c();
                  if(var24.getMaterial() == Material.AIR || var24.getMaterial() == Material.LEAVES) {
                     this.a(var1, var3.b(var14), Blocks.LOG, ayx.b.a());
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
