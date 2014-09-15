package net.minecraft.server;

public class PacketPlayInCloseWindow implements Packet {

   private int a;


   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.a);
   }
}
