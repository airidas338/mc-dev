package net.minecraft.server;

public class alc extends alq {

   public alc() {
      this.h = 16;
      this.a(akf.f);
   }

   public amj a(amj var1, aqu var2, ahd var3) {
      if(var3.by.d) {
         return var1;
      } else {
         --var1.b;
         var2.a((wv)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
         if(!var2.D) {
            var2.d((wv)(new aht(var2, var3)));
         }

         var3.b(ty.J[alq.b((alq)this)]);
         return var1;
      }
   }
}
