package net.minecraft.server;
import com.google.common.base.Predicate;
import java.util.Random;

public class avf extends atr {

   public static final beu a = beu.a("facing", (Predicate)en.a);
   public static final bet b = bet.a("open");
   public static final bev M = bev.a("hinge", avh.class);
   public static final bet N = bet.a("powered");
   public static final bev O = bev.a("half", avg.class);


   protected avf(bof var1) {
      super(var1);
      this.j(this.L.b().a(a, ej.c).a(b, Boolean.valueOf(false)).a(M, avh.a).a(N, Boolean.valueOf(false)).a(O, avg.b));
   }

   public boolean c() {
      return false;
   }

   public boolean b(ard var1, dt var2) {
      return g(e(var1, var2));
   }

   public boolean d() {
      return false;
   }

   public AxisAlignedBB a(World var1, dt var2, bec var3) {
      this.a(var1, var2);
      return super.a(var1, var2, var3);
   }

   public void a(ard var1, dt var2) {
      this.k(e(var1, var2));
   }

   private void k(int var1) {
      float var2 = 0.1875F;
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
      ej var3 = f(var1);
      boolean var4 = g(var1);
      boolean var5 = j(var1);
      if(var4) {
         if(var3 == ej.f) {
            if(!var5) {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            } else {
               this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            }
         } else if(var3 == ej.d) {
            if(!var5) {
               this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            }
         } else if(var3 == ej.e) {
            if(!var5) {
               this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
            } else {
               this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
            }
         } else if(var3 == ej.c) {
            if(!var5) {
               this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
            } else {
               this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
            }
         }
      } else if(var3 == ej.f) {
         this.a(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
      } else if(var3 == ej.d) {
         this.a(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
      } else if(var3 == ej.e) {
         this.a(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
      } else if(var3 == ej.c) {
         this.a(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
      }

   }

   public boolean a(World var1, dt var2, bec var3, EntityHuman var4, ej var5, float var6, float var7, float var8) {
      if(this.J == bof.f) {
         return true;
      } else {
         dt var9 = var3.b(O) == avg.b?var2:var2.b();
         bec var10 = var2.equals(var9)?var3:var1.p(var9);
         if(var10.c() != this) {
            return false;
         } else {
            var3 = var10.a(b);
            var1.a(var9, var3, 2);
            var1.b(var9, var2);
            var1.a(var4, ((Boolean)var3.b(b)).booleanValue()?1003:1006, var2, 0);
            return true;
         }
      }
   }

   public void a(World var1, dt var2, boolean var3) {
      bec var4 = var1.p(var2);
      if(var4.c() == this) {
         dt var5 = var4.b(O) == avg.b?var2:var2.b();
         bec var6 = var2 == var5?var4:var1.p(var5);
         if(var6.c() == this && ((Boolean)var6.b(b)).booleanValue() != var3) {
            var1.a(var5, var6.a(b, Boolean.valueOf(var3)), 2);
            var1.b(var5, var2);
            var1.a((EntityHuman)null, var3?1003:1006, var2, 0);
         }

      }
   }

   public void a(World var1, dt var2, bec var3, atr var4) {
      if(var3.b(O) == avg.a) {
         dt var5 = var2.b();
         bec var6 = var1.p(var5);
         if(var6.c() != this) {
            var1.g(var2);
         } else if(var4 != this) {
            this.a(var1, var5, var6, var4);
         }
      } else {
         boolean var9 = false;
         dt var10 = var2.a();
         bec var7 = var1.p(var10);
         if(var7.c() != this) {
            var1.g(var2);
            var9 = true;
         }

         if(!World.a((ard)var1, var2.b())) {
            var1.g(var2);
            var9 = true;
            if(var7.c() == this) {
               var1.g(var10);
            }
         }

         if(var9) {
            if(!var1.D) {
               this.b(var1, var2, var3, 0);
            }
         } else {
            boolean var8 = var1.z(var2) || var1.z(var10);
            if((var8 || var4.g()) && var4 != this && var8 != ((Boolean)var7.b(N)).booleanValue()) {
               var1.a(var10, var7.a(N, Boolean.valueOf(var8)), 2);
               if(var8 != ((Boolean)var3.b(b)).booleanValue()) {
                  var1.a(var2, var3.a(b, Boolean.valueOf(var8)), 2);
                  var1.b(var2, var2);
                  var1.a((EntityHuman)null, var8?1003:1006, var2, 0);
               }
            }
         }
      }

   }

   public alq a(bec var1, Random var2, int var3) {
      return var1.b(O) == avg.a?null:this.j();
   }

   public bru a(World var1, dt var2, ChunkCoordinates var3, ChunkCoordinates var4) {
      this.a(var1, var2);
      return super.a(var1, var2, var3, var4);
   }

   public boolean c(World var1, dt var2) {
      return var2.o() >= 255?false:World.a((ard)var1, var2.b()) && super.c(var1, var2) && super.c(var1, var2.a());
   }

   public int i() {
      return 1;
   }

   public static int e(ard var0, dt var1) {
      bec var2 = var0.p(var1);
      int var3 = var2.c().c(var2);
      boolean var4 = i(var3);
      bec var5 = var0.p(var1.b());
      int var6 = var5.c().c(var5);
      int var7 = var4?var6:var3;
      bec var8 = var0.p(var1.a());
      int var9 = var8.c().c(var8);
      int var10 = var4?var3:var9;
      boolean var11 = (var10 & 1) != 0;
      boolean var12 = (var10 & 2) != 0;
      return b(var7) | (var4?8:0) | (var11?16:0) | (var12?32:0);
   }

   private alq j() {
      return this == aty.aA?amk.aB:(this == aty.ap?amk.ar:(this == aty.aq?amk.as:(this == aty.ar?amk.at:(this == aty.as?amk.au:(this == aty.at?amk.av:amk.aq)))));
   }

   public void a(World var1, dt var2, bec var3, EntityHuman var4) {
      dt var5 = var2.b();
      if(var4.by.d && var3.b(O) == avg.a && var1.p(var5).c() == this) {
         var1.g(var5);
      }

   }

   public bec a(bec var1, ard var2, dt var3) {
      bec var4;
      if(var1.b(O) == avg.b) {
         var4 = var2.p(var3.a());
         if(var4.c() == this) {
            var1 = var1.a(M, var4.b(M)).a(N, var4.b(N));
         }
      } else {
         var4 = var2.p(var3.b());
         if(var4.c() == this) {
            var1 = var1.a(a, var4.b(a)).a(b, var4.b(b));
         }
      }

      return var1;
   }

   public bec a(int var1) {
      return (var1 & 8) > 0?this.P().a(O, avg.a).a(M, (var1 & 1) > 0?avh.b:avh.a).a(N, Boolean.valueOf((var1 & 2) > 0)):this.P().a(O, avg.b).a(a, ej.b(var1 & 3).f()).a(b, Boolean.valueOf((var1 & 4) > 0));
   }

   public int c(bec var1) {
      byte var2 = 0;
      int var3;
      if(var1.b(O) == avg.a) {
         var3 = var2 | 8;
         if(var1.b(M) == avh.b) {
            var3 |= 1;
         }

         if(((Boolean)var1.b(N)).booleanValue()) {
            var3 |= 2;
         }
      } else {
         var3 = var2 | ((ej)var1.b(a)).e().b();
         if(((Boolean)var1.b(b)).booleanValue()) {
            var3 |= 4;
         }
      }

      return var3;
   }

   protected static int b(int var0) {
      return var0 & 7;
   }

   public static boolean f(ard var0, dt var1) {
      return g(e(var0, var1));
   }

   public static ej h(ard var0, dt var1) {
      return f(e(var0, var1));
   }

   public static ej f(int var0) {
      return ej.b(var0 & 3).f();
   }

   protected static boolean g(int var0) {
      return (var0 & 4) != 0;
   }

   protected static boolean i(int var0) {
      return (var0 & 8) != 0;
   }

   protected static boolean j(int var0) {
      return (var0 & 16) != 0;
   }

   protected bed e() {
      return new bed(this, new bex[]{O, a, b, M, N});
   }

}
