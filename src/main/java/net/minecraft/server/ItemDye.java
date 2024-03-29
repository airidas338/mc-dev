package net.minecraft.server;


public class ItemDye extends Item {

   public static final int[] a = new int[]{1973019, 11743532, 3887386, 5320730, 2437522, 8073150, 2651799, 11250603, 4408131, 14188952, 4312372, 14602026, 6719955, 12801229, 15435844, 15790320};


   public ItemDye() {
      this.a(true);
      this.d(0);
      this.a(CreativeModeTab.l);
   }

   public String e_(ItemStack var1) {
      int var2 = var1.getData();
      return super.a() + "." + akv.a(var2).d();
   }

   public boolean interactWith(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      if(!var2.a(var4.a(var5), var5, var1)) {
         return false;
      } else {
         akv var9 = akv.a(var1.getData());
         if(var9 == akv.a) {
            if(a(var1, var3, var4)) {
               if(!var3.isStatic) {
                  var3.triggerEffect(2005, var4, 0);
               }

               return true;
            }
         } else if(var9 == akv.m) {
            IBlockData var10 = var3.getData(var4);
            Block var11 = var10.c();
            if(var11 == Blocks.LOG && var10.b(BlockWood.a) == ayx.d) {
               if(var5 == EnumFacing.DOWN) {
                  return false;
               }

               if(var5 == EnumFacing.UP) {
                  return false;
               }

               var4 = var4.a(var5);
               if(var3.isEmpty(var4)) {
                  IBlockData var12 = Blocks.COCOA.getPlacedData(var3, var4, var5, var6, var7, var8, 0, var2);
                  var3.setTypeAndData(var4, var12, 2);
                  if(!var2.abilities.canInstantlyBuild) {
                     --var1.count;
                  }
               }

               return true;
            }
         }

         return false;
      }
   }

   public static boolean a(ItemStack var0, World var1, Location var2) {
      IBlockData var3 = var1.getData(var2);
      if(var3.c() instanceof atz) {
         atz var4 = (atz)var3.c();
         if(var4.a(var1, var2, var3, var1.isStatic)) {
            if(!var1.isStatic) {
               if(var4.a(var1, var1.random, var2, var3)) {
                  var4.b(var1, var1.random, var2, var3);
               }

               --var0.count;
            }

            return true;
         }
      }

      return false;
   }

   public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3) {
      if(var3 instanceof EntitySheep) {
         EntitySheep var4 = (EntitySheep)var3;
         akv var5 = akv.a(var1.getData());
         if(!var4.ck() && var4.cj() != var5) {
            var4.b(var5);
            --var1.count;
         }

         return true;
      } else {
         return false;
      }
   }

}
