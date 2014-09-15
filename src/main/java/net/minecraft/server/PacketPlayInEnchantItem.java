package net.minecraft.server;

public class PacketPlayInEnchantItem implements Packet {

   private int a;
   private int b;


   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readByte();
      this.b = var1.readByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.a);
      var1.writeByte(this.b);
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }
}
