package net.minecraft.server;

class bdk implements ae {

   // $FF: synthetic field
   final bdj a;


   bdk(bdj var1) {
      this.a = var1;
   }

   public String d_() {
      return "Sign";
   }

   public ho e_() {
      return new hy(this.d_());
   }

   public void a(ho var1) {}

   public boolean a(int var1, String var2) {
      return true;
   }

   public dt c() {
      return this.a.c;
   }

   public brw d() {
      return new brw((double)this.a.c.n() + 0.5D, (double)this.a.c.o() + 0.5D, (double)this.a.c.p() + 0.5D);
   }

   public aqu e() {
      return this.a.b;
   }

   public wv f() {
      return null;
   }

   public boolean t_() {
      return false;
   }

   public void a(ag var1, int var2) {}
}
