package net.minecraft.server;
import java.util.List;

public class adi extends xm {

   private static final fa a = new fa(0.0F, 0.0F, 0.0F);
   private static final fa b = new fa(0.0F, 0.0F, 0.0F);
   private static final fa c = new fa(-10.0F, 0.0F, -10.0F);
   private static final fa d = new fa(-15.0F, 0.0F, 10.0F);
   private static final fa e = new fa(-1.0F, 0.0F, -1.0F);
   private static final fa f = new fa(1.0F, 0.0F, 1.0F);
   private final amj[] g;
   private boolean h;
   private long i;
   private int bg;
   private fa bh;
   private fa bi;
   private fa bj;
   private fa bk;
   private fa bl;
   private fa bm;


   public adi(aqu var1) {
      super(var1);
      this.g = new amj[5];
      this.bh = a;
      this.bi = b;
      this.bj = c;
      this.bk = d;
      this.bl = e;
      this.bm = f;
      this.b(true);
      this.T = this.p();
      this.a(0.5F, 1.975F);
   }

   public adi(aqu var1, double var2, double var4, double var6) {
      this(var1);
      this.b(var2, var4, var6);
   }

   public boolean bL() {
      return super.bL() && !this.p();
   }

   protected void h() {
      super.h();
      this.ac.a(10, Byte.valueOf((byte)0));
      this.ac.a(11, a);
      this.ac.a(12, b);
      this.ac.a(13, c);
      this.ac.a(14, d);
      this.ac.a(15, e);
      this.ac.a(16, f);
   }

   public amj bz() {
      return this.g[0];
   }

   public amj p(int var1) {
      return this.g[var1];
   }

   public void c(int var1, amj var2) {
      this.g[var1] = var2;
   }

   public amj[] at() {
      return this.g;
   }

   public boolean d(int var1, amj var2) {
      int var3;
      if(var1 == 99) {
         var3 = 0;
      } else {
         var3 = var1 - 100 + 1;
         if(var3 < 0 || var3 >= this.g.length) {
            return false;
         }
      }

      if(var2 != null && xn.c(var2) != var3 && (var3 != 4 || !(var2.b() instanceof aju))) {
         return false;
      } else {
         this.c(var3, var2);
         return true;
      }
   }

   public void b(fn var1) {
      super.b(var1);
      fv var2 = new fv();

      for(int var3 = 0; var3 < this.g.length; ++var3) {
         fn var4 = new fn();
         if(this.g[var3] != null) {
            this.g[var3].b(var4);
         }

         var2.a((gd)var4);
      }

      var1.a("Equipment", (gd)var2);
      if(this.aM() && (this.aL() == null || this.aL().length() == 0)) {
         var1.a("CustomNameVisible", this.aM());
      }

      var1.a("Invisible", this.ay());
      var1.a("Small", this.n());
      var1.a("ShowArms", this.q());
      var1.a("DisabledSlots", this.bg);
      var1.a("NoGravity", this.p());
      var1.a("NoBasePlate", this.r());
      var1.a("Pose", (gd)this.y());
   }

   public void a(fn var1) {
      super.a(var1);
      if(var1.b("Equipment", 9)) {
         fv var2 = var1.c("Equipment", 10);

         for(int var3 = 0; var3 < this.g.length; ++var3) {
            this.g[var3] = amj.a(var2.b(var3));
         }
      }

      this.e(var1.n("Invisible"));
      this.a(var1.n("Small"));
      this.k(var1.n("ShowArms"));
      this.bg = var1.f("DisabledSlots");
      this.j(var1.n("NoGravity"));
      this.l(var1.n("NoBasePlate"));
      this.T = this.p();
      fn var4 = var1.m("Pose");
      this.h(var4);
   }

   private void h(fn var1) {
      fv var2 = var1.c("Head", 5);
      if(var2.c() > 0) {
         this.a(new fa(var2));
      } else {
         this.a(a);
      }

      fv var3 = var1.c("Body", 5);
      if(var3.c() > 0) {
         this.b(new fa(var3));
      } else {
         this.b(b);
      }

      fv var4 = var1.c("LeftArm", 5);
      if(var4.c() > 0) {
         this.c(new fa(var4));
      } else {
         this.c(c);
      }

      fv var5 = var1.c("RightArm", 5);
      if(var5.c() > 0) {
         this.d(new fa(var5));
      } else {
         this.d(d);
      }

      fv var6 = var1.c("LeftLeg", 5);
      if(var6.c() > 0) {
         this.e(new fa(var6));
      } else {
         this.e(e);
      }

      fv var7 = var1.c("RightLeg", 5);
      if(var7.c() > 0) {
         this.f(new fa(var7));
      } else {
         this.f(f);
      }

   }

   private fn y() {
      fn var1 = new fn();
      if(!a.equals(this.bh)) {
         var1.a("Head", (gd)this.bh.a());
      }

      if(!b.equals(this.bi)) {
         var1.a("Body", (gd)this.bi.a());
      }

      if(!c.equals(this.bj)) {
         var1.a("LeftArm", (gd)this.bj.a());
      }

      if(!d.equals(this.bk)) {
         var1.a("RightArm", (gd)this.bk.a());
      }

      if(!e.equals(this.bl)) {
         var1.a("LeftLeg", (gd)this.bl.a());
      }

      if(!f.equals(this.bm)) {
         var1.a("RightLeg", (gd)this.bm.a());
      }

      return var1;
   }

   public boolean ae() {
      return false;
   }

   protected void s(wv var1) {}

   protected void bK() {
      List var1 = this.o.B((wv)this, this.aQ());
      if(var1 != null && !var1.isEmpty()) {
         for(int var2 = 0; var2 < var1.size(); ++var2) {
            wv var3 = (wv)var1.get(var2);
            if(var3 instanceof adx && ((adx)var3).s() == adz.a && this.h(var3) <= 0.2D) {
               var3.i(this);
            }
         }
      }

   }

   public boolean a(ahd var1, brw var2) {
      if(!this.o.D && !var1.v()) {
         byte var3 = 0;
         amj var4 = var1.bY();
         boolean var5 = var4 != null;
         if(var5 && var4.b() instanceof ajn) {
            ajn var6 = (ajn)var4.b();
            if(var6.b == 3) {
               var3 = 1;
            } else if(var6.b == 2) {
               var3 = 2;
            } else if(var6.b == 1) {
               var3 = 3;
            } else if(var6.b == 0) {
               var3 = 4;
            }
         }

         if(var5 && (var4.b() == amk.bX || var4.b() == alq.a(aty.aU))) {
            var3 = 4;
         }

         double var19 = 0.1D;
         double var8 = 0.9D;
         double var10 = 0.4D;
         double var12 = 1.6D;
         byte var14 = 0;
         boolean var15 = this.n();
         double var16 = var15?var2.b * 2.0D:var2.b;
         if(var16 >= 0.1D && var16 < 0.1D + (var15?0.8D:0.45D) && this.g[1] != null) {
            var14 = 1;
         } else if(var16 >= 0.9D + (var15?0.3D:0.0D) && var16 < 0.9D + (var15?1.0D:0.7D) && this.g[3] != null) {
            var14 = 3;
         } else if(var16 >= 0.4D && var16 < 0.4D + (var15?1.0D:0.8D) && this.g[2] != null) {
            var14 = 2;
         } else if(var16 >= 1.6D && this.g[4] != null) {
            var14 = 4;
         }

         boolean var18 = this.g[var14] != null;
         if((this.bg & 1 << var14) != 0 || (this.bg & 1 << var3) != 0) {
            var14 = var3;
            if((this.bg & 1 << var3) != 0) {
               if((this.bg & 1) != 0) {
                  return true;
               }

               var14 = 0;
            }
         }

         if(var5 && var3 == 0 && !this.q()) {
            return true;
         } else {
            if(var5) {
               this.a(var1, var3);
            } else if(var18) {
               this.a(var1, var14);
            }

            return true;
         }
      } else {
         return true;
      }
   }

   private void a(ahd var1, int var2) {
      amj var3 = this.g[var2];
      if(var3 == null || (this.bg & 1 << var2 + 8) == 0) {
         if(var3 != null || (this.bg & 1 << var2 + 16) == 0) {
            int var4 = var1.bg.c;
            amj var5 = var1.bg.a(var4);
            amj var6;
            if(var1.by.d && (var3 == null || var3.b() == alq.a(aty.a)) && var5 != null) {
               var6 = var5.k();
               var6.b = 1;
               this.c(var2, var6);
            } else if(var5 != null && var5.b > 1) {
               if(var3 == null) {
                  var6 = var5.k();
                  var6.b = 1;
                  this.c(var2, var6);
                  --var5.b;
               }
            } else {
               this.c(var2, var5);
               var1.bg.a(var4, var3);
            }
         }
      }
   }

   public boolean a(wh var1, float var2) {
      if(!this.o.D && !this.h) {
         if(wh.j.equals(var1)) {
            this.J();
            return false;
         } else if(this.b(var1)) {
            return false;
         } else if(var1.c()) {
            this.C();
            this.J();
            return false;
         } else if(wh.a.equals(var1)) {
            if(!this.au()) {
               this.e(5);
            } else {
               this.a(0.15F);
            }

            return false;
         } else if(wh.c.equals(var1) && this.bm() > 0.5F) {
            this.a(4.0F);
            return false;
         } else {
            boolean var3 = "arrow".equals(var1.p());
            boolean var4 = "player".equals(var1.p());
            if(!var4 && !var3) {
               return false;
            } else {
               if(var1.i() instanceof ahj) {
                  var1.i().J();
               }

               if(var1.j() instanceof ahd && !((ahd)var1.j()).by.e) {
                  return false;
               } else if(var1.u()) {
                  this.z();
                  this.J();
                  return false;
               } else {
                  long var5 = this.o.K();
                  if(var5 - this.i > 5L && !var3) {
                     this.i = var5;
                  } else {
                     this.A();
                     this.z();
                     this.J();
                  }

                  return false;
               }
            }
         }
      } else {
         return false;
      }
   }

   private void z() {
      if(this.o instanceof qt) {
         ((qt)this.o).a(ew.M, this.s, this.t + (double)this.K / 1.5D, this.u, 10, (double)(this.J / 4.0F), (double)(this.K / 4.0F), (double)(this.J / 4.0F), 0.05D, new int[]{atr.f(aty.f.P())});
      }

   }

   private void a(float var1) {
      float var2 = this.bm();
      var2 -= var1;
      if(var2 <= 0.5F) {
         this.C();
         this.J();
      } else {
         this.h(var2);
      }

   }

   private void A() {
      atr.a(this.o, new dt(this), new amj(amk.cj));
      this.C();
   }

   private void C() {
      for(int var1 = 0; var1 < this.g.length; ++var1) {
         if(this.g[var1] != null && this.g[var1].b > 0) {
            if(this.g[var1] != null) {
               atr.a(this.o, (new dt(this)).a(), this.g[var1]);
            }

            this.g[var1] = null;
         }
      }

   }

   protected float h(float var1, float var2) {
      this.aH = this.A;
      this.aG = this.y;
      return 0.0F;
   }

   public float aR() {
      return this.i_()?this.K * 0.5F:this.K * 0.9F;
   }

   public void g(float var1, float var2) {
      if(!this.p()) {
         super.g(var1, var2);
      }
   }

   public void s_() {
      super.s_();
      fa var1 = this.ac.h(11);
      if(!this.bh.equals(var1)) {
         this.a(var1);
      }

      fa var2 = this.ac.h(12);
      if(!this.bi.equals(var2)) {
         this.b(var2);
      }

      fa var3 = this.ac.h(13);
      if(!this.bj.equals(var3)) {
         this.c(var3);
      }

      fa var4 = this.ac.h(14);
      if(!this.bk.equals(var4)) {
         this.d(var4);
      }

      fa var5 = this.ac.h(15);
      if(!this.bl.equals(var5)) {
         this.e(var5);
      }

      fa var6 = this.ac.h(16);
      if(!this.bm.equals(var6)) {
         this.f(var6);
      }

   }

   protected void B() {
      this.e(this.h);
   }

   public void e(boolean var1) {
      this.h = var1;
      super.e(var1);
   }

   public boolean i_() {
      return this.n();
   }

   public void G() {
      this.J();
   }

   public boolean aV() {
      return this.ay();
   }

   private void a(boolean var1) {
      byte var2 = this.ac.a(10);
      if(var1) {
         var2 = (byte)(var2 | 1);
      } else {
         var2 &= -2;
      }

      this.ac.b(10, Byte.valueOf(var2));
   }

   public boolean n() {
      return (this.ac.a(10) & 1) != 0;
   }

   private void j(boolean var1) {
      byte var2 = this.ac.a(10);
      if(var1) {
         var2 = (byte)(var2 | 2);
      } else {
         var2 &= -3;
      }

      this.ac.b(10, Byte.valueOf(var2));
   }

   public boolean p() {
      return (this.ac.a(10) & 2) != 0;
   }

   private void k(boolean var1) {
      byte var2 = this.ac.a(10);
      if(var1) {
         var2 = (byte)(var2 | 4);
      } else {
         var2 &= -5;
      }

      this.ac.b(10, Byte.valueOf(var2));
   }

   public boolean q() {
      return (this.ac.a(10) & 4) != 0;
   }

   private void l(boolean var1) {
      byte var2 = this.ac.a(10);
      if(var1) {
         var2 = (byte)(var2 | 8);
      } else {
         var2 &= -9;
      }

      this.ac.b(10, Byte.valueOf(var2));
   }

   public boolean r() {
      return (this.ac.a(10) & 8) != 0;
   }

   public void a(fa var1) {
      this.bh = var1;
      this.ac.b(11, var1);
   }

   public void b(fa var1) {
      this.bi = var1;
      this.ac.b(12, var1);
   }

   public void c(fa var1) {
      this.bj = var1;
      this.ac.b(13, var1);
   }

   public void d(fa var1) {
      this.bk = var1;
      this.ac.b(14, var1);
   }

   public void e(fa var1) {
      this.bl = var1;
      this.ac.b(15, var1);
   }

   public void f(fa var1) {
      this.bm = var1;
      this.ac.b(16, var1);
   }

   public fa s() {
      return this.bh;
   }

   public fa t() {
      return this.bi;
   }

}
