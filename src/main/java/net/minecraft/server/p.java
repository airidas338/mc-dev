package net.minecraft.server;
import java.util.concurrent.Callable;

final class p implements Callable {

   // $FF: synthetic field
   final IBlockData a;


   p(IBlockData var1) {
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
