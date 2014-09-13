package net.minecraft.server;

public class PacketPlayOutKickDisconnect implements Packet {

   private IChatBaseComponent a;


   public PacketPlayOutKickDisconnect() {}

   public PacketPlayOutKickDisconnect(IChatBaseComponent var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.d();
   }

   public void b(hd var1) {
      var1.a(this.a);
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }
}
