package net.minecraft.server;
import java.util.Random;

public class bah extends atr {

   public bah(bof var1) {
      super(var1);
      this.a(akf.b);
   }

   public int a(Random var1) {
      return 2 + var1.nextInt(2);
   }

   public int a(int var1, Random var2) {
      return uv.a(this.a(var2) + var2.nextInt(var1 + 1), 1, 5);
   }

   public alq a(bec var1, Random var2, int var3) {
      return amk.cD;
   }

   public boh g(bec var1) {
      return boh.p;
   }

   protected boolean G() {
      return true;
   }
}
