package net.minecraft.server;

public class ItemGlassBottle extends Item {

   public ItemGlassBottle() {
      this.a(CreativeModeTab.k);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      MovingObjectPosition var4 = this.a(var2, var3, true);
      if(var4 == null) {
         return var1;
      } else {
         if(var4.a == brv.b) {
            Location var5 = var4.a();
            if(!var2.a(var3, var5)) {
               return var1;
            }

            if(!var3.a(var5.a(var4.b), var4.b, var1)) {
               return var1;
            }

            if(var2.getData(var5).c().getMaterial() == Material.WATER) {
               --var1.count;
               var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
               if(var1.count <= 0) {
                  return new ItemStack(Items.POTION);
               }

               if(!var3.bg.a(new ItemStack(Items.POTION))) {
                  var3.a(new ItemStack(Items.POTION, 1, 0), false);
               }
            }
         }

         return var1;
      }
   }
}
