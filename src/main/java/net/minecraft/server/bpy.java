package net.minecraft.server;


public class bpy extends bpu {

   private boolean f;
   private boolean g;
   private boolean h;
   private boolean i;
   private boolean j;


   public void a(IBlockAccess var1, Entity var2) {
      super.a(var1, var2);
      this.j = this.h;
   }

   public void a() {
      super.a();
      this.h = this.j;
   }

   public bpt a(Entity var1) {
      int var2;
      if(this.i && var1.V()) {
         var2 = (int)var1.aQ().b;

         for(Block var3 = this.a.getData(new Location(MathHelper.c(var1.s), var2, MathHelper.c(var1.u))).c(); var3 == Blocks.WATER || var3 == Blocks.STATIONARY_WATER; var3 = this.a.getData(new Location(MathHelper.c(var1.s), var2, MathHelper.c(var1.u))).c()) {
            ++var2;
         }

         this.h = false;
      } else {
         var2 = MathHelper.c(var1.aQ().b + 0.5D);
      }

      return this.a(MathHelper.c(var1.aQ().a), var2, MathHelper.c(var1.aQ().c));
   }

   public bpt a(Entity var1, double var2, double var4, double var6) {
      return this.a(MathHelper.c(var2 - (double)(var1.J / 2.0F)), MathHelper.c(var4), MathHelper.c(var6 - (double)(var1.J / 2.0F)));
   }

   public int a(bpt[] var1, Entity var2, bpt var3, bpt var4, float var5) {
      int var6 = 0;
      byte var7 = 0;
      if(this.a(var2, var3.a, var3.b + 1, var3.c) == 1) {
         var7 = 1;
      }

      bpt var8 = this.a(var2, var3.a, var3.b, var3.c + 1, var7);
      bpt var9 = this.a(var2, var3.a - 1, var3.b, var3.c, var7);
      bpt var10 = this.a(var2, var3.a + 1, var3.b, var3.c, var7);
      bpt var11 = this.a(var2, var3.a, var3.b, var3.c - 1, var7);
      if(var8 != null && !var8.i && var8.a(var4) < var5) {
         var1[var6++] = var8;
      }

      if(var9 != null && !var9.i && var9.a(var4) < var5) {
         var1[var6++] = var9;
      }

      if(var10 != null && !var10.i && var10.a(var4) < var5) {
         var1[var6++] = var10;
      }

      if(var11 != null && !var11.i && var11.a(var4) < var5) {
         var1[var6++] = var11;
      }

      return var6;
   }

   private bpt a(Entity var1, int var2, int var3, int var4, int var5) {
      bpt var6 = null;
      int var7 = this.a(var1, var2, var3, var4);
      if(var7 == 2) {
         return this.a(var2, var3, var4);
      } else {
         if(var7 == 1) {
            var6 = this.a(var2, var3, var4);
         }

         if(var6 == null && var5 > 0 && var7 != -3 && var7 != -4 && this.a(var1, var2, var3 + var5, var4) == 1) {
            var6 = this.a(var2, var3 + var5, var4);
            var3 += var5;
         }

         if(var6 != null) {
            int var8 = 0;

            int var9;
            for(var9 = 0; var3 > 0; var6 = this.a(var2, var3, var4)) {
               var9 = this.a(var1, var2, var3 - 1, var4);
               if(this.h && var9 == -1) {
                  return null;
               }

               if(var9 != 1) {
                  break;
               }

               if(var8++ >= var1.aF()) {
                  return null;
               }

               --var3;
               if(var3 <= 0) {
                  return null;
               }
            }

            if(var9 == -2) {
               return null;
            }
         }

         return var6;
      }
   }

   private int a(Entity var1, int var2, int var3, int var4) {
      return a(this.a, var1, var2, var3, var4, this.c, this.d, this.e, this.h, this.g, this.f);
   }

   public static int a(IBlockAccess var0, Entity var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean var8, boolean var9, boolean var10) {
      boolean var11 = false;
      Location var12 = new Location(var1);

      for(int var13 = var2; var13 < var2 + var5; ++var13) {
         for(int var14 = var3; var14 < var3 + var6; ++var14) {
            for(int var15 = var4; var15 < var4 + var7; ++var15) {
               Location var16 = new Location(var13, var14, var15);
               Block var17 = var0.getData(var16).c();
               if(var17.r() != Material.AIR) {
                  if(var17 != Blocks.TRAP_DOOR_WOOD && var17 != Blocks.TRAP_DOOR_IRON) {
                     if(var17 != Blocks.WATER && var17 != Blocks.STATIONARY_WATER) {
                        if(!var10 && var17 instanceof BlockDoor && var17.r() == Material.WOOD) {
                           return 0;
                        }
                     } else {
                        if(var8) {
                           return -1;
                        }

                        var11 = true;
                     }
                  } else {
                     var11 = true;
                  }

                  if(var1.o.getData(var16).c() instanceof ati) {
                     if(!(var1.o.getData(var12).c() instanceof ati) && !(var1.o.getData(var12.b()).c() instanceof ati)) {
                        return -3;
                     }
                  } else if(!var17.b(var0, var16) && (!var9 || !(var17 instanceof BlockDoor) || var17.r() != Material.WOOD)) {
                     if(var17 instanceof BlockFence || var17 instanceof BlockFenceGate || var17 instanceof BlockCobbleWall) {
                        return -3;
                     }

                     if(var17 == Blocks.TRAP_DOOR_WOOD || var17 == Blocks.TRAP_DOOR_IRON) {
                        return -4;
                     }

                     Material var18 = var17.r();
                     if(var18 != Material.LAVA) {
                        return 0;
                     }

                     if(!var1.ab()) {
                        return -2;
                     }
                  }
               }
            }
         }
      }

      return var11?2:1;
   }

   public void a(boolean var1) {
      this.f = var1;
   }

   public void b(boolean var1) {
      this.g = var1;
   }

   public void c(boolean var1) {
      this.h = var1;
   }

   public void d(boolean var1) {
      this.i = var1;
   }

   public boolean b() {
      return this.f;
   }

   public boolean d() {
      return this.i;
   }

   public boolean e() {
      return this.h;
   }
}
