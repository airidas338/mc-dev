package net.minecraft.server;

import java.util.concurrent.Callable;

class wx implements Callable {

   // $FF: synthetic field
   final Entity a;


   wx(Entity var1) {
      this.a = var1;
   }

   public String a() {
      return this.a.getName();
   }

   // $FF: synthetic method
   public Object call() {
      return this.a();
   }
}
