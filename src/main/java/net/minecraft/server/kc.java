package net.minecraft.server;

public class kc implements Packet {

   private Location a;


   public kc() {}

   public kc(Location var1) {
      this.a = var1;
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }

   public void a(hd var1) {
      this.a = var1.c();
   }

   public void b(hd var1) {
      var1.a(this.a);
   }
}
