package net.minecraft.server;


public class kn implements id {

   private int a;
   private int b;


   public kn() {}

   public kn(int var1, wq var2) {
      this.a = var1;
      this.b = var2.a();
   }

   public void a(hd var1) {
      this.a = var1.e();
      this.b = var1.readUnsignedByte();
   }

   public void b(hd var1) {
      var1.b(this.a);
      var1.writeByte(this.b);
   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }
}
