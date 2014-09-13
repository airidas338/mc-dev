package net.minecraft.server;

public class ip implements id {

   private int a;
   private dt b;
   private ej c;
   private String d;


   public ip() {}

   public ip(adm var1) {
      this.a = var1.F();
      this.b = var1.n();
      this.c = var1.b;
      this.d = var1.c.B;
   }

   public void a(hd var1) {
      this.a = var1.e();
      this.d = var1.c(adn.A);
      this.b = var1.c();
      this.c = ej.b(var1.readUnsignedByte());
   }

   public void b(hd var1) {
      var1.b(this.a);
      var1.a(this.d);
      var1.a(this.b);
      var1.writeByte(this.c.b());
   }

   public void a(hg var1) { // ik
      var1.a(this);
   }
}
