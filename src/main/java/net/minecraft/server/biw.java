package net.minecraft.server;

public class biw {

   private final int a;
   private IBlock b;
   private int c;
   private int d;


   public biw(int var1, Block var2) {
      this(3, var1, var2);
   }

   public biw(int var1, int var2, Block var3) {
      this.c = 1;
      this.a = var1;
      this.c = var2;
      this.b = var3.P();
   }

   public biw(int var1, int var2, Block var3, int var4) {
      this(var1, var2, var3);
      this.b = var3.a(var4);
   }

   public int b() {
      return this.c;
   }

   public IBlock c() {
      return this.b;
   }

   private Block e() {
      return this.b.c();
   }

   private int f() {
      return this.b.c().c(this.b);
   }

   public int d() {
      return this.d;
   }

   public void b(int var1) {
      this.d = var1;
   }

   public String toString() {
      String var1;
      if(this.a >= 3) {
         RegistryPrepender var2 = (RegistryPrepender)Block.c.c(this.e());
         var1 = var2 == null?"null":var2.toString();
         if(this.c > 1) {
            var1 = this.c + "*" + var1;
         }
      } else {
         var1 = Integer.toString(Block.a(this.e()));
         if(this.c > 1) {
            var1 = this.c + "x" + var1;
         }
      }

      int var3 = this.f();
      if(var3 > 0) {
         var1 = var1 + ":" + var3;
      }

      return var1;
   }
}
