package net.minecraft.server;

public class PacketPlayInArmAnimation implements Packet {

   public void a(PacketDataSerializer var1) {}

   public void b(PacketDataSerializer var1) {}

   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }
}
