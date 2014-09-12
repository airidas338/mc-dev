package net.minecraft.server;
import java.util.concurrent.Callable;

final class p implements Callable {

   // $FF: synthetic field
   final IBlock a;


   p(IBlock var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.toString();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
