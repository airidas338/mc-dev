package net.minecraft.server;


final class amq extends eg {

   private final eg b = new eg();


   public amj b(dz var1, amj var2) {
      ej var3 = ave.b(var1.f());
      World var4 = var1.i();
      double var5 = var1.a() + (double)var3.g() * 1.125D;
      double var7 = Math.floor(var1.b()) + (double)var3.h();
      double var9 = var1.c() + (double)var3.i() * 1.125D;
      Location var11 = var1.d().a(var3);
      IBlock var12 = var4.p(var11);
      atl var13 = var12.c() instanceof ati?(atl)var12.b(((ati)var12.c()).l()):atl.a;
      double var14;
      if(ati.d(var12)) {
         if(var13.c()) {
            var14 = 0.6D;
         } else {
            var14 = 0.1D;
         }
      } else {
         if(var12.c().r() != Material.a || !ati.d(var4.p(var11.b()))) {
            return this.b.a(var1, var2);
         }

         IBlock var16 = var4.p(var11.b());
         atl var17 = var16.c() instanceof ati?(atl)var16.b(((ati)var16.c()).l()):atl.a;
         if(var3 != ej.a && var17.c()) {
            var14 = -0.4D;
         } else {
            var14 = -0.9D;
         }
      }

      EntityMinecartAbstract var18 = EntityMinecartAbstract.a(var4, var5, var7 + var14, var9, amp.a((amp)var2.b()));
      if(var2.s()) {
         var18.a(var2.q());
      }

      var4.d((Entity)var18);
      var2.a(1);
      return var2;
   }

   protected void a(dz var1) {
      var1.i().b(1000, var1.d(), 0);
   }
}
