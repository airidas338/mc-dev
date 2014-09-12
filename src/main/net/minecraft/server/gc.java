package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class gc extends gd {

   private String b;


   public gc() {
      this.b = "";
   }

   public gc(String var1) {
      this.b = var1;
      if(var1 == null) {
         throw new IllegalArgumentException("Empty string not allowed");
      }
   }

   void a(DataOutput var1) throws IOException {
      var1.writeUTF(this.b);
   }

   void a(DataInput var1, int var2, fx var3) throws IOException  {
      this.b = var1.readUTF();
      var3.a((long)(16 * this.b.length()));
   }

   public byte a() {
      return (byte)8;
   }

   public String toString() {
      return "\"" + this.b.replace("\"", "\\\"") + "\"";
   }

   public gd b() {
      return new gc(this.b);
   }

   public boolean c_() {
      return this.b.isEmpty();
   }

   public boolean equals(Object var1) {
      if(!super.equals(var1)) {
         return false;
      } else {
         gc var2 = (gc)var1;
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
