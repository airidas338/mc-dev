package net.minecraft.server;



public class zk extends zb {

   World a;
   protected EntityCreature b;
   int c;
   double d;
   boolean e;
   bpv f;
   Class g;
   private int h;
   private double i;
   private double j;
   private double k;


   public zk(EntityCreature var1, Class var2, double var3, boolean var5) {
      this(var1, var3, var5);
      this.g = var2;
   }

   public zk(EntityCreature var1, double var2, boolean var4) {
      this.b = var1;
      this.a = var1.o;
      this.d = var2;
      this.e = var4;
      this.a(3);
   }

   public boolean a() {
      EntityLiving var1 = this.b.u();
      if(var1 == null) {
         return false;
      } else if(!var1.ai()) {
         return false;
      } else if(this.g != null && !this.g.isAssignableFrom(var1.getClass())) {
         return false;
      } else {
         this.f = this.b.s().a((Entity)var1);
         return this.f != null;
      }
   }

   public boolean b() {
      EntityLiving var1 = this.b.u();
      return var1 == null?false:(!var1.ai()?false:(!this.e?!this.b.s().m():this.b.d(new Location(var1))));
   }

   public void c() {
      this.b.s().a(this.f, this.d);
      this.h = 0;
   }

   public void d() {
      this.b.s().n();
   }

   public void e() {
      EntityLiving var1 = this.b.u();
      this.b.p().a(var1, 30.0F, 30.0F);
      double var2 = this.b.e(var1.s, var1.aQ().b, var1.u);
      double var4 = this.a(var1);
      --this.h;
      if((this.e || this.b.t().a(var1)) && this.h <= 0 && (this.i == 0.0D && this.j == 0.0D && this.k == 0.0D || var1.e(this.i, this.j, this.k) >= 1.0D || this.b.bb().nextFloat() < 0.05F)) {
         this.i = var1.s;
         this.j = var1.aQ().b;
         this.k = var1.u;
         this.h = 4 + this.b.bb().nextInt(7);
         if(var2 > 1024.0D) {
            this.h += 10;
         } else if(var2 > 256.0D) {
            this.h += 5;
         }

         if(!this.b.s().a((Entity)var1, this.d)) {
            this.h += 15;
         }
      }

      this.c = Math.max(this.c - 1, 0);
      if(var2 <= var4 && this.c <= 0) {
         this.c = 20;
         if(this.b.bz() != null) {
            this.b.bv();
         }

         this.b.r(var1);
      }

   }

   protected double a(EntityLiving var1) {
      return (double)(this.b.J * 2.0F * this.b.J * 2.0F + var1.J);
   }
}
