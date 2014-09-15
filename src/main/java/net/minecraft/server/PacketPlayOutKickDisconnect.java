package net.minecraft.server;

public class PacketPlayOutKickDisconnect implements Packet {

   private IChatBaseComponent a;


   public PacketPlayOutKickDisconnect() {}

   public PacketPlayOutKickDisconnect(IChatBaseComponent var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.d();
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
