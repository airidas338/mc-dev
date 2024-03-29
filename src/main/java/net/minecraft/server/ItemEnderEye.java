package net.minecraft.server;


public class ItemEnderEye extends Item {

   public ItemEnderEye() {
      this.a(CreativeModeTab.f);
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      IBlockData var9 = var3.getData(var4);
      if(var2.a(var4.a(var5), var5, var1) && var9.c() == Blocks.ENDER_PORTAL_FRAME && !((Boolean)var9.b(BlockEnderPortalFrame.b)).booleanValue()) {
         if(var3.isStatic) {
            return true;
         } else {
            var3.setTypeAndData(var4, var9.a(BlockEnderPortalFrame.b, Boolean.valueOf(true)), 2);
            var3.updateAdjacentComparators(var4, Blocks.ENDER_PORTAL_FRAME);
            --var1.count;

            for(int var10 = 0; var10 < 16; ++var10) {
               double var11 = (double)((float)var4.n() + (5.0F + g.nextFloat() * 6.0F) / 16.0F);
               double var13 = (double)((float)var4.o() + 0.8125F);
               double var15 = (double)((float)var4.p() + (5.0F + g.nextFloat() * 6.0F) / 16.0F);
               double var17 = 0.0D;
               double var19 = 0.0D;
               double var21 = 0.0D;
               var3.a(EnumParticleEffect.l, var11, var13, var15, var17, var19, var21, new int[0]);
            }

            EnumFacing var24 = (EnumFacing)var9.b(BlockEnderPortalFrame.a);
            int var23 = 0;
            int var12 = 0;
            boolean var25 = false;
            boolean var14 = true;
            EnumFacing var26 = var24.e();

            for(int var16 = -2; var16 <= 2; ++var16) {
               Location var29 = var4.a(var26, var16);
               IBlockData var18 = var3.getData(var29);
               if(var18.c() == Blocks.ENDER_PORTAL_FRAME) {
                  if(!((Boolean)var18.b(BlockEnderPortalFrame.b)).booleanValue()) {
                     var14 = false;
                     break;
                  }

                  var12 = var16;
                  if(!var25) {
                     var23 = var16;
                     var25 = true;
                  }
               }
            }

            if(var14 && var12 == var23 + 2) {
               Location var27 = var4.a(var24, 4);

               int var28;
               for(var28 = var23; var28 <= var12; ++var28) {
                  Location var32 = var27.a(var26, var28);
                  IBlockData var30 = var3.getData(var32);
                  if(var30.c() != Blocks.ENDER_PORTAL_FRAME || !((Boolean)var30.b(BlockEnderPortalFrame.b)).booleanValue()) {
                     var14 = false;
                     break;
                  }
               }

               int var31;
               Location var33;
               for(var28 = var23 - 1; var28 <= var12 + 1; var28 += 4) {
                  var27 = var4.a(var26, var28);

                  for(var31 = 1; var31 <= 3; ++var31) {
                     var33 = var27.a(var24, var31);
                     IBlockData var20 = var3.getData(var33);
                     if(var20.c() != Blocks.ENDER_PORTAL_FRAME || !((Boolean)var20.b(BlockEnderPortalFrame.b)).booleanValue()) {
                        var14 = false;
                        break;
                     }
                  }
               }

               if(var14) {
                  for(var28 = var23; var28 <= var12; ++var28) {
                     var27 = var4.a(var26, var28);

                     for(var31 = 1; var31 <= 3; ++var31) {
                        var33 = var27.a(var24, var31);
                        var3.setTypeAndData(var33, Blocks.ENDER_PORTAL.P(), 2);
                     }
                  }
               }
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      MovingObjectPosition var4 = this.a(var2, var3, false);
      if(var4 != null && var4.a == brv.b && var2.getData(var4.a()).c() == Blocks.ENDER_PORTAL_FRAME) {
         return var1;
      } else {
         if(!var2.isStatic) {
            Location var5 = var2.a("Stronghold", new Location(var3));
            if(var5 != null) {
               EntityEnderSignal var6 = new EntityEnderSignal(var2, var3.s, var3.t, var3.u);
               var6.a(var5);
               var2.addEntity((Entity)var6);
               var2.makeSound((Entity)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
               var2.a((EntityHuman)null, 1002, new Location(var3), 0);
               if(!var3.abilities.canInstantlyBuild) {
                  --var1.count;
               }

               var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
            }
         }

         return var1;
      }
   }
}
