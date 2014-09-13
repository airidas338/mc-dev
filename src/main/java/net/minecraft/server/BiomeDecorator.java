package net.minecraft.server;
import java.util.Random;

public class BiomeDecorator {

   protected World a;
   protected Random b;
   protected Location c;
   protected bgl d;
   protected WorldGenerator e = new WorldGenClay(4);
   protected WorldGenerator f;
   protected WorldGenerator g;
   protected WorldGenerator h;
   protected WorldGenerator i;
   protected WorldGenerator j;
   protected WorldGenerator k;
   protected WorldGenerator l;
   protected WorldGenerator m;
   protected WorldGenerator n;
   protected WorldGenerator o;
   protected WorldGenerator p;
   protected WorldGenerator q;
   protected WorldGenerator r;
   protected bhq s;
   protected WorldGenerator t;
   protected WorldGenerator u;
   protected WorldGenerator v;
   protected WorldGenerator w;
   protected WorldGenerator x;
   protected WorldGenerator y;
   protected int z;
   protected int A;
   protected int B;
   protected int C;
   protected int D;
   protected int E;
   protected int F;
   protected int G;
   protected int H;
   protected int I;
   protected int J;
   protected int K;
   public boolean L;


   public BiomeDecorator() {
      this.f = new WorldGenSand(Blocks.m, 7);
      this.g = new WorldGenSand(Blocks.n, 6);
      this.s = new bhq(Blocks.N, EnumFlowerType.a);
      this.t = new bhi(Blocks.P);
      this.u = new bhi(Blocks.Q);
      this.v = new bhv();
      this.w = new bii();
      this.x = new bhj();
      this.y = new bit();
      this.B = 2;
      this.C = 1;
      this.H = 1;
      this.I = 3;
      this.J = 1;
      this.L = true;
   }

   public void a(World var1, Random var2, BiomeBase var3, Location var4) {
      if(this.a != null) {
         throw new RuntimeException("Already decorating");
      } else {
         this.a = var1;
         String var5 = var1.P().B();
         if(var5 != null) {
            this.d = bgn.a(var5).b();
         } else {
            this.d = bgn.a("").b();
         }

         this.b = var2;
         this.c = var4;
         this.h = new bif(Blocks.d.P(), this.d.I);
         this.i = new bif(Blocks.n.P(), this.d.M);
         this.j = new bif(Blocks.b.P().a(BlockStone.a, bbb.b), this.d.Q);
         this.k = new bif(Blocks.b.P().a(BlockStone.a, bbb.d), this.d.U);
         this.l = new bif(Blocks.b.P().a(BlockStone.a, bbb.f), this.d.Y);
         this.m = new bif(Blocks.q.P(), this.d.ac);
         this.n = new bif(Blocks.p.P(), this.d.ag);
         this.o = new bif(Blocks.o.P(), this.d.ak);
         this.p = new bif(Blocks.aC.P(), this.d.ao);
         this.q = new bif(Blocks.ag.P(), this.d.as);
         this.r = new bif(Blocks.x.P(), this.d.aw);
         this.a(var3);
         this.a = null;
         this.b = null;
      }
   }

   protected void a(BiomeBase var1) {
      this.a();

      int var2;
      int var3;
      int var4;
      for(var2 = 0; var2 < this.I; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.f.generate(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      for(var2 = 0; var2 < this.J; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.e.generate(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      for(var2 = 0; var2 < this.H; ++var2) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         this.g.generate(this.a, this.b, this.a.r(this.c.a(var3, 0, var4)));
      }

      var2 = this.A;
      if(this.b.nextInt(10) == 0) {
         ++var2;
      }

      int var5;
      Location var7;
      for(var3 = 0; var3 < var2; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         WorldGenTreeAbstract var6 = var1.a(this.b);
         var6.e();
         var7 = this.a.m(this.c.a(var4, 0, var5));
         if(var6.generate(this.a, this.b, var7)) {
            var6.a(this.a, this.b, var7);
         }
      }

      for(var3 = 0; var3 < this.K; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         this.v.generate(this.a, this.b, this.a.m(this.c.a(var4, 0, var5)));
      }

      int var10;
      for(var3 = 0; var3 < this.B; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var10 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).o() + 32);
         var7 = this.c.a(var4, var10, var5);
         EnumFlowerType var8 = var1.a(this.b, var7);
         BlockFlowers var9 = var8.a().a();
         if(var9.r() != Material.AIR) {
            this.s.a(var9, var8);
            this.s.generate(this.a, this.b, var7);
         }
      }

      for(var3 = 0; var3 < this.C; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var10 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).o() * 2);
         var1.b(this.b).generate(this.a, this.b, this.c.a(var4, var10, var5));
      }

      for(var3 = 0; var3 < this.D; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var10 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).o() * 2);
         (new bhm()).generate(this.a, this.b, this.c.a(var4, var10, var5));
      }

      var3 = 0;

      while(var3 < this.z) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var10 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).o() * 2);
         var7 = this.c.a(var4, var10, var5);

         while(true) {
            if(var7.o() > 0) {
               Location var12 = var7.b();
               if(this.a.d(var12)) {
                  var7 = var12;
                  continue;
               }
            }

            this.y.generate(this.a, this.b, var7);
            ++var3;
            break;
         }
      }

      for(var3 = 0; var3 < this.E; ++var3) {
         if(this.b.nextInt(4) == 0) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            Location var11 = this.a.m(this.c.a(var4, 0, var5));
            this.t.generate(this.a, this.b, var11);
         }

         if(this.b.nextInt(8) == 0) {
            var4 = this.b.nextInt(16) + 8;
            var5 = this.b.nextInt(16) + 8;
            var10 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).o() * 2);
            var7 = this.c.a(var4, var10, var5);
            this.u.generate(this.a, this.b, var7);
         }
      }

      if(this.b.nextInt(4) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(this.a.m(this.c.a(var3, 0, var4)).o() * 2);
         this.t.generate(this.a, this.b, this.c.a(var3, var5, var4));
      }

      if(this.b.nextInt(8) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(this.a.m(this.c.a(var3, 0, var4)).o() * 2);
         this.u.generate(this.a, this.b, this.c.a(var3, var5, var4));
      }

      for(var3 = 0; var3 < this.F; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var10 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).o() * 2);
         this.w.generate(this.a, this.b, this.c.a(var4, var10, var5));
      }

      for(var3 = 0; var3 < 10; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var10 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).o() * 2);
         this.w.generate(this.a, this.b, this.c.a(var4, var10, var5));
      }

      if(this.b.nextInt(32) == 0) {
         var3 = this.b.nextInt(16) + 8;
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(this.a.m(this.c.a(var3, 0, var4)).o() * 2);
         (new bih()).generate(this.a, this.b, this.c.a(var3, var5, var4));
      }

      for(var3 = 0; var3 < this.G; ++var3) {
         var4 = this.b.nextInt(16) + 8;
         var5 = this.b.nextInt(16) + 8;
         var10 = this.b.nextInt(this.a.m(this.c.a(var4, 0, var5)).o() * 2);
         this.x.generate(this.a, this.b, this.c.a(var4, var10, var5));
      }

      if(this.L) {
         Location var13;
         for(var3 = 0; var3 < 50; ++var3) {
            var13 = this.c.a(this.b.nextInt(16) + 8, this.b.nextInt(this.b.nextInt(248) + 8), this.b.nextInt(16) + 8);
            (new bin(Blocks.i)).generate(this.a, this.b, var13);
         }

         for(var3 = 0; var3 < 20; ++var3) {
            var13 = this.c.a(this.b.nextInt(16) + 8, this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8), this.b.nextInt(16) + 8);
            (new bin(Blocks.k)).generate(this.a, this.b, var13);
         }
      }

   }

   protected void a(int var1, WorldGenerator var2, int var3, int var4) {
      int var5;
      if(var4 < var3) {
         var5 = var3;
         var3 = var4;
         var4 = var5;
      } else if(var4 == var3) {
         if(var3 < 255) {
            ++var4;
         } else {
            --var3;
         }
      }

      for(var5 = 0; var5 < var1; ++var5) {
         Location var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4 - var3) + var3, this.b.nextInt(16));
         var2.generate(this.a, this.b, var6);
      }

   }

   protected void b(int var1, WorldGenerator var2, int var3, int var4) {
      for(int var5 = 0; var5 < var1; ++var5) {
         Location var6 = this.c.a(this.b.nextInt(16), this.b.nextInt(var4) + this.b.nextInt(var4) + var3 - var4, this.b.nextInt(16));
         var2.generate(this.a, this.b, var6);
      }

   }

   protected void a() {
      this.a(this.d.J, this.h, this.d.K, this.d.L);
      this.a(this.d.N, this.i, this.d.O, this.d.P);
      this.a(this.d.V, this.k, this.d.W, this.d.X);
      this.a(this.d.R, this.j, this.d.S, this.d.T);
      this.a(this.d.Z, this.l, this.d.aa, this.d.ab);
      this.a(this.d.ad, this.m, this.d.ae, this.d.af);
      this.a(this.d.ah, this.n, this.d.ai, this.d.aj);
      this.a(this.d.al, this.o, this.d.am, this.d.an);
      this.a(this.d.ap, this.p, this.d.aq, this.d.ar);
      this.a(this.d.at, this.q, this.d.au, this.d.av);
      this.b(this.d.ax, this.r, this.d.ay, this.d.az);
   }
}
