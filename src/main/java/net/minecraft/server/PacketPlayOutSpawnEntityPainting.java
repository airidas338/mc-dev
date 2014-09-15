package net.minecraft.server;

public class PacketPlayOutSpawnEntityPainting implements Packet {

   private int a;
   private Location b;
   private EnumFacing c;
   private String d;


   public PacketPlayOutSpawnEntityPainting() {}

   public PacketPlayOutSpawnEntityPainting(EntityPainting var1) {
      this.a = var1.F();
      this.b = var1.n();
      this.c = var1.b;
      this.d = var1.c.B;
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.d = var1.c(EnumArt.A);
      this.b = var1.c();
      this.c = EnumFacing.b(var1.readUnsignedByte());
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.a(this.d);
      var1.a(this.b);
      var1.writeByte(this.c.b());
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
