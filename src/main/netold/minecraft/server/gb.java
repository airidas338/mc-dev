package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class gb extends ge {

   private short b;


   public gb() {}

   public gb(short var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeShort(this.b);
   }

   void a(DataInput var1, int var2, fx var3) throws IOException {
      var3.a(16L);
      this.b = var1.readShort();
   }

   public byte a() {
      return (byte)2;
   }

   public String toString() {
      return "" + this.b + "s";
   }

   public gd b() {
      return new gb(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         gb var2 = (gb)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.b;
   }

   public long c() {
      return (long)this.b;
   }

   public int d() {
      return this.b;
   }

   public short e() {
      return this.b;
   }

   public byte f() {
      return (byte)(this.b & 255);
   }

   public double g() {
      return (double)this.b;
   }

   public float h() {
      return (float)this.b;
   }
}
