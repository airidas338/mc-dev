package net.minecraft.server;

public class aky extends alq {

   public aky() {
      this.h = 16;
      this.a(akf.l);
   }

   public amj a(amj var1, aqu var2, ahd var3) {
      if(!var3.by.d) {
         --var1.b;
      }

      var2.a((wv)var3, "random.bow", 0.5F, 0.4F / (g.nextFloat() * 0.4F + 0.8F));
      if(!var2.D) {
         var2.d((wv)(new ahs(var2, var3)));
      }

      var3.b(ty.J[alq.b((alq)this)]);
      return var1;
   }
}
