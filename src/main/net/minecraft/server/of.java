package net.minecraft.server;

final class of extends eg {

   private final eg b = new eg();


   public amj b(dz var1, amj var2) {
      akb var3 = (akb)var2.b();
      Location var4 = var1.d().a(ave.b(var1.f()));
      if(var3.a(var1.i(), var4)) {
         var2.a(Items.aw);
         var2.b = 1;
         return var2;
      } else {
         return this.b.a(var1, var2);
      }
   }
}
