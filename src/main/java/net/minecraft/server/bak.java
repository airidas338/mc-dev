package net.minecraft.server;
import com.google.common.base.Predicate;

final class bak implements Predicate {

   public boolean a(bei var1) {
      return var1.a().c() == Blocks.SKULL && var1.b() instanceof TileEntitySkull && ((TileEntitySkull)var1.b()).c() == 1;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((bei)var1);
   }
}
