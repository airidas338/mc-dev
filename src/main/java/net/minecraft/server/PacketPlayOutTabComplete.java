package net.minecraft.server;

public class PacketPlayOutTabComplete implements Packet {

   private String[] a;


   public PacketPlayOutTabComplete() {}

   public PacketPlayOutTabComplete(String[] var1) {
      this.a = var1;
   }

   public void a(PacketDataSerializer var1) {
      this.a = new String[var1.e()];

      for(int var2 = 0; var2 < this.a.length; ++var2) {
         this.a[var2] = var1.c(32767);
      }

   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a.length);
      String[] var2 = this.a;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         var1.a(var5);
      }

   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
