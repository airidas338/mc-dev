package net.minecraft.server;

class bkc {

   public Class a;
   public final int b;
   public int c;
   public int d;
   public boolean e;


   public bkc(Class var1, int var2, int var3, boolean var4) {
      this.a = var1;
      this.b = var2;
      this.d = var3;
      this.e = var4;
   }

   public bkc(Class var1, int var2, int var3) {
      this(var1, var2, var3, false);
   }

   public boolean a(int var1) {
      return this.d == 0 || this.c < this.d;
   }

   public boolean a() {
      return this.d == 0 || this.c < this.d;
   }
}
