package net.minecraft.server;

public class PacketPlayInBlockDig implements Packet {

   private Location a;
   private EnumFacing b;
   private mm c;


   public void a(PacketDataSerializer var1) {
      this.c = (mm)var1.a(mm.class);
      this.a = var1.c();
      this.b = EnumFacing.a(var1.readUnsignedByte());
   }

   public void b(PacketDataSerializer var1) {
      var1.a((Enum)this.c);
      var1.a(this.a);
      var1.writeByte(this.b.a());
   }

   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public Location a() {
      return this.a;
   }

   public EnumFacing b() {
      return this.b;
   }

   public mm c() {
      return this.c;
   }
}
