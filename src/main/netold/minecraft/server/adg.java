package net.minecraft.server;
import com.google.common.base.Predicate;

final class adg implements Predicate {

   public boolean a(wv var1) {
      return var1 instanceof xm && ((xm)var1).by() != xs.b;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((wv)var1);
   }
}
