package net.minecraft.server;

public class PacketPlayOutEntityDestroy implements Packet {

   private int[] a;


   public PacketPlayOutEntityDestroy() {}

   public PacketPlayOutEntityDestroy(int ... var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = new int[var1.e()];

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = var1.e();
      }

   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a.length);

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         var1.b(this.a[var2]);
      }

   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
