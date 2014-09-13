package net.minecraft.server;
import java.util.concurrent.Callable;

class wx implements Callable {

   // $FF: synthetic field
   final wv a;


   wx(wv var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.d_();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
