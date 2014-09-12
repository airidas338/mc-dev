package net.minecraft.server;

public class bmr extends bqc {

   private fn b = new fn();


   public bmr(String var1) {
      super(var1);
   }

   public void a(fn var1) {
      this.b = var1.m("Features");
   }

   public void b(fn var1) {
      var1.a("Features", (gd)this.b);
   }

   public void a(fn var1, int var2, int var3) {
      this.b.a(b(var2, var3), (gd)var1);
   }

   public static String b(int var0, int var1) {
      return "[" + var0 + "," + var1 + "]";
   }

   public fn a() {
      return this.b;
   }
}
