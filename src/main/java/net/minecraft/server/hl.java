package net.minecraft.server;
import com.google.common.base.Function;

final class hl implements Function {

   public IChatBaseComponent a(IChatBaseComponent var1) {
      IChatBaseComponent var2 = var1.f();
      var2.setChatModifier(var2.getChatModifier().n());
      return var2;
   }

   // $FF: synthetic method
   public Object apply(Object var1) {
      return this.a((IChatBaseComponent)var1);
   }
}
