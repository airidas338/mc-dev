package net.minecraft.server;
import com.google.common.base.Predicate;
import java.util.Iterator;

public class bbl extends atr {

   public static final beu a = beu.a("facing", (Predicate)(new bbm()));


   protected bbl() {
      super(bof.q);
      this.j(this.L.b().a(a, ej.b));
      this.a(true);
      this.a(akf.c);
   }

   public brt a(aqu var1, dt var2, bec var3) {
      return null;
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   private boolean d(aqu var1, dt var2) {
      if(aqu.a((ard)var1, var2)) {
         return true;
      } else {
         atr var3 = var1.p(var2).c();
         return var3 instanceof avv || var3 == aty.w || var3 == aty.bZ || var3 == aty.cG;
      }
   }

   public boolean c(aqu var1, dt var2) {
      Iterator var3 = a.c().iterator();

      ej var4;
      do {
         if(!var3.hasNext()) {
            return false;
         }

         var4 = (ej)var3.next();
      } while(!this.b(var1, var2, var4));

      return true;
   }

   private boolean b(aqu var1, dt var2, ej var3) {
      dt var4 = var2.a(var3.d());
      boolean var5 = var3.k().c();
      return var5 && var1.d(var4, true) || var3.equals(ej.b) && this.d(var1, var4);
   }

   public bec a(aqu var1, dt var2, ej var3, float var4, float var5, float var6, int var7, xm var8) {
      if(this.b(var1, var2, var3)) {
         return this.P().a(a, var3);
      } else {
         Iterator var9 = en.a.iterator();

         ej var10;
         do {
            if(!var9.hasNext()) {
               return this.P();
            }

            var10 = (ej)var9.next();
         } while(!var1.d(var2.a(var10.d()), true));

         return this.P().a(a, var10);
      }
   }

   public void c(aqu var1, dt var2, bec var3) {
      this.f(var1, var2, var3);
   }

   public void a(aqu var1, dt var2, bec var3, atr var4) {
      this.e(var1, var2, var3);
   }

   protected boolean e(aqu var1, dt var2, bec var3) {
      if(!this.f(var1, var2, var3)) {
         return true;
      } else {
         ej var4 = (ej)var3.b(a);
         el var5 = var4.k();
         ej var6 = var4.d();
         boolean var7 = false;
         if(var5.c() && !var1.d(var2.a(var6), true)) {
            var7 = true;
         } else if(var5.b() && !this.d(var1, var2.a(var6))) {
            var7 = true;
         }

         if(var7) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
            return true;
         } else {
            return false;
         }
      }
   }

   protected boolean f(aqu var1, dt var2, bec var3) {
      if(var3.c() == this && this.b(var1, var2, (ej)var3.b(a))) {
         return true;
      } else {
         if(var1.p(var2).c() == this) {
            this.b(var1, var2, var3, 0);
            var1.g(var2);
         }

         return false;
      }
   }

   public bru a(aqu var1, dt var2, brw var3, brw var4) {
      ej var5 = (ej)var1.p(var2).b(a);
      float var6 = 0.15F;
      if(var5 == ej.f) {
         this.a(0.0F, 0.2F, 0.5F - var6, var6 * 2.0F, 0.8F, 0.5F + var6);
      } else if(var5 == ej.e) {
         this.a(1.0F - var6 * 2.0F, 0.2F, 0.5F - var6, 1.0F, 0.8F, 0.5F + var6);
      } else if(var5 == ej.d) {
         this.a(0.5F - var6, 0.2F, 0.0F, 0.5F + var6, 0.8F, var6 * 2.0F);
      } else if(var5 == ej.c) {
         this.a(0.5F - var6, 0.2F, 1.0F - var6 * 2.0F, 0.5F + var6, 0.8F, 1.0F);
      } else {
         var6 = 0.1F;
         this.a(0.5F - var6, 0.0F, 0.5F - var6, 0.5F + var6, 0.6F, 0.5F + var6);
      }

      return super.a(var1, var2, var3, var4);
   }

   public bec a(int var1) {
      bec var2 = this.P();
      switch(var1) {
      case 1:
         var2 = var2.a(a, ej.f);
         break;
      case 2:
         var2 = var2.a(a, ej.e);
         break;
      case 3:
         var2 = var2.a(a, ej.d);
         break;
      case 4:
         var2 = var2.a(a, ej.c);
         break;
      case 5:
      default:
         var2 = var2.a(a, ej.b);
      }

      return var2;
   }

   public int c(bec var1) {
      byte var2 = 0;
      int var3;
      switch(bbn.a[((ej)var1.b(a)).ordinal()]) {
      case 1:
         var3 = var2 | 1;
         break;
      case 2:
         var3 = var2 | 2;
         break;
      case 3:
         var3 = var2 | 3;
         break;
      case 4:
         var3 = var2 | 4;
         break;
      case 5:
      case 6:
      default:
         var3 = var2 | 5;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
