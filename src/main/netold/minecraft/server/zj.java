package net.minecraft.server;

public class zj extends zb {

   private agp b;
   private agp c;
   private aqu d;
   private int e;
   abi a;


   public zj(agp var1) {
      this.b = var1;
      this.d = var1.o;
      this.a(3);
   }

   public boolean a() {
      if(this.b.l() != 0) {
         return false;
      } else if(this.b.bb().nextInt(500) != 0) {
         return false;
      } else {
         this.a = this.d.ae().a(new dt(this.b), 0);
         if(this.a == null) {
            return false;
         } else if(this.f() && this.b.n(true)) {
            wv var1 = this.d.a(agp.class, this.b.aQ().b(8.0D, 3.0D, 8.0D), (wv)this.b);
            if(var1 == null) {
               return false;
            } else {
               this.c = (agp)var1;
               return this.c.l() == 0 && this.c.n(true);
            }
         } else {
            return false;
         }
      }
   }

   public void c() {
      this.e = 300;
      this.b.l(true);
   }

   public void d() {
      this.a = null;
      this.c = null;
      this.b.l(false);
   }

   public boolean b() {
      return this.e >= 0 && this.f() && this.b.l() == 0 && this.b.n(false);
   }

   public void e() {
      --this.e;
      this.b.p().a(this.c, 10.0F, 30.0F);
      if(this.b.h(this.c) > 2.25D) {
         this.b.s().a((wv)this.c, 0.25D);
      } else if(this.e == 0 && this.c.ck()) {
         this.g();
      }

      if(this.b.bb().nextInt(35) == 0) {
         this.d.a((wv)this.b, (byte)12);
      }

   }

   private boolean f() {
      if(!this.a.i()) {
         return false;
      } else {
         int var1 = (int)((double)((float)this.a.c()) * 0.35D);
         return this.a.e() < var1;
      }
   }

   private void g() {
      agp var1 = this.b.b((ws)this.c);
      this.c.b(6000);
      this.b.b(6000);
      this.c.o(false);
      this.b.o(false);
      var1.b(-24000);
      var1.b(this.b.s, this.b.t, this.b.u, 0.0F, 0.0F);
      this.d.d((wv)var1);
      this.d.a((wv)var1, (byte)12);
   }
}
