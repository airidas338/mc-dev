package net.minecraft.server;
import com.google.common.base.Predicate;

public class bep implements Predicate {

   private final Block a;


   private bep(Block var1) {
      this.a = var1;
   }

   public static bep a(Block var0) {
      return new bep(var0);
   }

   public boolean a(IBlockData var1) {
      return var1 != null && var1.c() == this.a;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((IBlockData)var1);
   }
}
