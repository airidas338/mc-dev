package net.minecraft.server;
import java.util.concurrent.Callable;

class rh implements Callable {

   // $FF: synthetic field
   final gr a;
   // $FF: synthetic field
   final rc b;


   rh(rc var1, gr var2) {
      this.b = var1;
      this.a = var2;
   }

   public String a() {
      return this.a.toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
