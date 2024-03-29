package net.minecraft.server;


public class ItemMonsterEgg extends Item {

   public ItemMonsterEgg() {
      this.a(true);
      this.a(CreativeModeTab.f);
   }

   public String a(ItemStack var1) {
      String var2 = ("" + LocaleI18n.get(this.a() + ".name")).trim();
      String var3 = EntityTypes.b(var1.getData());
      if(var3 != null) {
         var2 = var2 + " " + LocaleI18n.get("entity." + var3 + ".name");
      }

      return var2;
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(var3.isStatic) {
         return true;
      } else if(!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         IBlockData var9 = var3.getData(var4);
         if(var9.c() == Blocks.MOB_SPAWNER) {
            TileEntity var10 = var3.getTileEntity(var4);
            if(var10 instanceof TileEntityMobSpawner) {
               MobSpawnerAbstract var11 = ((TileEntityMobSpawner)var10).getSpawner();
               var11.a(EntityTypes.b(var1.getData()));
               var10.o_();
               var3.notify(var4);
               if(!var2.abilities.canInstantlyBuild) {
                  --var1.count;
               }

               return true;
            }
         }

         var4 = var4.a(var5);
         double var13 = 0.0D;
         if(var5 == EnumFacing.UP && var9 instanceof BlockFence) {
            var13 = 0.5D;
         }

         Entity var12 = a(var3, var1.getData(), (double)var4.n() + 0.5D, (double)var4.o() + var13, (double)var4.p() + 0.5D);
         if(var12 != null) {
            if(var12 instanceof EntityLiving && var1.hasName()) {
               var12.a(var1.getName());
            }

            if(!var2.abilities.canInstantlyBuild) {
               --var1.count;
            }
         }

         return true;
      }
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(var2.isStatic) {
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

               if(var2.getData(var5).c() instanceof BlockFluids) {
                  Entity var6 = a(var2, var1.getData(), (double)var5.n() + 0.5D, (double)var5.o() + 0.5D, (double)var5.p() + 0.5D);
                  if(var6 != null) {
                     if(var6 instanceof EntityLiving && var1.hasName()) {
                        ((EntityInsentient)var6).a(var1.getName());
                     }

                     if(!var3.abilities.canInstantlyBuild) {
                        --var1.count;
                     }

                     var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
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
               var8.setPositionRotation(var2, var4, var6, MathHelper.g(var0.random.nextFloat() * 360.0F), 0.0F);
               var10.aI = var10.y;
               var10.aG = var10.y;
               var10.a(var0.E(new Location(var10)), (xq)null);
               var0.addEntity(var8);
               var10.x();
            }
         }

         return var8;
      }
   }
}
