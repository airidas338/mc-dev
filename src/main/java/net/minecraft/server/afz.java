package net.minecraft.server;


class afz extends zb {

   private afy a;
   private int b;


   public afz(afy var1) {
      this.a = var1;
      this.a(2);
   }

   public boolean a() {
      xm var1 = this.a.u();
      return var1 == null?false:var1.ai();
   }

   public void c() {
      this.b = 300;
      super.c();
   }

   public boolean b() {
      xm var1 = this.a.u();
      return var1 == null?false:(!var1.ai()?false:--this.b > 0);
   }

   public void e() {
      this.a.a(this.a.u(), 10.0F, 10.0F);
      ((agc)this.a.q()).a(this.a.y, this.a.cg());
   }
}
