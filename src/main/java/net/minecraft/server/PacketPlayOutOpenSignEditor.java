package net.minecraft.server;

public class PacketPlayOutOpenSignEditor implements Packet {

   private Location a;


   public PacketPlayOutOpenSignEditor() {}

   public PacketPlayOutOpenSignEditor(Location var1) {
      this.a = var1;
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.c();
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
   }
}
