package net.minecraft.server;

public class lv implements Packet {

   private lw a;


   public lv() {}

   public lv(lw var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = (lw)var1.a(lw.class);
   }

   public void b(hd var1) {
      var1.a((Enum)this.a);
   }

   public void a(PacketListener var1) {
      ((ls)var1).a(this);
   }

   public lw a() {
      return this.a;
   }
}
