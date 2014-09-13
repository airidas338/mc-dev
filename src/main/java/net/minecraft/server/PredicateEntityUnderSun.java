package net.minecraft.server;
import com.google.common.base.Predicate;

class PredicateEntityUnderSun implements Predicate {

   // $FF: synthetic field
   final WorldServer a;


   PredicateEntityUnderSun(WorldServer var1) {
      this.a = var1;
   }

   public boolean a(EntityLiving var1) {
      return var1 != null && var1.isAlive() && this.a.i(var1.c());
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((EntityLiving)var1);
   }
}
