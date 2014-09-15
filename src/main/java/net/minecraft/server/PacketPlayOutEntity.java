package net.minecraft.server;

public class PacketPlayOutEntity implements Packet {

   protected int a;
   protected byte b;
   protected byte c;
   protected byte d;
   protected byte e;
   protected byte f;
   protected boolean g;
   protected boolean h;


   public PacketPlayOutEntity() {}

   public PacketPlayOutEntity(int var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }

   public String toString() {
      return "Entity_" + super.toString();
   }
}
