package net.minecraft.server;


public class ItemSaddle extends Item {

   public ItemSaddle() {
      this.maxStackSize = 1;
      this.a(CreativeModeTab.e);
   }

   public boolean a(ItemStack var1, EntityHuman var2, EntityLiving var3) {
      if(var3 instanceof EntityPig) {
         EntityPig var4 = (EntityPig)var3;
         if(!var4.cj() && !var4.i_()) {
            var4.l(true);
            var4.o.makeSound((Entity)var4, "mob.horse.leather", 0.5F, 1.0F);
            --var1.count;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean a(ItemStack var1, EntityLiving var2, EntityLiving var3) {
      this.a(var1, (EntityHuman)null, var2);
      return true;
   }
}
