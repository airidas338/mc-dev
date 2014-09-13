package net.minecraft.server;


public class alb extends Item {

   public alb() {
      this.a(CreativeModeTab.f);
   }

   public boolean a(amj var1, EntityHuman var2, World var3, Location var4, ej var5, float var6, float var7, float var8) {
      IBlock var9 = var3.getData(var4);
      if(var2.a(var4.a(var5), var5, var1) && var9.c() == Blocks.bG && !((Boolean)var9.b(BlockEnderPortalFrame.b)).booleanValue()) {
         if(var3.D) {
            return true;
         } else {
            var3.a(var4, var9.a(BlockEnderPortalFrame.b, Boolean.valueOf(true)), 2);
            var3.e(var4, Blocks.bG);
            --var1.b;

            for(int var10 = 0; var10 < 16; ++var10) {
               double var11 = (double)((float)var4.n() + (5.0F + g.nextFloat() * 6.0F) / 16.0F);
               double var13 = (double)((float)var4.o() + 0.8125F);
               double var15 = (double)((float)var4.p() + (5.0F + g.nextFloat() * 6.0F) / 16.0F);
               double var17 = 0.0D;
               double var19 = 0.0D;
               double var21 = 0.0D;
               var3.a(ew.l, var11, var13, var15, var17, var19, var21, new int[0]);
            }

            ej var24 = (ej)var9.b(BlockEnderPortalFrame.a);
            int var23 = 0;
            int var12 = 0;
            boolean var25 = false;
            boolean var14 = true;
            ej var26 = var24.e();

            for(int var16 = -2; var16 <= 2; ++var16) {
               Location var29 = var4.a(var26, var16);
               IBlock var18 = var3.getData(var29);
               if(var18.c() == Blocks.bG) {
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
                  IBlock var30 = var3.getData(var32);
                  if(var30.c() != Blocks.bG || !((Boolean)var30.b(BlockEnderPortalFrame.b)).booleanValue()) {
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
                     IBlock var20 = var3.getData(var33);
                     if(var20.c() != Blocks.bG || !((Boolean)var20.b(BlockEnderPortalFrame.b)).booleanValue()) {
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
                        var3.a(var33, Blocks.bF.P(), 2);
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

   public amj a(amj var1, World var2, EntityHuman var3) {
      MovingObjectPosition var4 = this.a(var2, var3, false);
      if(var4 != null && var4.a == brv.b && var2.getData(var4.a()).c() == Blocks.bG) {
         return var1;
      } else {
         if(!var2.D) {
            Location var5 = var2.a("Stronghold", new Location(var3));
            if(var5 != null) {
               EntityEnderSignal var6 = new EntityEnderSignal(var2, var3.s, var3.t, var3.u);
               var6.a(var5);
               var2.d((Entity)var6);
               var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
               var2.a((EntityHuman)null, 1002, new Location(var3), 0);
               if(!var3.by.d) {
                  --var1.b;
               }

               var3.b(ty.J[Item.b((Item)this)]);
            }
         }

         return var1;
      }
   }
}
