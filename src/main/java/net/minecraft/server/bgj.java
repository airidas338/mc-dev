package net.minecraft.server;
import java.util.Random;

public class bgj extends bgt {

   private float[] d = new float[1024];


   protected void a(long var1, int var3, int var4, bgk var5, double var6, double var8, double var10, float var12, float var13, float var14, int var15, int var16, double var17) {
      Random var19 = new Random(var1);
      double var20 = (double)(var3 * 16 + 8);
      double var22 = (double)(var4 * 16 + 8);
      float var24 = 0.0F;
      float var25 = 0.0F;
      if(var16 <= 0) {
         int var26 = this.a * 16 - 16;
         var16 = var26 - var19.nextInt(var26 / 4);
      }

      boolean var53 = false;
      if(var15 == -1) {
         var15 = var16 / 2;
         var53 = true;
      }

      float var27 = 1.0F;

      for(int var28 = 0; var28 < 256; ++var28) {
         if(var28 == 0 || var19.nextInt(3) == 0) {
            var27 = 1.0F + var19.nextFloat() * var19.nextFloat() * 1.0F;
         }

         this.d[var28] = var27 * var27;
      }

      for(; var15 < var16; ++var15) {
         double var52 = 1.5D + (double)(MathHelper.sin((float)var15 * 3.1415927F / (float)var16) * var12 * 1.0F);
         double var30 = var52 * var17;
         var52 *= (double)var19.nextFloat() * 0.25D + 0.75D;
         var30 *= (double)var19.nextFloat() * 0.25D + 0.75D;
         float var32 = MathHelper.cos(var14);
         float var33 = MathHelper.sin(var14);
         var6 += (double)(MathHelper.cos(var13) * var32);
         var8 += (double)var33;
         var10 += (double)(MathHelper.sin(var13) * var32);
         var14 *= 0.7F;
         var14 += var25 * 0.05F;
         var13 += var24 * 0.05F;
         var25 *= 0.8F;
         var24 *= 0.5F;
         var25 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 2.0F;
         var24 += (var19.nextFloat() - var19.nextFloat()) * var19.nextFloat() * 4.0F;
         if(var53 || var19.nextInt(4) != 0) {
            double var34 = var6 - var20;
            double var36 = var10 - var22;
            double var38 = (double)(var16 - var15);
            double var40 = (double)(var12 + 2.0F + 16.0F);
            if(var34 * var34 + var36 * var36 - var38 * var38 > var40 * var40) {
               return;
            }

            if(var6 >= var20 - 16.0D - var52 * 2.0D && var10 >= var22 - 16.0D - var52 * 2.0D && var6 <= var20 + 16.0D + var52 * 2.0D && var10 <= var22 + 16.0D + var52 * 2.0D) {
               int var55 = MathHelper.c(var6 - var52) - var3 * 16 - 1;
               int var35 = MathHelper.c(var6 + var52) - var3 * 16 + 1;
               int var54 = MathHelper.c(var8 - var30) - 1;
               int var37 = MathHelper.c(var8 + var30) + 1;
               int var56 = MathHelper.c(var10 - var52) - var4 * 16 - 1;
               int var39 = MathHelper.c(var10 + var52) - var4 * 16 + 1;
               if(var55 < 0) {
                  var55 = 0;
               }

               if(var35 > 16) {
                  var35 = 16;
               }

               if(var54 < 1) {
                  var54 = 1;
               }

               if(var37 > 248) {
                  var37 = 248;
               }

               if(var56 < 0) {
                  var56 = 0;
               }

               if(var39 > 16) {
                  var39 = 16;
               }

               boolean var57 = false;

               int var41;
               for(var41 = var55; !var57 && var41 < var35; ++var41) {
                  for(int var42 = var56; !var57 && var42 < var39; ++var42) {
                     for(int var43 = var37 + 1; !var57 && var43 >= var54 - 1; --var43) {
                        if(var43 >= 0 && var43 < 256) {
                           IBlock var44 = var5.a(var41, var43, var42);
                           if(var44.c() == Blocks.i || var44.c() == Blocks.j) {
                              var57 = true;
                           }

                           if(var43 != var54 - 1 && var41 != var55 && var41 != var35 - 1 && var42 != var56 && var42 != var39 - 1) {
                              var43 = var54;
                           }
                        }
                     }
                  }
               }

               if(!var57) {
                  for(var41 = var55; var41 < var35; ++var41) {
                     double var58 = ((double)(var41 + var3 * 16) + 0.5D - var6) / var52;

                     for(int var59 = var56; var59 < var39; ++var59) {
                        double var45 = ((double)(var59 + var4 * 16) + 0.5D - var10) / var52;
                        boolean var47 = false;
                        if(var58 * var58 + var45 * var45 < 1.0D) {
                           for(int var48 = var37; var48 > var54; --var48) {
                              double var49 = ((double)(var48 - 1) + 0.5D - var8) / var30;
                              if((var58 * var58 + var45 * var45) * (double)this.d[var48 - 1] + var49 * var49 / 6.0D < 1.0D) {
                                 IBlock var51 = var5.a(var41, var48, var59);
                                 if(var51.c() == Blocks.c) {
                                    var47 = true;
                                 }

                                 if(var51.c() == Blocks.b || var51.c() == Blocks.d || var51.c() == Blocks.c) {
                                    if(var48 - 1 < 10) {
                                       var5.a(var41, var48, var59, Blocks.k.P());
                                    } else {
                                       var5.a(var41, var48, var59, Blocks.a.P());
                                       if(var47 && var5.a(var41, var48 - 1, var59).c() == Blocks.d) {
                                          var5.a(var41, var48 - 1, var59, this.c.b(new Location(var41 + var3 * 16, 0, var59 + var4 * 16)).ak);
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }

                  if(var53) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected void a(World var1, int var2, int var3, int var4, int var5, bgk var6) {
      if(this.b.nextInt(50) == 0) {
         double var7 = (double)(var2 * 16 + this.b.nextInt(16));
         double var9 = (double)(this.b.nextInt(this.b.nextInt(40) + 8) + 20);
         double var11 = (double)(var3 * 16 + this.b.nextInt(16));
         byte var13 = 1;

         for(int var14 = 0; var14 < var13; ++var14) {
            float var15 = this.b.nextFloat() * 3.1415927F * 2.0F;
            float var16 = (this.b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var17 = (this.b.nextFloat() * 2.0F + this.b.nextFloat()) * 2.0F;
            this.a(this.b.nextLong(), var4, var5, var6, var7, var9, var11, var17, var15, var16, 0, 0, 3.0D);
         }

      }
   }
}
