package net.minecraft.server;
import com.google.common.cache.CacheLoader;

class bel extends CacheLoader {

   private final World a;


   public bel(World var1) {
      this.a = var1;
   }

   public bei a(dt var1) {
      return new bei(this.a, var1);
   }

   // $FF: synthetic method
   public Object load(Object var1) {
      return this.a((dt)var1);
   }
}
