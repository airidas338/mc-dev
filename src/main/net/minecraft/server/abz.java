package net.minecraft.server;
import com.google.common.base.Predicate;

class abz implements Predicate {

   // $FF: synthetic field
   final EntityOcelot a;


   abz(EntityOcelot var1) {
      this.a = var1;
   }

   public boolean a(Entity var1) {
      return var1 instanceof EntityHuman;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((Entity)var1);
   }
}
