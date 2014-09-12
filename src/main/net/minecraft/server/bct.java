package net.minecraft.server;

public class bct extends bcm {

   private final aqf a = new bcu(this);


   public void b(fn var1) {
      super.b(var1);
      this.a.a(var1);
   }

   public void a(fn var1) {
      super.a(var1);
      this.a.b(var1);
   }

   public id x_() {
      fn var1 = new fn();
      this.b(var1);
      return new iu(this.c, 2, var1);
   }

   public aqf b() {
      return this.a;
   }

   public af c() {
      return this.a.n();
   }
}
