package net.minecraft.server;
import com.google.common.base.Predicate;

final class xh implements Predicate {

   public boolean a(wv var1) {
      return var1 instanceof vq && var1.ai();
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((wv)var1);
   }
}
