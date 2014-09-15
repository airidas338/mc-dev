package net.minecraft.server;


public class PacketPlayOutAnimation implements Packet {

   private int a;
   private int b;


   public PacketPlayOutAnimation() {}

   public PacketPlayOutAnimation(Entity var1, int var2) {
      this.a = var1.F();
      this.b = var2;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.b = var1.readUnsignedByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.writeByte(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
