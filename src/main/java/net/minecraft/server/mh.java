package net.minecraft.server;

public class mh extends PacketPlayInFlying {

   public mh() {
      this.g = true;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readDouble();
      this.b = var1.readDouble();
      this.c = var1.readDouble();
      super.a(var1);
   }

   public void b(PacketDataSerializer var1) {
      var1.writeDouble(this.a);
      var1.writeDouble(this.b);
      var1.writeDouble(this.c);
      super.b(var1);
   }
}
