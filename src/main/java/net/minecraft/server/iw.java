package net.minecraft.server;

public class iw implements Packet {

   private Location a;
   private IBlockData b;


   public iw() {}

   public iw(World var1, Location var2) {
      this.a = var2;
      this.b = var1.getData(var2);
   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.c();
      this.b = (IBlockData)Block.d.a(var1.e());
   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);
      var1.b(Block.d.b(this.b));
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
