package net.minecraft.server;

public class mb implements Packet {

   private int a;


   public void a(PacketListener var1) {
      ((ls)var1).a(this);
   }

   public void a(hd var1) {
      this.a = var1.readByte();
   }

   public void b(hd var1) {
      var1.writeByte(this.a);
   }
}