package net.minecraft.server;

public class PacketPlayInUpdateSign implements Packet {

   private Location a;
   private IChatBaseComponent[] b;


   public void a(PacketDataSerializer var1) {
      this.a = var1.c();
      this.b = new IChatBaseComponent[4];

      for(int var2 = 0; var2 < 4; ++var2) {
         this.b[var2] = var1.d();
      }

   }

   public void b(PacketDataSerializer var1) {
      var1.a(this.a);

      for(int var2 = 0; var2 < 4; ++var2) {
         var1.a(this.b[var2]);
      }

   }

   public void a(PacketListener var1) {
      ((PacketPlayInListener)var1).a(this);
   }

   public Location a() {
      return this.a;
   }

   public IChatBaseComponent[] b() {
      return this.b;
   }
}
