package net.minecraft.server;
import java.util.Random;

public class BlockSeaLantern extends Block {

   public BlockSeaLantern(Material var1) {
      super(var1);
      this.a(CreativeModeTab.b);
   }

   public int a(Random var1) {
      return 2 + var1.nextInt(2);
   }

   public int a(int var1, Random var2) {
      return MathHelper.a(this.a(var2) + var2.nextInt(var1 + 1), 1, 5);
   }

   public Item a(IBlock var1, Random var2, int var3) {
      return Items.cD;
   }

   public MaterialMapColor g(IBlock var1) {
      return MaterialMapColor.p;
   }

   protected boolean G() {
      return true;
   }
}
