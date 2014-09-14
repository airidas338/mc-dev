package net.minecraft.server;


public class alc extends Item {

   public alc() {
      this.h = 16;
      this.a(CreativeModeTab.f);
   }

   public ItemStack a(ItemStack var1, World var2, EntityHuman var3) {
      if(var3.by.canInstantlyBuild) {
         return var1;
      } else {
         --var1.b;
         var2.a((Entity)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
         if(!var2.D) {
            var2.d((Entity)(new EntityEnderPearl(var2, var3)));
         }

         var3.b(ty.J[Item.b((Item)this)]);
         return var1;
      }
   }
}
