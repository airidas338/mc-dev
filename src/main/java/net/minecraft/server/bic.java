package net.minecraft.server;
import java.util.Random;

public abstract class bic extends bhc {

   protected final int a;
   protected final int b;
   protected final int c;
   protected int d;


   public bic(boolean var1, int var2, int var3, int var4, int var5) {
      super(var1);
      this.a = var2;
      this.d = var3;
      this.b = var4;
      this.c = var5;
   }

   protected int a(Random var1) {
      int var2 = var1.nextInt(3) + this.a;
      if(this.d > 1) {
         var2 += var1.nextInt(this.d);
      }

      return var2;
   }

   private boolean c(World var1, dt var2, int var3) {
      boolean var4 = true;
      if(var2.o() >= 1 && var2.o() + var3 + 1 <= 256) {
         for(int var5 = 0; var5 <= 1 + var3; ++var5) {
            byte var6 = 2;
            if(var5 == 0) {
               var6 = 1;
            } else if(var5 >= 1 + var3 - 2) {
               var6 = 2;
            }

            for(int var7 = -var6; var7 <= var6 && var4; ++var7) {
               for(int var8 = -var6; var8 <= var6 && var4; ++var8) {
                  if(var2.o() + var5 < 0 || var2.o() + var5 >= 256 || !this.a(var1.p(var2.a(var7, var5, var8)).c())) {
                     var4 = false;
                  }
               }
            }
         }

         return var4;
      } else {
         return false;
      }
   }

   private boolean a(dt var1, World var2) {
      dt var3 = var1.b();
      atr var4 = var2.p(var3).c();
      if((var4 == aty.c || var4 == aty.d) && var1.o() >= 2) {
         this.a(var2, var3);
         this.a(var2, var3.f());
         this.a(var2, var3.d());
         this.a(var2, var3.d().f());
         return true;
      } else {
         return false;
      }
   }

   protected boolean a(World var1, Random var2, dt var3, int var4) {
      return this.c(var1, var3, var4) && this.a(var3, var1);
   }

   protected void a(World var1, dt var2, int var3) {
      int var4 = var3 * var3;

      for(int var5 = -var3; var5 <= var3 + 1; ++var5) {
         for(int var6 = -var3; var6 <= var3 + 1; ++var6) {
            int var7 = var5 - 1;
            int var8 = var6 - 1;
            if(var5 * var5 + var6 * var6 <= var4 || var7 * var7 + var8 * var8 <= var4 || var5 * var5 + var8 * var8 <= var4 || var7 * var7 + var6 * var6 <= var4) {
               dt var9 = var2.a(var5, 0, var6);
               bof var10 = var1.p(var9).c().r();
               if(var10 == bof.a || var10 == bof.j) {
                  this.a(var1, var9, aty.t, this.c);
               }
            }
         }
      }

   }

   protected void b(World var1, dt var2, int var3) {
      int var4 = var3 * var3;

      for(int var5 = -var3; var5 <= var3; ++var5) {
         for(int var6 = -var3; var6 <= var3; ++var6) {
            if(var5 * var5 + var6 * var6 <= var4) {
               dt var7 = var2.a(var5, 0, var6);
               bof var8 = var1.p(var7).c().r();
               if(var8 == bof.a || var8 == bof.j) {
                  this.a(var1, var7, aty.t, this.c);
               }
            }
         }
      }

   }
}
