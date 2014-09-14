package net.minecraft.server;


public class anl extends Item {

   public anl() {
      this.a(true);
      this.a(CreativeModeTab.f);
   }

   public String a(ItemStack var1) {
      String var2 = ("" + fi.a(this.a() + ".name")).trim();
      String var3 = EntityTypes.b(var1.i());
      if(var3 != null) {
         var2 = var2 + " " + fi.a("entity." + var3 + ".name");
      }

      return var2;
   }

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var3.D) {
         return true;
      } else if(!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         IBlock var9 = var3.getData(var4);
         if(var9.c() == Blocks.MOB_SPAWNER) {
            TileEntity var10 = var3.s(var4);
            if(var10 instanceof bdg) {
               aqi var11 = ((bdg)var10).b();
               var11.a(EntityTypes.b(var1.i()));
               var10.o_();
               var3.h(var4);
               if(!var2.by.canInstantlyBuild) {
                  --var1.b;
               }

               return true;
            }
         }

         var4 = var4.a(var5);
         double var13 = 0.0D;
         if(var5 == EnumFacing.UP && var9 instanceof BlockFence) {
            var13 = 0.5D;
         }

         Entity var12 = a(var3, var1.i(), (double)var4.n() + 0.5D, (double)var4.o() + var13, (double)var4.p() + 0.5D);
         if(var12 != null) {
            if(var12 instanceof EntityLiving && var1.s()) {
               var12.a(var1.q());
            }

            if(!var2.by.canInstantlyBuild) {
               --var1.b;
            }
         }

         return true;
      }
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(var2.D) {
         return var1;
      } else {
         MovingObjectPosition var4 = this.a(var2, var3, true);
         if(var4 == null) {
            return var1;
         } else {
            if(var4.a == brv.b) {
               Location var5 = var4.a();
               if(!var2.a(var3, var5)) {
                  return var1;
               }

               if(!var3.a(var5, var4.b, var1)) {
                  return var1;
               }

               if(var2.getData(var5).c() instanceof axl) {
                  Entity var6 = a(var2, var1.i(), (double)var5.n() + 0.5D, (double)var5.o() + 0.5D, (double)var5.p() + 0.5D);
                  if(var6 != null) {
                     if(var6 instanceof EntityLiving && var1.s()) {
                        ((EntityInsentient)var6).a(var1.q());
                     }

                     if(!var3.by.canInstantlyBuild) {
                        --var1.b;
                     }

                     var3.b(ty.J[Item.b((Item)this)]);
                  }
               }
            }

            return var1;
         }
      }
   }

   public static Entity a(World var0, int var1, double var2, double var4, double var6) {
      if(!EntityTypes.a.containsKey(Integer.valueOf(var1))) {
         return null;
      } else {
         Entity var8 = null;

         for(int var9 = 0; var9 < 1; ++var9) {
            var8 = EntityTypes.a(var1, var0);
            if(var8 instanceof EntityLiving) {
               EntityInsentient var10 = (EntityInsentient)var8;
               var8.setPositionRotation(var2, var4, var6, MathHelper.g(var0.s.nextFloat() * 360.0F), 0.0F);
               var10.aI = var10.y;
               var10.aG = var10.y;
               var10.a(var0.E(new Location(var10)), (xq)null);
               var0.d(var8);
               var10.x();
            }
         }

         return var8;
      }
   }
}
