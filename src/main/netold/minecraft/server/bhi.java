package net.minecraft.server;
import java.util.Random;

public class bhi extends bhp {

   private auc a;


   public bhi(auc var1) {
      this.a = var1;
   }

   public boolean b(aqu var1, Random var2, dt var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         dt var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var5) && (!var1.t.o() || var5.o() < 255) && this.a.f(var1, var5, this.a.P())) {
            var1.a(var5, this.a.P(), 2);
         }
      }

      return true;
   }
}
