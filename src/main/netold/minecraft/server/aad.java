package net.minecraft.server;

public class aad extends zb {

   private xx a;
   private boolean b;


   public aad(xx var1) {
      this.a = var1;
      this.a(5);
   }

   public boolean a() {
      if(!this.a.cj()) {
         return false;
      } else if(this.a.V()) {
         return false;
      } else if(!this.a.C) {
         return false;
      } else {
         xm var1 = this.a.cm();
         return var1 == null?true:(this.a.h(var1) < 144.0D && var1.bc() != null?false:this.b);
      }
   }

   public void c() {
      this.a.s().n();
      this.a.n(true);
   }

   public void d() {
      this.a.n(false);
   }

   public void a(boolean var1) {
      this.b = var1;
   }
}
