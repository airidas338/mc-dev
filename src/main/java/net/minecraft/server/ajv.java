package net.minecraft.server;


public class ajv extends Item {

   private Block a;


   public ajv(Block var1) {
      this.a = var1;
   }

   public boolean a(amj var1, EntityHuman var2, World var3, Location var4, ej var5, float var6, float var7, float var8) {
      IBlock var9 = var3.getData(var4);
      Block var10 = var9.c();
      if(var10 == aty.aH && ((Integer)var9.b(BlockSnow.a)).intValue() < 1) {
         var5 = ej.b;
      } else if(!var10.f(var3, var4)) {
         var4 = var4.a(var5);
      }

      if(!var2.a(var4, var5, var1)) {
         return false;
      } else if(var1.b == 0) {
         return false;
      } else {
         if(var3.a(this.a, var4, false, var5, (Entity)null, var1)) {
            IBlock var11 = this.a.a(var3, var4, var5, var6, var7, var8, 0, var2);
            if(var3.a(var4, var11, 3)) {
               var11 = var3.getData(var4);
               if(var11.c() == this.a) {
                  aju.a(var3, var4, var1);
                  var11.c().a(var3, var4, var11, (EntityLiving)var2, var1);
               }

               var3.a((double)((float)var4.n() + 0.5F), (double)((float)var4.o() + 0.5F), (double)((float)var4.p() + 0.5F), this.a.H.b(), (this.a.H.d() + 1.0F) / 2.0F, this.a.H.e() * 0.8F);
               --var1.b;
               return true;
            }
         }

         return false;
      }
   }
}
