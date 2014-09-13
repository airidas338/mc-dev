package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class qq {

   private static final Logger a = LogManager.getLogger();
   private final qt b;
   private final List c = Lists.newArrayList();
   private final ur d = new ur();
   private final List e = Lists.newArrayList();
   private final List f = Lists.newArrayList();
   private int g;
   private long h;
   private final int[][] i = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};


   public qq(qt var1) {
      this.b = var1;
      this.a(var1.r().an().t());
   }

   public qt a() {
      return this.b;
   }

   public void b() {
      long var1 = this.b.K();
      int var3;
      qr var4;
      if(var1 - this.h > 8000L) {
         this.h = var1;

         for(var3 = 0; var3 < this.f.size(); ++var3) {
            var4 = (qr)this.f.get(var3);
            var4.b();
            var4.a();
         }
      } else {
         for(var3 = 0; var3 < this.e.size(); ++var3) {
            var4 = (qr)this.e.get(var3);
            var4.b();
         }
      }

      this.e.clear();
      if(this.c.isEmpty()) {
         bgd var5 = this.b.t;
         if(!var5.e()) {
            this.b.b.b();
         }
      }

   }

   public boolean a(int var1, int var2) {
      long var3 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
      return this.d.a(var3) != null;
   }

   private qr a(int var1, int var2, boolean var3) {
      long var4 = (long)var1 + 2147483647L | (long)var2 + 2147483647L << 32;
      qr var6 = (qr)this.d.a(var4);
      if(var6 == null && var3) {
         var6 = new qr(this, var1, var2);
         this.d.a(var4, var6);
         this.f.add(var6);
      }

      return var6;
   }

   public void a(dt var1) {
      int var2 = var1.n() >> 4;
      int var3 = var1.p() >> 4;
      qr var4 = this.a(var2, var3, false);
      if(var4 != null) {
         var4.a(var1.n() & 15, var1.o(), var1.p() & 15);
      }

   }

   public void a(qw var1) {
      int var2 = (int)var1.s >> 4;
      int var3 = (int)var1.u >> 4;
      var1.d = var1.s;
      var1.e = var1.u;

      for(int var4 = var2 - this.g; var4 <= var2 + this.g; ++var4) {
         for(int var5 = var3 - this.g; var5 <= var3 + this.g; ++var5) {
            this.a(var4, var5, true).a(var1);
         }
      }

      this.c.add(var1);
      this.b(var1);
   }

   public void b(qw var1) {
      ArrayList var2 = Lists.newArrayList(var1.f);
      int var3 = 0;
      int var4 = this.g;
      int var5 = (int)var1.s >> 4;
      int var6 = (int)var1.u >> 4;
      int var7 = 0;
      int var8 = 0;
      aqm var9 = qr.a(this.a(var5, var6, true));
      var1.f.clear();
      if(var2.contains(var9)) {
         var1.f.add(var9);
      }

      int var10;
      for(var10 = 1; var10 <= var4 * 2; ++var10) {
         for(int var11 = 0; var11 < 2; ++var11) {
            int[] var12 = this.i[var3++ % 4];

            for(int var13 = 0; var13 < var10; ++var13) {
               var7 += var12[0];
               var8 += var12[1];
               var9 = qr.a(this.a(var5 + var7, var6 + var8, true));
               if(var2.contains(var9)) {
                  var1.f.add(var9);
               }
            }
         }
      }

      var3 %= 4;

      for(var10 = 0; var10 < var4 * 2; ++var10) {
         var7 += this.i[var3][0];
         var8 += this.i[var3][1];
         var9 = qr.a(this.a(var5 + var7, var6 + var8, true));
         if(var2.contains(var9)) {
            var1.f.add(var9);
         }
      }

   }

   public void c(qw var1) {
      int var2 = (int)var1.d >> 4;
      int var3 = (int)var1.e >> 4;

      for(int var4 = var2 - this.g; var4 <= var2 + this.g; ++var4) {
         for(int var5 = var3 - this.g; var5 <= var3 + this.g; ++var5) {
            qr var6 = this.a(var4, var5, false);
            if(var6 != null) {
               var6.b(var1);
            }
         }
      }

      this.c.remove(var1);
   }

   private boolean a(int var1, int var2, int var3, int var4, int var5) {
      int var6 = var1 - var3;
      int var7 = var2 - var4;
      return var6 >= -var5 && var6 <= var5?var7 >= -var5 && var7 <= var5:false;
   }

   public void d(qw var1) {
      int var2 = (int)var1.s >> 4;
      int var3 = (int)var1.u >> 4;
      double var4 = var1.d - var1.s;
      double var6 = var1.e - var1.u;
      double var8 = var4 * var4 + var6 * var6;
      if(var8 >= 64.0D) {
         int var10 = (int)var1.d >> 4;
         int var11 = (int)var1.e >> 4;
         int var12 = this.g;
         int var13 = var2 - var10;
         int var14 = var3 - var11;
         if(var13 != 0 || var14 != 0) {
            for(int var15 = var2 - var12; var15 <= var2 + var12; ++var15) {
               for(int var16 = var3 - var12; var16 <= var3 + var12; ++var16) {
                  if(!this.a(var15, var16, var10, var11, var12)) {
                     this.a(var15, var16, true).a(var1);
                  }

                  if(!this.a(var15 - var13, var16 - var14, var2, var3, var12)) {
                     qr var17 = this.a(var15 - var13, var16 - var14, false);
                     if(var17 != null) {
                        var17.b(var1);
                     }
                  }
               }
            }

            this.b(var1);
            var1.d = var1.s;
            var1.e = var1.u;
         }
      }
   }

   public boolean a(qw var1, int var2, int var3) {
      qr var4 = this.a(var2, var3, false);
      return var4 != null && qr.b(var4).contains(var1) && !var1.f.contains(qr.a(var4));
   }

   public void a(int var1) {
      var1 = uv.a(var1, 3, 32);
      if(var1 != this.g) {
         int var2 = var1 - this.g;
         ArrayList var3 = Lists.newArrayList(this.c);
         Iterator var4 = var3.iterator();

         while(var4.hasNext()) {
            qw var5 = (qw)var4.next();
            int var6 = (int)var5.s >> 4;
            int var7 = (int)var5.u >> 4;
            int var8;
            int var9;
            if(var2 > 0) {
               for(var8 = var6 - var1; var8 <= var6 + var1; ++var8) {
                  for(var9 = var7 - var1; var9 <= var7 + var1; ++var9) {
                     qr var10 = this.a(var8, var9, true);
                     if(!qr.b(var10).contains(var5)) {
                        var10.a(var5);
                     }
                  }
               }
            } else {
               for(var8 = var6 - this.g; var8 <= var6 + this.g; ++var8) {
                  for(var9 = var7 - this.g; var9 <= var7 + this.g; ++var9) {
                     if(!this.a(var8, var9, var6, var7, var1)) {
                        this.a(var8, var9, true).b(var5);
                     }
                  }
               }
            }
         }

         this.g = var1;
      }
   }

   public static int b(int var0) {
      return var0 * 16 - 16;
   }

   // $FF: synthetic method
   static Logger c() {
      return a;
   }

   // $FF: synthetic method
   static qt a(qq var0) {
      return var0.b;
   }

   // $FF: synthetic method
   static ur b(qq var0) {
      return var0.d;
   }

   // $FF: synthetic method
   static List c(qq var0) {
      return var0.f;
   }

   // $FF: synthetic method
   static List d(qq var0) {
      return var0.e;
   }

}
