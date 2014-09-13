package net.minecraft.server;

import com.google.common.base.Predicate;

final class PredicateSingluarAliveEntity implements Predicate {

   public boolean a(Entity var1) {
      return var1.isAlive() && var1.l == null && var1.m == null;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((Entity)var1);
   }
}
