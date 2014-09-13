package net.minecraft.server;

public class aom extends aos {

   public aom() {
      super(3, 3, new ItemStack[]{new ItemStack(Items.aK), new ItemStack(Items.aK), new ItemStack(Items.aK), new ItemStack(Items.aK), new ItemStack(Items.bd, 0, 32767), new ItemStack(Items.aK), new ItemStack(Items.aK), new ItemStack(Items.aK), new ItemStack(Items.aK)}, new ItemStack(Items.bV, 0, 0));
   }

   public boolean a(ain var1, World var2) {
      if(!super.a(var1, var2)) {
         return false;
      } else {
         ItemStack var3 = null;

         for(int var4 = 0; var4 < var1.n_() && var3 == null; ++var4) {
            ItemStack var5 = var1.a(var4);
            if(var5 != null && var5.b() == Items.bd) {
               var3 = var5;
            }
         }

         if(var3 == null) {
            return false;
         } else {
            WorldMap var6 = Items.bd.a(var3, var2);
            return var6 == null?false:var6.e < 4;
         }
      }
   }

   public ItemStack a(ain var1) {
      ItemStack var2 = null;

      for(int var3 = 0; var3 < var1.n_() && var2 == null; ++var3) {
         ItemStack var4 = var1.a(var3);
         if(var4 != null && var4.b() == Items.bd) {
            var2 = var4;
         }
      }

      var2 = var2.k();
      var2.b = 1;
      if(var2.o() == null) {
         var2.d(new NBTTagCompound());
      }

      var2.o().setBoolean("map_is_scaling", true);
      return var2;
   }
}
