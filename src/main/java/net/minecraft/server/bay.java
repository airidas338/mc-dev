package net.minecraft.server;
import com.google.common.base.Predicate;
import java.util.Iterator;
import java.util.Random;

public class bay extends auc implements atz {

   public static final bew a = bew.a("age", 0, 7);
   public static final beu b = beu.a("facing", (Predicate)(new baz()));
   private final Block M;


   protected bay(Block var1) {
      this.j(this.L.b().a(a, Integer.valueOf(0)).a(b, ej.b));
      this.M = var1;
      this.a(true);
      float var2 = 0.125F;
      this.a(0.5F - var2, 0.0F, 0.5F - var2, 0.5F + var2, 0.25F, 0.5F + var2);
      this.a((akf)null);
   }

   public IBlock a(IBlock var1, ard var2, Location var3) {
      var1 = var1.a(b, ej.b);
      Iterator var4 = en.a.iterator();

      while(var4.hasNext()) {
         ej var5 = (ej)var4.next();
         if(var2.p(var3.a(var5)).c() == this.M) {
            var1 = var1.a(b, var5);
            break;
         }
      }

      return var1;
   }

   protected boolean c(Block var1) {
      return var1 == aty.ak;
   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      super.b(var1, var2, var3, var4);
      if(var1.l(var2.a()) >= 9) {
         float var5 = auu.a(this, var1, var2);
         if(var4.nextInt((int)(25.0F / var5) + 1) == 0) {
            int var6 = ((Integer)var3.b(a)).intValue();
            if(var6 < 7) {
               var3 = var3.a(a, Integer.valueOf(var6 + 1));
               var1.a(var2, var3, 2);
            } else {
               Iterator var7 = en.a.iterator();

               while(var7.hasNext()) {
                  ej var8 = (ej)var7.next();
                  if(var1.p(var2.a(var8)).c() == this.M) {
                     return;
                  }
               }

               var2 = var2.a(en.a.a(var4));
               Block var9 = var1.p(var2.b()).c();
               if(var1.p(var2).c().J == Material.a && (var9 == aty.ak || var9 == aty.d || var9 == aty.c)) {
                  var1.a(var2, this.M.P());
               }
            }
         }

      }
   }

   public void g(World var1, Location var2, IBlock var3) {
      int var4 = ((Integer)var3.b(a)).intValue() + MathHelper.a(var1.s, 2, 5);
      var1.a(var2, var3.a(a, Integer.valueOf(Math.min(7, var4))), 2);
   }

   public void h() {
      float var1 = 0.125F;
      this.a(0.5F - var1, 0.0F, 0.5F - var1, 0.5F + var1, 0.25F, 0.5F + var1);
   }

   public void a(ard var1, Location var2) {
      this.F = (double)((float)(((Integer)var1.p(var2).b(a)).intValue() * 2 + 2) / 16.0F);
      float var3 = 0.125F;
      this.a(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, (float)this.F, 0.5F + var3);
   }

   public void a(World var1, Location var2, IBlock var3, float var4, int var5) {
      super.a(var1, var2, var3, var4, var5);
      if(!var1.D) {
         alq var6 = this.j();
         if(var6 != null) {
            int var7 = ((Integer)var3.b(a)).intValue();

            for(int var8 = 0; var8 < 3; ++var8) {
               if(var1.s.nextInt(15) <= var7) {
                  a(var1, var2, new amj(var6));
               }
            }

         }
      }
   }

   protected alq j() {
      return this.M == aty.aU?Items.bg:(this.M == aty.bk?Items.bh:null);
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return null;
   }

   public boolean a(World var1, Location var2, IBlock var3, boolean var4) {
      return ((Integer)var3.b(a)).intValue() != 7;
   }

   public boolean a(World var1, Random var2, Location var3, IBlock var4) {
      return true;
   }

   public void b(World var1, Random var2, Location var3, IBlock var4) {
      this.g(var1, var3, var4);
   }

   public IBlock a(int var1) {
      return this.P().a(a, Integer.valueOf(var1));
   }

   public int c(IBlock var1) {
      return ((Integer)var1.b(a)).intValue();
   }

   protected bed e() {
      return new bed(this, new bex[]{a, b});
   }

}
