package net.minecraft.server;

public class it implements Packet {

   private int a;
   private Location b;
   private int c;


   public it() {}

   public it(int var1, Location var2, int var3) {
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void a(hd var1) {
      this.a = var1.e();
      this.b = var1.c();
      this.c = var1.readUnsignedByte();
   }

   public void b(hd var1) {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeByte(this.c);
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }
}
