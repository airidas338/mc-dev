package net.minecraft.server;
import java.util.Random;

public class bhs extends bhp {

   public boolean b(aqu var1, Random var2, dt var3) {
      for(int var4 = 0; var4 < 64; ++var4) {
         dt var5 = var3.a(var2.nextInt(8) - var2.nextInt(8), var2.nextInt(4) - var2.nextInt(4), var2.nextInt(8) - var2.nextInt(8));
         if(var1.d(var5) && var1.p(var5.b()).c() == aty.aV) {
            var1.a(var5, aty.ab.P(), 2);
         }
      }

      return true;
   }
}
