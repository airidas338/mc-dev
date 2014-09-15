package net.minecraft.server;


public class kq implements Packet {

   private int a;
   private byte b;


   public kq() {}

   public kq(Entity var1, byte var2) {
      this.a = var1.F();
      this.b = var2;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.b = var1.readByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.writeByte(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
