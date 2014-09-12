package net.minecraft.server;
import com.google.common.collect.Lists;
import java.util.Iterator;
import java.util.List;

public class abl extends bqc {

   private World b;
   private final List c = Lists.newArrayList();
   private final List d = Lists.newArrayList();
   private final List e = Lists.newArrayList();
   private int f;


   public abl(String var1) {
      super(var1);
   }

   public abl(World var1) {
      super(a(var1.t));
      this.b = var1;
      this.c();
   }

   public void a(World var1) {
      this.b = var1;
      Iterator var2 = this.e.iterator();

      while(var2.hasNext()) {
         abi var3 = (abi)var2.next();
         var3.a(var1);
      }

   }

   public void a(dt var1) {
      if(this.c.size() <= 64) {
         if(!this.e(var1)) {
            this.c.add(var1);
         }

      }
   }

   public void a() {
      ++this.f;
      Iterator var1 = this.e.iterator();

      while(var1.hasNext()) {
         abi var2 = (abi)var1.next();
         var2.a(this.f);
      }

      this.e();
      this.f();
      this.g();
      if(this.f % 400 == 0) {
         this.c();
      }

   }

   private void e() {
      Iterator var1 = this.e.iterator();

      while(var1.hasNext()) {
         abi var2 = (abi)var1.next();
         if(var2.g()) {
            var1.remove();
            this.c();
         }
      }

   }

   public List b() {
      return this.e;
   }

   public abi a(dt var1, int var2) {
      abi var3 = null;
      double var4 = 3.4028234663852886E38D;
      Iterator var6 = this.e.iterator();

      while(var6.hasNext()) {
         abi var7 = (abi)var6.next();
         double var8 = var7.a().i(var1);
         if(var8 < var4) {
            float var10 = (float)(var2 + var7.b());
            if(var8 <= (double)(var10 * var10)) {
               var3 = var7;
               var4 = var8;
            }
         }
      }

      return var3;
   }

   private void f() {
      if(!this.c.isEmpty()) {
         this.b((dt)this.c.remove(0));
      }
   }

   private void g() {
      for(int var1 = 0; var1 < this.d.size(); ++var1) {
         abh var2 = (abh)this.d.get(var1);
         abi var3 = this.a(var2.d(), 32);
         if(var3 == null) {
            var3 = new abi(this.b);
            this.e.add(var3);
            this.c();
         }

         var3.a(var2);
      }

      this.d.clear();
   }

   private void b(dt var1) {
      byte var2 = 16;
      byte var3 = 4;
      byte var4 = 16;

      for(int var5 = -var2; var5 < var2; ++var5) {
         for(int var6 = -var3; var6 < var3; ++var6) {
            for(int var7 = -var4; var7 < var4; ++var7) {
               dt var8 = var1.a(var5, var6, var7);
               if(this.f(var8)) {
                  abh var9 = this.c(var8);
                  if(var9 == null) {
                     this.d(var8);
                  } else {
                     var9.a(this.f);
                  }
               }
            }
         }
      }

   }

   private abh c(dt var1) {
      Iterator var2 = this.d.iterator();

      abh var3;
      do {
         if(!var2.hasNext()) {
            var2 = this.e.iterator();

            abh var4;
            do {
               if(!var2.hasNext()) {
                  return null;
               }

               abi var5 = (abi)var2.next();
               var4 = var5.e(var1);
            } while(var4 == null);

            return var4;
         }

         var3 = (abh)var2.next();
      } while(var3.d().n() != var1.n() || var3.d().p() != var1.p() || Math.abs(var3.d().o() - var1.o()) > 1);

      return var3;
   }

   private void d(dt var1) {
      ej var2 = avf.h(this.b, var1);
      ej var3 = var2.d();
      int var4 = this.a(var1, var2, 5);
      int var5 = this.a(var1, var3, var4 + 1);
      if(var4 != var5) {
         this.d.add(new abh(var1, var4 < var5?var2:var3, this.f));
      }

   }

   private int a(dt var1, ej var2, int var3) {
      int var4 = 0;

      for(int var5 = 1; var5 <= 5; ++var5) {
         if(this.b.i(var1.a(var2, var5))) {
            ++var4;
            if(var4 >= var3) {
               return var4;
            }
         }
      }

      return var4;
   }

   private boolean e(dt var1) {
      Iterator var2 = this.c.iterator();

      dt var3;
      do {
         if(!var2.hasNext()) {
            return false;
         }

         var3 = (dt)var2.next();
      } while(!var3.equals(var1));

      return true;
   }

   private boolean f(dt var1) {
      atr var2 = this.b.p(var1).c();
      return var2 instanceof avf?var2.r() == bof.d:false;
   }

   public void a(fn var1) {
      this.f = var1.f("Tick");
      fv var2 = var1.c("Villages", 10);

      for(int var3 = 0; var3 < var2.c(); ++var3) {
         fn var4 = var2.b(var3);
         abi var5 = new abi();
         var5.a(var4);
         this.e.add(var5);
      }

   }

   public void b(fn var1) {
      var1.a("Tick", this.f);
      fv var2 = new fv();
      Iterator var3 = this.e.iterator();

      while(var3.hasNext()) {
         abi var4 = (abi)var3.next();
         fn var5 = new fn();
         var4.b(var5);
         var2.a((gd)var5);
      }

      var1.a("Villages", (gd)var2);
   }

   public static String a(bgd var0) {
      return "villages" + var0.l();
   }
}
