package net.minecraft.server;

public class kb extends PacketPlayOutEntity {

   public kb() {
      this.h = true;
   }

   public kb(int var1, byte var2, byte var3, boolean var4) {
      super(var1);
      this.e = var2;
      this.f = var3;
      this.h = true;
      this.g = var4;
   }

   public void a(PacketDataSerializer var1) {
      super.a(var1);
      this.e = var1.readByte();
      this.f = var1.readByte();
      this.g = var1.readBoolean();
   }

   public void b(PacketDataSerializer var1) {
      super.b(var1);
      var1.writeByte(this.e);
      var1.writeByte(this.f);
      var1.writeBoolean(this.g);
   }
}
