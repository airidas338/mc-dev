package net.minecraft.server;
import com.google.common.base.Predicates;
import java.util.List;

final class ajo extends eg {

   protected amj b(dz var1, amj var2) {
      dt var3 = var1.d().a(ave.b(var1.f()));
      int var4 = var3.n();
      int var5 = var3.o();
      int var6 = var3.p();
      brt var7 = new brt((double)var4, (double)var5, (double)var6, (double)(var4 + 1), (double)(var5 + 1), (double)(var6 + 1));
      List var8 = var1.i().a(xm.class, var7, Predicates.and(xe.d, new xj(var2)));
      if(var8.size() > 0) {
         xm var9 = (xm)var8.get(0);
         int var10 = var9 instanceof ahd?1:0;
         int var11 = xn.c(var2);
         amj var12 = var2.k();
         var12.b = 1;
         var9.c(var11 - var10, var12);
         if(var9 instanceof xn) {
            ((xn)var9).a(var11, 2.0F);
         }

         --var2.b;
         return var2;
      } else {
         return super.b(var1, var2);
      }
   }
}
