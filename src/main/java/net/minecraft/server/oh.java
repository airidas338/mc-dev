package net.minecraft.server;

final class oh extends eg {

   private boolean b = true;


   protected amj b(dz var1, amj var2) {
      World var3 = var1.i();
      dt var4 = var1.d().a(ave.b(var1.f()));
      if(var3.d(var4)) {
         var3.a(var4, aty.ab.P());
         if(var2.a(1, var3.s)) {
            var2.b = 0;
         }
      } else if(var3.p(var4).c() == aty.W) {
         aty.W.d(var3, var4, aty.W.P().a(bbk.a, Boolean.valueOf(true)));
         var3.g(var4);
      } else {
         this.b = false;
      }

      return var2;
   }

   protected void a(dz var1) {
      if(this.b) {
         var1.i().b(1000, var1.d(), 0);
      } else {
         var1.i().b(1001, var1.d(), 0);
      }

   }
}
