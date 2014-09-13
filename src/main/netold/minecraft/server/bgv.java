package net.minecraft.server;
import java.util.List;
import java.util.Random;

public class bgv implements bfe {

   private Random h;
   private bnv i;
   private bnv j;
   private bnv k;
   private bnw l;
   public bnv a;
   public bnv b;
   public bnv c;
   private aqu m;
   private final boolean n;
   private are o;
   private final double[] p;
   private final float[] q;
   private bgl r;
   private atr s;
   private double[] t;
   private bgt u;
   private blp v;
   private bmw w;
   private bjd x;
   private blg y;
   private bgt z;
   private bkg A;
   private arm[] B;
   double[] d;
   double[] e;
   double[] f;
   double[] g;


   public bgv(aqu var1, long var2, boolean var4, String var5) {
      this.s = aty.j;
      this.t = new double[256];
      this.u = new bgs();
      this.v = new blp();
      this.w = new bmw();
      this.x = new bjd();
      this.y = new blg();
      this.z = new bgj();
      this.A = new bkg();
      this.m = var1;
      this.n = var4;
      this.o = var1.P().u();
      this.h = new Random(var2);
      this.i = new bnv(this.h, 16);
      this.j = new bnv(this.h, 16);
      this.k = new bnv(this.h, 8);
      this.l = new bnw(this.h, 4);
      this.a = new bnv(this.h, 10);
      this.b = new bnv(this.h, 16);
      this.c = new bnv(this.h, 8);
      this.p = new double[825];
      this.q = new float[25];

      for(int var6 = -2; var6 <= 2; ++var6) {
         for(int var7 = -2; var7 <= 2; ++var7) {
            float var8 = 10.0F / uv.c((float)(var6 * var6 + var7 * var7) + 0.2F);
            this.q[var6 + 2 + (var7 + 2) * 5] = var8;
         }
      }

      if(var5 != null) {
         this.r = bgn.a(var5).b();
         this.s = this.r.E?aty.l:aty.j;
      }

   }

   public void a(int var1, int var2, bgk var3) {
      this.B = this.m.v().a(this.B, var1 * 4 - 2, var2 * 4 - 2, 10, 10);
      this.a(var1 * 4, 0, var2 * 4);

      for(int var4 = 0; var4 < 4; ++var4) {
         int var5 = var4 * 5;
         int var6 = (var4 + 1) * 5;

         for(int var7 = 0; var7 < 4; ++var7) {
            int var8 = (var5 + var7) * 33;
            int var9 = (var5 + var7 + 1) * 33;
            int var10 = (var6 + var7) * 33;
            int var11 = (var6 + var7 + 1) * 33;

            for(int var12 = 0; var12 < 32; ++var12) {
               double var13 = 0.125D;
               double var15 = this.p[var8 + var12];
               double var17 = this.p[var9 + var12];
               double var19 = this.p[var10 + var12];
               double var21 = this.p[var11 + var12];
               double var23 = (this.p[var8 + var12 + 1] - var15) * var13;
               double var25 = (this.p[var9 + var12 + 1] - var17) * var13;
               double var27 = (this.p[var10 + var12 + 1] - var19) * var13;
               double var29 = (this.p[var11 + var12 + 1] - var21) * var13;

               for(int var31 = 0; var31 < 8; ++var31) {
                  double var32 = 0.25D;
                  double var34 = var15;
                  double var36 = var17;
                  double var38 = (var19 - var15) * var32;
                  double var40 = (var21 - var17) * var32;

                  for(int var42 = 0; var42 < 4; ++var42) {
                     double var43 = 0.25D;
                     double var47 = (var36 - var34) * var43;
                     double var45 = var34 - var47;

                     for(int var49 = 0; var49 < 4; ++var49) {
                        if((var45 += var47) > 0.0D) {
                           var3.a(var4 * 4 + var42, var12 * 8 + var31, var7 * 4 + var49, aty.b.P());
                        } else if(var12 * 8 + var31 < this.r.q) {
                           var3.a(var4 * 4 + var42, var12 * 8 + var31, var7 * 4 + var49, this.s.P());
                        }
                     }

                     var34 += var38;
                     var36 += var40;
                  }

                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
                  var21 += var29;
               }
            }
         }
      }

   }

   public void a(int var1, int var2, bgk var3, arm[] var4) {
      double var5 = 0.03125D;
      this.t = this.l.a(this.t, (double)(var1 * 16), (double)(var2 * 16), 16, 16, var5 * 2.0D, var5 * 2.0D, 1.0D);

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            arm var9 = var4[var8 + var7 * 16];
            var9.a(this.m, this.h, var3, var1 * 16 + var7, var2 * 16 + var8, this.t[var8 + var7 * 16]);
         }
      }

   }

   public bfh d(int var1, int var2) {
      this.h.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      bgk var3 = new bgk();
      this.a(var1, var2, var3);
      this.B = this.m.v().b(this.B, var1 * 16, var2 * 16, 16, 16);
      this.a(var1, var2, var3, this.B);
      if(this.r.r) {
         this.u.a(this, this.m, var1, var2, var3);
      }

      if(this.r.z) {
         this.z.a(this, this.m, var1, var2, var3);
      }

      if(this.r.w && this.n) {
         this.x.a(this, this.m, var1, var2, var3);
      }

      if(this.r.v && this.n) {
         this.w.a(this, this.m, var1, var2, var3);
      }

      if(this.r.u && this.n) {
         this.v.a(this, this.m, var1, var2, var3);
      }

      if(this.r.x && this.n) {
         this.y.a(this, this.m, var1, var2, var3);
      }

      if(this.r.y && this.n) {
         this.a.a(this, this.m, var1, var2, var3);
      }

      bfh var4 = new bfh(this.m, var3, var1, var2);
      byte[] var5 = var4.k();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.B[var6].az;
      }

      var4.b();
      return var4;
   }

   private void a(int var1, int var2, int var3) {
      this.g = this.b.a(this.g, var1, var3, 5, 5, (double)this.r.e, (double)this.r.f, (double)this.r.g);
      float var4 = this.r.a;
      float var5 = this.r.b;
      this.d = this.k.a(this.d, var1, var2, var3, 5, 33, 5, (double)(var4 / this.r.h), (double)(var5 / this.r.i), (double)(var4 / this.r.j));
      this.e = this.i.a(this.e, var1, var2, var3, 5, 33, 5, (double)var4, (double)var5, (double)var4);
      this.f = this.j.a(this.f, var1, var2, var3, 5, 33, 5, (double)var4, (double)var5, (double)var4);
      boolean var37 = false;
      boolean var36 = false;
      int var6 = 0;
      int var7 = 0;

      for(int var8 = 0; var8 < 5; ++var8) {
         for(int var9 = 0; var9 < 5; ++var9) {
            float var10 = 0.0F;
            float var11 = 0.0F;
            float var12 = 0.0F;
            byte var13 = 2;
            arm var14 = this.B[var8 + 2 + (var9 + 2) * 10];

            for(int var15 = -var13; var15 <= var13; ++var15) {
               for(int var16 = -var13; var16 <= var13; ++var16) {
                  arm var17 = this.B[var8 + var15 + 2 + (var9 + var16 + 2) * 10];
                  float var18 = this.r.n + var17.an * this.r.m;
                  float var19 = this.r.p + var17.ao * this.r.o;
                  if(this.o == are.e && var18 > 0.0F) {
                     var18 = 1.0F + var18 * 2.0F;
                     var19 = 1.0F + var19 * 4.0F;
                  }

                  float var20 = this.q[var15 + 2 + (var16 + 2) * 5] / (var18 + 2.0F);
                  if(var17.an > var14.an) {
                     var20 /= 2.0F;
                  }

                  var10 += var19 * var20;
                  var11 += var18 * var20;
                  var12 += var20;
               }
            }

            var10 /= var12;
            var11 /= var12;
            var10 = var10 * 0.9F + 0.1F;
            var11 = (var11 * 4.0F - 1.0F) / 8.0F;
            double var38 = this.g[var7] / 8000.0D;
            if(var38 < 0.0D) {
               var38 = -var38 * 0.3D;
            }

            var38 = var38 * 3.0D - 2.0D;
            if(var38 < 0.0D) {
               var38 /= 2.0D;
               if(var38 < -1.0D) {
                  var38 = -1.0D;
               }

               var38 /= 1.4D;
               var38 /= 2.0D;
            } else {
               if(var38 > 1.0D) {
                  var38 = 1.0D;
               }

               var38 /= 8.0D;
            }

            ++var7;
            double var39 = (double)var11;
            double var40 = (double)var10;
            var39 += var38 * 0.2D;
            var39 = var39 * (double)this.r.k / 8.0D;
            double var21 = (double)this.r.k + var39 * 4.0D;

            for(int var23 = 0; var23 < 33; ++var23) {
               double var24 = ((double)var23 - var21) * (double)this.r.l * 128.0D / 256.0D / var40;
               if(var24 < 0.0D) {
                  var24 *= 4.0D;
               }

               double var26 = this.e[var6] / (double)this.r.d;
               double var28 = this.f[var6] / (double)this.r.c;
               double var30 = (this.d[var6] / 10.0D + 1.0D) / 2.0D;
               double var32 = uv.b(var26, var28, var30) - var24;
               if(var23 > 29) {
                  double var34 = (double)((float)(var23 - 29) / 3.0F);
                  var32 = var32 * (1.0D - var34) + -10.0D * var34;
               }

               this.p[var6] = var32;
               ++var6;
            }
         }
      }

   }

   public boolean a(int var1, int var2) {
      return true;
   }

   public void a(bfe var1, int var2, int var3) {
      avt.M = true;
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      dt var6 = new dt(var4, 0, var5);
      arm var7 = this.m.b(var6.a(16, 0, 16));
      this.h.setSeed(this.m.J());
      long var8 = this.h.nextLong() / 2L * 2L + 1L;
      long var10 = this.h.nextLong() / 2L * 2L + 1L;
      this.h.setSeed((long)var2 * var8 + (long)var3 * var10 ^ this.m.J());
      boolean var12 = false;
      aqm var13 = new aqm(var2, var3);
      if(this.r.w && this.n) {
         this.x.a(this.m, this.h, var13);
      }

      if(this.r.v && this.n) {
         var12 = this.w.a(this.m, this.h, var13);
      }

      if(this.r.u && this.n) {
         this.v.a(this.m, this.h, var13);
      }

      if(this.r.x && this.n) {
         this.y.a(this.m, this.h, var13);
      }

      if(this.r.y && this.n) {
         this.a.a(this.m, this.h, var13);
      }

      int var14;
      int var15;
      int var16;
      if(var7 != arm.r && var7 != arm.G && this.r.A && !var12 && this.h.nextInt(this.r.B) == 0) {
         var14 = this.h.nextInt(16) + 8;
         var15 = this.h.nextInt(256);
         var16 = this.h.nextInt(16) + 8;
         (new bhy(aty.j)).b(this.m, this.h, var6.a(var14, var15, var16));
      }

      if(!var12 && this.h.nextInt(this.r.D / 10) == 0 && this.r.C) {
         var14 = this.h.nextInt(16) + 8;
         var15 = this.h.nextInt(this.h.nextInt(248) + 8);
         var16 = this.h.nextInt(16) + 8;
         if(var15 < 63 || this.h.nextInt(this.r.D / 8) == 0) {
            (new bhy(aty.l)).b(this.m, this.h, var6.a(var14, var15, var16));
         }
      }

      if(this.r.s) {
         for(var14 = 0; var14 < this.r.t; ++var14) {
            var15 = this.h.nextInt(16) + 8;
            var16 = this.h.nextInt(256);
            int var17 = this.h.nextInt(16) + 8;
            (new bie()).b(this.m, this.h, var6.a(var15, var16, var17));
         }
      }

      var7.a(this.m, this.h, new dt(var4, 0, var5));
      arg.a(this.m, var7, var4 + 8, var5 + 8, 16, 16, this.h);
      var6 = var6.a(8, 0, 8);

      for(var14 = 0; var14 < 16; ++var14) {
         for(var15 = 0; var15 < 16; ++var15) {
            dt var19 = this.m.q(var6.a(var14, 0, var15));
            dt var18 = var19.b();
            if(this.m.v(var18)) {
               this.m.a(var18, aty.aI.P(), 2);
            }

            if(this.m.f(var19, true)) {
               this.m.a(var19, aty.aH.P(), 2);
            }
         }
      }

      avt.M = false;
   }

   public boolean a(bfe var1, bfh var2, int var3, int var4) {
      boolean var5 = false;
      if(this.r.y && this.n && var2.w() < 3600L) {
         var5 |= this.a.a(this.m, this.h, new aqm(var3, var4));
      }

      return var5;
   }

   public boolean a(boolean var1, uy var2) {
      return true;
   }

   public void c() {}

   public boolean d() {
      return false;
   }

   public boolean e() {
      return true;
   }

   public String f() {
      return "RandomLevelSource";
   }

   public List a(xp var1, dt var2) {
      arm var3 = this.m.b(var2);
      if(this.n) {
         if(var1 == xp.a && this.y.a(var2)) {
            return this.y.b();
         }

         if(var1 == xp.a && this.r.y && this.a.a(this.m, var2)) {
            return this.a.b();
         }
      }

      return var3.a(var1);
   }

   public dt a(aqu var1, String var2, dt var3) {
      return "Stronghold".equals(var2) && this.v != null?this.v.b(var1, var3):null;
   }

   public int g() {
      return 0;
   }

   public void a(bfh var1, int var2, int var3) {
      if(this.r.w && this.n) {
         this.x.a(this, this.m, var2, var3, (bgk)null);
      }

      if(this.r.v && this.n) {
         this.w.a(this, this.m, var2, var3, (bgk)null);
      }

      if(this.r.u && this.n) {
         this.v.a(this, this.m, var2, var3, (bgk)null);
      }

      if(this.r.x && this.n) {
         this.y.a(this, this.m, var2, var3, (bgk)null);
      }

      if(this.r.y && this.n) {
         this.a.a(this, this.m, var2, var3, (bgk)null);
      }

   }

   public bfh a(dt var1) {
      return this.d(var1.n() >> 4, var1.p() >> 4);
   }
}
