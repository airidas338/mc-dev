package net.minecraft.server;
import java.io.ByteArrayOutputStream;

class bfw extends ByteArrayOutputStream {

   private int b;
   private int c;
   // $FF: synthetic field
   final bfv a;


   public bfw(bfv var1, int var2, int var3) {
      super(8096);
      this.a = var1;
      this.b = var2;
      this.c = var3;
   }

   public void close() {
      this.a.a(this.b, this.c, this.buf, this.count);
   }
}
