package net.minecraft.server;

public class mz implements Packet {

   private int a;
   private String b;
   private int c;
   private gy d;


   public void a(PacketDataSerializer var1) {
      this.a = var1.e();
      this.b = var1.c(255);
      this.c = var1.readUnsignedShort();
      this.d = gy.a(var1.e());
   }

   public void b(PacketDataSerializer var1) {
      var1.b(this.a);
      var1.a(this.b);
      var1.writeShort(this.c);
      var1.b(this.d.a());
   }

   public void a(PacketListener var1) {
      ((na)var1).a(this);
   }

   public gy a() {
      return this.d;
   }

   public int b() {
      return this.a;
   }
}
