package net.minecraft.server;

public class ze extends zn {

   private final agp c;
   private boolean d;
   private boolean e;
   private int f;


   public ze(agp var1, double var2) {
      super(var1, var2, 16);
      this.c = var1;
   }

   public boolean a() {
      if(this.a <= 0) {
         if(!this.c.o.Q().b("mobGriefing")) {
            return false;
         }

         this.f = -1;
         this.d = this.c.cs();
         this.e = this.c.cr();
      }

      return super.a();
   }

   public boolean b() {
      return this.f >= 0 && super.b();
   }

   public void c() {
      super.c();
   }

   public void d() {
      super.d();
   }

   public void e() {
      super.e();
      this.c.p().a((double)this.b.n() + 0.5D, (double)(this.b.o() + 1), (double)this.b.p() + 0.5D, 10.0F, (float)this.c.bP());
      if(this.f()) {
         aqu var1 = this.c.o;
         dt var2 = this.b.a();
         bec var3 = var1.p(var2);
         atr var4 = var3.c();
         if(this.f == 0 && var4 instanceof auu && ((Integer)var3.b(auu.a)).intValue() == 7) {
            var1.b(var2, true);
         } else if(this.f == 1 && var4 == aty.a) {
            wa var5 = this.c.co();

            for(int var6 = 0; var6 < var5.n_(); ++var6) {
               amj var7 = var5.a(var6);
               boolean var8 = false;
               if(var7 != null) {
                  if(var7.b() == amk.N) {
                     var1.a(var2, aty.aj.P(), 3);
                     var8 = true;
                  } else if(var7.b() == amk.bS) {
                     var1.a(var2, aty.cc.P(), 3);
                     var8 = true;
                  } else if(var7.b() == amk.bR) {
                     var1.a(var2, aty.cb.P(), 3);
                     var8 = true;
                  }
               }

               if(var8) {
                  --var7.b;
                  if(var7.b <= 0) {
                     var5.a(var6, (amj)null);
                  }
                  break;
               }
            }
         }

         this.f = -1;
         this.a = 10;
      }

   }

   protected boolean a(aqu var1, dt var2) {
      atr var3 = var1.p(var2).c();
      if(var3 == aty.ak) {
         var2 = var2.a();
         bec var4 = var1.p(var2);
         var3 = var4.c();
         if(var3 instanceof auu && ((Integer)var4.b(auu.a)).intValue() == 7 && this.e && (this.f == 0 || this.f < 0)) {
            this.f = 0;
            return true;
         }

         if(var3 == aty.a && this.d && (this.f == 1 || this.f < 0)) {
            this.f = 1;
            return true;
         }
      }

      return false;
   }
}
