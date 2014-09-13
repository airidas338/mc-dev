package net.minecraft.server;
import java.util.Random;

public class bhv extends WorldGenerator {

   private int a = -1;


   public bhv(int var1) {
      super(true);
      this.a = var1;
   }

   public bhv() {
      super(false);
   }

   public boolean generate(World var1, Random var2, Location var3) {
      int var4 = var2.nextInt(2);
      if(this.a >= 0) {
         var4 = this.a;
      }

      int var5 = var2.nextInt(3) + 4;
      boolean var6 = true;
      if(var3.o() >= 1 && var3.o() + var5 + 1 < 256) {
         int var9;
         int var10;
         for(int var7 = var3.o(); var7 <= var3.o() + 1 + var5; ++var7) {
            byte var8 = 3;
            if(var7 <= var3.o() + 3) {
               var8 = 0;
            }

            for(var9 = var3.n() - var8; var9 <= var3.n() + var8 && var6; ++var9) {
               for(var10 = var3.p() - var8; var10 <= var3.p() + var8 && var6; ++var10) {
                  if(var7 >= 0 && var7 < 256) {
                     Block var11 = var1.getData(new Location(var9, var7, var10)).c();
                     if(var11.r() != Material.AIR && var11.r() != Material.LEAVES) {
                        var6 = false;
                     }
                  } else {
                     var6 = false;
                  }
               }
            }
         }

         if(!var6) {
            return false;
         } else {
            Block var15 = var1.getData(var3.b()).c();
            if(var15 != Blocks.d && var15 != Blocks.c && var15 != Blocks.bw) {
               return false;
            } else {
               int var16 = var3.o() + var5;
               if(var4 == 1) {
                  var16 = var3.o() + var5 - 3;
               }

               for(var9 = var16; var9 <= var3.o() + var5; ++var9) {
                  var10 = 1;
                  if(var9 < var3.o() + var5) {
                     ++var10;
                  }

                  if(var4 == 0) {
                     var10 = 3;
                  }

                  for(int var17 = var3.n() - var10; var17 <= var3.n() + var10; ++var17) {
                     for(int var12 = var3.p() - var10; var12 <= var3.p() + var10; ++var12) {
                        int var13 = 5;
                        if(var17 == var3.n() - var10) {
                           --var13;
                        }

                        if(var17 == var3.n() + var10) {
                           ++var13;
                        }

                        if(var12 == var3.p() - var10) {
                           var13 -= 3;
                        }

                        if(var12 == var3.p() + var10) {
                           var13 += 3;
                        }

                        if(var4 == 0 || var9 < var3.o() + var5) {
                           if((var17 == var3.n() - var10 || var17 == var3.n() + var10) && (var12 == var3.p() - var10 || var12 == var3.p() + var10)) {
                              continue;
                           }

                           if(var17 == var3.n() - (var10 - 1) && var12 == var3.p() - var10) {
                              var13 = 1;
                           }

                           if(var17 == var3.n() - var10 && var12 == var3.p() - (var10 - 1)) {
                              var13 = 1;
                           }

                           if(var17 == var3.n() + (var10 - 1) && var12 == var3.p() - var10) {
                              var13 = 3;
                           }

                           if(var17 == var3.n() + var10 && var12 == var3.p() - (var10 - 1)) {
                              var13 = 3;
                           }

                           if(var17 == var3.n() - (var10 - 1) && var12 == var3.p() + var10) {
                              var13 = 7;
                           }

                           if(var17 == var3.n() - var10 && var12 == var3.p() + (var10 - 1)) {
                              var13 = 7;
                           }

                           if(var17 == var3.n() + (var10 - 1) && var12 == var3.p() + var10) {
                              var13 = 9;
                           }

                           if(var17 == var3.n() + var10 && var12 == var3.p() + (var10 - 1)) {
                              var13 = 9;
                           }
                        }

                        if(var13 == 5 && var9 < var3.o() + var5) {
                           var13 = 0;
                        }

                        if(var13 != 0 || var3.o() >= var3.o() + var5 - 1) {
                           Location var14 = new Location(var17, var9, var12);
                           if(!var1.getData(var14).c().m()) {
                              this.a(var1, var14, Block.c(Block.a(Blocks.bg) + var4), var13);
                           }
                        }
                     }
                  }
               }

               for(var9 = 0; var9 < var5; ++var9) {
                  Block var18 = var1.getData(var3.b(var9)).c();
                  if(!var18.m()) {
                     this.a(var1, var3.b(var9), Block.c(Block.a(Blocks.bg) + var4), 10);
                  }
               }

               return true;
            }
         }
      } else {
         return false;
      }
   }
}
