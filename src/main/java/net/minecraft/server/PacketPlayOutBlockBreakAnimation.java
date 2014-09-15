package net.minecraft.server;

public class PacketPlayOutBlockBreakAnimation implements Packet {

   private int a;
   private Location b;
   private int c;


   public PacketPlayOutBlockBreakAnimation() {}

   public PacketPlayOutBlockBreakAnimation(int var1, Location var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.b = var1.c();
      this.c = var1.readUnsignedByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeByte(this.c);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
