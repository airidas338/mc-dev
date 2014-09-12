package net.minecraft.server;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class fz {

   public static fn a(InputStream var0) throws IOException {
      DataInputStream var1 = new DataInputStream(new BufferedInputStream(new GZIPInputStream(var0)));

      fn var2;
      try {
         var2 = a((DataInput)var1, fx.a);
      } finally {
         var1.close();
      }

      return var2;
   }

   public static void a(fn var0, OutputStream var1) throws IOException {
      DataOutputStream var2 = new DataOutputStream(new BufferedOutputStream(new GZIPOutputStream(var1)));

      try {
         a(var0, (DataOutput)var2);
      } finally {
         var2.close();
      }

   }

   public static fn a(DataInputStream var0) throws IOException {
      return a((DataInput)var0, fx.a);
   }

   public static fn a(DataInput var0, fx var1) throws IOException {
      gd var2 = a(var0, 0, var1);
      if(var2 instanceof fn) {
         return (fn)var2;
      } else {
         throw new IOException("Root tag must be a named compound tag");
      }
   }

   public static void a(fn var0, DataOutput var1) throws IOException {
      a((gd)var0, var1);
   }

   private static void a(gd var0, DataOutput var1) throws IOException {
      var1.writeByte(var0.a());
      if(var0.a() != 0) {
         var1.writeUTF("");
         var0.a(var1);
      }
   }

   private static gd a(DataInput var0, int var1, fx var2) throws IOException {
      byte var3 = var0.readByte();
      if(var3 == 0) {
         return new fr();
      } else {
         var0.readUTF();
         gd var4 = gd.a(var3);

         try {
            var4.a(var0, var1, var2);
            return var4;
         } catch (IOException var8) {
            CrashReport var6 = CrashReport.a(var8, "Loading NBT data");
            CrashReportSystemDetails var7 = var6.a("NBT Tag");
            var7.a("Tag name", (Object)"[UNNAMED TAG]");
            var7.a("Tag type", (Object)Byte.valueOf(var3));
            throw new ReportedException(var6);
         }
      }
   }
}
