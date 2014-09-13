package net.minecraft.server;

import com.google.common.base.Predicate;

final class PredicateAlive implements Predicate {

   public boolean a(Entity var1) {
      return var1.isAlive();
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((Entity)var1);
   }
}
