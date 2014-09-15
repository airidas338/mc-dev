package net.minecraft.server;

public class PacketPlayOutUpdateTime implements Packet {

   private long a;
   private long b;


   public PacketPlayOutUpdateTime() {}

   public PacketPlayOutUpdateTime(long var1, long var3, boolean var5) {
      this.a = var1;
      this.b = var3;
      if(!var5) {
         this.b = -this.b;
         if(this.b == 0L) {
            this.b = -1L;
         }
      }

   }

   public void a(PacketDataSerializer var1) {
      this.a = var1.readLong();
      this.b = var1.readLong();
   }

   public void b(PacketDataSerializer var1) {
      var1.writeLong(this.a);
      var1.writeLong(this.b);
   }

   public void a(PacketListener var1) {
      ((PacketPlayOutListener)var1).a(this);
   }
}
