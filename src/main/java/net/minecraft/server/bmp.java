package net.minecraft.server;
import java.util.concurrent.Callable;

class bmp implements Callable {

   // $FF: synthetic field
   final bmm a;


   bmp(bmm var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.getClass().getCanonicalName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
