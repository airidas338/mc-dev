package net.minecraft.server;
import com.google.common.collect.Sets;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class arg {

   private static final int a = (int)Math.pow(17.0D, 2.0D);
   private final Set b = Sets.newHashSet();


   public int a(qt var1, boolean var2, boolean var3, boolean var4) {
      if(!var2 && !var3) {
         return 0;
      } else {
         this.b.clear();
         int var5 = 0;
         Iterator var6 = var1.j.iterator();

         int var9;
         int var12;
         while(var6.hasNext()) {
            ahd var7 = (ahd)var6.next();
            if(!var7.v()) {
               int var8 = uv.c(var7.s / 16.0D);
               var9 = uv.c(var7.u / 16.0D);
               byte var10 = 8;

               for(int var11 = -var10; var11 <= var10; ++var11) {
                  for(var12 = -var10; var12 <= var10; ++var12) {
                     boolean var13 = var11 == -var10 || var11 == var10 || var12 == -var10 || var12 == var10;
                     aqm var14 = new aqm(var11 + var8, var12 + var9);
                     if(!this.b.contains(var14)) {
                        ++var5;
                        if(!var13 && var1.af().a(var14)) {
                           this.b.add(var14);
                        }
                     }
                  }
               }
            }
         }

         int var36 = 0;
         dt var37 = var1.M();
         xp[] var38 = xp.values();
         var9 = var38.length;

         for(int var39 = 0; var39 < var9; ++var39) {
            xp var40 = var38[var39];
            if((!var40.d() || var3) && (var40.d() || var2) && (!var40.e() || var4)) {
               var12 = var1.a(var40.a());
               int var41 = var40.b() * var5 / a;
               if(var12 <= var41) {
                  Iterator var42 = this.b.iterator();

                  label115:
                  while(var42.hasNext()) {
                     aqm var15 = (aqm)var42.next();
                     dt var16 = a(var1, var15.a, var15.b);
                     int var17 = var16.n();
                     int var18 = var16.o();
                     int var19 = var16.p();
                     atr var20 = var1.p(var16).c();
                     if(!var20.t()) {
                        int var21 = 0;
                        int var22 = 0;

                        while(var22 < 3) {
                           int var23 = var17;
                           int var24 = var18;
                           int var25 = var19;
                           byte var26 = 6;
                           arq var27 = null;
                           xq var28 = null;
                           int var29 = 0;

                           while(true) {
                              if(var29 < 4) {
                                 label108: {
                                    var23 += var1.s.nextInt(var26) - var1.s.nextInt(var26);
                                    var24 += var1.s.nextInt(1) - var1.s.nextInt(1);
                                    var25 += var1.s.nextInt(var26) - var1.s.nextInt(var26);
                                    dt var30 = new dt(var23, var24, var25);
                                    float var31 = (float)var23 + 0.5F;
                                    float var32 = (float)var25 + 0.5F;
                                    if(!var1.b((double)var31, (double)var24, (double)var32, 24.0D) && var37.c((double)var31, (double)var24, (double)var32) >= 576.0D) {
                                       if(var27 == null) {
                                          var27 = var1.a(var40, var30);
                                          if(var27 == null) {
                                             break label108;
                                          }
                                       }

                                       if(var1.a(var40, var27, var30) && a(xr.a(var27.b), var1, var30)) {
                                          xn var33;
                                          try {
                                             var33 = (xn)var27.b.getConstructor(new Class[]{aqu.class}).newInstance(new Object[]{var1});
                                          } catch (Exception var35) {
                                             var35.printStackTrace();
                                             return var36;
                                          }

                                          var33.b((double)var31, (double)var24, (double)var32, var1.s.nextFloat() * 360.0F, 0.0F);
                                          if(var33.bQ() && var33.bR()) {
                                             var28 = var33.a(var1.E(new dt(var33)), var28);
                                             if(var33.bR()) {
                                                ++var21;
                                                var1.d(var33);
                                             }

                                             if(var21 >= var33.bU()) {
                                                continue label115;
                                             }
                                          }

                                          var36 += var21;
                                       }
                                    }

                                    ++var29;
                                    continue;
                                 }
                              }

                              ++var22;
                              break;
                           }
                        }
                     }
                  }
               }
            }
         }

         return var36;
      }
   }

   protected static dt a(aqu var0, int var1, int var2) {
      bfh var3 = var0.a(var1, var2);
      int var4 = var1 * 16 + var0.s.nextInt(16);
      int var5 = var2 * 16 + var0.s.nextInt(16);
      int var6 = uv.c(var3.f(new dt(var4, 0, var5)) + 1, 16);
      int var7 = var0.s.nextInt(var6 > 0?var6:var3.g() + 16 - 1);
      return new dt(var4, var7, var5);
   }

   public static boolean a(xo var0, aqu var1, dt var2) {
      if(!var1.af().a(var2)) {
         return false;
      } else {
         atr var3 = var1.p(var2).c();
         if(var0 == xo.c) {
            return var3.r().d() && var1.p(var2.b()).c().r().d() && !var1.p(var2.a()).c().t();
         } else {
            dt var4 = var2.b();
            if(!aqu.a((ard)var1, var4)) {
               return false;
            } else {
               atr var5 = var1.p(var4).c();
               boolean var6 = var5 != aty.h && var5 != aty.cv;
               return var6 && !var3.t() && !var3.r().d() && !var1.p(var2.a()).c().t();
            }
         }
      }
   }

   public static void a(aqu var0, arm var1, int var2, int var3, int var4, int var5, Random var6) {
      List var7 = var1.a(xp.b);
      if(!var7.isEmpty()) {
         while(var6.nextFloat() < var1.g()) {
            arq var8 = (arq)vj.a(var0.s, var7);
            int var9 = var8.c + var6.nextInt(1 + var8.d - var8.c);
            xq var10 = null;
            int var11 = var2 + var6.nextInt(var4);
            int var12 = var3 + var6.nextInt(var5);
            int var13 = var11;
            int var14 = var12;

            for(int var15 = 0; var15 < var9; ++var15) {
               boolean var16 = false;

               for(int var17 = 0; !var16 && var17 < 4; ++var17) {
                  dt var18 = var0.r(new dt(var11, 0, var12));
                  if(a(xo.a, var0, var18)) {
                     xn var19;
                     try {
                        var19 = (xn)var8.b.getConstructor(new Class[]{aqu.class}).newInstance(new Object[]{var0});
                     } catch (Exception var21) {
                        var21.printStackTrace();
                        continue;
                     }

                     var19.b((double)((float)var11 + 0.5F), (double)var18.o(), (double)((float)var12 + 0.5F), var6.nextFloat() * 360.0F, 0.0F);
                     var0.d((wv)var19);
                     var10 = var19.a(var0.E(new dt(var19)), var10);
                     var16 = true;
                  }

                  var11 += var6.nextInt(5) - var6.nextInt(5);

                  for(var12 += var6.nextInt(5) - var6.nextInt(5); var11 < var2 || var11 >= var2 + var4 || var12 < var3 || var12 >= var3 + var4; var12 = var14 + var6.nextInt(5) - var6.nextInt(5)) {
                     var11 = var13 + var6.nextInt(5) - var6.nextInt(5);
                  }
               }
            }
         }

      }
   }

}
