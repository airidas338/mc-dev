package net.minecraft.server;

public class PacketPlayOutSpawnPosition implements Packet {

   private Location a;


   public PacketPlayOutSpawnPosition() {}

   public PacketPlayOutSpawnPosition(Location var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.c();
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
