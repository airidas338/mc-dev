package net.minecraft.server;

public class bdb extends bcm {

   private alq a;
   private int f;


   public bdb() {}

   public bdb(alq var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public void b(fn var1) {
      super.b(var1);
      RegistryMaterials var2 = (RegistryMaterials)alq.e.c(this.a);
      var1.a("Item", var2 == null?"":var2.toString());
      var1.a("Data", this.f);
   }

   public void a(fn var1) {
      super.a(var1);
      if(var1.b("Item", 8)) {
         this.a = alq.d(var1.j("Item"));
      } else {
         this.a = alq.b(var1.f("Item"));
      }

      this.f = var1.f("Data");
   }

   public id x_() {
      fn var1 = new fn();
      this.b(var1);
      var1.o("Item");
      var1.a("Item", alq.b(this.a));
      return new iu(this.c, 5, var1);
   }

   public void a(alq var1, int var2) {
      this.a = var1;
      this.f = var2;
   }

   public alq b() {
      return this.a;
   }

   public int c() {
      return this.f;
   }
}
