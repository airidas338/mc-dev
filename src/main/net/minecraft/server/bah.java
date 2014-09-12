package net.minecraft.server;
import java.util.Random;

public class bah extends Block {

   public bah(Material var1) {
      super(var1);
      this.a(akf.b);
   }

   public int a(Random var1) {
      return 2 + var1.nextInt(2);
   }

   public int a(int var1, Random var2) {
      return MathHelper.a(this.a(var2) + var2.nextInt(var1 + 1), 1, 5);
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return Items.cD;
   }

   public boh g(IBlock var1) {
      return boh.p;
   }

   protected boolean G() {
      return true;
   }
}
