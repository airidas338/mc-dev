package net.minecraft.server;
import java.util.Random;

class afu extends zy {

   private final aft a;
   private ej b;
   private boolean c;


   public afu(aft var1) {
      super(var1, 1.0D, 10);
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      if(this.a.u() != null) {
         return false;
      } else if(!this.a.s().m()) {
         return false;
      } else {
         Random var1 = this.a.bb();
         if(var1.nextInt(10) == 0) {
            this.b = ej.a(var1);
            dt var2 = (new dt(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
            bec var3 = this.a.o.p(var2);
            if(axs.d(var3)) {
               this.c = true;
               return true;
            }
         }

         this.c = false;
         return super.a();
      }
   }

   public boolean b() {
      return this.c?false:super.b();
   }

   public void c() {
      if(!this.c) {
         super.c();
      } else {
         World var1 = this.a.o;
         dt var2 = (new dt(this.a.s, this.a.t + 0.5D, this.a.u)).a(this.b);
         bec var3 = var1.p(var2);
         if(axs.d(var3)) {
            var1.a(var2, aty.be.P().a(axs.a, axu.a(var3)), 3);
            this.a.y();
            this.a.J();
         }

      }
   }
}
