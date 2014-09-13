package net.minecraft.server;
import com.google.common.base.Function;

final class alt implements Function {

   public String a(ItemStack var1) {
      return EnumFlowerType.a(awc.b, var1.i()).d();
   }

   // $FF: synthetic method
   public Object apply(Object var1) {
      return this.a((ItemStack)var1);
   }
}
