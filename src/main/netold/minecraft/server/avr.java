package net.minecraft.server;
import com.google.common.base.Predicate;
import java.util.Random;

public class avr extends atg {

   public static final beu a = beu.a("facing", (Predicate)en.a);


   protected avr() {
      super(bof.e);
      this.j(this.L.b().a(a, ej.c));
      this.a(akf.c);
      this.a(0.0625F, 0.0F, 0.0625F, 0.9375F, 0.875F, 0.9375F);
   }

   public boolean c() {
      return false;
   }

   public boolean d() {
      return false;
   }

   public int b() {
      return 2;
   }

   public alq a(bec var1, Random var2, int var3) {
      return alq.a(aty.Z);
   }

   public int a(Random var1) {
      return 8;
   }

   protected boolean G() {
      return true;
   }

   public bec a(aqu var1, dt var2, ej var3, float var4, float var5, float var6, int var7, xm var8) {
      return this.P().a(a, var8.aO().d());
   }

   public void a(aqu var1, dt var2, bec var3, xm var4, amj var5) {
      var1.a(var2, var3.a(a, var4.aO().d()), 2);
   }

   public boolean a(aqu var1, dt var2, bec var3, ahd var4, ej var5, float var6, float var7, float var8) {
      ajh var9 = var4.cn();
      bcm var10 = var1.s(var2);
      if(var9 != null && var10 instanceof bda) {
         if(var1.p(var2.a()).c().t()) {
            return true;
         } else if(var1.D) {
            return true;
         } else {
            var9.a((bda)var10);
            var4.a((vq)var9);
            return true;
         }
      } else {
         return true;
      }
   }

   public bcm a(aqu var1, int var2) {
      return new bda();
   }

   public bec a(int var1) {
      ej var2 = ej.a(var1);
      if(var2.k() == el.b) {
         var2 = ej.c;
      }

      return this.P().a(a, var2);
   }

   public int c(bec var1) {
      return ((ej)var1.b(a)).a();
   }

   protected bed e() {
      return new bed(this, new bex[]{a});
   }

}
