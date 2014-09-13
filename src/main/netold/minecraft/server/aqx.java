package net.minecraft.server;
import java.util.concurrent.Callable;

class aqx implements Callable {

   // $FF: synthetic field
   final aqu a;


   aqx(aqu var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.j.size() + " total; " + this.a.j.toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
