package net.minecraft.server;


public class ItemEgg extends Item {

   public ItemEgg() {
      this.maxStackSize = 16;
      this.a(CreativeModeTab.l);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(!var3.abilities.canInstantlyBuild) {
         --var1.count;
      }

      var2.makeSound((Entity)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
      if(!var2.isStatic) {
         var2.addEntity((Entity)(new EntityEgg(var2, var3)));
      }

      var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
      return var1;
   }
}
