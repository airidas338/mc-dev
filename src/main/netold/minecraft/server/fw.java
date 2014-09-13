package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class fw extends ge {

   private long b;


   fw() {}

   public fw(long var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeLong(this.b);
   }

   void a(DataInput var1, int var2, fx var3) throws IOException {
      var3.a(64L);
      this.b = var1.readLong();
   }

   public byte a() {
      return (byte)4;
   }

   public String toString() {
      return "" + this.b + "L";
   }

   public gd b() {
      return new fw(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         fw var2 = (fw)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ (int)(this.b ^ this.b >>> 32);
   }

   public long c() {
      return this.b;
   }

   public int d() {
      return (int)(this.b & -1L);
   }

   public short e() {
      return (short)((int)(this.b & 65535L));
   }

   public byte f() {
      return (byte)((int)(this.b & 255L));
   }

   public double g() {
      return (double)this.b;
   }

   public float h() {
      return (float)this.b;
   }
}
