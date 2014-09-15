package net.minecraft.server;


public class PacketPlayOutSpawnEntityExperienceOrb implements Packet {

   private int a;
   private int b;
   private int c;
   private int d;
   private int e;


   public PacketPlayOutSpawnEntityExperienceOrb() {}

   public PacketPlayOutSpawnEntityExperienceOrb(EntityExperienceOrb var1) {
      this.a = var1.F();
      this.b = MathHelper.floor(var1.s * 32.0D);
      this.c = MathHelper.floor(var1.t * 32.0D);
      this.d = MathHelper.floor(var1.u * 32.0D);
      this.e = var1.j();
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
      this.e = var1.readShort();
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
      var1.writeShort(this.e);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
