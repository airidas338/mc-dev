package net.minecraft.server;
import java.util.Random;

public class bis extends bhp {

   public boolean b(aqu var1, Random var2, dt var3) {
      for(; var3.o() < 128; var3 = var3.a()) {
         if(var1.d(var3)) {
            ej[] var4 = en.a.a();
            int var5 = var4.length;

            for(int var6 = 0; var6 < var5; ++var6) {
               ej var7 = var4[var6];
               if(aty.bn.a(var1, var3, var7)) {
                  bec var8 = aty.bn.P().a(bbv.b, Boolean.valueOf(var7 == ej.c)).a(bbv.M, Boolean.valueOf(var7 == ej.f)).a(bbv.N, Boolean.valueOf(var7 == ej.d)).a(bbv.O, Boolean.valueOf(var7 == ej.e));
                  var1.a(var3, var8, 2);
                  break;
               }
            }
         } else {
            var3 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         }
      }

      return true;
   }
}
