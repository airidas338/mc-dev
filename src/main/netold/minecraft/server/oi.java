package net.minecraft.server;

final class oi extends eg {

   private boolean b = true;


   protected amj b(dz var1, amj var2) {
      if(akv.a == akv.a(var2.i())) {
         aqu var3 = var1.i();
         dt var4 = var1.d().a(ave.b(var1.f()));
         if(akw.a(var2, var3, var4)) {
            if(!var3.D) {
               var3.b(2005, var4, 0);
            }
         } else {
            this.b = false;
         }

         return var2;
      } else {
         return super.b(var1, var2);
      }
   }

   protected void a(dz var1) {
      if(this.b) {
         var1.i().b(1000, var1.d(), 0);
      } else {
         var1.i().b(1001, var1.d(), 0);
      }

   }
}
