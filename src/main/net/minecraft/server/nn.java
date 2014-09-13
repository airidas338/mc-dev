package net.minecraft.server;

public class nn implements Packet {

   private long a;


   public nn() {}

   public nn(long var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.readLong();
   }

   public void b(hd var1) {
      var1.writeLong(this.a);
   }

   public void a(PacketListener var1) {
      ((nm)var1).a(this);
   }
}
