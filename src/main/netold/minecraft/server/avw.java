package net.minecraft.server;

public class avw extends avb {

   public static final bet a = bet.a("open");
   public static final bet b = bet.a("powered");
   public static final bet M = bet.a("in_wall");


   public avw() {
      super(bof.d);
      this.j(this.L.b().a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false)));
      this.a(akf.d);
   }

   public bec a(bec var1, ard var2, dt var3) {
      el var4 = ((ej)var1.b(N)).k();
      if(var4 == el.c && (var2.p(var3.e()).c() == aty.bZ || var2.p(var3.f()).c() == aty.bZ) || var4 == el.a && (var2.p(var3.c()).c() == aty.bZ || var2.p(var3.d()).c() == aty.bZ)) {
         var1 = var1.a(M, Boolean.valueOf(true));
      }

      return var1;
   }

   public boolean c(aqu var1, dt var2) {
      return var1.p(var2.b()).c().r().a()?super.c(var1, var2):false;
   }

   public brt a(aqu var1, dt var2, bec var3) {
      if(((Boolean)var3.b(a)).booleanValue()) {
         return null;
      } else {
         el var4 = ((ej)var3.b(N)).k();
         return var4 == el.c?new brt((double)var2.n(), (double)var2.o(), (double)((float)var2.p() + 0.375F), (double)(var2.n() + 1), (double)((float)var2.o() + 1.5F), (double)((float)var2.p() + 0.625F)):new brt((double)((float)var2.n() + 0.375F), (double)var2.o(), (double)var2.p(), (double)((float)var2.n() + 0.625F), (double)((float)var2.o() + 1.5F), (double)(var2.p() + 1));
      }
   }

   public void a(ard var1, dt var2) {
      el var3 = ((ej)var1.p(var2).b(N)).k();
      if(var3 == el.c) {
         this.a(0.0F, 0.0F, 0.375F, 1.0F, 1.0F, 0.625F);
      } else {
         this.a(0.375F, 0.0F, 0.0F, 0.625F, 1.0F, 1.0F);
      }

   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public boolean b(ard var1, dt var2) {
      return ((Boolean)var1.p(var2).b(a)).booleanValue();
   }

   public bec a(aqu var1, dt var2, ej var3, float var4, float var5, float var6, int var7, xm var8) {
      return this.P().a(N, var8.aO()).a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)).a(M, Boolean.valueOf(false));
   }

   public boolean a(aqu var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
      if(((Boolean)var3.b(a)).booleanValue()) {
         var3 = var3.a(a, Boolean.valueOf(false));
         var1.a(var2, var3, 2);
      } else {
         ej var9 = ej.a((double)var4.y);
         if(var3.b(N) == var9.d()) {
            var3 = var3.a(N, var9);
         }

         var3 = var3.a(a, Boolean.valueOf(true));
         var1.a(var2, var3, 2);
      }

      var1.a(var4, ((Boolean)var3.b(a)).booleanValue()?1003:1006, var2, 0);
      return true;
   }

   public void a(aqu var1, dt var2, bec var3, atr var4) {
      if(!var1.D) {
         boolean var5 = var1.z(var2);
         if(var5 || var4.g()) {
            if(var5 && !((Boolean)var3.b(a)).booleanValue() && !((Boolean)var3.b(b)).booleanValue()) {
               var1.a(var2, var3.a(a, Boolean.valueOf(true)).a(b, Boolean.valueOf(true)), 2);
               var1.a((ahd)null, 1003, var2, 0);
            } else if(!var5 && ((Boolean)var3.b(a)).booleanValue() && ((Boolean)var3.b(b)).booleanValue()) {
               var1.a(var2, var3.a(a, Boolean.valueOf(false)).a(b, Boolean.valueOf(false)), 2);
               var1.a((ahd)null, 1006, var2, 0);
            } else if(var5 != ((Boolean)var3.b(b)).booleanValue()) {
               var1.a(var2, var3.a(b, Boolean.valueOf(var5)), 2);
            }
         }

      }
   }

   public bec a(int var1) {
      return this.P().a(N, ej.b(var1)).a(a, Boolean.valueOf((var1 & 4) != 0)).a(b, Boolean.valueOf((var1 & 8) != 0));
   }

   public int c(bec var1) {
      byte var2 = 0;
      int var3 = var2 | ((ej)var1.b(N)).b();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 8;
      }

      if(((Boolean)var1.b(a)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{N, a, b, M});
   }

}
