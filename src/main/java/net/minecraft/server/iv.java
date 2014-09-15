package net.minecraft.server;

public class iv implements Packet {

   private Location a;
   private int b;
   private int c;
   private Block d;


   public iv() {}

   public iv(Location var1, Block var2, int var3, int var4) {
      this.a = var1;
      this.b = var3;
      this.c = var4;
      this.d = var2;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.c();
      this.b = var1.readUnsignedByte();
      this.c = var1.readUnsignedByte();
      this.d = Block.c(var1.e() & 4095);
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
      var1.writeByte(this.b);
      var1.writeByte(this.c);
      var1.b(Block.a(this.d) & 4095);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
