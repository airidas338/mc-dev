package net.minecraft.server;

public class lm implements id {

   private ho a;
   private ho b;


   public lm() {}

   public lm(ho var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.d();
      this.b = var1.d();
   }

   public void b(hd var1) {
      var1.a(this.a);
      var1.a(this.b);
   }

   public void a(hg var1) { // ik
      var1.a(this);
   }
}
