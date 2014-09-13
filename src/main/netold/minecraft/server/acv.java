package net.minecraft.server;
import com.google.common.base.Predicate;

class acv implements Predicate {

   // $FF: synthetic field
   final acu a;


   acv(acu var1) {
      this.a = var1;
   }

   public boolean a(wv var1) {
      return var1 instanceof acl || var1 instanceof acb;
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((wv)var1);
   }
}
