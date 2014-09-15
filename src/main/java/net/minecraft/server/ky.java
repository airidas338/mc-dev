package net.minecraft.server;


public class ky implements Packet {

   private int a;
   private int b;
   private int c;


   public ky() {}

   public ky(int var1, Entity var2, Entity var3) {
      this.a = var1;
      this.b = var2.F();
      this.c = var3 != null?var3.F():-1;
   }

   public void a(PacketDataSerializer var1) {
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.a = var1.readUnsignedByte();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeByte(this.a);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
