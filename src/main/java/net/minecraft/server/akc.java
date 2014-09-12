package net.minecraft.server;


public class akc extends alq {

   public akc() {
      this.a(akf.e);
      this.c(1);
      this.d(25);
   }

   public amj a(amj var1, World var2, EntityHuman var3) {
      if(var3.av() && var3.m instanceof EntityPig) {
         EntityPig var4 = (EntityPig)var3.m;
         if(var4.ck().h() && var1.j() - var1.i() >= 7) {
            var4.ck().g();
            var1.a(7, (EntityLiving)var3);
            if(var1.b == 0) {
               amj var5 = new amj(Items.aR);
               var5.d(var1.o());
               return var5;
            }
         }
      }

      var3.b(ty.J[alq.b((alq)this)]);
      return var1;
   }
}
