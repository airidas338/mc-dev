package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class fr extends NBTBase {

   void a(DataInput var1, int var2, NBTReadLimiter var3) throws IOException  {}

   void a(DataOutput var1) {}

   public byte getTypeId() {
      return (byte)0;
   }

   public String toString() {
      return "END";
   }

   public NBTBase b() {
      return new fr();
   }
}
