package net.minecraft.server;
import com.google.common.base.Predicate;

class auq implements Predicate {

   // $FF: synthetic field
   final ej a;
   // $FF: synthetic field
   final aup b;


   auq(aup var1, ej var2) {
      this.b = var1;
      this.a = var2;
   }

   public boolean a(wv var1) {
      return var1 != null && var1.aO() == this.a;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((wv)var1);
   }
}
