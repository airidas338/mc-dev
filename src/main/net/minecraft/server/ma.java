package net.minecraft.server;
import java.io.IOException;


public class ma implements id {

   private int a;
   private int b;
   private int c;
   private short d;
   private amj e;
   private int f;


   public void a(PacketListener var1) {
      ((ls)var1).a(this);
   }

   public void a(hd var1) throws IOException {
      this.a = var1.readByte();
      this.b = var1.readShort();
      this.c = var1.readByte();
      this.d = var1.readShort();
      this.f = var1.readByte();
      this.e = var1.i();
   }

   public void b(hd var1) throws IOException {
      var1.writeByte(this.a);
      var1.writeShort(this.b);
      var1.writeByte(this.c);
      var1.writeShort(this.d);
      var1.writeByte(this.f);
      var1.a(this.e);
   }

   public int a() {
      return this.a;
   }

   public int b() {
      return this.b;
   }

   public int c() {
      return this.c;
   }

   public short d() {
      return this.d;
   }

   public amj e() {
      return this.e;
   }

   public int f() {
      return this.f;
   }
}
