package net.minecraft.server;
import com.google.common.base.Predicate;

final class adg implements Predicate {

   public boolean a(Entity var1) {
      return var1 instanceof EntityLiving && ((EntityLiving)var1).by() != xs.b;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((Entity)var1);
   }
}
