package net.minecraft.server;
import java.util.Random;

public class awm extends Block {

   public awm(Material var1) {
      super(var1);
      this.a(akf.b);
   }

   public int a(int var1, Random var2) {
      return MathHelper.a(this.a(var2) + var2.nextInt(var1 + 1), 1, 4);
   }

   public int a(Random var1) {
      return 2 + var1.nextInt(3);
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return Items.aT;
   }

   public boh g(IBlock var1) {
      return boh.d;
   }
}
