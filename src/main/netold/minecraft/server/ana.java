package net.minecraft.server;

public class ana extends alq {

   public ana() {
      this.h = 1;
      this.a(akf.e);
   }

   public boolean a(amj var1, ahd var2, xm var3) {
      if(var3 instanceof aca) {
         aca var4 = (aca)var3;
         if(!var4.cj() && !var4.i_()) {
            var4.l(true);
            var4.o.a((wv)var4, "mob.horse.leather", 0.5F, 1.0F);
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean a(amj var1, xm var2, xm var3) {
      this.a(var1, (ahd)null, var2);
      return true;
   }
}
