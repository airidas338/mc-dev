package net.minecraft.server;


public class aau extends aaw {

   xx a;
   xm b;
   private int c;


   public aau(xx var1) {
      super(var1, false);
      this.a = var1;
      this.a(1);
   }

   public boolean a() {
      if(!this.a.cj()) {
         return false;
      } else {
         xm var1 = this.a.cm();
         if(var1 == null) {
            return false;
         } else {
            this.b = var1.bc();
            int var2 = var1.bd();
            return var2 != this.c && this.a(this.b, false) && this.a.a(this.b, var1);
         }
      }
   }

   public void c() {
      this.e.d(this.b);
      xm var1 = this.a.cm();
      if(var1 != null) {
         this.c = var1.bd();
      }

      super.c();
   }
}
