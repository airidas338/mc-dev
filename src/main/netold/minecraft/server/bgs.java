package net.minecraft.server;
import com.google.common.base.Objects;
import java.util.Random;

public class bgs extends bgt {

   protected void a(long var1, int var3, int var4, bgk var5, double var6, double var8, double var10) {
      this.a(var1, var3, var4, var5, var6, var8, var10, 1.0F + this.b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
   }

   protected void a(long var1, int var3, int var4, bgk var5, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
      double var19 = (double)(var3 * 16 + 8);
      double var21 = (double)(var4 * 16 + 8);
      float var23 = 0.0F;
      float var24 = 0.0F;
      Random var25 = new Random(var1);
      if(var16 <= 0) {
         int var26 = this.a * 16 - 16;
         var16 = var26 - var25.nextInt(var26 / 4);
      }

      boolean var54 = false;
      if(var15 == -1) {
         var15 = var16 / 2;
         var54 = true;
      }

      int var27 = var25.nextInt(var16 / 2) + var16 / 4;

      for(boolean var28 = var25.nextInt(6) == 0; var15 < var16; ++var15) {
         double var29 = 1.5D + (double)(uv.a((float)var15 * 3.1415927F / (float)var16) * var12 * 1.0F);
         double var31 = var29 * var17;
         float var33 = uv.b(var14);
         float var34 = uv.a(var14);
         var6 += (double)(uv.b(var13) * var33);
         var8 += (double)var34;
         var10 += (double)(uv.a(var13) * var33);
         if(var28) {
            var14 *= 0.92F;
         } else {
            var14 *= 0.7F;
         }

         var14 += var24 * 0.1F;
         var13 += var23 * 0.1F;
         var24 *= 0.9F;
         var23 *= 0.75F;
         var24 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 2.0F;
         var23 += (var25.nextFloat() - var25.nextFloat()) * var25.nextFloat() * 4.0F;
         if(!var54 && var15 == var27 && var12 > 1.0F && var16 > 0) {
            this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 - 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
            this.a(var25.nextLong(), var3, var4, var5, var6, var8, var10, var25.nextFloat() * 0.5F + 0.5F, var13 + 1.5707964F, var14 / 3.0F, var15, var16, 1.0D);
            return;
         }

         if(var54 || var25.nextInt(4) != 0) {
            double var35 = var6 - var19;
            double var37 = var10 - var21;
            double var39 = (double)(var16 - var15);
            double var41 = (double)(var12 + 2.0F + 16.0F);
            if(var35 * var35 + var37 * var37 - var39 * var39 > var41 * var41) {
               return;
            }

            if(var6 >= var19 - 16.0D - var29 * 2.0D && var10 >= var21 - 16.0D - var29 * 2.0D && var6 <= var19 + 16.0D + var29 * 2.0D && var10 <= var21 + 16.0D + var29 * 2.0D) {
               int var55 = uv.c(var6 - var29) - var3 * 16 - 1;
               int var36 = uv.c(var6 + var29) - var3 * 16 + 1;
               int var57 = uv.c(var8 - var31) - 1;
               int var38 = uv.c(var8 + var31) + 1;
               int var56 = uv.c(var10 - var29) - var4 * 16 - 1;
               int var40 = uv.c(var10 + var29) - var4 * 16 + 1;
               if(var55 < 0) {
                  var55 = 0;
               }

               if(var36 > 16) {
                  var36 = 16;
               }

               if(var57 < 1) {
                  var57 = 1;
               }

               if(var38 > 248) {
                  var38 = 248;
               }

               if(var56 < 0) {
                  var56 = 0;
               }

               if(var40 > 16) {
                  var40 = 16;
               }

               boolean var58 = false;

               int var42;
               for(var42 = var55; !var58 && var42 < var36; ++var42) {
                  for(int var43 = var56; !var58 && var43 < var40; ++var43) {
                     for(int var44 = var38 + 1; !var58 && var44 >= var57 - 1; --var44) {
                        if(var44 >= 0 && var44 < 256) {
                           bec var45 = var5.a(var42, var44, var43);
                           if(var45.c() == aty.i || var45.c() == aty.j) {
                              var58 = true;
                           }

                           if(var44 != var57 - 1 && var42 != var55 && var42 != var36 - 1 && var43 != var56 && var43 != var40 - 1) {
                              var44 = var57;
                           }
                        }
                     }
                  }
               }

               if(!var58) {
                  for(var42 = var55; var42 < var36; ++var42) {
                     double var60 = ((double)(var42 + var3 * 16) + 0.5D - var6) / var29;

                     for(int var59 = var56; var59 < var40; ++var59) {
                        double var46 = ((double)(var59 + var4 * 16) + 0.5D - var10) / var29;
                        boolean var48 = false;
                        if(var60 * var60 + var46 * var46 < 1.0D) {
                           for(int var49 = var38; var49 > var57; --var49) {
                              double var50 = ((double)(var49 - 1) + 0.5D - var8) / var31;
                              if(var50 > -0.7D && var60 * var60 + var50 * var50 + var46 * var46 < 1.0D) {
                                 bec var52 = var5.a(var42, var49, var59);
                                 bec var53 = (bec)Objects.firstNonNull(var5.a(var42, var49 + 1, var59), aty.a.P());
                                 if(var52.c() == aty.c || var52.c() == aty.bw) {
                                    var48 = true;
                                 }

                                 if(this.a(var52, var53)) {
                                    if(var49 - 1 < 10) {
                                       var5.a(var42, var49, var59, aty.l.P());
                                    } else {
                                       var5.a(var42, var49, var59, aty.a.P());
                                       if(var53.c() == aty.m) {
                                          var5.a(var42, var49 + 1, var59, var53.b(bab.a) == bac.b?aty.cM.P():aty.a.P());
                                       }

                                       if(var48 && var5.a(var42, var49 - 1, var59).c() == aty.d) {
                                          var5.a(var42, var49 - 1, var59, this.c.b(new dt(var42 + var3 * 16, 0, var59 + var4 * 16)).ak.c().P());
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if(var54) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected boolean a(bec var1, bec var2) {
      return var1.c() == aty.b?true:(var1.c() == aty.d?true:(var1.c() == aty.c?true:(var1.c() == aty.cz?true:(var1.c() == aty.cu?true:(var1.c() == aty.A?true:(var1.c() == aty.cM?true:(var1.c() == aty.bw?true:(var1.c() == aty.aH?true:(var1.c() == aty.m || var1.c() == aty.n) && var2.c().r() != bof.h))))))));
   }

   protected void a(aqu var1, int var2, int var3, int var4, int var5, bgk var6) {
      int var7 = this.b.nextInt(this.b.nextInt(this.b.nextInt(15) + 1) + 1);
      if(this.b.nextInt(7) != 0) {
         var7 = 0;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         double var9 = (double)(var2 * 16 + this.b.nextInt(16));
         double var11 = (double)this.b.nextInt(this.b.nextInt(120) + 8);
         double var13 = (double)(var3 * 16 + this.b.nextInt(16));
         int var15 = 1;
         if(this.b.nextInt(4) == 0) {
            this.a(this.b.nextLong(), var4, var5, var6, var9, var11, var13);
            var15 += this.b.nextInt(4);
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            float var17 = this.b.nextFloat() * 3.1415927F * 2.0F;
            float var18 = (this.b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var19 = this.b.nextFloat() * 2.0F + this.b.nextFloat();
            if(this.b.nextInt(10) == 0) {
               var19 *= this.b.nextFloat() * this.b.nextFloat() * 3.0F + 1.0F;
            }

            this.a(this.b.nextLong(), var4, var5, var6, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
         }
      }

   }
}
