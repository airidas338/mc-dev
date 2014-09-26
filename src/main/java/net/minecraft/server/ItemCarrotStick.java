package net.minecraft.server;


public class ItemCarrotStick extends Item {

   public ItemCarrotStick() {
      this.a(CreativeModeTab.e);
      this.c(1);
      this.d(25);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(var3.av() && var3.m instanceof EntityPig) {
         EntityPig var4 = (EntityPig)var3.m;
         if(var4.ck().h() && var1.j() - var1.getData() >= 7) {
            var4.ck().g();
            var1.damage(7, (EntityLiving)var3);
            if(var1.count == 0) {
               ItemStack var5 = new ItemStack(Items.aR);
               var5.setTag(var1.getTag());
               return var5;
            }
         }
      }

      var3.b(StatisticList.USE_ITEM_COUNT[Item.getId((Item)this)]);
      return var1;
   }
}
