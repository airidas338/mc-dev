package net.minecraft.server;

public class ng implements Packet {

   private IChatBaseComponent a;


   public ng() {}

   public ng(IChatBaseComponent var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.d();
   }

   public void b(hd var1) {
      var1.a(this.a);
   }

   public void a(PacketListener var1) {
      ((nc)var1).a(this);
   }
}
