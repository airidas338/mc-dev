package net.minecraft.server;

public class PacketPlayOutGameStateChange implements Packet {

   public static final String[] a = new String[]{"tile.bed.notValid"};
   private int b;
   private float c;


   public PacketPlayOutGameStateChange() {}

   public PacketPlayOutGameStateChange(int var1, float var2) {
      this.b = var1;
      this.c = var2;
   }

   public void a(PacketDataSerializer var1) {
      this.b = var1.readUnsignedByte();
      this.c = var1.readFloat();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeByte(this.b);
      var1.writeFloat(this.c);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

}
