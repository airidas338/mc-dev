package net.minecraft.server;

public class akb extends Item {

   private Block a;


   public akb(Block var1) {
      this.h = 1;
      this.a = var1;
      this.a(CreativeModeTab.f);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      boolean var4 = this.a == Blocks.AIR;
      MovingObjectPosition var5 = this.a(var2, var3, var4);
      if(var5 == null) {
         return var1;
      } else {
         if(var5.a == brv.b) {
            Location var6 = var5.a();
            if(!var2.a(var3, var6)) {
               return var1;
            }

            if(var4) {
               if(!var3.a(var6.a(var5.b), var5.b, var1)) {
                  return var1;
               }

               IBlockData var7 = var2.getData(var6);
               Material var8 = var7.c().getMaterial();
               if(var8 == Material.WATER && ((Integer)var7.b(BlockFluids.b)).intValue() == 0) {
                  var2.setAir(var6);
                  var3.b(StatisticList.J[Item.b((Item)this)]);
                  return this.a(var1, var3, Items.ax);
               }

               if(var8 == Material.LAVA && ((Integer)var7.b(BlockFluids.b)).intValue() == 0) {
                  var2.setAir(var6);
                  var3.b(StatisticList.J[Item.b((Item)this)]);
                  return this.a(var1, var3, Items.ay);
               }
            } else {
               if(this.a == Blocks.AIR) {
                  return new ItemStack(Items.BUCKET);
               }

               Location var9 = var6.a(var5.b);
               if(!var3.a(var9, var5.b, var1)) {
                  return var1;
               }

               if(this.a(var2, var9) && !var3.by.canInstantlyBuild) {
                  var3.b(StatisticList.J[Item.b((Item)this)]);
                  return new ItemStack(Items.BUCKET);
               }
            }
         }

         return var1;
      }
   }

   private ItemStack a(ItemStack var1, EntityHuman var2, Item var3) {
      if(var2.by.canInstantlyBuild) {
         return var1;
      } else if(--var1.b <= 0) {
         return new ItemStack(var3);
      } else {
         if(!var2.bg.a(new ItemStack(var3))) {
            var2.a(new ItemStack(var3, 1, 0), false);
         }

         return var1;
      }
   }

   public boolean a(World var1, Location var2) {
      if(this.a == Blocks.AIR) {
         return false;
      } else {
         Material var3 = var1.getData(var2).c().getMaterial();
         boolean var4 = !var3.isBuildable();
         if(!var1.isEmpty(var2) && !var4) {
            return false;
         } else {
            if(var1.worldProvider.n() && this.a == Blocks.WATER) {
               int var5 = var2.n();
               int var6 = var2.o();
               int var7 = var2.p();
               var1.makeSound((double)((float)var5 + 0.5F), (double)((float)var6 + 0.5F), (double)((float)var7 + 0.5F), "random.fizz", 0.5F, 2.6F + (var1.random.nextFloat() - var1.random.nextFloat()) * 0.8F);

               for(int var8 = 0; var8 < 8; ++var8) {
                  var1.a(EnumParticleEffect.m, (double)var5 + Math.random(), (double)var6 + Math.random(), (double)var7 + Math.random(), 0.0D, 0.0D, 0.0D, new int[0]);
               }
            } else {
               if(!var1.isStatic && var4 && !var3.isLiquid()) {
                  var1.setAir(var2, true);
               }

               var1.setTypeAndData(var2, this.a.P(), 3);
            }

            return true;
         }
      }
   }
}
