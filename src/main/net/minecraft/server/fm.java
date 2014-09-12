package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class fm extends ge {

   private byte b;


   fm() {}

   public fm(byte var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeByte(this.b);
   }

   void a(DataInput var1, int var2, fx var3) throws IOException  {
      var3.a(8L);
      this.b = var1.readByte();
   }

   public byte a() {
      return (byte)1;
   }

   public String toString() {
      return "" + this.b + "b";
   }

   public gd b() {
      return new fm(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         fm var2 = (fm)var1;
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
      return (short)this.b;
   }

   public byte f() {
      return this.b;
   }

   public double g() {
      return (double)this.b;
   }

   public float h() {
      return (float)this.b;
   }
}
