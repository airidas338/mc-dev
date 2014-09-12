package net.minecraft.server;

public class nw implements id {

   private long a;


   public void a(hd var1) {
      this.a = var1.readLong();
   }

   public void b(hd var1) {
      var1.writeLong(this.a);
   }

   public void a(PacketListener var1) {
      ((nv)var1).a(this);
   }

   public long a() {
      return this.a;
   }
}
