package net.minecraft.server;
import com.google.common.base.Predicate;

final class am implements Predicate {

   public boolean a(Entity var1) {
      return var1 instanceof EntityHuman;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((Entity)var1);
   }
}
