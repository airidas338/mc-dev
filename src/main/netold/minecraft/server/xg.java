package net.minecraft.server;
import com.google.common.base.Predicate;

final class xg implements Predicate {

   public boolean a(wv var1) {
      return var1.ai() && var1.l == null && var1.m == null;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((wv)var1);
   }
}
