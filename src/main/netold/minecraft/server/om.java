package net.minecraft.server;

final class om extends eg {

   protected amj b(dz var1, amj var2) {
      aqu var3 = var1.i();
      dt var4 = var1.d().a(ave.b(var1.f()));
      if(var3.d(var4)) {
         if(!var3.D) {
            bec var5 = aty.bX.P().a(auo.a, Boolean.valueOf(false));
            var3.a(var4, var5, 3);
            aju.a(var3, var4, var2);
            var3.c(var1.d(), var1.e());
         }

         --var2.b;
      }

      return var2;
   }

   protected void a(dz var1) {}

   protected void a(dz var1, ej var2) {}
}
