package net.minecraft.server;

public class mj extends PacketPlayInFlying {

   public mj() {
      this.h = true;
   }

   public void a(PacketDataSerializer var1) {
      this.d = var1.readFloat();
      this.e = var1.readFloat();
      super.a(var1);
   }

   public void b(PacketDataSerializer var1) {
      var1.writeFloat(this.d);
      var1.writeFloat(this.e);
      super.b(var1);
   }
}
