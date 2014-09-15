package net.minecraft.server;

public class PacketPlayInHeldItemSlot implements Packet {

   private int a;


   public void a(PacketDataSerializer var1) {
      this.a = var1.readShort();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeShort(this.a);
   }

   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public int a() {
      return this.a;
   }
}
