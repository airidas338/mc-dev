package net.minecraft.server;

public class lf implements id {

   private String a = "";
   private String b = "";
   private int c;
   private lg d;


   public lf() {}

   public lf(bsa var1) {
      this.a = var1.e();
      this.b = var1.d().b();
      this.c = var1.c();
      this.d = lg.a;
   }

   public lf(String var1) {
      this.a = var1;
      this.b = "";
      this.c = 0;
      this.d = lg.b;
   }

   public lf(String var1, bry var2) {
      this.a = var1;
      this.b = var2.b();
      this.c = 0;
      this.d = lg.b;
   }

   public void a(hd var1) {
      this.a = var1.c(40);
      this.d = (lg)var1.a(lg.class);
      this.b = var1.c(16);
      if(this.d != lg.b) {
         this.c = var1.e();
      }

   }

   public void b(hd var1) {
      var1.a(this.a);
      var1.a((Enum)this.d);
      var1.a(this.b);
      if(this.d != lg.b) {
         var1.b(this.c);
      }

   }

   public void a(hg var1) {
      ((ik)var1).a(this);
   }
}
