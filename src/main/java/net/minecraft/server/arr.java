package net.minecraft.server;
import com.google.common.collect.Lists;

import java.util.List;

public class arr {

   private final arz a;
   private long b;
   private ur c = new ur();
   private List d = Lists.newArrayList();


   public arr(arz var1) {
      this.a = var1;
   }

   public ars a(int var1, int var2) {
      var1 >>= 4;
      var2 >>= 4;
      long var3 = (long)var1 & 4294967295L | ((long)var2 & 4294967295L) << 32;
      ars var5 = (ars)this.c.a(var3);
      if(var5 == null) {
         var5 = new ars(this, var1, var2);
         this.c.a(var3, var5);
         this.d.add(var5);
      }

      var5.e = MinecraftServer.ax();
      return var5;
   }

   public arm a(int var1, int var2, arm var3) {
      arm var4 = this.a(var1, var2).a(var1, var2);
      return var4 == null?var3:var4;
   }

   public void a() {
      long var1 = MinecraftServer.ax();
      long var3 = var1 - this.b;
      if(var3 > 7500L || var3 < 0L) {
         this.b = var1;

         for(int var5 = 0; var5 < this.d.size(); ++var5) {
            ars var6 = (ars)this.d.get(var5);
            long var7 = var1 - var6.e;
            if(var7 > 30000L || var7 < 0L) {
               this.d.remove(var5--);
               long var9 = (long)var6.c & 4294967295L | ((long)var6.d & 4294967295L) << 32;
               this.c.d(var9);
            }
         }
      }

   }

   public arm[] c(int var1, int var2) {
      return this.a(var1, var2).b;
   }

   // $FF: synthetic method
   static arz a(arr var0) {
      return var0.a;
   }
}
