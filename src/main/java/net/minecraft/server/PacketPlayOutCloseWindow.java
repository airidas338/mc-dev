package net.minecraft.server;

public class PacketPlayOutCloseWindow implements Packet {

   private int a;


   public PacketPlayOutCloseWindow() {}

   public PacketPlayOutCloseWindow(int var1) {
      this.a = var1;
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readUnsignedByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.a);
   }
}
