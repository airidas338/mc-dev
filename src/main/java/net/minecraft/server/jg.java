package net.minecraft.server;

public class jg implements Packet {

   private int a;
   private int b;
   private int c;


   public jg() {}

   public jg(int var1, int var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readUnsignedByte();
      this.b = var1.readShort();
      this.c = var1.readShort();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeShort(this.c);
   }
}
