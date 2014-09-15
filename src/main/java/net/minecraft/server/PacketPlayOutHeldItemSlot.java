package net.minecraft.server;

public class PacketPlayOutHeldItemSlot implements Packet {

   private int a;


   public PacketPlayOutHeldItemSlot() {}

   public PacketPlayOutHeldItemSlot(int var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.a);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
