package net.minecraft.server;

public class PacketPlayInKeepAlive implements Packet {

   private int a;


   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
   }

   public int a() {
      return this.a;
   }
}
