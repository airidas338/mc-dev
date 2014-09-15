package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class NBTTagString extends NBTBase {

   private String b;


   public NBTTagString() {
      this.b = "";
   }

   public NBTTagString(String var1) {
      this.b = var1;
      if(var1 == null) {
         throw new IllegalArgumentException("Empty string not allowed");
      }
   }

   void write(DataOutput var1) throws IOException {
      var1.writeUTF(this.b);
   }

   void load(DataInput var1, int var2, NBTReadLimiter var3) throws IOException  {
      this.b = var1.readUTF();
      var3.a((long)(16 * this.b.length()));
   }

   public byte getTypeId() {
      return (byte)8;
   }

   public String toString() {
      return "\"" + this.b.replace("\"", "\\\"") + "\"";
   }

   public NBTBase clone() {
      return new NBTTagString(this.b);
   }

   public boolean isEmpty() {
      return this.b.isEmpty();
   }

   public boolean equals(Object var1) {
      if(!super.equals(var1)) {
         return false;
      } else {
         NBTTagString var2 = (NBTTagString)var1;
         return this.b == null && var2.b == null || this.b != null && this.b.equals(var2.b);
      }
   }

   public int hashCode() {
      return super.hashCode() ^ this.b.hashCode();
   }

   public String a_() {
      return this.b;
   }
}
