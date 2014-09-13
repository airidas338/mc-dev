package net.minecraft.server;

public class azk extends avb {

   private bek a;
   private bek b;
   private bek M;
   private bek O;


   protected azk() {
      super(bof.C);
      this.j(this.L.b().a(N, ej.c));
      this.a(true);
      this.a(akf.b);
   }

   public void c(aqu var1, dt var2, bec var3) {
      super.c(var1, var2, var3);
      this.e(var1, var2);
   }

   public boolean d(aqu var1, dt var2) {
      return this.j().a(var1, var2) != null || this.S().a(var1, var2) != null;
   }

   private void e(aqu var1, dt var2) {
      bem var3;
      int var4;
      int var6;
      if((var3 = this.l().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.l().b(); ++var4) {
            bei var5 = var3.a(0, var4, 0);
            var1.a(var5.d(), aty.a.P(), 2);
         }

         acn var9 = new acn(var1);
         dt var10 = var3.a(0, 2, 0).d();
         var9.b((double)var10.n() + 0.5D, (double)var10.o() + 0.05D, (double)var10.p() + 0.5D, 0.0F, 0.0F);
         var1.d((wv)var9);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.a(ew.G, (double)var10.n() + var1.s.nextDouble(), (double)var10.o() + var1.s.nextDouble() * 2.5D, (double)var10.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
         }

         for(var6 = 0; var6 < this.l().b(); ++var6) {
            bei var7 = var3.a(0, var6, 0);
            var1.b(var7.d(), aty.a);
         }
      } else if((var3 = this.T().a(var1, var2)) != null) {
         for(var4 = 0; var4 < this.T().c(); ++var4) {
            for(int var11 = 0; var11 < this.T().b(); ++var11) {
               var1.a(var3.a(var4, var11, 0).d(), aty.a.P(), 2);
            }
         }

         dt var12 = var3.a(1, 2, 0).d();
         acq var13 = new acq(var1);
         var13.l(true);
         var13.b((double)var12.n() + 0.5D, (double)var12.o() + 0.05D, (double)var12.p() + 0.5D, 0.0F, 0.0F);
         var1.d((wv)var13);

         for(var6 = 0; var6 < 120; ++var6) {
            var1.a(ew.F, (double)var12.n() + var1.s.nextDouble(), (double)var12.o() + var1.s.nextDouble() * 3.9D, (double)var12.p() + var1.s.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
         }

         for(var6 = 0; var6 < this.T().c(); ++var6) {
            for(int var14 = 0; var14 < this.T().b(); ++var14) {
               bei var8 = var3.a(var6, var14, 0);
               var1.b(var8.d(), aty.a);
            }
         }
      }

   }

   public boolean c(aqu var1, dt var2) {
      return var1.p(var2).c().J.j() && aqu.a((ard)var1, var2.b());
   }

   public bec a(aqu var1, dt var2, ej var3, float var4, float var5, float var6, int var7, xm var8) {
      return this.P().a(N, var8.aO().d());
   }

   public bec a(int var1) {
      return this.P().a(N, ej.b(var1));
   }

   public int c(bec var1) {
      return ((ej)var1.b(N)).b();
   }

   protected bed e() {
      return new bed(this, new bex[]{N});
   }

   protected bek j() {
      if(this.a == null) {
         this.a = ben.a().a(new String[]{" ", "#", "#"}).a('#', bei.a(beq.a(aty.aJ))).b();
      }

      return this.a;
   }

   protected bek l() {
      if(this.b == null) {
         this.b = ben.a().a(new String[]{"^", "#", "#"}).a('^', bei.a(beq.a(aty.aU))).a('#', bei.a(beq.a(aty.aJ))).b();
      }

      return this.b;
   }

   protected bek S() {
      if(this.M == null) {
         this.M = ben.a().a(new String[]{"~ ~", "###", "~#~"}).a('#', bei.a(beq.a(aty.S))).a('~', bei.a(beq.a(aty.a))).b();
      }

      return this.M;
   }

   protected bek T() {
      if(this.O == null) {
         this.O = ben.a().a(new String[]{"~^~", "###", "~#~"}).a('^', bei.a(beq.a(aty.aU))).a('#', bei.a(beq.a(aty.S))).a('~', bei.a(beq.a(aty.a))).b();
      }

      return this.O;
   }
}
