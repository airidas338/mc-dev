package net.minecraft.server;
import com.google.common.base.Predicate;
import java.util.List;
import java.util.Random;

public class avq extends atr {

   public static final beu a = beu.a("facing", (Predicate)en.a);
   public static final bet b = bet.a("eye");


   public avq() {
      super(bof.e);
      this.j(this.L.b().a(a, ej.c).a(b, Boolean.valueOf(false)));
   }

   public boolean c() {
      return false;
   }

   public void h() {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
   }

   public void a(aqu var1, dt var2, bec var3, brt var4, List var5, wv var6) {
      this.a(0.0F, 0.0F, 0.0F, 1.0F, 0.8125F, 1.0F);
      super.a(var1, var2, var3, var4, var5, var6);
      if(((Boolean)var1.p(var2).b(b)).booleanValue()) {
         this.a(0.3125F, 0.8125F, 0.3125F, 0.6875F, 1.0F, 0.6875F);
         super.a(var1, var2, var3, var4, var5, var6);
      }

      this.h();
   }

   public alq a(bec var1, Random var2, int var3) {
      return null;
   }

   public bec a(aqu var1, dt var2, ej var3, float var4, float var5, float var6, int var7, xm var8) {
      return this.P().a(a, var8.aO().d()).a(b, Boolean.valueOf(false));
   }

   public boolean N() {
      return true;
   }

   public int l(aqu var1, dt var2) {
      return ((Boolean)var1.p(var2).b(b)).booleanValue()?15:0;
   }

   public bec a(int var1) {
      return this.P().a(b, Boolean.valueOf((var1 & 4) != 0)).a(a, ej.b(var1 & 3));
   }

   public int c(bec var1) {
      byte var2 = 0;
      int var3 = var2 | ((ej)var1.b(a)).b();
      if(((Boolean)var1.b(b)).booleanValue()) {
         var3 |= 4;
      }

      return var3;
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b});
   }

}
