package net.minecraft.server;


public class ItemFishingRod extends Item {

   public ItemFishingRod() {
      this.d(64);
      this.c(1);
      this.a(CreativeModeTab.i);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(var3.bE != null) {
         int var4 = var3.bE.l();
         var1.damage(var4, (EntityLiving)var3);
         var3.bv();
      } else {
         var2.makeSound((Entity)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
         if(!var2.isStatic) {
            var2.addEntity((Entity)(new EntityFishingHook(var2, var3)));
         }

         var3.bv();
         var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
      }

      return var1;
   }

   public boolean f_(ItemStack var1) {
      return super.f_(var1);
   }

   public int b() {
      return 1;
   }
}
