package net.minecraft.server;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class avn extends axl {

   int a;


   protected avn(Material var1) {
      super(var1);
   }

   private void f(World var1, Location var2, IBlock var3) {
      var1.a(var2, b(this.J).P().a(b, var3.b(b)), 2);
   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      int var5 = ((Integer)var3.b(b)).intValue();
      byte var6 = 1;
      if(this.J == Material.i && !var1.t.n()) {
         var6 = 2;
      }

      int var7 = this.a(var1);
      int var15;
      if(var5 > 0) {
         int var8 = -100;
         this.a = 0;

         ej var10;
         for(Iterator var9 = en.a.iterator(); var9.hasNext(); var8 = this.a(var1, var2.a(var10), var8)) {
            var10 = (ej)var9.next();
         }

         int var14 = var8 + var6;
         if(var14 >= 8 || var8 < 0) {
            var14 = -1;
         }

         if(this.e((ard)var1, var2.a()) >= 0) {
            var15 = this.e((ard)var1, var2.a());
            if(var15 >= 8) {
               var14 = var15;
            } else {
               var14 = var15 + 8;
            }
         }

         if(this.a >= 2 && this.J == Material.h) {
            IBlock var16 = var1.p(var2.b());
            if(var16.c().r().a()) {
               var14 = 0;
            } else if(var16.c().r() == this.J && ((Integer)var16.b(b)).intValue() == 0) {
               var14 = 0;
            }
         }

         if(this.J == Material.i && var5 < 8 && var14 < 8 && var14 > var5 && var4.nextInt(4) != 0) {
            var7 *= 4;
         }

         if(var14 == var5) {
            this.f(var1, var2, var3);
         } else {
            var5 = var14;
            if(var14 < 0) {
               var1.g(var2);
            } else {
               var3 = var3.a(b, Integer.valueOf(var14));
               var1.a(var2, var3, 2);
               var1.a(var2, (Block)this, var7);
               var1.c(var2, (Block)this);
            }
         }
      } else {
         this.f(var1, var2, var3);
      }

      IBlock var13 = var1.p(var2.b());
      if(this.h(var1, var2.b(), var13)) {
         if(this.J == Material.i && var1.p(var2.b()).c().r() == Material.h) {
            var1.a(var2.b(), aty.b.P());
            this.d(var1, var2.b());
            return;
         }

         if(var5 >= 8) {
            this.a(var1, var2.b(), var13, var5);
         } else {
            this.a(var1, var2.b(), var13, var5 + 8);
         }
      } else if(var5 >= 0 && (var5 == 0 || this.g(var1, var2.b(), var13))) {
         Set var17 = this.e(var1, var2);
         var15 = var5 + var6;
         if(var5 >= 8) {
            var15 = 1;
         }

         if(var15 >= 8) {
            return;
         }

         Iterator var11 = var17.iterator();

         while(var11.hasNext()) {
            ej var12 = (ej)var11.next();
            this.a(var1, var2.a(var12), var1.p(var2.a(var12)), var15);
         }
      }

   }

   private void a(World var1, Location var2, IBlock var3, int var4) {
      if(this.h(var1, var2, var3)) {
         if(var3.c() != aty.a) {
            if(this.J == Material.i) {
               this.d(var1, var2);
            } else {
               var3.c().b(var1, var2, var3, 0);
            }
         }

         var1.a(var2, this.P().a(b, Integer.valueOf(var4)), 3);
      }

   }

   private int a(World var1, Location var2, int var3, ej var4) {
      int var5 = 1000;
      Iterator var6 = en.a.iterator();

      while(var6.hasNext()) {
         ej var7 = (ej)var6.next();
         if(var7 != var4) {
            Location var8 = var2.a(var7);
            IBlock var9 = var1.p(var8);
            if(!this.g(var1, var8, var9) && (var9.c().r() != this.J || ((Integer)var9.b(b)).intValue() > 0)) {
               if(!this.g(var1, var8.b(), var9)) {
                  return var3;
               }

               if(var3 < 4) {
                  int var10 = this.a(var1, var8, var3 + 1, var7.d());
                  if(var10 < var5) {
                     var5 = var10;
                  }
               }
            }
         }
      }

      return var5;
   }

   private Set e(World var1, Location var2) {
      int var3 = 1000;
      EnumSet var4 = EnumSet.noneOf(ej.class);
      Iterator var5 = en.a.iterator();

      while(var5.hasNext()) {
         ej var6 = (ej)var5.next();
         Location var7 = var2.a(var6);
         IBlock var8 = var1.p(var7);
         if(!this.g(var1, var7, var8) && (var8.c().r() != this.J || ((Integer)var8.b(b)).intValue() > 0)) {
            int var9;
            if(this.g(var1, var7.b(), var1.p(var7.b()))) {
               var9 = this.a(var1, var7, 1, var6.d());
            } else {
               var9 = 0;
            }

            if(var9 < var3) {
               var4.clear();
            }

            if(var9 <= var3) {
               var4.add(var6);
               var3 = var9;
            }
         }
      }

      return var4;
   }

   private boolean g(World var1, Location var2, IBlock var3) {
      Block var4 = var1.p(var2).c();
      return !(var4 instanceof avf) && var4 != aty.an && var4 != aty.au && var4 != aty.aM?(var4.J == Material.E?true:var4.J.c()):true;
   }

   protected int a(World var1, Location var2, int var3) {
      int var4 = this.e((ard)var1, var2);
      if(var4 < 0) {
         return var3;
      } else {
         if(var4 == 0) {
            ++this.a;
         }

         if(var4 >= 8) {
            var4 = 0;
         }

         return var3 >= 0 && var4 >= var3?var3:var4;
      }
   }

   private boolean h(World var1, Location var2, IBlock var3) {
      Material var4 = var3.c().r();
      return var4 != this.J && var4 != Material.i && !this.g(var1, var2, var3);
   }

   public void c(World var1, Location var2, IBlock var3) {
      if(!this.e(var1, var2, var3)) {
         var1.a(var2, (Block)this, this.a(var1));
      }

   }
}
