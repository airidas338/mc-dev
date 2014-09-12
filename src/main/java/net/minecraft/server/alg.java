package net.minecraft.server;


public class alg extends alq {

   public boolean a(amj var1, EntityHuman var2, World var3, dt var4, ej var5, float var6, float var7, float var8) {
      if(!var3.D) {
         EntityFireworks var9 = new EntityFireworks(var3, (double)((float)var4.n() + var6), (double)((float)var4.o() + var7), (double)((float)var4.p() + var8), var1);
         var3.d((Entity)var9);
         if(!var2.by.d) {
            --var1.b;
         }

         return true;
      } else {
         return false;
      }
   }
}
