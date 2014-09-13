package net.minecraft.server;
import java.util.concurrent.Callable;

class wy implements Callable {

   // $FF: synthetic field
   final wv a;


   wy(wv var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.l.toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
