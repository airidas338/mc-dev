package net.minecraft.server;

class aof implements IRecipe {

   private aof() {}

   public boolean a(ain var1, World var2) {
      ItemStack var3 = null;
      ItemStack var4 = null;

      for(int var5 = 0; var5 < var1.n_(); ++var5) {
         ItemStack var6 = var1.a(var5);
         if(var6 != null) {
            if(var6.getItem() != Items.cE) {
               return false;
            }

            if(var3 != null && var4 != null) {
               return false;
            }

            int var7 = TileEntityBanner.b(var6);
            boolean var8 = TileEntityBanner.c(var6) > 0;
            if(var3 != null) {
               if(var8) {
                  return false;
               }

               if(var7 != TileEntityBanner.b(var3)) {
                  return false;
               }

               var4 = var6;
            } else if(var4 != null) {
               if(!var8) {
                  return false;
               }

               if(var7 != TileEntityBanner.b(var4)) {
                  return false;
               }

               var3 = var6;
            } else if(var8) {
               var3 = var6;
            } else {
               var4 = var6;
            }
         }
      }

      return var3 != null && var4 != null;
   }

   public ItemStack a(ain var1) {
      for(int var2 = 0; var2 < var1.n_(); ++var2) {
         ItemStack var3 = var1.a(var2);
         if(var3 != null && TileEntityBanner.c(var3) > 0) {
            ItemStack var4 = var3.cloneItemStack();
            var4.count = 1;
            return var4;
         }
      }

      return null;
   }

   public int a() {
      return 2;
   }

   public ItemStack b() {
      return null;
   }

   public ItemStack[] b(ain var1) {
      ItemStack[] var2 = new ItemStack[var1.n_()];

      for(int var3 = 0; var3 < var2.length; ++var3) {
         ItemStack var4 = var1.a(var3);
         if(var4 != null) {
            if(var4.getItem().r()) {
               var2[var3] = new ItemStack(var4.getItem().q());
            } else if(var4.hasTag() && TileEntityBanner.c(var4) > 0) {
               var2[var3] = var4.cloneItemStack();
               var2[var3].count = 1;
            }
         }
      }

      return var2;
   }

   // $FF: synthetic method
   aof(aod var1) {
      this();
   }
}
