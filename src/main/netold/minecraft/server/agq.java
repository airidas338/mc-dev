package net.minecraft.server;
import com.google.common.base.Predicate;

class agq implements Predicate {

   // $FF: synthetic field
   final agp a;


   agq(agp var1) {
      this.a = var1;
   }

   public boolean a(wv var1) {
      return var1 instanceof agj;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((wv)var1);
   }
}
