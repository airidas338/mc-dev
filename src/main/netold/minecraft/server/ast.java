package net.minecraft.server;
import java.util.Random;

public class ast extends arm {

   protected ast(int var1) {
      super(var1);
      this.as.A = 2;
      this.as.B = 1;
      this.as.D = 1;
      this.as.E = 8;
      this.as.F = 10;
      this.as.J = 1;
      this.as.z = 4;
      this.as.I = 0;
      this.as.H = 0;
      this.as.C = 5;
      this.ar = 14745518;
      this.at.add(new arq(afy.class, 1, 1, 1));
   }

   public bhc a(Random var1) {
      return this.aC;
   }

   public awa a(Random var1, dt var2) {
      return awa.c;
   }

   public void a(aqu var1, Random var2, bgk var3, int var4, int var5, double var6) {
      double var8 = af.a((double)var4 * 0.25D, (double)var5 * 0.25D);
      if(var8 > 0.0D) {
         int var10 = var4 & 15;
         int var11 = var5 & 15;

         for(int var12 = 255; var12 >= 0; --var12) {
            if(var3.a(var11, var12, var10).c().r() != bof.a) {
               if(var12 == 62 && var3.a(var11, var12, var10).c() != aty.j) {
                  var3.a(var11, var12, var10, aty.j.P());
                  if(var8 < 0.12D) {
                     var3.a(var11, var12 + 1, var10, aty.bx.P());
                  }
               }
               break;
            }
         }
      }

      this.b(var1, var2, var3, var4, var5, var6);
   }
}
