package net.minecraft.server;

public class jp implements Packet {

   private int a;


   public jp() {}

   public jp(int var1) {
      this.a = var1;
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }

   public void a(hd var1) {
      this.a = var1.e();
   }

   public void b(hd var1) {
      var1.b(this.a);
   }
}