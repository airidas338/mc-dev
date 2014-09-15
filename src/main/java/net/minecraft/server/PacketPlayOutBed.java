package net.minecraft.server;

public class PacketPlayOutBed implements Packet {

   private int a;
   private Location b;


   public PacketPlayOutBed() {}

   public PacketPlayOutBed(EntityHuman var1, Location var2) {
      this.a = var1.F();
      this.b = var2;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.b = var1.c();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.a(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
