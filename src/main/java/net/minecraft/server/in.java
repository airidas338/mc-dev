package net.minecraft.server;


public class in implements Packet {

   private int a;
   private int b;
   private int c;
   private int d;
   private int e;


   public in() {}

   public in(Entity var1) {
      this.a = var1.F();
      this.b = MathHelper.c(var1.s * 32.0D);
      this.c = MathHelper.c(var1.t * 32.0D);
      this.d = MathHelper.c(var1.u * 32.0D);
      if(var1 instanceof EntityLightning) {
         this.e = 1;
      }

   }

   public void a(hd var1) {
      this.a = var1.e();
      this.e = var1.readByte();
      this.b = var1.readInt();
      this.c = var1.readInt();
      this.d = var1.readInt();
   }

   public void b(hd var1) {
      var1.b(this.a);
      var1.writeByte(this.e);
      var1.writeInt(this.b);
      var1.writeInt(this.c);
      var1.writeInt(this.d);
   }

   public void a(PacketListener var1) {
      ((ik)var1).a(this);
   }
}
