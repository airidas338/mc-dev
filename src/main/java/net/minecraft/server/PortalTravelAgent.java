package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PortalTravelAgent {

   private final WorldServer a;
   private final Random b;
   private final ur c = new ur();
   private final List d = Lists.newArrayList();


   public PortalTravelAgent(WorldServer var1) {
      this.a = var1;
      this.b = new Random(var1.J());
   }

   public void a(Entity var1, float var2) {
      if(this.a.worldProvider.q() != 1) {
         if(!this.b(var1, var2)) {
            this.a(var1);
            this.b(var1, var2);
         }
      } else {
         int var3 = MathHelper.floor(var1.s);
         int var4 = MathHelper.floor(var1.t) - 1;
         int var5 = MathHelper.floor(var1.u);
         byte var6 = 1;
         byte var7 = 0;

         for(int var8 = -2; var8 <= 2; ++var8) {
            for(int var9 = -2; var9 <= 2; ++var9) {
               for(int var10 = -1; var10 < 3; ++var10) {
                  int var11 = var3 + var9 * var6 + var8 * var7;
                  int var12 = var4 + var10;
                  int var13 = var5 + var9 * var7 - var8 * var6;
                  boolean var14 = var10 < 0;
                  this.a.a(new Location(var11, var12, var13), var14?Blocks.OBSIDIAN.P():Blocks.AIR.P());
               }
            }
         }

         var1.setPositionRotation((double)var3, (double)var4, (double)var5, var1.y, 0.0F);
         var1.v = var1.w = var1.x = 0.0D;
      }
   }

   public boolean b(Entity var1, float var2) {
      boolean var3 = true;
      double var4 = -1.0D;
      int var6 = MathHelper.floor(var1.s);
      int var7 = MathHelper.floor(var1.u);
      boolean var8 = true;
      Object var9 = Location.a;
      long var10 = aqm.a(var6, var7);
      if(this.c.b(var10)) {
         ari var12 = (ari)this.c.a(var10);
         var4 = 0.0D;
         var9 = var12;
         var12.b = this.a.K();
         var8 = false;
      } else {
         Location var34 = new Location(var1);

         for(int var13 = -128; var13 <= 128; ++var13) {
            Location var16;
            for(int var14 = -128; var14 <= 128; ++var14) {
               for(Location var15 = var34.a(var13, this.a.V() - 1 - var34.o(), var14); var15.o() >= 0; var15 = var16) {
                  var16 = var15.b();
                  if(this.a.getData(var15).c() == Blocks.PORTAL) {
                     while(this.a.getData(var16 = var15.b()).c() == Blocks.PORTAL) {
                        var15 = var16;
                     }

                     double var17 = var15.i(var34);
                     if(var4 < 0.0D || var17 < var4) {
                        var4 = var17;
                        var9 = var15;
                     }
                  }
               }
            }
         }
      }

      if(var4 >= 0.0D) {
         if(var8) {
            this.c.a(var10, new ari(this, (Location)var9, this.a.K()));
            this.d.add(Long.valueOf(var10));
         }

         double var35 = (double)((Location)var9).n() + 0.5D;
         double var36 = (double)((Location)var9).o() + 0.5D;
         double var37 = (double)((Location)var9).p() + 0.5D;
         EnumFacing var18 = null;
         if(this.a.getData(((Location)var9).e()).c() == Blocks.PORTAL) {
            var18 = EnumFacing.NORTH;
         }

         if(this.a.getData(((Location)var9).f()).c() == Blocks.PORTAL) {
            var18 = EnumFacing.SOUTH;
         }

         if(this.a.getData(((Location)var9).c()).c() == Blocks.PORTAL) {
            var18 = EnumFacing.EAST;
         }

         if(this.a.getData(((Location)var9).d()).c() == Blocks.PORTAL) {
            var18 = EnumFacing.WEST;
         }

         EnumFacing var19 = EnumFacing.b(var1.aG());
         if(var18 != null) {
            EnumFacing var20 = var18.f();
            Location var21 = ((Location)var9).a(var18);
            boolean var22 = this.a(var21);
            boolean var23 = this.a(var21.a(var20));
            if(var23 && var22) {
               var9 = ((Location)var9).a(var20);
               var18 = var18.d();
               var20 = var20.d();
               Location var24 = ((Location)var9).a(var18);
               var22 = this.a(var24);
               var23 = this.a(var24.a(var20));
            }

            float var38 = 0.5F;
            float var25 = 0.5F;
            if(!var23 && var22) {
               var38 = 1.0F;
            } else if(var23 && !var22) {
               var38 = 0.0F;
            } else if(var23) {
               var25 = 0.0F;
            }

            var35 = (double)((Location)var9).n() + 0.5D;
            var36 = (double)((Location)var9).o() + 0.5D;
            var37 = (double)((Location)var9).p() + 0.5D;
            var35 += (double)((float)var20.g() * var38 + (float)var18.g() * var25);
            var37 += (double)((float)var20.i() * var38 + (float)var18.i() * var25);
            float var26 = 0.0F;
            float var27 = 0.0F;
            float var28 = 0.0F;
            float var29 = 0.0F;
            if(var18 == var19) {
               var26 = 1.0F;
               var27 = 1.0F;
            } else if(var18 == var19.d()) {
               var26 = -1.0F;
               var27 = -1.0F;
            } else if(var18 == var19.e()) {
               var28 = 1.0F;
               var29 = -1.0F;
            } else {
               var28 = -1.0F;
               var29 = 1.0F;
            }

            double var30 = var1.v;
            double var32 = var1.x;
            var1.v = var30 * (double)var26 + var32 * (double)var29;
            var1.x = var30 * (double)var28 + var32 * (double)var27;
            var1.y = var2 - (float)(var19.b() * 90) + (float)(var18.b() * 90);
         } else {
            var1.v = var1.w = var1.x = 0.0D;
         }

         var1.setPositionRotation(var35, var36, var37, var1.y, var1.z);
         return true;
      } else {
         return false;
      }
   }

   private boolean a(Location var1) {
      return !this.a.isEmpty(var1) || !this.a.isEmpty(var1.a());
   }

   public boolean a(Entity var1) {
      byte var2 = 16;
      double var3 = -1.0D;
      int var5 = MathHelper.floor(var1.s);
      int var6 = MathHelper.floor(var1.t);
      int var7 = MathHelper.floor(var1.u);
      int var8 = var5;
      int var9 = var6;
      int var10 = var7;
      int var11 = 0;
      int var12 = this.b.nextInt(4);

      int var13;
      double var14;
      double var17;
      int var16;
      int var19;
      int var21;
      int var20;
      int var23;
      int var22;
      int var25;
      int var24;
      int var27;
      int var26;
      double var32;
      double var33;
      for(var13 = var5 - var2; var13 <= var5 + var2; ++var13) {
         var14 = (double)var13 + 0.5D - var1.s;

         for(var16 = var7 - var2; var16 <= var7 + var2; ++var16) {
            var17 = (double)var16 + 0.5D - var1.u;

            label271:
            for(var19 = this.a.V() - 1; var19 >= 0; --var19) {
               if(this.a.isEmpty(new Location(var13, var19, var16))) {
                  while(var19 > 0 && this.a.isEmpty(new Location(var13, var19 - 1, var16))) {
                     --var19;
                  }

                  for(var20 = var12; var20 < var12 + 4; ++var20) {
                     var21 = var20 % 2;
                     var22 = 1 - var21;
                     if(var20 % 4 >= 2) {
                        var21 = -var21;
                        var22 = -var22;
                     }

                     for(var23 = 0; var23 < 3; ++var23) {
                        for(var24 = 0; var24 < 4; ++var24) {
                           for(var25 = -1; var25 < 4; ++var25) {
                              var26 = var13 + (var24 - 1) * var21 + var23 * var22;
                              var27 = var19 + var25;
                              int var28 = var16 + (var24 - 1) * var22 - var23 * var21;
                              if(var25 < 0 && !this.a.getData(new Location(var26, var27, var28)).c().getMaterial().a() || var25 >= 0 && !this.a.isEmpty(new Location(var26, var27, var28))) {
                                 continue label271;
                              }
                           }
                        }
                     }

                     var33 = (double)var19 + 0.5D - var1.t;
                     var32 = var14 * var14 + var33 * var33 + var17 * var17;
                     if(var3 < 0.0D || var32 < var3) {
                        var3 = var32;
                        var8 = var13;
                        var9 = var19;
                        var10 = var16;
                        var11 = var20 % 4;
                     }
                  }
               }
            }
         }
      }

      if(var3 < 0.0D) {
         for(var13 = var5 - var2; var13 <= var5 + var2; ++var13) {
            var14 = (double)var13 + 0.5D - var1.s;

            for(var16 = var7 - var2; var16 <= var7 + var2; ++var16) {
               var17 = (double)var16 + 0.5D - var1.u;

               label219:
               for(var19 = this.a.V() - 1; var19 >= 0; --var19) {
                  if(this.a.isEmpty(new Location(var13, var19, var16))) {
                     while(var19 > 0 && this.a.isEmpty(new Location(var13, var19 - 1, var16))) {
                        --var19;
                     }

                     for(var20 = var12; var20 < var12 + 2; ++var20) {
                        var21 = var20 % 2;
                        var22 = 1 - var21;

                        for(var23 = 0; var23 < 4; ++var23) {
                           for(var24 = -1; var24 < 4; ++var24) {
                              var25 = var13 + (var23 - 1) * var21;
                              var26 = var19 + var24;
                              var27 = var16 + (var23 - 1) * var22;
                              if(var24 < 0 && !this.a.getData(new Location(var25, var26, var27)).c().getMaterial().a() || var24 >= 0 && !this.a.isEmpty(new Location(var25, var26, var27))) {
                                 continue label219;
                              }
                           }
                        }

                        var33 = (double)var19 + 0.5D - var1.t;
                        var32 = var14 * var14 + var33 * var33 + var17 * var17;
                        if(var3 < 0.0D || var32 < var3) {
                           var3 = var32;
                           var8 = var13;
                           var9 = var19;
                           var10 = var16;
                           var11 = var20 % 2;
                        }
                     }
                  }
               }
            }
         }
      }

      int var29 = var8;
      int var15 = var9;
      var16 = var10;
      int var30 = var11 % 2;
      int var18 = 1 - var30;
      if(var11 % 4 >= 2) {
         var30 = -var30;
         var18 = -var18;
      }

      if(var3 < 0.0D) {
         var9 = MathHelper.a(var9, 70, this.a.V() - 10);
         var15 = var9;

         for(var19 = -1; var19 <= 1; ++var19) {
            for(var20 = 1; var20 < 3; ++var20) {
               for(var21 = -1; var21 < 3; ++var21) {
                  var22 = var29 + (var20 - 1) * var30 + var19 * var18;
                  var23 = var15 + var21;
                  var24 = var16 + (var20 - 1) * var18 - var19 * var30;
                  boolean var34 = var21 < 0;
                  this.a.a(new Location(var22, var23, var24), var34?Blocks.OBSIDIAN.P():Blocks.AIR.P());
               }
            }
         }
      }

      IBlockData var31 = Blocks.PORTAL.P().a(BlockPortal.a, var30 != 0?el.a:el.c);

      for(var20 = 0; var20 < 4; ++var20) {
         for(var21 = 0; var21 < 4; ++var21) {
            for(var22 = -1; var22 < 4; ++var22) {
               var23 = var29 + (var21 - 1) * var30;
               var24 = var15 + var22;
               var25 = var16 + (var21 - 1) * var18;
               boolean var35 = var21 == 0 || var21 == 3 || var22 == -1 || var22 == 3;
               this.a.a(new Location(var23, var24, var25), var35?Blocks.OBSIDIAN.P():var31, 2);
            }
         }

         for(var21 = 0; var21 < 4; ++var21) {
            for(var22 = -1; var22 < 4; ++var22) {
               var23 = var29 + (var21 - 1) * var30;
               var24 = var15 + var22;
               var25 = var16 + (var21 - 1) * var18;
               this.a.c(new Location(var23, var24, var25), this.a.getData(new Location(var23, var24, var25)).c());
            }
         }
      }

      return true;
   }

   public void a(long var1) {
      if(var1 % 100L == 0L) {
         Iterator var3 = this.d.iterator();
         long var4 = var1 - 600L;

         while(var3.hasNext()) {
            Long var6 = (Long)var3.next();
            ari var7 = (ari)this.c.a(var6.longValue());
            if(var7 == null || var7.b < var4) {
               var3.remove();
               this.c.d(var6.longValue());
            }
         }
      }

   }
}
