package net.minecraft.server;
import java.util.Random;

public class bij extends WorldGenTreeAbstract {

   public bij(boolean var1) {
      super(var1);
   }

   public boolean generate(World var1, Random var2, Location var3) {
      int var4 = var2.nextInt(3) + var2.nextInt(2) + 6;
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
            Block var18 = var1.getData(var3.b()).c();
            if((var18 == Blocks.c || var18 == Blocks.d) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());
               this.a(var1, var3.a(1, -1, 0));
               this.a(var1, var3.a(1, -1, 1));
               this.a(var1, var3.a(0, -1, 1));
               ej var19 = en.a.a(var2);
               var8 = var4 - var2.nextInt(4);
               var9 = 2 - var2.nextInt(3);
               int var10 = var3.n();
               int var11 = var3.p();
               int var12 = 0;

               int var13;
               int var14;
               for(var13 = 0; var13 < var4; ++var13) {
                  var14 = var3.o() + var13;
                  if(var13 >= var8 && var9 > 0) {
                     var10 += var19.g();
                     var11 += var19.i();
                     --var9;
                  }

                  Location var15 = new Location(var10, var14, var11);
                  Material var16 = var1.getData(var15).c().r();
                  if(var16 == Material.AIR || var16 == Material.LEAVES) {
                     this.a(var1, var15, Blocks.s, ayx.f.a() - 4);
                     this.a(var1, var15.f(), Blocks.s, ayx.f.a() - 4);
                     this.a(var1, var15.d(), Blocks.s, ayx.f.a() - 4);
                     this.a(var1, var15.f().d(), Blocks.s, ayx.f.a() - 4);
                     var12 = var14;
                  }
               }

               for(var13 = -2; var13 <= 0; ++var13) {
                  for(var14 = -2; var14 <= 0; ++var14) {
                     byte var20 = -1;
                     this.a(var1, var10 + var13, var12 + var20, var11 + var14);
                     this.a(var1, 1 + var10 - var13, var12 + var20, var11 + var14);
                     this.a(var1, var10 + var13, var12 + var20, 1 + var11 - var14);
                     this.a(var1, 1 + var10 - var13, var12 + var20, 1 + var11 - var14);
                     if((var13 > -2 || var14 > -1) && (var13 != -1 || var14 != -2)) {
                        byte var23 = 1;
                        this.a(var1, var10 + var13, var12 + var23, var11 + var14);
                        this.a(var1, 1 + var10 - var13, var12 + var23, var11 + var14);
                        this.a(var1, var10 + var13, var12 + var23, 1 + var11 - var14);
                        this.a(var1, 1 + var10 - var13, var12 + var23, 1 + var11 - var14);
                     }
                  }
               }

               if(var2.nextBoolean()) {
                  this.a(var1, var10, var12 + 2, var11);
                  this.a(var1, var10 + 1, var12 + 2, var11);
                  this.a(var1, var10 + 1, var12 + 2, var11 + 1);
                  this.a(var1, var10, var12 + 2, var11 + 1);
               }

               for(var13 = -3; var13 <= 4; ++var13) {
                  for(var14 = -3; var14 <= 4; ++var14) {
                     if((var13 != -3 || var14 != -3) && (var13 != -3 || var14 != 4) && (var13 != 4 || var14 != -3) && (var13 != 4 || var14 != 4) && (Math.abs(var13) < 3 || Math.abs(var14) < 3)) {
                        this.a(var1, var10 + var13, var12, var11 + var14);
                     }
                  }
               }

               for(var13 = -1; var13 <= 2; ++var13) {
                  for(var14 = -1; var14 <= 2; ++var14) {
                     if((var13 < 0 || var13 > 1 || var14 < 0 || var14 > 1) && var2.nextInt(3) <= 0) {
                        int var22 = var2.nextInt(3) + 2;

                        int var21;
                        for(var21 = 0; var21 < var22; ++var21) {
                           this.a(var1, new Location(var3.n() + var13, var12 - var21 - 1, var3.p() + var14), Blocks.s, ayx.f.a() - 4);
                        }

                        int var17;
                        for(var21 = -1; var21 <= 1; ++var21) {
                           for(var17 = -1; var17 <= 1; ++var17) {
                              this.a(var1, var10 + var13 + var21, var12 - 0, var11 + var14 + var17);
                           }
                        }

                        for(var21 = -2; var21 <= 2; ++var21) {
                           for(var17 = -2; var17 <= 2; ++var17) {
                              if(Math.abs(var21) != 2 || Math.abs(var17) != 2) {
                                 this.a(var1, var10 + var13 + var21, var12 - 1, var11 + var14 + var17);
                              }
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

   private void a(World var1, int var2, int var3, int var4) {
      Block var5 = var1.getData(new Location(var2, var3, var4)).c();
      if(var5.r() == Material.AIR) {
         this.a(var1, new Location(var2, var3, var4), Blocks.u, 1);
      }

   }
}
