package net.minecraft.server;


public class aac extends zb {

   private abt a;
   private double b;
   private double c;
   private double d;
   private double e;


   public aac(abt var1, double var2) {
      this.a = var1;
      this.b = var2;
      this.a(1);
   }

   public boolean a() {
      if(!this.a.cm() && this.a.l != null) {
         ChunkCoordinates var1 = abf.a(this.a, 5, 4);
         if(var1 == null) {
            return false;
         } else {
            this.c = var1.a;
            this.d = var1.b;
            this.e = var1.c;
            return true;
         }
      } else {
         return false;
      }
   }

   public void c() {
      this.a.s().a(this.c, this.d, this.e, this.b);
   }

   public boolean b() {
      return !this.a.s().m() && this.a.l != null;
   }

   public void e() {
      if(this.a.bb().nextInt(50) == 0) {
         if(this.a.l instanceof ahd) {
            int var1 = this.a.cA();
            int var2 = this.a.cG();
            if(var2 > 0 && this.a.bb().nextInt(var2) < var1) {
               this.a.h((ahd)this.a.l);
               this.a.o.a((Entity)this.a, (byte)7);
               return;
            }

            this.a.u(5);
         }

         this.a.l.a((Entity)null);
         this.a.l = null;
         this.a.cU();
         this.a.o.a((Entity)this.a, (byte)6);
      }

   }
}
