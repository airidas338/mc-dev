package net.minecraft.server;

public class lh implements Packet {

   private Location a;


   public lh() {}

   public lh(Location var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.c();
   }

   public void b(hd var1) {
      var1.a(this.a);
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }
}
