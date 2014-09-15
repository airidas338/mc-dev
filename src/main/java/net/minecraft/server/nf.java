package net.minecraft.server;

public class nf implements Packet {

   private int a;


   public nf() {}

   public nf(int var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
   }

   public void a(PacketListener var1) {
      ((nc)var1).a(this);
   }
}
