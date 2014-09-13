package net.minecraft.server;
import java.util.Random;

public class WorldGenTrees extends WorldGenTreeAbstract {

   private final int a;
   private final boolean b;
   private final int c;
   private final int d;


   public WorldGenTrees(boolean var1) {
      this(var1, 4, 0, 0, false);
   }

   public WorldGenTrees(boolean var1, int var2, int var3, int var4, boolean var5) {
      super(var1);
      this.a = var2;
      this.c = var3;
      this.d = var4;
      this.b = var5;
   }

   public boolean generate(World var1, Random var2, Location var3) {
      int var4 = var2.nextInt(3) + this.a;
      boolean var5 = true;
      if(var3.o() >= 1 && var3.o() + var4 + 1 <= 256) {
         byte var7;
         int var9;
         for(int var6 = var3.o(); var6 <= var3.o() + 1 + var4; ++var6) {
            var7 = 1;
            if(var6 == var3.o()) {
               var7 = 0;
            }

            if(var6 >= var3.o() + 1 + var4 - 2) {
               var7 = 2;
            }

            for(int var8 = var3.n() - var7; var8 <= var3.n() + var7 && var5; ++var8) {
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
            Block var19 = var1.getData(var3.b()).c();
            if((var19 == Blocks.c || var19 == Blocks.d || var19 == Blocks.ak) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());
               var7 = 3;
               byte var20 = 0;

               int var10;
               int var11;
               int var12;
               int var13;
               Location var16;
               for(var9 = var3.o() - var7 + var4; var9 <= var3.o() + var4; ++var9) {
                  var10 = var9 - (var3.o() + var4);
                  var11 = var20 + 1 - var10 / 2;

                  for(var12 = var3.n() - var11; var12 <= var3.n() + var11; ++var12) {
                     var13 = var12 - var3.n();

                     for(int var14 = var3.p() - var11; var14 <= var3.p() + var11; ++var14) {
                        int var15 = var14 - var3.p();
                        if(Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) {
                           var16 = new Location(var12, var9, var14);
                           Block var17 = var1.getData(var16).c();
                           if(var17.r() == Material.AIR || var17.r() == Material.LEAVES || var17.r() == Material.REPLACAEBLE_PLAN) {
                              this.a(var1, var16, Blocks.t, this.d);
                           }
                        }
                     }
                  }
               }

               for(var9 = 0; var9 < var4; ++var9) {
                  Block var21 = var1.getData(var3.b(var9)).c();
                  if(var21.r() == Material.AIR || var21.r() == Material.LEAVES || var21.r() == Material.REPLACAEBLE_PLAN) {
                     this.a(var1, var3.b(var9), Blocks.r, this.c);
                     if(this.b && var9 > 0) {
                        if(var2.nextInt(3) > 0 && var1.d(var3.a(-1, var9, 0))) {
                           this.a(var1, var3.a(-1, var9, 0), Blocks.bn, BlockVine.S);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(1, var9, 0))) {
                           this.a(var1, var3.a(1, var9, 0), Blocks.bn, BlockVine.T);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, -1))) {
                           this.a(var1, var3.a(0, var9, -1), Blocks.bn, BlockVine.Q);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, 1))) {
                           this.a(var1, var3.a(0, var9, 1), Blocks.bn, BlockVine.R);
                        }
                     }
                  }
               }

               if(this.b) {
                  for(var9 = var3.o() - 3 + var4; var9 <= var3.o() + var4; ++var9) {
                     var10 = var9 - (var3.o() + var4);
                     var11 = 2 - var10 / 2;

                     for(var12 = var3.n() - var11; var12 <= var3.n() + var11; ++var12) {
                        for(var13 = var3.p() - var11; var13 <= var3.p() + var11; ++var13) {
                           Location var24 = new Location(var12, var9, var13);
                           if(var1.getData(var24).c().r() == Material.LEAVES) {
                              Location var23 = var24.e();
                              var16 = var24.f();
                              Location var25 = var24.c();
                              Location var18 = var24.d();
                              if(var2.nextInt(4) == 0 && var1.getData(var23).c().r() == Material.AIR) {
                                 this.a(var1, var23, BlockVine.S);
                              }

                              if(var2.nextInt(4) == 0 && var1.getData(var16).c().r() == Material.AIR) {
                                 this.a(var1, var16, BlockVine.T);
                              }

                              if(var2.nextInt(4) == 0 && var1.getData(var25).c().r() == Material.AIR) {
                                 this.a(var1, var25, BlockVine.Q);
                              }

                              if(var2.nextInt(4) == 0 && var1.getData(var18).c().r() == Material.AIR) {
                                 this.a(var1, var18, BlockVine.R);
                              }
                           }
                        }
                     }
                  }

                  if(var2.nextInt(5) == 0 && var4 > 5) {
                     for(var9 = 0; var9 < 2; ++var9) {
                        for(var10 = 0; var10 < 4; ++var10) {
                           if(var2.nextInt(4 - var9) == 0) {
                              var11 = var2.nextInt(3);
                              EnumFacing var22 = EnumFacing.b(var10).d();
                              this.a(var1, var3.a(var22.g(), var4 - 5 + var9, var22.i()), Blocks.bN, var11 << 2 | EnumFacing.b(var10).b());
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
      this.a(var1, var2, Blocks.bn, var3);
      int var4 = 4;

      for(var2 = var2.b(); var1.getData(var2).c().r() == Material.AIR && var4 > 0; --var4) {
         this.a(var1, var2, Blocks.bn, var3);
         var2 = var2.b();
      }

   }
}
