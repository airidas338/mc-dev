package net.minecraft.server;

public final class dy extends Location {

   public int b;
   public int c;
   public int d;


   private dy(int var1, int var2, int var3) {
      super(0, 0, 0);
      this.b = var1;
      this.c = var2;
      this.d = var3;
   }

   public int n() {
      return this.b;
   }

   public int o() {
      return this.c;
   }

   public int p() {
      return this.d;
   }

   // $FF: synthetic method
   public fd d(fd var1) {
      return super.c(var1);
   }

   // $FF: synthetic method
   dy(int var1, int var2, int var3, du var4) {
      this(var1, var2, var3);
   }
}
