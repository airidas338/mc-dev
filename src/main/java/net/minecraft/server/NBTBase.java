package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class NBTBase {

   public static final String[] a = new String[]{"END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]"};


   abstract void a(DataOutput var1) throws IOException;

   abstract void a(DataInput var1, int var2, NBTReadLimiter var3) throws IOException;

   public abstract String toString();

   public abstract byte getTypeId();

   protected static NBTBase a(byte var0) {
      switch(var0) {
      case 0:
         return new fr();
      case 1:
         return new NBTTagByte();
      case 2:
         return new NBTTagShort();
      case 3:
         return new NBTTagInt();
      case 4:
         return new NBTTagLong();
      case 5:
         return new NBTTagFloat();
      case 6:
         return new NBTTagDouble();
      case 7:
         return new NBTTagByteArray();
      case 8:
         return new NBTTagString();
      case 9:
         return new NBTTagList();
      case 10:
         return new NBTTagCompound();
      case 11:
         return new NBTTagIntArray();
      default:
         return null;
      }
   }

   public abstract NBTBase b();

   public boolean c_() {
      return false;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof NBTBase)) {
         return false;
      } else {
         NBTBase var2 = (NBTBase)var1;
         return this.getTypeId() == var2.getTypeId();
      }
   }

   public int hashCode() {
      return this.getTypeId();
   }

   protected String a_() {
      return this.toString();
   }

}
