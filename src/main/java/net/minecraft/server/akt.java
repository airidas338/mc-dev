package net.minecraft.server;

public class akt extends alq {

   private atr a;


   public akt(atr var1) {
      this.a = var1;
      this.a(akf.d);
   }

   public boolean a(amj var1, ahd var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
      if(var5 != ej.b) {
         return false;
      } else {
         bec var9 = var3.p(var4);
         atr var10 = var9.c();
         if(!var10.f(var3, var4)) {
            var4 = var4.a(var5);
         }

         if(!var2.a(var4, var5, var1)) {
            return false;
         } else if(!this.a.c(var3, var4)) {
            return false;
         } else {
            a(var3, var4, ej.a((double)var2.y), this.a);
            --var1.b;
            return true;
         }
      }
   }

   public static void a(World var0, dt var1, ej var2, atr var3) {
      dt var4 = var1.a(var2.e());
      dt var5 = var1.a(var2.f());
      int var6 = (var0.p(var5).c().t()?1:0) + (var0.p(var5.a()).c().t()?1:0);
      int var7 = (var0.p(var4).c().t()?1:0) + (var0.p(var4.a()).c().t()?1:0);
      boolean var8 = var0.p(var5).c() == var3 || var0.p(var5.a()).c() == var3;
      boolean var9 = var0.p(var4).c() == var3 || var0.p(var4.a()).c() == var3;
      boolean var10 = false;
      if(var8 && !var9 || var7 > var6) {
         var10 = true;
      }

      dt var11 = var1.a();
      bec var12 = var3.P().a(avf.a, var2).a(avf.M, var10?avh.b:avh.a);
      var0.a(var1, var12.a(avf.O, avg.b), 2);
      var0.a(var11, var12.a(avf.O, avg.a), 2);
      var0.c(var1, var3);
      var0.c(var11, var3);
   }
}
