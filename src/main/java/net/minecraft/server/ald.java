package net.minecraft.server;


public class ald extends Item {

   public ald() {
      this.a(CreativeModeTab.f);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(!var3.by.canInstantlyBuild) {
         --var1.b;
      }

      var2.makeSound((Entity)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
      if(!var2.isStatic) {
         var2.addEntity((Entity)(new EntityThrownExpBottle(var2, var3)));
      }

      var3.b(StatisticList.J[Item.b((Item)this)]);
      return var1;
   }
}
