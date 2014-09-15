package net.minecraft.server;

public class ix implements Packet {

   private EnumDifficulty a;
   private boolean b;


   public ix() {}

   public ix(EnumDifficulty var1, boolean var2) {
      this.a = var1;
      this.b = var2;
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public void a(PacketDataSerializer var1) {
      this.a = EnumDifficulty.getById(var1.readUnsignedByte());
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.a.a());
   }
}
