package net.minecraft.server;
import com.google.common.base.Predicate;

final class xi implements Predicate {

   public boolean a(wv var1) {
      return !(var1 instanceof ahd) || !((ahd)var1).v();
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((wv)var1);
   }
}
