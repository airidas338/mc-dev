package net.minecraft.server;


final class os extends eg {

   public amj b(dz var1, amj var2) {
      ej var3 = ave.b(var1.f());
      double var4 = var1.a() + (double)var3.g();
      double var6 = (double)((float)var1.d().o() + 0.2F);
      double var8 = var1.c() + (double)var3.i();
      Entity var10 = anl.a(var1.i(), var2.i(), var4, var6, var8);
      if(var10 instanceof xm && var2.s()) {
         ((xn)var10).a(var2.q());
      }

      var2.a(1);
      return var2;
   }
}
