package net.minecraft.server;
import java.util.Random;

public class ala extends alq {

   public boolean f_(amj var1) {
      return false;
   }

   public amx g(amj var1) {
      return this.h(var1).c() > 0?amx.b:super.g(var1);
   }

   public fv h(amj var1) {
      fn var2 = var1.o();
      return var2 != null && var2.b("StoredEnchantments", 9)?(fv)var2.a("StoredEnchantments"):new fv();
   }

   public void a(amj var1, apo var2) {
      fv var3 = this.h(var1);
      boolean var4 = true;

      for(int var5 = 0; var5 < var3.c(); ++var5) {
         fn var6 = var3.b(var5);
         if(var6.e("id") == var2.b.B) {
            if(var6.e("lvl") < var2.c) {
               var6.a("lvl", (short)var2.c);
            }

            var4 = false;
            break;
         }
      }

      if(var4) {
         fn var7 = new fn();
         var7.a("id", (short)var2.b.B);
         var7.a("lvl", (short)var2.c);
         var3.a((gd)var7);
      }

      if(!var1.n()) {
         var1.d(new fn());
      }

      var1.o().a("StoredEnchantments", (gd)var3);
   }

   public amj a(apo var1) {
      amj var2 = new amj(this);
      this.a(var2, var1);
      return var2;
   }

   public vl b(Random var1) {
      return this.a(var1, 1, 1, 1);
   }

   public vl a(Random var1, int var2, int var3, int var4) {
      amj var5 = new amj(amk.aL, 1, 0);
      aph.a(var1, var5, 30);
      return new vl(var5, var2, var3, var4);
   }
}
