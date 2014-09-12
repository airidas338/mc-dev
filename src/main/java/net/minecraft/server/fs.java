package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class fs extends ge {

   private float b;


   fs() {}

   public fs(float var1) {
      this.b = var1;
   }

   void a(DataOutput var1) throws IOException {
      var1.writeFloat(this.b);
   }

   void a(DataInput var1, int var2, fx var3) throws IOException  {
      var3.a(32L);
      this.b = var1.readFloat();
   }

   public byte a() {
      return (byte)5;
   }

   public String toString() {
      return "" + this.b + "f";
   }

   public gd b() {
      return new fs(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         fs var2 = (fs)var1;
         return this.b == var2.b;
      } else {
         return false;
      }
   }

   public int hashCode() {
      return super.hashCode() ^ Float.floatToIntBits(this.b);
   }

   public long c() {
      return (long)this.b;
   }

   public int d() {
      return MathHelper.d(this.b);
   }

   public short e() {
      return (short)(MathHelper.d(this.b) & '\uffff');
   }

   public byte f() {
      return (byte)(MathHelper.d(this.b) & 255);
   }

   public double g() {
      return (double)this.b;
   }

   public float h() {
      return this.b;
   }
}
