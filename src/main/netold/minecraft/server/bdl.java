package net.minecraft.server;

class bdl implements ae {

   // $FF: synthetic field
   final ahd a;
   // $FF: synthetic field
   final bdj b;


   bdl(bdj var1, ahd var2) {
      this.b = var1;
      this.a = var2;
   }

   public String d_() {
      return this.a.d_();
   }

   public ho e_() {
      return this.a.e_();
   }

   public void a(ho var1) {}

   public boolean a(int var1, String var2) {
      return true;
   }

   public dt c() {
      return this.b.c;
   }

   public brw d() {
      return new brw((double)this.b.c.n() + 0.5D, (double)this.b.c.o() + 0.5D, (double)this.b.c.p() + 0.5D);
   }

   public aqu e() {
      return this.a.e();
   }

   public wv f() {
      return this.a;
   }

   public boolean t_() {
      return false;
   }

   public void a(ag var1, int var2) {
      bdj.a(this.b).a(this, var1, var2);
   }
}
