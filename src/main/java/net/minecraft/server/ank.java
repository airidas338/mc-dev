package net.minecraft.server;


public class ank extends Item {

   public ank() {
      this.h = 16;
      this.a(CreativeModeTab.f);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(!var3.by.canInstantlyBuild) {
         --var1.b;
      }

      var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
      if(!var2.isStatic) {
         var2.d((Entity)(new EntitySnowball(var2, var3)));
      }

      var3.b(StatisticList.J[Item.b((Item)this)]);
      return var1;
   }
}
