package net.minecraft.server;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public abstract class gd {

   public static final String[] a = new String[]{"END", "BYTE", "SHORT", "INT", "LONG", "FLOAT", "DOUBLE", "BYTE[]", "STRING", "LIST", "COMPOUND", "INT[]"};


   abstract void a(DataOutput var1) throws IOException;

   abstract void a(DataInput var1, int var2, fx var3) throws IOException ;

   public abstract String toString();

   public abstract byte a();

   protected static gd a(byte var0) {
      switch(var0) {
      case 0:
         return new fr();
      case 1:
         return new fm();
      case 2:
         return new gb();
      case 3:
         return new fu();
      case 4:
         return new fw();
      case 5:
         return new fs();
      case 6:
         return new fq();
      case 7:
         return new fl();
      case 8:
         return new gc();
      case 9:
         return new fv();
      case 10:
         return new fn();
      case 11:
         return new ft();
      default:
         return null;
      }
   }

   public abstract gd b();

   public boolean c_() {
      return false;
   }

   public boolean equals(Object var1) {
      if(!(var1 instanceof gd)) {
         return false;
      } else {
         gd var2 = (gd)var1;
         return this.a() == var2.a();
      }
   }

   public int hashCode() {
      return this.a();
   }

   protected String a_() {
      return this.toString();
   }

}
