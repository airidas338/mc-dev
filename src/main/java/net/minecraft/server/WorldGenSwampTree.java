package net.minecraft.server;
import java.util.Random;

public class WorldGenSwampTree extends WorldGenTreeAbstract {

   public WorldGenSwampTree() {
      super(false);
   }

   public boolean generate(World var1, Random var2, Location var3) {
      int var4;
      for(var4 = var2.nextInt(4) + 5; var1.getData(var3.b()).c().getMaterial() == Material.WATER; var3 = var3.b()) {
         ;
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
               var7 = 3;
            }

            for(var8 = var3.n() - var7; var8 <= var3.n() + var7 && var5; ++var8) {
               for(var9 = var3.p() - var7; var9 <= var3.p() + var7 && var5; ++var9) {
                  if(var6 >= 0 && var6 < 256) {
                     Block var10 = var1.getData(new Location(var8, var6, var9)).c();
                     if(var10.getMaterial() != Material.AIR && var10.getMaterial() != Material.LEAVES) {
                        if(var10 != Blocks.STATIONARY_WATER && var10 != Blocks.WATER) {
                           var5 = false;
                        } else if(var6 > var3.o()) {
                           var5 = false;
                        }
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
            Block var17 = var1.getData(var3.b()).c();
            if((var17 == Blocks.GRASS || var17 == Blocks.DIRT) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());

               int var11;
               Location var14;
               int var18;
               int var20;
               for(var18 = var3.o() - 3 + var4; var18 <= var3.o() + var4; ++var18) {
                  var8 = var18 - (var3.o() + var4);
                  var9 = 2 - var8 / 2;

                  for(var20 = var3.n() - var9; var20 <= var3.n() + var9; ++var20) {
                     var11 = var20 - var3.n();

                     for(int var12 = var3.p() - var9; var12 <= var3.p() + var9; ++var12) {
                        int var13 = var12 - var3.p();
                        if(Math.abs(var11) != var9 || Math.abs(var13) != var9 || var2.nextInt(2) != 0 && var8 != 0) {
                           var14 = new Location(var20, var18, var12);
                           if(!var1.getData(var14).c().m()) {
                              this.a(var1, var14, Blocks.LEAVES);
                           }
                        }
                     }
                  }
               }

               for(var18 = 0; var18 < var4; ++var18) {
                  Block var19 = var1.getData(var3.b(var18)).c();
                  if(var19.getMaterial() == Material.AIR || var19.getMaterial() == Material.LEAVES || var19 == Blocks.WATER || var19 == Blocks.STATIONARY_WATER) {
                     this.a(var1, var3.b(var18), Blocks.LOG);
                  }
               }

               for(var18 = var3.o() - 3 + var4; var18 <= var3.o() + var4; ++var18) {
                  var8 = var18 - (var3.o() + var4);
                  var9 = 2 - var8 / 2;

                  for(var20 = var3.n() - var9; var20 <= var3.n() + var9; ++var20) {
                     for(var11 = var3.p() - var9; var11 <= var3.p() + var9; ++var11) {
                        Location var21 = new Location(var20, var18, var11);
                        if(var1.getData(var21).c().getMaterial() == Material.LEAVES) {
                           Location var22 = var21.e();
                           var14 = var21.f();
                           Location var15 = var21.c();
                           Location var16 = var21.d();
                           if(var2.nextInt(4) == 0 && var1.getData(var22).c().getMaterial() == Material.AIR) {
                              this.a(var1, var22, BlockVine.S);
                           }

                           if(var2.nextInt(4) == 0 && var1.getData(var14).c().getMaterial() == Material.AIR) {
                              this.a(var1, var14, BlockVine.T);
                           }

                           if(var2.nextInt(4) == 0 && var1.getData(var15).c().getMaterial() == Material.AIR) {
                              this.a(var1, var15, BlockVine.Q);
                           }

                           if(var2.nextInt(4) == 0 && var1.getData(var16).c().getMaterial() == Material.AIR) {
                              this.a(var1, var16, BlockVine.R);
                           }
                        }
                     }
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

   private void a(World var1, Location var2, int var3) {
      this.a(var1, var2, Blocks.VINE, var3);
      int var4 = 4;

      for(var2 = var2.b(); var1.getData(var2).c().getMaterial() == Material.AIR && var4 > 0; --var4) {
         this.a(var1, var2, Blocks.VINE, var3);
         var2 = var2.b();
      }

   }
}
