package net.minecraft.server;
import java.util.Random;

public class axp extends Block {

   protected axp() {
      super(Material.C);
      this.a(akf.b);
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return Items.bf;
   }

   public int a(Random var1) {
      return 3 + var1.nextInt(5);
   }

   public int a(int var1, Random var2) {
      return Math.min(9, this.a(var2) + var2.nextInt(1 + var1));
   }
}
