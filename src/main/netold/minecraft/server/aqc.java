package net.minecraft.server;

public class aqc {

   private amj a;
   private amj b;
   private amj c;
   private int d;
   private int e;
   private boolean f;


   public aqc(fn var1) {
      this.a(var1);
   }

   public aqc(amj var1, amj var2, amj var3) {
      this(var1, var2, var3, 0, 7);
   }

   public aqc(amj var1, amj var2, amj var3, int var4, int var5) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
      this.d = var4;
      this.e = var5;
      this.f = true;
   }

   public aqc(amj var1, amj var2) {
      this(var1, (amj)null, var2);
   }

   public aqc(amj var1, alq var2) {
      this(var1, new amj(var2));
   }

   public amj a() {
      return this.a;
   }

   public amj b() {
      return this.b;
   }

   public boolean c() {
      return this.b != null;
   }

   public amj d() {
      return this.c;
   }

   public int e() {
      return this.d;
   }

   public int f() {
      return this.e;
   }

   public void g() {
      ++this.d;
   }

   public void a(int var1) {
      this.e += var1;
   }

   public boolean h() {
      return this.d >= this.e;
   }

   public boolean j() {
      return this.f;
   }

   public void a(fn var1) {
      fn var2 = var1.m("buy");
      this.a = amj.a(var2);
      fn var3 = var1.m("sell");
      this.c = amj.a(var3);
      if(var1.b("buyB", 10)) {
         this.b = amj.a(var1.m("buyB"));
      }

      if(var1.b("uses", 99)) {
         this.d = var1.f("uses");
      }

      if(var1.b("maxUses", 99)) {
         this.e = var1.f("maxUses");
      } else {
         this.e = 7;
      }

      if(var1.b("rewardExp", 1)) {
         this.f = var1.n("rewardExp");
      } else {
         this.f = true;
      }

   }

   public fn k() {
      fn var1 = new fn();
      var1.a("buy", (gd)this.a.b(new fn()));
      var1.a("sell", (gd)this.c.b(new fn()));
      if(this.b != null) {
         var1.a("buyB", (gd)this.b.b(new fn()));
      }

      var1.a("uses", this.d);
      var1.a("maxUses", this.e);
      var1.a("rewardExp", this.f);
      return var1;
   }
}
