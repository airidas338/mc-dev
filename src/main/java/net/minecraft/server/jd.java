package net.minecraft.server;

public class jd implements Packet {

   private int a;


   public jd() {}

   public jd(int var1) {
      this.a = var1;
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public void a(hd var1) {
      this.a = var1.readUnsignedByte();
   }

   public void b(hd var1) {
      var1.writeByte(this.a);
   }
}
