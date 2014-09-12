package net.minecraft.server;
import java.util.Random;

public class ban extends Block {

   protected ban() {
      super(Material.z);
      this.a(true);
      this.a(akf.b);
   }

   public alq a(IBlock var1, Random var2, int var3) {
      return Items.aD;
   }

   public int a(Random var1) {
      return 4;
   }

   public void b(World var1, Location var2, IBlock var3, Random var4) {
      if(var1.b(EnumSkyBlock.BLOCK, var2) > 11) {
         this.b(var1, var2, var1.p(var2), 0);
         var1.g(var2);
      }

   }
}
