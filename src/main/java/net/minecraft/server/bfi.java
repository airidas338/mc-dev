package net.minecraft.server;
import java.util.concurrent.Callable;

class bfi implements Callable {

   // $FF: synthetic field
   final int a;
   // $FF: synthetic field
   final int b;
   // $FF: synthetic field
   final int c;
   // $FF: synthetic field
   final Chunk d;


   bfi(Chunk var1, int var2, int var3, int var4) {
      this.d = var1;
      this.a = var2;
      this.b = var3;
      this.c = var4;
   }

   public String a() {
      return CrashReportSystemDetails.a(new Location(this.d.a * 16 + this.a, this.b, this.d.b * 16 + this.c));
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
