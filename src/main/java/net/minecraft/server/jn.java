package net.minecraft.server;

public class jn implements Packet {

   private int a;


   public void a(hd var1) {
      this.a = var1.e();
   }

   public void b(hd var1) {
      var1.b(this.a);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
