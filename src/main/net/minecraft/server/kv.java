package net.minecraft.server;

public class kv implements id {

   private int a;


   public kv() {}

   public kv(int var1) {
      this.a = var1;
   }

   public void a(hd var1) {
      this.a = var1.readByte();
   }

   public void b(hd var1) {
      var1.writeByte(this.a);
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }
}
