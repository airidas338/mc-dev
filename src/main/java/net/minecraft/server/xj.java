package net.minecraft.server;

import com.google.common.base.Predicate;

public class xj implements Predicate {

   private final ItemStack a;


   public xj(ItemStack var1) {
      this.a = var1;
   }

   public boolean a(Entity var1) {
      if(!var1.isAlive()) {
         return false;
      } else if(!(var1 instanceof EntityLiving)) {
         return false;
      } else {
         EntityLiving var2 = (EntityLiving)var1;
         return var2.p(EntityInsentient.c(this.a)) != null?false:(var2 instanceof EntityInsentient?((EntityInsentient)var2).bX():(var2 instanceof EntityArmorStand?true:var2 instanceof EntityHuman));
      }
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((Entity)var1);
   }
}
