package net.minecraft.server;


public class ku implements Packet {

   public int a;


   public ku() {}

   public ku(Entity var1) {
      this.a = var1.F();
   }

   public void a(hd var1) {
      this.a = var1.e();
   }

   public void b(hd var1) {
      var1.b(this.a);
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }
}
