package net.minecraft.server;

public class kl implements id {

   private int a;
   private dt b;


   public kl() {}

   public kl(EntityHuman var1, dt var2) {
      this.a = var1.F();
      this.b = var2;
   }

   public void a(hd var1) {
      this.a = var1.e();
      this.b = var1.c();
   }

   public void b(hd var1) {
      var1.b(this.a);
      var1.a(this.b);
   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }
}
