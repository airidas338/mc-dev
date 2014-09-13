package net.minecraft.server;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

public final class SpawnerCreature {

   private static final int a = (int)Math.pow(17.0D, 2.0D);
   private final Set b = Sets.newHashSet();


   public int a(WorldServer var1, boolean var2, boolean var3, boolean var4) {
      if(!var2 && !var3) {
         return 0;
      } else {
         this.b.clear();
         int var5 = 0;
         Iterator var6 = var1.j.iterator();

         int var9;
         int var12;
         while(var6.hasNext()) {
            EntityHuman var7 = (EntityHuman)var6.next();
            if(!var7.v()) {
               int var8 = MathHelper.c(var7.s / 16.0D);
               var9 = MathHelper.c(var7.u / 16.0D);
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
         Location var37 = var1.M();
         EnumCreatureType[] var38 = EnumCreatureType.values();
         var9 = var38.length;

         for(int var39 = 0; var39 < var9; ++var39) {
            EnumCreatureType var40 = var38[var39];
            if((!var40.d() || var3) && (var40.d() || var2) && (!var40.e() || var4)) {
               var12 = var1.a(var40.a());
               int var41 = var40.b() * var5 / a;
               if(var12 <= var41) {
                  Iterator var42 = this.b.iterator();

                  label115:
                  while(var42.hasNext()) {
                     aqm var15 = (aqm)var42.next();
                     Location var16 = a(var1, var15.a, var15.b);
                     int var17 = var16.n();
                     int var18 = var16.o();
                     int var19 = var16.p();
                     Block var20 = var1.getData(var16).c();
                     if(!var20.t()) {
                        int var21 = 0;
                        int var22 = 0;

                        while(var22 < 3) {
                           int var23 = var17;
                           int var24 = var18;
                           int var25 = var19;
                           byte var26 = 6;
                           BiomeMeta var27 = null;
                           xq var28 = null;
                           int var29 = 0;

                           while(true) {
                              if(var29 < 4) {
                                 label108: {
                                    var23 += var1.s.nextInt(var26) - var1.s.nextInt(var26);
                                    var24 += var1.s.nextInt(1) - var1.s.nextInt(1);
                                    var25 += var1.s.nextInt(var26) - var1.s.nextInt(var26);
                                    Location var30 = new Location(var23, var24, var25);
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
                                          EntityInsentient var33;
                                          try {
                                             var33 = (EntityInsentient)var27.b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var1});
                                          } catch (Exception var35) {
                                             var35.printStackTrace();
                                             return var36;
                                          }

                                          var33.b((double)var31, (double)var24, (double)var32, var1.s.nextFloat() * 360.0F, 0.0F);
                                          if(var33.bQ() && var33.bR()) {
                                             var28 = var33.a(var1.E(new Location(var33)), var28);
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

   protected static Location a(World var0, int var1, int var2) {
      bfh var3 = var0.a(var1, var2);
      int var4 = var1 * 16 + var0.s.nextInt(16);
      int var5 = var2 * 16 + var0.s.nextInt(16);
      int var6 = MathHelper.c(var3.f(new Location(var4, 0, var5)) + 1, 16);
      int var7 = var0.s.nextInt(var6 > 0?var6:var3.g() + 16 - 1);
      return new Location(var4, var7, var5);
   }

   public static boolean a(xo var0, World var1, Location var2) {
      if(!var1.af().a(var2)) {
         return false;
      } else {
         Block var3 = var1.getData(var2).c();
         if(var0 == xo.c) {
            return var3.r().d() && var1.getData(var2.b()).c().r().d() && !var1.getData(var2.a()).c().t();
         } else {
            Location var4 = var2.b();
            if(!World.a((IBlockAccess)var1, var4)) {
               return false;
            } else {
               Block var5 = var1.getData(var4).c();
               boolean var6 = var5 != aty.h && var5 != aty.cv;
               return var6 && !var3.t() && !var3.r().d() && !var1.getData(var2.a()).c().t();
            }
         }
      }
   }

   public static void a(World var0, BiomeBase var1, int var2, int var3, int var4, int var5, Random var6) {
      List var7 = var1.a(EnumCreatureType.CREATURE);
      if(!var7.isEmpty()) {
         while(var6.nextFloat() < var1.g()) {
            BiomeMeta var8 = (BiomeMeta)WeightedRandom.a(var0.s, var7);
            int var9 = var8.c + var6.nextInt(1 + var8.d - var8.c);
            xq var10 = null;
            int var11 = var2 + var6.nextInt(var4);
            int var12 = var3 + var6.nextInt(var5);
            int var13 = var11;
            int var14 = var12;

            for(int var15 = 0; var15 < var9; ++var15) {
               boolean var16 = false;

               for(int var17 = 0; !var16 && var17 < 4; ++var17) {
                  Location var18 = var0.r(new Location(var11, 0, var12));
                  if(a(xo.a, var0, var18)) {
                     EntityInsentient var19;
                     try {
                        var19 = (EntityInsentient)var8.b.getConstructor(new Class[]{World.class}).newInstance(new Object[]{var0});
                     } catch (Exception var21) {
                        var21.printStackTrace();
                        continue;
                     }

                     var19.b((double)((float)var11 + 0.5F), (double)var18.o(), (double)((float)var12 + 0.5F), var6.nextFloat() * 360.0F, 0.0F);
                     var0.d((Entity)var19);
                     var10 = var19.a(var0.E(new Location(var19)), var10);
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
