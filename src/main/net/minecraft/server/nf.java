package net.minecraft.server;

public class nf implements id {

   private int a;


   public nf() {}

   public nf(int var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.e();
   }

   public void b(hd var1) {
      var1.b(this.a);
   }

   public void a(PacketListener var1) {
      ((nc)var1).a(this);
   }
}
