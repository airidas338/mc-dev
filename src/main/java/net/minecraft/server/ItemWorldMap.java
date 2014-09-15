package net.minecraft.server;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multisets;

public class ItemWorldMap extends ake {

   protected ItemWorldMap() {
      this.a(true);
   }

   public WorldMap a(ItemStack var1, World var2) {
      String var3 = "map_" + var1.i();
      WorldMap var4 = (WorldMap)var2.a(WorldMap.class, var3);
      if(var4 == null && !var2.isStatic) {
         var1.b(var2.b("map"));
         var3 = "map_" + var1.i();
         var4 = new WorldMap(var3);
         var4.e = 3;
         var4.a((double)var2.P().c(), (double)var2.P().e(), var4.e);
         var4.d = (byte)var2.worldProvider.q();
         var4.c();
         var2.a(var3, (PersistentBase)var4);
      }

      return var4;
   }

   public void a(World var1, Entity var2, WorldMap var3) {
      if(var1.worldProvider.q() == var3.d && var2 instanceof EntityHuman) {
         int var4 = 1 << var3.e;
         int var5 = var3.b;
         int var6 = var3.c;
         int var7 = MathHelper.floor(var2.s - (double)var5) / var4 + 64;
         int var8 = MathHelper.floor(var2.u - (double)var6) / var4 + 64;
         int var9 = 128 / var4;
         if(var1.worldProvider.o()) {
            var9 /= 2;
         }

         bqf var10 = var3.a((EntityHuman)var2);
         ++var10.b;
         boolean var11 = false;

         for(int var12 = var7 - var9 + 1; var12 < var7 + var9; ++var12) {
            if((var12 & 15) == (var10.b & 15) || var11) {
               var11 = false;
               double var13 = 0.0D;

               for(int var15 = var8 - var9 - 1; var15 < var8 + var9; ++var15) {
                  if(var12 >= 0 && var15 >= -1 && var12 < 128 && var15 < 128) {
                     int var16 = var12 - var7;
                     int var17 = var15 - var8;
                     boolean var18 = var16 * var16 + var17 * var17 > (var9 - 2) * (var9 - 2);
                     int var19 = (var5 / var4 + var12 - 64) * var4;
                     int var20 = (var6 / var4 + var15 - 64) * var4;
                     HashMultiset var21 = HashMultiset.create();
                     Chunk var22 = var1.f(new Location(var19, 0, var20));
                     if(!var22.f()) {
                        int var23 = var19 & 15;
                        int var24 = var20 & 15;
                        int var25 = 0;
                        double var26 = 0.0D;
                        int var28;
                        if(var1.worldProvider.o()) {
                           var28 = var19 + var20 * 231871;
                           var28 = var28 * var28 * 31287121 + var28 * 11;
                           if((var28 >> 20 & 1) == 0) {
                              var21.add(Blocks.DIRT.g(Blocks.DIRT.P().a(BlockDirt.a, avd.a)), 10);
                           } else {
                              var21.add(Blocks.STONE.g(Blocks.STONE.P().a(BlockStone.a, bbb.a)), 100);
                           }

                           var26 = 100.0D;
                        } else {
                           for(var28 = 0; var28 < var4; ++var28) {
                              for(int var29 = 0; var29 < var4; ++var29) {
                                 int var30 = var22.b(var28 + var23, var29 + var24) + 1;
                                 IBlockData var31 = Blocks.AIR.P();
                                 if(var30 > 1) {
                                    do {
                                       --var30;
                                       var31 = var22.g(new Location(var28 + var23, var30, var29 + var24));
                                    } while(var31.c().g(var31) == MaterialMapColor.b && var30 > 0);

                                    if(var30 > 0 && var31.c().getMaterial().isLiquid()) {
                                       int var32 = var30 - 1;

                                       Block var33;
                                       do {
                                          var33 = var22.a(var28 + var23, var32--, var29 + var24);
                                          ++var25;
                                       } while(var32 > 0 && var33.getMaterial().isLiquid());
                                    }
                                 }

                                 var26 += (double)var30 / (double)(var4 * var4);
                                 var21.add(var31.c().g(var31));
                              }
                           }
                        }

                        var25 /= var4 * var4;
                        double var35 = (var26 - var13) * 4.0D / (double)(var4 + 4) + ((double)(var12 + var15 & 1) - 0.5D) * 0.4D;
                        byte var34 = 1;
                        if(var35 > 0.6D) {
                           var34 = 2;
                        }

                        if(var35 < -0.6D) {
                           var34 = 0;
                        }

                        MaterialMapColor var38 = (MaterialMapColor)Iterables.getFirst(Multisets.copyHighestCountFirst(var21), MaterialMapColor.b);
                        if(var38 == MaterialMapColor.n) {
                           var35 = (double)var25 * 0.1D + (double)(var12 + var15 & 1) * 0.2D;
                           var34 = 1;
                           if(var35 < 0.5D) {
                              var34 = 2;
                           }

                           if(var35 > 0.9D) {
                              var34 = 0;
                           }
                        }

                        var13 = var26;
                        if(var15 >= 0 && var16 * var16 + var17 * var17 < var9 * var9 && (!var18 || (var12 + var15 & 1) != 0)) {
                           byte var37 = var3.f[var12 + var15 * 128];
                           byte var36 = (byte)(var38.M * 4 + var34);
                           if(var37 != var36) {
                              var3.f[var12 + var15 * 128] = var36;
                              var3.a(var12, var15);
                              var11 = true;
                           }
                        }
                     }
                  }
               }
            }
         }

      }
   }

   public void a(ItemStack var1, World var2, Entity var3, int var4, boolean var5) {
      if(!var2.isStatic) {
         WorldMap var6 = this.a(var1, var2);
         if(var3 instanceof EntityHuman) {
            EntityHuman var7 = (EntityHuman)var3;
            var6.a(var7, var1);
         }

         if(var5) {
            this.a(var2, var3, var6);
         }

      }
   }

   public Packet c(ItemStack var1, World var2, EntityHuman var3) {
      return this.a(var1, var2).a(var1, var2, var3);
   }

   public void d(ItemStack var1, World var2, EntityHuman var3) {
      if(var1.n() && var1.o().getBoolean("map_is_scaling")) {
         WorldMap var4 = Items.bd.a(var1, var2);
         var1.b(var2.b("map"));
         WorldMap var5 = new WorldMap("map_" + var1.i());
         var5.e = (byte)(var4.e + 1);
         if(var5.e > 4) {
            var5.e = 4;
         }

         var5.a((double)var4.b, (double)var4.c, var5.e);
         var5.d = var4.d;
         var5.c();
         var2.a("map_" + var1.i(), (PersistentBase)var5);
      }

   }
}
