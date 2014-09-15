package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class fr extends NBTBase {

   void load(DataInput var1, int var2, NBTReadLimiter var3) throws IOException  {}

   void write(DataOutput var1) {}

   public byte getTypeId() {
      return (byte)0;
   }

   public String toString() {
      return "END";
   }

   public NBTBase clone() {
      return new fr();
   }
}
