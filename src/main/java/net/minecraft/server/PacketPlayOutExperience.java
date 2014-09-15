package net.minecraft.server;

public class PacketPlayOutExperience implements Packet {

   private float a;
   private int b;
   private int c;


   public PacketPlayOutExperience() {}

   public PacketPlayOutExperience(float var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readFloat();
      this.c = var1.e();
      this.b = var1.e();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeFloat(this.a);
      var1.b(this.c);
      var1.b(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
