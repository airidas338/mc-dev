package net.minecraft.server;
import java.util.Random;

public class bir extends bhc {

   private final int a;
   private final boolean b;
   private final int c;
   private final int d;


   public bir(boolean var1) {
      this(var1, 4, 0, 0, false);
   }

   public bir(boolean var1, int var2, int var3, int var4, boolean var5) {
      super(var1);
      this.a = var2;
      this.c = var3;
      this.d = var4;
      this.b = var5;
   }

   public boolean b(World var1, Random var2, dt var3) {
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
                     if(!this.a(var1.p(new dt(var8, var6, var9)).c())) {
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
            atr var19 = var1.p(var3.b()).c();
            if((var19 == aty.c || var19 == aty.d || var19 == aty.ak) && var3.o() < 256 - var4 - 1) {
               this.a(var1, var3.b());
               var7 = 3;
               byte var20 = 0;

               int var10;
               int var11;
               int var12;
               int var13;
               dt var16;
               for(var9 = var3.o() - var7 + var4; var9 <= var3.o() + var4; ++var9) {
                  var10 = var9 - (var3.o() + var4);
                  var11 = var20 + 1 - var10 / 2;

                  for(var12 = var3.n() - var11; var12 <= var3.n() + var11; ++var12) {
                     var13 = var12 - var3.n();

                     for(int var14 = var3.p() - var11; var14 <= var3.p() + var11; ++var14) {
                        int var15 = var14 - var3.p();
                        if(Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) {
                           var16 = new dt(var12, var9, var14);
                           atr var17 = var1.p(var16).c();
                           if(var17.r() == bof.a || var17.r() == bof.j || var17.r() == bof.l) {
                              this.a(var1, var16, aty.t, this.d);
                           }
                        }
                     }
                  }
               }

               for(var9 = 0; var9 < var4; ++var9) {
                  atr var21 = var1.p(var3.b(var9)).c();
                  if(var21.r() == bof.a || var21.r() == bof.j || var21.r() == bof.l) {
                     this.a(var1, var3.b(var9), aty.r, this.c);
                     if(this.b && var9 > 0) {
                        if(var2.nextInt(3) > 0 && var1.d(var3.a(-1, var9, 0))) {
                           this.a(var1, var3.a(-1, var9, 0), aty.bn, bbv.S);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(1, var9, 0))) {
                           this.a(var1, var3.a(1, var9, 0), aty.bn, bbv.T);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, -1))) {
                           this.a(var1, var3.a(0, var9, -1), aty.bn, bbv.Q);
                        }

                        if(var2.nextInt(3) > 0 && var1.d(var3.a(0, var9, 1))) {
                           this.a(var1, var3.a(0, var9, 1), aty.bn, bbv.R);
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
                           dt var24 = new dt(var12, var9, var13);
                           if(var1.p(var24).c().r() == bof.j) {
                              dt var23 = var24.e();
                              var16 = var24.f();
                              dt var25 = var24.c();
                              dt var18 = var24.d();
                              if(var2.nextInt(4) == 0 && var1.p(var23).c().r() == bof.a) {
                                 this.a(var1, var23, bbv.S);
                              }

                              if(var2.nextInt(4) == 0 && var1.p(var16).c().r() == bof.a) {
                                 this.a(var1, var16, bbv.T);
                              }

                              if(var2.nextInt(4) == 0 && var1.p(var25).c().r() == bof.a) {
                                 this.a(var1, var25, bbv.Q);
                              }

                              if(var2.nextInt(4) == 0 && var1.p(var18).c().r() == bof.a) {
                                 this.a(var1, var18, bbv.R);
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
                              ej var22 = ej.b(var10).d();
                              this.a(var1, var3.a(var22.g(), var4 - 5 + var9, var22.i()), aty.bN, var11 << 2 | ej.b(var10).b());
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

   private void a(World var1, dt var2, int var3) {
      this.a(var1, var2, aty.bn, var3);
      int var4 = 4;

      for(var2 = var2.b(); var1.p(var2).c().r() == bof.a && var4 > 0; --var4) {
         this.a(var1, var2, aty.bn, var3);
         var2 = var2.b();
      }

   }
}
