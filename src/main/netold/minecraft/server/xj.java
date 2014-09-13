package net.minecraft.server;
import com.google.common.base.Predicate;

public class xj implements Predicate {

   private final amj a;


   public xj(amj var1) {
      this.a = var1;
   }

   public boolean a(wv var1) {
      if(!var1.ai()) {
         return false;
      } else if(!(var1 instanceof xm)) {
         return false;
      } else {
         xm var2 = (xm)var1;
         return var2.p(xn.c(this.a)) != null?false:(var2 instanceof xn?((xn)var2).bX():(var2 instanceof adi?true:var2 instanceof ahd));
      }
   }

   // $FF: synthetic method
   public boolean apply(Object var1) {
      return this.a((wv)var1);
   }
}
