package net.minecraft.server;
import com.google.common.base.Predicate;

final class baz implements Predicate {

   public boolean a(EnumFacing var1) {
      return var1 != EnumFacing.DOWN;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((EnumFacing)var1);
   }
}
