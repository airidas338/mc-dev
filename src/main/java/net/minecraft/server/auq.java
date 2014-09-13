package net.minecraft.server;
import com.google.common.base.Predicate;

class auq implements Predicate {

   // $FF: synthetic field
   final EnumFacing a;
   // $FF: synthetic field
   final BlockRedstoneComparator b;


   auq(BlockRedstoneComparator var1, EnumFacing var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean a(Entity var1) {
      return var1 != null && var1.aO() == this.a;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((Entity)var1);
   }
}
