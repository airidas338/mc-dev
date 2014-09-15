package net.minecraft.server;


public class ItemFlintAndSteel extends Item {

   public ItemFlintAndSteel() {
      this.h = 1;
      this.d(64);
      this.a(CreativeModeTab.i);
   }

   public boolean a(ItemStack var1, EntityHuman var2, World var3, Location var4, EnumFacing var5, float var6, float var7, float var8) {
      var4 = var4.a(var5);
      if(!var2.a(var4, var5, var1)) {
         return false;
      } else {
         if(var3.getData(var4).c().getMaterial() == Material.AIR) {
            var3.a((double)var4.n() + 0.5D, (double)var4.o() + 0.5D, (double)var4.p() + 0.5D, "fire.ignite", 1.0F, g.nextFloat() * 0.4F + 0.8F);
            var3.a(var4, Blocks.FIRE.P());
         }

         var1.a(1, (EntityLiving)var2);
         return true;
      }
   }
}
