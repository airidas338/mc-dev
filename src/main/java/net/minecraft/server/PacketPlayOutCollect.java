package net.minecraft.server;

public class PacketPlayOutCollect implements Packet {

   private int a;
   private int b;


   public PacketPlayOutCollect() {}

   public PacketPlayOutCollect(int var1, int var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.b = var1.e();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.b(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
