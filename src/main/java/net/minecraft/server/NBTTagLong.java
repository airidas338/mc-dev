package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagLong extends NBTNumber {

   private long b;


   NBTTagLong() {}

   public NBTTagLong(long var1) {
      this.b = var1;
   }

   void write(DataOutput var1) throws IOException {
      var1.writeLong(this.b);
   }

   void load(DataInput var1, int var2, NBTReadLimiter var3) throws IOException  {
      var3.a(64L);
      this.b = var1.readLong();
   }

   public byte getTypeId() {
      return (byte)4;
   }

   public String toString() {
      return "" + this.b + "L";
   }

   public NBTBase clone() {
      return new NBTTagLong(this.b);
   }

   public boolean equals(Object var1) {
      if(super.equals(var1)) {
         NBTTagLong var2 = (NBTTagLong)var1;
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
