package net.minecraft.server;
import java.util.Comparator;

public class aas implements Comparator {

   private final wv a;


   public aas(wv var1) {
      this.a = var1;
   }

   public int a(wv var1, wv var2) {
      double var3 = this.a.h(var1);
      double var5 = this.a.h(var2);
      return var3 < var5?-1:(var3 > var5?1:0);
   }

   // $FF: synthetic method
   public int compare(Object var1, Object var2) {
      return this.a((wv)var1, (wv)var2);
   }
}
