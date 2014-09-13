package net.minecraft.server;
import java.util.concurrent.Callable;

class wz implements Callable {

   // $FF: synthetic field
   final wv a;


   wz(wv var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.m.toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
