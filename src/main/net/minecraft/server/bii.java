package net.minecraft.server;
import java.util.Random;

public class bii extends bhp {

   public boolean generate(World var1, Random var2, Location var3) {
      for(int var4 = 0; var4 < 20; ++var4) {
         Location var5 = var3.a(var2.nextInt(4) - var2.nextInt(4), 0, var2.nextInt(4) - var2.nextInt(4));
         if(var1.d(var5)) {
            Location var6 = var5.b();
            if(var1.p(var6.e()).c().r() == Material.h || var1.p(var6.f()).c().r() == Material.h || var1.p(var6.c()).c().r() == Material.h || var1.p(var6.d()).c().r() == Material.h) {
               int var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

               for(int var8 = 0; var8 < var7; ++var8) {
                  if(aty.aM.d(var1, var5)) {
                     var1.a(var5.b(var8), aty.aM.P(), 2);
                  }
               }
            }
         }
      }

      return true;
   }
}