package net.minecraft.server;
import com.google.common.base.Predicate;

class qu implements Predicate {

   // $FF: synthetic field
   final qt a;


   qu(qt var1) {
      this.a = var1;
   }

   public boolean a(xm var1) {
      return var1 != null && var1.ai() && this.a.i(var1.c());
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((xm)var1);
   }
}
